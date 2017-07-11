# -*- coding: utf-8 -*-
"""
Created on Mon Jul 10 19:11:01 2017

@author: Luis
"""

import pygame,sys
from pygame.locals import *
from random import randint  # crear numeros aleatorios

ancho = 800
alto = 600
posX = 10
posY = 10


class Bola(pygame.sprite.Sprite): # heredar de pygame.Sprite..
    """"Clase para la nave"""
    def __init__(self):
        pygame.sprite.Sprite.__init__(self) #usar sprite en la imagen
        self.bola = pygame.image.load("Imagenes/bola.png")
        self.bola = pygame.transform.scale(self.bola, (25,25))
        self.rect = self.bola.get_rect()
        self.velocidad = 40
        
        self.change_x = 0
        self.change_y = 0
        self.vida = True
        
    def dibujar(self, superficie, x, y):
        superficie.blit(self.bola, self.rect)
        
    def cambiovelocidad(self,x,y):
        """Cambiamos la velocidad del protagonista"""
        self.change_x += x
        self.change_y += y
        
    def movimiento(self):
        if self.vida == True:
            
            if self.rect.left<=0:
                self.rect.left = 0
            elif self.rect.right>800:
                self.rect.right = 800
            elif self.rect.up >600:
                self.rect.up = 600
    # Encontramos una posición nueva para el protagonista
    def update(self):
        self.rect.x += self.change_x
        self.rect.y += self.change_y

         



pygame.init()
ventana = pygame.display.set_mode((ancho,alto))
pygame.display.set_caption("Juego")
imagenFondo = pygame.image.load("Imagenes/fondo1.jpg")
imagenFondo = pygame.transform.scale(imagenFondo, (800,600))

jugador = Bola()
listade_todoslos_sprites = pygame.sprite.Group()
listade_todoslos_sprites.add(jugador)
Blanco = (255,255,255)
#velocidad = 5 # velocidad de 5 pixeles
enJuego = True

reloj = pygame.time.Clock()                
while True:
    
    jugador.movimiento()
    for evento in pygame.event.get(): # regresa una lista de eventos
        if evento.type == QUIT: # si se presiona x se cierra la venta
                pygame.quit()
                sys.exit()
        if enJuego == True:
                if evento.type == pygame.KEYDOWN: # SI ALGUNA TECLA FUE PRESIONADA
                    if evento.key == pygame.K_LEFT:
                        jugador.cambiovelocidad(-3,0)
                    elif evento.key == pygame.K_RIGHT:
                        jugador.cambiovelocidad(3,0)
                    elif evento.key == pygame.K_UP: 
                        jugador.cambiovelocidad(0,-3)
                    elif evento.key == pygame.K_DOWN:
                        jugador.cambiovelocidad(0,3)
                elif evento.type == pygame.KEYUP:
                    if evento.key == pygame.K_LEFT:
                        jugador.cambiovelocidad(3,0)
                    elif evento.key == pygame.K_RIGHT:
                        jugador.cambiovelocidad(-3,0)
                    elif evento.key == pygame.K_UP:
                        jugador.cambiovelocidad(0,3)
                    elif evento.key == pygame.K_DOWN:
                        jugador.cambiovelocidad(0,-3)
                        


        # Reseteamos la velocidad cuando la tecla es hacia arriba      
    # Esto mueve al bloque protagonista según la velocidad actual
    listade_todoslos_sprites.update()
    # Pausa
    reloj.tick(60)


    ventana.blit(imagenFondo, (0,0))
    jugador.dibujar(ventana,posX, posY)
    pygame.display.update()