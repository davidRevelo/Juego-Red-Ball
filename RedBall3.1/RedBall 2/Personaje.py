import pygame

# Colores
NEGRO = (0, 0, 0) 
BLANCO = (255, 255, 255) 
AZUL = (0, 0, 255)
ROJO = (255, 0, 0)
VERDE = (0, 255, 0)

# Dimensiones de la pantalla
LARGO_PANTALLA = 800
ALTO_PANTALLA = 600
xPos = 200
yPos = 300

class Protagonista(pygame.sprite.Sprite): 
    """ Esta clase representa la barra inferior que controla el protagonista """
   
    # -- Atributos 
    # Establecemos el vector velocidad del protagonista
    cambio_x = 0
    cambio_y = 0
     
    # Lista de todos los sprites contra los que podemos botar
    nivel = None
     
    # -- Métodos
        
    def __init__(self, nombre_de_archivo):
        # Llamada al constructor de la clase padre (Sprite)
        super().__init__() 
 
        # Crea una imagen del bloque y la rellena con un color.
        # También podría tratarse de una imagen guardada en disco.
        
        self.image = pygame.image.load(nombre_de_archivo).convert()
        self.image = pygame.transform.scale(self.image, (50,50))
 
        #Hacemos que el fondo sea transparente. Ajusta a BLANCO si tu
        # imagen de fondo es blanca.
        self.image.set_colorkey(NEGRO)
 
        # Extraemos el objeto rectángulo que posee las dimensiones de la imagen.
        # DEfiniendo los valores para rect.x y rect.y, actualizamos la posición de este
        # objeto
        self.rect = self.image.get_rect()
       
    def update(self): 
        """ Desplazamos al protagonista. """
        # Gravedad
        self.calc_grav()
         
        # Desplazar izquierda/derecha
        self.rect.x += self.cambio_x
         
        # Comprobamos si hemos chocado contra algo
        lista_impactos_bloques = pygame.sprite.spritecollide(self, self.nivel.listade_plataformas, False)
        for bloque in lista_impactos_bloques:
            # Si nos estamos desplazando hacia la derecha, hacemos que nuestro lado derecho sea el lado izquierdo del objeto que hemos tocado-
            if self.cambio_x > 0:
                self.rect.right = bloque.rect.left
            elif self.cambio_x < 0:
                # En caso contrario, si nos desplazamos hacia la izquierda, hacemos lo opuesto.
                self.rect.left = bloque.rect.right
 
        # Desplazar arriba/abajo
        self.rect.y += self.cambio_y
         
        # Comprobamos si hemos chocado contra algo
        lista_impactos_bloques = pygame.sprite.spritecollide(self, self.nivel.listade_plataformas, False) 
        for bloque in lista_impactos_bloques:
 
            # Restablecemos nuestra posición basándonos en la parte superior/inferior del objeto.
            if self.cambio_y > 0:
                self.rect.bottom = bloque.rect.top 
            elif self.cambio_y < 0:
                self.rect.top = bloque.rect.bottom
 
            # Detenemos nuestro movimiento vertical
            self.cambio_y = 0
 
    def calc_grav(self):
        """ Calculamos el efecto de la gravedad. """
        if self.cambio_y == 0:
            self.cambio_y = 1
        else:
            self.cambio_y += .35
 
        # Observamos si nos encontramos sobre el suelo. 
        if self.rect.y >= ALTO_PANTALLA - self.rect.height and self.cambio_y >= 0:
            self.cambio_y = 0
            self.rect.y = ALTO_PANTALLA - self.rect.height
 
    def saltar(self):
        """ Llamado cuando el usuario pulsa el botón de 'saltar'. """
         
        # Descendemos un poco y observamos si hay una plataforma debajo nuestro.
        # Descendemos 2 píxels (con una plataforma que está  descendiendo, no funciona bien 
    # si solo descendemos uno).
        self.rect.y += 2
        lista_impactos_plataforma = pygame.sprite.spritecollide(self, self.nivel.listade_plataformas, False)
        self.rect.y -= 2
         
        # Si está listo para saltar, aumentamos nuestra velocidad hacia arriba
        if len(lista_impactos_plataforma) > 0 or self.rect.bottom >= ALTO_PANTALLA:
            self.cambio_y = -10
             
    # Movimiento controlado por el protagonista
    def ir_izquierda(self):
        """ Es llamado cuando el usuario pulsa la flecha izquierda """
        self.cambio_x = -6
 
    def ir_derecha(self):
        """ Es llamado cuando el usuario pulsa la flecha derecha """
        self.cambio_x = 6
 
    def stop(self):
        """ Es llamado cuando el usuario abandona el teclado """
        self.cambio_x = 0

