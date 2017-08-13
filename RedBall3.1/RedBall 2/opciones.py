import pygame,sys


def opciones():
    pantalla = pygame.display.set_mode((800, 600))
    pygame.display.set_caption('Titulo de ventana')
    pygame.init()



    reloj = pygame.time.Clock()


    fondo = pygame.image.load('Imagenes/creditos.jpg')
    pantalla.blit(fondo, (0, 0)) 
    pygame.display.flip()


    pygame.display.update()
    reloj.tick(60)
