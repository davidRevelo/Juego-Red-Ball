import pygame
from States import AnimatedState, StaticState


class Bola(pygame.sprite.Sprite): # heredar de pygame.Sprite..
    """"Clase para la nave"""
    def __init__(self,display):
        super(Bola,self).__init__()

        self.display = display
        self.states_dict = {}
        self.current_state = None
        self.dx = 0
        self.dy = 0
        self.image = None
        self.jumping = False
        
    def set_current_state(self, key):
        self.current_state = self.states_dict[key]

    def impulse(self, dx, dy):
        self.dx = dx
        self.dy = dy
        
    def actualizar(self,moneda):
        if pygame.sprite.collide_rect(self,moneda):
            print("c")

    def draw(self):
        self.image = pygame.transform.scale(self.image, (self.rect.width, self.rect.height))
        self.display.blit(self.image, (self.rect.x, self.rect.y))


            
    # Encontramos una posición nueva para el protagonista
    def update(self, dt):
        raise NotImplementedError("The update method must be called in any child class")

class Character (Bola):
    def __init__(self, display, px, py):
        super(Character, self).__init__(display)
        #velocidad del personaje
        self.speed = 3.5
        #cargo los sprites a mi personaje
        self.walking_images = pygame.image.load('Imagenes/bola.png')
        self.number_of_sprites = 4
        
        self.walking_right_state = AnimatedState(self.walking_images.subsurface(0,0,
                                                 self.walking_images.get_width(),
                                                 self.walking_images.get_height()/2),
                                                 self.number_of_sprites, 400, "walking_right")
        
        self.walking_left_state = AnimatedState(self.walking_images.subsurface(0,
                                                self.walking_images.get_height()/2,
                                                self.walking_images.get_width(),
                                                self.walking_images.get_height()/2),
                                                self.number_of_sprites, 400, "walking_left")

        self.resting_left_state = StaticState(self.walking_images.subsurface(
                                              self.walking_images.get_width()*3/4,
                                              self.walking_images.get_height()/2,
                                              self.walking_images.get_width()/self.number_of_sprites,
                                              self.walking_images.get_height()/2),
                                               "resting_left")

        self.resting_right_state = StaticState(self.walking_images.subsurface(0,0,
                                               self.walking_images.get_width()/self.number_of_sprites,
                                               self.walking_images.get_height()/2),
                                               "resting_right")

        self.states_dict["walking_right"] = self.walking_right_state
        self.states_dict["walking_left"] = self.walking_left_state
        self.states_dict["resting_left"] = self.resting_left_state
        self.states_dict["resting_right"] = self.resting_right_state

        self.set_current_state("resting_left")
        self.image = self.current_state.get_sprite()
        self.rect = self.image.get_rect()
        self.rect.x = px
        self.rect.y = py

        self.accelerating = False
        self.jumping = False

    def calculate_gravity(self):
        if self.dy == 0:
            self.dy = 1
        else:
            self.dy = self.dy + 0.35

    def jump(self, jump_force):
        self.impulse(self.dx, -jump_force)
    #cuando las tecla esta presionada
    def key_down(self, key):
        if key == pygame.K_UP:
            if not self.jumping:
                self.jump(10)
                self.jumping = True
        if key == pygame.K_DOWN:
            pass
        if key == pygame.K_LEFT:
            self.set_current_state("walking_left")
            self.dx = -self.speed
        if key == pygame.K_RIGHT:
            self.set_current_state("walking_right")
            self.dx = self.speed
    #cuando soltamos la tecla
    def key_up(self, key):
        if key == pygame.K_UP:
            pass
        if key == pygame.K_DOWN:
            pass
        if key == pygame.K_LEFT:
            if self.dx < 0:
                self.set_current_state("resting_left")
                self.dx = 0
        if key == pygame.K_RIGHT:
            if self.dx > 0:
                self.set_current_state("resting_right")
                self.dx = 0

    def update(self, dt):
        self.calculate_gravity()

        self.rect.x = self.rect.x + self.dx
        self.rect.y = self.rect.y + self.dy
    #actualizacion del personaje cuando salta
        if self.rect.y+self.rect.height > self.display.get_height():
            self.rect.y = self.display.get_height()-self.rect.height
            self.jumping = False
            self.dy = 0
    #Limites de la pantalla
        if self.rect.left<=0:
                self.rect.left =5
        elif self.rect.right>=800:
                self.rect.right = 800
        elif self.rect.top >=560:
                self.rect.top = 560
        elif self.rect.bottom <=30:
                self.rect.bottom = 30
                
        self.current_state.update(dt)
        self.image = self.current_state.get_sprite()


