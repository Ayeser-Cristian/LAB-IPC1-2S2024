/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modal.play;
import Modal.progreso;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author coxla
 */
public class contoller implements ActionListener {

    private View vista;

    public contoller(View vista) {
        this.vista = vista;
        inicializar();
    }

    private void inicializar() {
        vista.setVisible(true);
        vista.btnIniciar.addActionListener(this);
        vista.btnSaludar.addActionListener(this);
    }

    public void iniciarProgreso() {
        progreso h1 = new progreso(vista.jProgressCorrer, 5);
        progreso h2 = new progreso(vista.jProgressNadar, 6);
        progreso h3 = new progreso(vista.jProgressSaltar, 7);

        play ejectuar = new play(h1, h2, h3);
        ejectuar.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnIniciar) {
            iniciarProgreso();
        } else if (e.getSource() == vista.btnSaludar) {
            System.out.println("Hola mundo :D");
        }
    }

}
