/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 *
 * @author coxla
 */
public class progreso extends Thread {

    private JProgressBar barraProgreso;
    private int progreso;
    private int tiempoTotal;
    private volatile boolean correr = true;

    public progreso(JProgressBar barra_Progreso, int tiempo_Total) {
        this.barraProgreso = barra_Progreso;
        this.tiempoTotal = tiempo_Total;
        this.progreso = 0;
    }

    public void detener() {
        correr = false;
    }

    @Override
    public void run() {
        int segundos = 0;
        int intervalo = 100 / tiempoTotal;
        while (correr) {
            try {
                segundos += 1;
                this.progreso += intervalo;
                System.out.println("Tiempo hilo: "+  tiempoTotal);
                if(segundos==tiempoTotal || this.progreso>=100){
                    this.progreso=100;
                    detener();
                }
                
                SwingUtilities.invokeLater(() -> barraProgreso.setValue(this.progreso));
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(progreso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
