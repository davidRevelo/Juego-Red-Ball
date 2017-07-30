import pygame
from Personaje import Character
from Monedas import Moneda
from pygame.locals import *
import random
from random import randint  # crear numeros aleatorios
import Archivos as archi
import time
import threading

global segundos
global minutos

segundos= 0
minutos=0

ancho = 800
alto = 600
posX = 0
posY = 520

Blanco = (255,255,255)
Negro = (0,0,0,0)
Rojo = (178,34,4)
screen = pygame.display.set_mode((ancho,alto))
imagenFondo = pygame.image.load("Imagenes/fondo1.jpg")
imagenFondo = pygame.transform.scale(imagenFondo, (800,600))



class Main(object):
    def __init__(self):
        self.running = True
        self.clock = pygame.time.Clock()
        self.drawable_sprites = pygame.sprite.Group()
        self.character = Character(screen, 300, 0)
        self.drawable_sprites.add(self.character)
        
    def keydown(self, event_key):
        self.character.key_down(event_key)

    def keyup(self, event_key):
        self.character.key_up(event_key)

    def main(self):
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
       
        pygame.init()
        puntuacion = pygame.mixer.music.load("Sonido/intro.mp3")
        pygame.mixer.music.play(2)
        sonido=pygame.mixer.Sound("Sonido/choque.wav")
        self.listade_monedas = pygame.sprite.Group()
        self.listade_todos_los_sprites = pygame.sprite.Group()
        
        pygame.display.set_caption("Cronometro")
        def Reloj():
            
            fuente1= pygame.font.SysFont("Algerian",30)
            Reloj=str("Tiempo  "+str(minutos)+":"+str(segundos))
            mensaje=fuente1.render(Reloj,1,(Rojo))
            screen.blit(mensaje,(600,10))
        
        hilo = threading.Thread(target=crono, args=())
        hilo.start()
       
        músicaSonando = True
        listade_monedas = pygame.sprite.Group()
        listade_todos_los_sprites = pygame.sprite.Group()

        x = 10
        y = 20

        for i in range(15):
                
                # ESto representa un bloque
                monedas = Moneda("Imagenes/moneda.png")
             
                # Definimos una ubicación aleatoria para el bloque
                monedas.rect.x = random.randrange(ancho)
                monedas.rect.y = random.randrange(alto)
                #moneda1.dibujar(ventana, moneda1.rect.x,moneda1.rect.y )
                 
                # Añadimos el bloque a la lista de objetos
                listade_monedas.add(monedas)
                listade_todos_los_sprites.add(monedas)
                
        puntuacion = 0
        mifuenteSistema = pygame.font.SysFont("Algerian",30)  # obtener una fuente del sistema
        miTextoSistema = mifuenteSistema.render("Puntos: ",0,Rojo)
             
        miTextoSistema2 = mifuenteSistema.render("",0,Rojo)
        
       
        
        while(self.running):
            global segundos
            
            
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    self.running = False

                if event.type == pygame.KEYDOWN:
                    self.keydown(event.key)
                if event.type == pygame.KEYUP:
                    self.keyup(event.key)
          
            s1 = pygame.Surface([300,70])
            s2 = pygame.Surface([310,80])
            s1.fill(Negro)
            s2.fill(Rojo)

            
            screen.blit(imagenFondo, (0,0))
            Reloj()
            
            dt = self.clock.tick(60)
            self.character.update(dt)
            listade_impactos_bloque = pygame.sprite.spritecollide(self.character, listade_monedas, True)

            
            # Comprobamos la lista de colisiones
            
            for monedas in listade_impactos_bloque:
                puntuacion += 1
                sonido.play()
                puntaje = str (puntuacion)
                
                miTextoSistema2 = mifuenteSistema.render(puntaje,5,Rojo)
                print(puntuacion)
                L=str(puntuacion)
                archi.creartxt("puntuaciones.txt")
                archi.grabartxt("puntuaciones.txt",L)
                print("La puntuacion es:",str(L))
                

            #Agrego las monedas a la ventana
            listade_todos_los_sprites.draw(screen)
            for sprite in self.drawable_sprites.sprites():
                sprite.draw()
            #Agrego el puntaje a el programa
            screen.blit(miTextoSistema,(10,10))
            screen.blit(miTextoSistema2, (150,10))
            
            pygame.display.flip()
        pygame.quit()

if __name__=="__main__":
    main = Main()
    main.main()
