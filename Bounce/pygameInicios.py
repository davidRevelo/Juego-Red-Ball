import pygame
from pygame.locals import *
WIDTH = 900
HEIGHT = 500
posX=100
posY=360


global bola

def movimiento(self):
        if self.vida == True:
            if self.rect.left<=0:
                self.rect.left = 0
            elif self.rect.right>900:
                self.rect.right = 900
def teclado():
    teclado = pygame.key.get_pressed()

    global posX, posY
    if teclado[K_RIGHT]:
        posX+=2
    if teclado[K_LEFT]:
        posX-=2
    if teclado[K_UP]:
        posY-=2
    if teclado[K_DOWN]:
        posY+=2
    return


def main():
    pygame.init()
    pantalla=pygame.display.set_mode([WIDTH,HEIGHT])
    pygame.display.set_caption("Ventana") #TITULO VENTANA
    salir = False
    reloj1=pygame.time.Clock()
    blanco=(255,255,255)
    rojo =(220,30,40)
    s1=pygame.Surface((100,150)) #crear superfficies
    s1.fill(rojo) #pintar superficie
    imagen=pygame.image.load("prueba.jpg")
    imagen = pygame.transform.scale(imagen,(900,500))
    bola=pygame.image.load("bola.png")
    bola = pygame.transform.scale(bola,(40,40))
   
    
    while salir!=True: #VENTANA PRINCIPAL
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                salir = True
                
                
        reloj1.tick(40)
        pantalla.fill(blanco) # color a la superficie de la ventana
        
        pantalla.blit(imagen,[10,0])
        pantalla.blit(bola,[posX,posY])
        teclado()
        movimiento()
        pygame.display.update()
        
    pygame.quit()

main()
