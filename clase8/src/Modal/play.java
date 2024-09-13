/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

import View.View;

/**
 *
 * @author coxla
 */
public class play extends Thread {

    private volatile boolean correr = true;
    /*private progreso h1;
    private progreso h2;
    private progreso h3;*/
    private Timer timerPlay;
    private View vtn_hilos;
    private int repetir;
    private int tiempo1;
    private int tiempo2;
    private int tiempo3;

    public play(View vtn_hilos, Timer timerPlay, int repetir, int t1, int t2, int t3) {
        /*this.h1 = h1;
        this.h2 = h2;
        this.h3 = h3;*/
        this.vtn_hilos = vtn_hilos;
        this.timerPlay = timerPlay;
        this.repetir = repetir;
        this.tiempo1 = t1;
        this.tiempo2 = t2;
        this.tiempo3 = t3;
    }

    public void detener() {
        correr = false;
    }

    @Override
    public void run() {
        try {
            int contador_repeticiones = 0;
            while (correr) {
                
                this.vtn_hilos.lblRepeticion.setText(contador_repeticiones+"/"+this.repetir);
                
                
                this.vtn_hilos.jProgressCorrer.setValue(0);
                this.vtn_hilos.jProgressNadar.setValue(0);
                this.vtn_hilos.jProgressSaltar.setValue(0);
                
                progreso h1 = new progreso(this.vtn_hilos.jProgressCorrer, this.tiempo1);
                progreso h2 = new progreso(this.vtn_hilos.jProgressNadar, this.tiempo2);
                progreso h3 = new progreso(this.vtn_hilos.jProgressSaltar, this.tiempo3);
                h1.start();
                h1.join();

                h2.start();
                h2.join();

                h3.start();
                h3.join();
                
                contador_repeticiones++;
                if(contador_repeticiones== this.repetir){
                    this.vtn_hilos.lblRepeticion.setText(contador_repeticiones+"/"+this.repetir);
                    this.detener();
                }
                

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.timerPlay.detener();
        }

        /*try {
            h1.start();
            h1.join();

            h2.start();
            h2.join();

            h3.start();
            h3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            this.timerPlay.detener();
        }*/
    }
}
