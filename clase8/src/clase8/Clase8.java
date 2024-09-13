/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase8;

import Controller.controller;
import Controller.controllerStart;
import View.View;
import View.ViewStart;

/**
 *
 * @author coxla
 */
public class Clase8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //View vtn= new View();
        //controller control= new controller(vtn);
        
        ViewStart vtn_Start= new ViewStart();
        controllerStart control_start= new controllerStart(vtn_Start);
        
    }
    
}
