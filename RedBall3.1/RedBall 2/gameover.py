import pygame



class Game_over(pygame.sprite.Sprite): # heredar de pygame.Sprite..
    def __init__(self, nombre_de_archivo):
        super().__init__() 

        self.image = pygame.image.load(nombre_de_archivo)
        self.image = pygame.transform.scale(self.image, (800,650))
        self.rect = self.image.get_rect()
        
class Finjuego(pygame.sprite.Sprite): # heredar de pygame.Sprite..
    def __init__(self, nombre_de_archivo):
        super().__init__() 

        self.image = pygame.image.load(nombre_de_archivo)
        self.image = pygame.transform.scale(self.image, (800,650))
        self.rect = self.image.get_rect()
class Fuego(pygame.sprite.Sprite): # heredar de pygame.Sprite..
    def __init__(self, nombre_de_archivo):
        super().__init__() 

        self.image = pygame.image.load(nombre_de_archivo)
        self.image = pygame.transform.scale(self.image, (120,120))
        self.rect = self.image.get_rect()
