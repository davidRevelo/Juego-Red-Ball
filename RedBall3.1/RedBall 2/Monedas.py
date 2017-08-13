import pygame
from random import randint

class Moneda(pygame.sprite.Sprite): # heredar de pygame.Sprite..
    def __init__(self, nombre_de_archivo):
        super().__init__() 
 
        # Crea una imagen del bloque y la rellena con un color.
        # También podría tratarse de una imagen guardada en disco.

        self.image = pygame.image.load(nombre_de_archivo)
        self.image = pygame.transform.scale(self.image, (35,35))
 
        #Hacemos que el fondo sea transparente. Ajusta a BLANCO si tu
        # imagen de fondo es blanca.
        #self.image.set_colorkey(Negro)
 
        # Extraemos el objeto rectángulo que posee las dimensiones de la imagen.
        # DEfiniendo los valores para rect.x y rect.y, actualizamos la posición de este
        # objeto
        self.rect = self.image.get_rect()
