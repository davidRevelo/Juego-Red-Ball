import pygame

class Llave(pygame.sprite.Sprite): # heredar de pygame.Sprite..
    def __init__(self, nombre_de_archivo):
        super().__init__() 

        self.image = pygame.image.load(nombre_de_archivo)
        self.image = pygame.transform.scale(self.image, (35,35))
        self.rect = self.image.get_rect()

