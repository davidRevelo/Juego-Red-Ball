import sys, pygame

 
# Constantes
WIDTH = 800
HEIGHT = 600


pygame.init()
reloj = pygame.time.Clock()

screen = pygame.display.set_mode((WIDTH, HEIGHT))
fondo = pygame.image.load("Imagenes/creditos.jpg")
pygame.display.set_caption("Pruebas Pygame")
screen.blit(fondo,(0,0))
pygame.display.flip()
pygame.display.update()
reloj.tick(60)
