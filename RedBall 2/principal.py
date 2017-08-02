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

                    
class Plataforma(pygame.sprite.Sprite):
    """ Plataforma sobre la que el usuario puede saltar. """
 
    def __init__(self, largo, alto):
        """  Constructor de plataforma. Asume su construcción cuando el usuario le haya pasado 
            un array de 5 números, tal como se ha definido al principio de este código. """
        super().__init__()

        self.image = pygame.Surface([largo, alto])
        self.image.fill(BLANCO)    
                 
        self.rect = self.image.get_rect()
  
class Nivel(object):
    """ Esta es una súper clase genérica usada para definir un nivel.
        Crea una clase hija específica para cada nivel con una info específica. """
         
    def __init__(self, protagonista):
        """ Constructor. Requerido para cuando las plataformas móviles colisionan con el protagonista. """
        self.listade_plataformas = pygame.sprite.Group()
        self.listade_enemigos = pygame.sprite.Group()
        self.protagonista = protagonista
 
         
        # Imagen de fondo
        self.imagende_fondo = None
         
     
    # Actualizamos todo en este nivel
    def update(self):
        """ Actualizamos todo en este nivel."""
        self.listade_plataformas.update()
        self.listade_enemigos.update()
     
    def draw(self, pantalla):
        """ Dibujamos todo en este nivel. """
         
        # Dibujamos la imagen de fondo
        pantalla.fill(NEGRO)    
        # Dibujamos todas las listas de sprites que tengamos
        self.listade_plataformas.draw(pantalla)
        self.listade_enemigos.draw(pantalla)
 
     
# Creamos las plataformas para el nivel
class Nivel_01(Nivel):
    """ Definición para el nivel 1. """
 
    def __init__(self, protagonista):
        """ Creamos el nivel 1. """
         
        # llamamos al constructor padre
        Nivel.__init__(self, protagonista)
         
        # Array con la información sobre el largo, alto, x, e y
        nivel = [ [210, 70, 500, 500],
                  [210, 70, 200, 400],
                  [210, 70, 600, 300],
                  [210, 70, 300, 150],
                  ]
         
        # Iteramos sobre el array anterior y añadimos plataformas
        for plataforma in nivel:
            bloque = Plataforma(plataforma[0], plataforma[1])
            bloque.rect.x = plataforma[2]
            bloque.rect.y = plataforma[3]
            bloque.protagonista = self.protagonista
            self.listade_plataformas.add(bloque)                      
 
def main():


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
       
    pygame.display.set_caption("Cronometro")
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
     
    # Establecemos el nivel actual
    nivel_actual_no = 0
    nivel_actual = listade_niveles[nivel_actual_no]
     
    lista_sprites_activos = pygame.sprite.Group()
    protagonista.nivel = nivel_actual
     
    protagonista.rect.x = 340
    protagonista.rect.y = ALTO_PANTALLA - protagonista.rect.height
    lista_sprites_activos.add(protagonista)
    
    listade_monedas = pygame.sprite.Group()
    listade_todos_los_sprites = pygame.sprite.Group()

    
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
         
    #Iteramos hasta que el usuario pulse sobre el botón de salida 
    hecho = False
       
    # Lo usamos para gestionar cuan rápido se actualiza la pantalla.
    reloj = pygame.time.Clock() 
       
    puntuacion = 0
    puntosMonedas = 0

    mifuenteSistema = pygame.font.SysFont("Algerian",30)  # obtener una fuente del sistema
    miTextoSistema = mifuenteSistema.render("Puntos: ",0,BLANCO)
    miTextoSistema2 = mifuenteSistema.render("",0,BLANCO)
    miTextoSistema3 = mifuenteSistema.render("x 0",0,BLANCO)
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


        

        
        
        listade_impactos_bloque = pygame.sprite.spritecollide(protagonista, listade_monedas, True)
        
        for monedas in listade_impactos_bloque:
                puntuacion += 10
                puntosMonedas += 1 
                sonido.play()
                puntaje = str (puntuacion)
                puntajeM = str (puntosMonedas)
                
                miTextoSistema2 = mifuenteSistema.render(puntaje,5,BLANCO)
                miTextoSistema3 = mifuenteSistema.render(("X"+puntajeM),5,BLANCO)
                
                L=str(puntuacion)
                archi.creartxt("puntuaciones.txt")
                archi.grabartxt("puntuaciones.txt",("puntos:"+L))
                print("La puntuacion es:",str(L))
         
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

        
        pantalla.blit(imagenMoneda, (10,10))
        
        Reloj()

        pantalla.blit(miTextoSistema,(260,10))
        pantalla.blit(miTextoSistema2,(380,10))
        pantalla.blit(miTextoSistema3,(45,10))
        
         
        
         
        # TODO EL CÓDIGO DE DIBUJO DEBERÍA IR ENCIMA DE ESTE COMENTARIO 
           
        # Limitamos a 60 fps 
        reloj.tick(60) 
       
        # Avanzamos y actualizamos la pantalla con todo lo que hemos dibujado. 
        pygame.display.flip() 
           
    # Pórtate bien con el IDLE. Si te olvidas de esta línea, el programa se 'colgará' al salir.
    pygame.quit()
 
if __name__ == "__main__":
    main()
