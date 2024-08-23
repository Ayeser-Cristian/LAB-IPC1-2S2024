/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase5.modals;

import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author coxla
 */
public class Matrix implements Serializable{

    

    private String codigo;
    private String nombre;
    private int[][] patron;
    
    private JButton verBtn;

    public Matrix(String codigo, String nombre, int[][] patron) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.patron = patron;
        this.verBtn= new JButton("Ver");
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the patron
     */
    public int[][] getPatron() {
        return patron;
    }

    /**
     * @param patron the patron to set
     */
    public void setPatron(int[][] patron) {
        this.patron = patron;
    }

    /**
     * @return the verBtn
     */
    public JButton getVerBtn() {
        return verBtn;
    }

    /**
     * @param verBtn the verBtn to set
     */
    public void setVerBtn(JButton verBtn) {
        this.verBtn = verBtn;
    }
}
