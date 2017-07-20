# -*- coding: utf-8 -*-
"""
Created on Mon Jul 17 17:03:55 2017

@author: Luis
"""

import pygame
from pygame.locals import *
 
pygame.init()
 
pantalla = pygame.display.set_mode((470,300),0,32)
pygame.display.set_caption("Modulo Music")
 
reloj = pygame.time.Clock()
 
pygame.mixer.music.load("intro.mp3")
pygame.mixer.music.play(2)
while True:
    for eventos in pygame.event.get():
        if eventos.type == pygame.QUIT:
            exit()
        if eventos.type == pygame.KEYDOWN:
            if eventos.key == pygame.K_p:
                pygame.mixer.music.stop()
    reloj.tick(20)
    pygame.display.update()
