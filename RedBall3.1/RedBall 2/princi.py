# -*- coding: utf-8 -*-
"""
Created on Wed Aug  2 11:41:44 2017

@author: 22B
"""

""" 
"""
 
import pygame,sys
from pygame.locals import *
from random import randint  # crear numeros aleatorios
from Monedas import Moneda
from Llaves import Llave
from Personaje import Protagonista
from Plataforma import Plataforma
from gameover import Fuego
from gameover import Finjuego
from gameover import Game_over
from Nivel import Nivel
from Nivel import Nivel_01
from Nivel import Nivel_02
from Nivel import Nivel_03
from Nivel import Nivel_04
import random
import Archivos as archi

import time
import threading

global segundos
global minutos

segundos= 0
minutos=0

imagenMoneda = pygame.image.load("Imagenes/moneda.png")
imagenMoneda = pygame.transform.scale(imagenMoneda, (30,30))

imagenLlave = pygame.image.load("Imagenes/llave.png")
imagenLlave = pygame.transform.scale(imagenLlave, (150,150))


imagenVida = pygame.image.load("Imagenes/corazon.png")
imagenVida = pygame.transform.scale(imagenVida, (40,40))



 
# Constantes globales
 
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



  
def inicio():


    def crono():
        global segundos
        global minutos
        segundos = int(segundos)
        if segundos == 60:               
            segundos = 0
            minutos+=1
            return crono()
                    
        else:
            segundos+=1
            time.sleep(1)
                    
            return crono()

    """ Programa Principal """
    pygame.init()

    puntuacion = pygame.mixer.music.load("Sonido/intro2.wav")
    pygame.mixer.music.play(2)
    sonido=pygame.mixer.Sound("Sonido/choque.wav")
        
    # Definimos el alto y largo de la pantalla 
    dimensiones = [LARGO_PANTALLA, ALTO_PANTALLA] 
    pantalla = pygame.display.set_mode(dimensiones) 
       
    pygame.display.set_caption("Red Ball")
    def Reloj():
            
        fuente1= pygame.font.SysFont("Algerian",30)
        Reloj=str("Tiempo  "+str(minutos)+":"+str(segundos))
        mensaje=fuente1.render(Reloj,1,(BLANCO))
        pantalla.blit(mensaje,(600,10))
        
    hilo = threading.Thread(target=crono, args=())
    hilo.start()
    
    
     
    # Creamos al protagonista
    protagonista = Protagonista("Imagenes/bola2.png")
    
    #imagenFondo = pygame.image.load("Imagenes/fondo1.jpg")
    #imagenFondo = pygame.transform.scale(imagenFondo, (800,600))
 
    # Creamos todos los niveles
    listade_niveles = []
    listade_niveles.append(Nivel_01(protagonista))
    listade_niveles.append(Nivel_02(protagonista))
    listade_niveles.append(Nivel_03(protagonista))
    listade_niveles.append(Nivel_04(protagonista))

     
    # Establecemos el nivel actual
    nivel_actual_no = 0
    
    nivel_actual = listade_niveles[nivel_actual_no]
     
    lista_sprites_activos = pygame.sprite.Group()
    protagonista.nivel = nivel_actual
     
    protagonista.rect.x = 140
    protagonista.rect.y = ALTO_PANTALLA - protagonista.rect.height
    lista_sprites_activos.add(protagonista)
    
    listade_monedas = pygame.sprite.Group()
    listade_todos_los_sprites = pygame.sprite.Group()

    lista_obstaculos = pygame.sprite.Group()
    lista_de_spritesObstaculos= pygame.sprite.Group()


    lista_fin = pygame.sprite.Group()
    lista_Sprites_fin= pygame.sprite.Group()

    def Obstaculos(x,y):


            fuego = Fuego("Imagenes/fuego.jpg")

            fuego.rect.x = x
            fuego.rect.y =y


            lista_obstaculos.add(fuego)
            lista_de_spritesObstaculos.add(fuego)
    def game_over():
            

            fin = Game_over("Imagenes/game_over.png")

            fin.rect.x = 0
            fin.rect.y =0

            
            lista_fin.add(fin)
            lista_Sprites_fin.add(fin)
    def fin_juego():
            

            fin = Finjuego("Imagenes/finjuego.jpg")

            fin.rect.x = 0
            fin.rect.y =0

            
            lista_fin.add(fin)
            lista_Sprites_fin.add(fin)
    def DibujarLlave():


            llave = Llave("Imagenes/llave.png")

            llave.rect.x = 670
            llave.rect.y =450


            listade_monedas.add(llave)
            listade_todos_los_sprites.add(llave)
            
    def DibujarMonedas_N3():
        z = 0
        z1 = 450
        
        for i in range(4):
            
            # ESto representa un bloque
            monedas = Moneda("Imagenes/moneda.png")
            monedas2 = Moneda("Imagenes/moneda.png")

            # Definimos una ubicación aleatoria para el bloque
            monedas.rect.x = z
            monedas2.rect.x = z1
 
            monedas.rect.y = 500
            monedas2.rect.y = 400
            
            z +=50
            z1 += 50
            
            # Añadimos el bloque a la lista de objetos
            listade_monedas.add(monedas)
            listade_todos_los_sprites.add(monedas)
            listade_monedas.add(monedas2)
            listade_todos_los_sprites.add(monedas2)
            Obstaculos(350,500)
            
    def DibujarMonedas_N2():
        z = 0
        z1 = 450
        z2 = 450
        
        for i in range(6):
            
            # ESto representa un bloque
            monedas = Moneda("Imagenes/moneda.png")
            monedas2 = Moneda("Imagenes/moneda.png")
            monedas3 = Moneda("Imagenes/moneda.png")


            # Definimos una ubicación aleatoria para el bloque
            monedas.rect.x = z
            monedas2.rect.x = z1
            monedas3.rect.x = z2

 
            monedas.rect.y = 250
            monedas2.rect.y = 350
            monedas3.rect.y = 150
            
            z +=50
            z1 += 50
            z2 +=50
            
            # Añadimos el bloque a la lista de objetos
            listade_monedas.add(monedas)
            listade_todos_los_sprites.add(monedas)
            listade_monedas.add(monedas2)
            listade_todos_los_sprites.add(monedas2)
            listade_monedas.add(monedas3)
            listade_todos_los_sprites.add(monedas3)
            

    def DibujarMonedas():
        z = 200
        z1 = 590
        z2 = 300
        
        for i in range(4):
            
            # ESto representa un bloque
            monedas = Moneda("Imagenes/moneda.png")
            monedas2 = Moneda("Imagenes/moneda.png")
            monedas3 = Moneda("Imagenes/moneda.png")
            

            # Definimos una ubicación aleatoria para el bloque
            monedas.rect.x = z
            monedas2.rect.x = z1
            monedas3.rect.x = z2
            
            
            monedas.rect.y = 350
            monedas2.rect.y = 260
            monedas3.rect.y = 110

            
            
            z +=50
            z1 += 50
            z2 += 50
            
            # Añadimos el bloque a la lista de objetos
            listade_monedas.add(monedas)
            listade_todos_los_sprites.add(monedas)
            listade_monedas.add(monedas2)
            listade_todos_los_sprites.add(monedas2)
            listade_monedas.add(monedas3)
            listade_todos_los_sprites.add(monedas3)
            
            
    DibujarMonedas()
         
    #Iteramos hasta que el usuario pulse sobre el botón de salida 
    hecho = False
       
    # Lo usamos para gestionar cuan rápido se actualiza la pantalla.
    reloj = pygame.time.Clock() 
       
    puntuacion = 0
    puntosMonedas = 0
    vida = 1000
    vidaCero = 0

    mifuenteSistema = pygame.font.SysFont("Algerian",30)  # obtener una fuente del sistema
    miTextoSistema = mifuenteSistema.render("Puntos: ",0,BLANCO)
    miTextoSistema2 = mifuenteSistema.render("",0,BLANCO)
    miTextoSistema3 = mifuenteSistema.render("x 0",0,BLANCO)
    vidaTexto = mifuenteSistema.render("1000",0,BLANCO)
    vidaTextoP = mifuenteSistema.render("Game Over",0,VERDE)
    # -------- Bucle Principal del Programa ----------- 
    while not hecho:
        global segundos
        
        for evento in pygame.event.get(): # El usuario realizó alguna acción 
            if evento.type == pygame.QUIT: # Si el usuario hizo click en salir
                hecho = True # Marcamos como hecho y salimos de este bucle
     
            if evento.type == pygame.KEYDOWN:
                if evento.key == pygame.K_LEFT:
                    protagonista.ir_izquierda()
                if evento.key == pygame.K_RIGHT:
                    protagonista.ir_derecha()
                if evento.key == pygame.K_UP:
                    protagonista.saltar()
                     
            if evento.type == pygame.KEYUP:
                if evento.key == pygame.K_LEFT and protagonista.cambio_x < 0: 
                    protagonista.stop()
                if evento.key == pygame.K_RIGHT and protagonista.cambio_x > 0:
                    protagonista.stop()
                    
        # Actualizamos al protagonista. 
        lista_sprites_activos.update()


        

        
        
        
         
        # Actualizamos los objetos en este nivel
        
        
        # Si el protagonista se aproxima al lado derecho, desplazamos su mundo a la izquierda (-x)
        if protagonista.rect.right > LARGO_PANTALLA:
            protagonista.rect.right = LARGO_PANTALLA
     
        # Si el protagonista se aproxima al lado izquierdo, desplazamos su mundo a la derecha (+x)
        if protagonista.rect.left < 0:
            protagonista.rect.left = 0

        
             
        # TODO EL CÓDIGO DE DIBUJO DEBERÍA IR DEBAJO DE ESTE COMENTARIO 
        
        
    
        
        nivel_actual.update()
        nivel_actual.draw(pantalla)
        
        lista_sprites_activos.draw(pantalla)
        listade_todos_los_sprites.draw(pantalla)
        lista_de_spritesObstaculos.draw(pantalla)
        lista_Sprites_fin.draw(pantalla)



        listade_impactos_bloque = pygame.sprite.spritecollide(protagonista, listade_monedas, True)
        choque_Obstaculos = pygame.sprite.spritecollide(protagonista, lista_obstaculos, False)

        for fuego in choque_Obstaculos:
            
            vida -=5
            print(vida)
            vidaM = str (vida)
            vidaTexto = mifuenteSistema.render((vidaM),5,BLANCO)
            if vida == 0:
                sonido.stop()
                def Reloj():
            
                 fuente1= pygame.font.SysFont("Algerian",30)
                 Reloj=str("Tiempo  "+str("00")+":"+str("00"))
                 mensaje=fuente1.render(Reloj,1,(BLANCO))
                 pantalla.blit(mensaje,(600,10))
                vida = 100
                protagonista.rect.x = 600
                protagonista.rect.y = 500
                vida = vidaCero
                game_over()
                
                
            
            
        
        for monedas in listade_impactos_bloque:
                puntuacion += 10
                puntosMonedas += 1
                 
                # If the player gets to the end of the level, go to the next level
                    
                if nivel_actual_no < len(listade_niveles)-1 and puntuacion ==120:
                    nivel_actual_no +=1
                    nivel_actual = listade_niveles[nivel_actual_no]
                    protagonista.nivel = nivel_actual
                    DibujarMonedas_N2()
                if nivel_actual_no < len(listade_niveles)-1 and puntuacion ==300:
                    nivel_actual_no +=1
                    nivel_actual = listade_niveles[nivel_actual_no]
                    protagonista.nivel = nivel_actual
                    DibujarMonedas_N3()
                if puntuacion == 380:
                    DibujarLlave()
                    
                    
                                
                    print("Gano")
                if puntuacion ==390:
                    fin_juego()  

                      
                sonido.play()
                puntaje = str (puntuacion)
                puntajeM = str (puntosMonedas)
                
                miTextoSistema2 = mifuenteSistema.render(puntaje,5,BLANCO)
                miTextoSistema3 = mifuenteSistema.render(("X"+puntajeM),5,BLANCO)
                
                L=str(puntuacion)
                R=(str(minutos)+" "+"min"+" "+str(segundos)+" "+"seg")
                
                archi.creartxt("puntuaciones.txt")
                archi.grabartxt("puntuaciones.txt","                                   RESULTADOS DE JUGADORES"+"\n")
                archi.grabartxt("puntuaciones.txt",("PUNTAJE OBTENIDO:"+L+" "+"Puntos"))
                archi.grabartxt("puntuaciones.txt","\n")
                archi.grabartxt("puntuaciones.txt",("TIEMPO TRANSCURRIDO:"+R))
                print("La puntuacion es:",str(L))        
        pantalla.blit(imagenMoneda, (10,10))
        pantalla.blit(imagenVida, (0,80))
        
        Reloj()

        pantalla.blit(miTextoSistema,(260,10))
        pantalla.blit(miTextoSistema2,(380,10))
        pantalla.blit(miTextoSistema3,(45,10))
        pantalla.blit(vidaTexto,(40,80))
        
         
        
         
        # TODO EL CÓDIGO DE DIBUJO DEBERÍA IR ENCIMA DE ESTE COMENTARIO 
           
        # Limitamos a 60 fps 
        reloj.tick(60) 
       
        # Avanzamos y actualizamos la pantalla con todo lo que hemos dibujado. 
        pygame.display.flip() 
           
    # Pórtate bien con el IDLE. Si te olvidas de esta línea, el programa se 'colgará' al salir.
    pygame.quit()
 
if __name__ == "__main__":
    inicio()
