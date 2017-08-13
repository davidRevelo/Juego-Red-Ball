import pygame
from Plataforma import Plataforma
from Personaje import Protagonista

# Colores
NEGRO = (0, 0, 0) 
BLANCO = (255, 255, 255) 
AZUL = (0, 0, 255)
ROJO = (255, 0, 0)
VERDE = (0, 255, 0)

 
class Nivel(object):
    """ Esta es una súper clase genérica usada para definir un nivel.
        Crea una clase hija específica para cada nivel con una info específica. """
         
    def __init__(self, protagonista):
        """ Constructor. Requerido para cuando las plataformas móviles colisionan con el protagonista. """
        self.listade_plataformas = pygame.sprite.Group()
        self.listade_enemigos = pygame.sprite.Group()
        self.protagonista = protagonista
 
         
        # Imagen de fondo
        self.imagende_fondo = '\Imagenes\fondo1.jpg'
         
     
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
            
class Nivel_02(Nivel):
    """ Definición para el nivel 2. """
 
    def __init__(self, protagonista):
        """ Creamos el nivel 2. """
         
        # llamamos al constructor padre
        Nivel.__init__(self, protagonista)
         
        # Array con la información sobre el largo, alto, x, e y
        nivel = [ [800, 70, 0, 550],
                  [350, 70, 450, 400],
                  [300, 70, 0, 300],
                  [350, 70, 450, 200],
                  ]
         
        # Iteramos sobre el array anterior y añadimos plataformas
        for plataforma in nivel:
            bloque = Plataforma(plataforma[0], plataforma[1])
            bloque.rect.x = plataforma[2]
            bloque.rect.y = plataforma[3]
            bloque.protagonista = self.protagonista
            self.listade_plataformas.add(bloque)

class Nivel_03(Nivel):
    """ Definición para el nivel 3. """
 
    def __init__(self, protagonista):
        """ Creamos el nivel 3 """
         
        # llamamos al constructor padre
        Nivel.__init__(self, protagonista)

      
        
         
        # Array con la información sobre el largo, alto, x, e y
        nivel = [ [350, 70, 0, 550],
                  [350, 70, 450, 550],
                  [300, 70, 550, 120],
                  ]
         
        # Iteramos sobre el array anterior y añadimos plataformas
        for plataforma in nivel:

            bloque = Plataforma(plataforma[0], plataforma[1])
            bloque.rect.x = plataforma[2]
            bloque.rect.y = plataforma[3]
            bloque.protagonista = self.protagonista
            self.listade_plataformas.add(bloque)
            
class Nivel_04(Nivel):
    """ Definición para el nivel 1. """
 
    def __init__(self, protagonista):
        """ Creamos el nivel 1. """
         
        # llamamos al constructor padre
        Nivel.__init__(self, protagonista)

      
        
         
        # Array con la información sobre el largo, alto, x, e y
        nivel = [ [800, 70, 0, 550],
                  [70, 800, 0, 550],
                  [800, 70, 0, 550],
                  [70, 800, 0, 550],
                  ]
         
        # Iteramos sobre el array anterior y añadimos plataformas
        for plataforma in nivel:

            bloque = Plataforma(plataforma[0], plataforma[1])
            bloque.rect.x = plataforma[2]
            bloque.rect.y = plataforma[3]
            bloque.protagonista = self.protagonista
            self.listade_plataformas.add(bloque)            
