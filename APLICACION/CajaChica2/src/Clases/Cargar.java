/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author IsraelCM
 */
public class Cargar extends Thread{
    
    JProgressBar progreso;
    
    public Cargar(JProgressBar progreso){
        super();
        this.progreso=progreso;
    }
    
    @Override
    public void run(){
        
        for(int i=1;i<=100;i++){
            
            progreso.setValue(i);
            pausa(80);
            
        }
    }
    public void pausa(int miliseg){
        
        try {
            Thread.sleep(miliseg);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cargar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        
    }
}
