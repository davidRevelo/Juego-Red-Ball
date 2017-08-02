def creartxt(nombre):
    archi = open(nombre+".txt",'w')
    archi.close()

def grabartxt(nombre,texto):
    archi = open(nombre+".txt",'a')    
    archi.write(str(texto))
    archi.close()

