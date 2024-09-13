/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.View;
import View.ViewStart;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author coxla
 */
public class controllerStart implements ActionListener {

    ViewStart vtn_start = new ViewStart();

    public controllerStart(ViewStart vtn_start) {
        this.vtn_start = vtn_start;
        inicializar();
    }

    private void inicializar() {
        vtn_start.setVisible(true);
        vtn_start.btnStart.addActionListener(this);

    }

    public void IniciarHilos() {
        
        int  repetir= Integer.parseInt(this.vtn_start.txtRepeticion.getText());
        
        View vtn= new View();
        
        controller control= new controller(vtn, repetir);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vtn_start.btnStart) {

            IniciarHilos();
        }
    }
}
