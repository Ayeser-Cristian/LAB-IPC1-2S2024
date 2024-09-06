/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

/**
 *
 * @author coxla
 */
public class play extends Thread {

    private volatile boolean correr = true;
    private progreso h1;
    private progreso h2;
    private progreso h3;

    public play(progreso h1, progreso h2, progreso h3) {
        this.h1 = h1;
        this.h2 = h2;
        this.h3 = h3;
    }

    public void detener() {
        correr = false;
    }

    @Override
    public void run() {

        try {
            h1.start();
            h1.join();

            h2.start();
            h2.join();

            h3.start();
            h3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
