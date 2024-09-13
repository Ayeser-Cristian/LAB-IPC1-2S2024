/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author coxla
 */
public class Timer extends Thread {

    private volatile boolean correr = true;
    private int segundos;
    private int minutos;
    private JLabel labelTiempo;

    public Timer(JLabel labelTiempo) {
        this.labelTiempo = labelTiempo;
        this.segundos=0;
        this.minutos=0;
    }

    public void detener() {
        correr = false;
    }

    @Override
    public void run() {
        while (correr) {

            try {
                
                if(this.segundos<10){
                    
                    this.labelTiempo.setText(this.minutos+":0"+this.segundos);
                }else{
                    this.labelTiempo.setText(this.minutos+":"+this.segundos);
                }
                
                labelTiempo.repaint();
               
                Thread.sleep(1000);
                
                this.segundos++;
                
                if(this.segundos==60){
                    this.minutos++;
                    this.segundos = 0;
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
