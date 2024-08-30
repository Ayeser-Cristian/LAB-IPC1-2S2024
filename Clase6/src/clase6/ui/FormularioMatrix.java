/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase6.ui;

import clase6.Clase6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author coxla
 */
public class FormularioMatrix extends JFrame implements ActionListener {

    private JTextField codigoField;
    private JTextField nombreField;

    JButton cargarButton, registerButton;

    private int[][] matrizLeida = null;

    public FormularioMatrix() {

        //Titulo de la ventana
        JLabel titleLabel = new JLabel("Matriz");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20));
        titleLabel.setBounds(200, 10, 100, 30);
        this.add(titleLabel);

        //Etiqueta de Codigo
        JLabel codigoLabel = new JLabel("Codigo:");
        codigoLabel.setBounds(70, 50, 80, 25);
        this.add(codigoLabel);

        //Campo de Codigo
        codigoField = new JTextField();
        codigoField.setBounds(130, 50, 260, 25);
        this.add(codigoField);

        //Etiqueta de nombre
        JLabel nameLabel = new JLabel("Nombre:");
        nameLabel.setBounds(70, 90, 80, 25);
        this.add(nameLabel);

        //Campo de Nombre
        nombreField = new JTextField();
        nombreField.setBounds(130, 90, 260, 25);
        this.add(nombreField);

        //Botón para Carga
        cargarButton = new JButton("Cargar");
        cargarButton.setBounds(180, 150, 150, 25);
        cargarButton.addActionListener(this);
        this.add(cargarButton);

        //Botón para registrarse
        registerButton = new JButton("Registrarse");
        registerButton.setBounds(180, 200, 150, 25);
        registerButton.addActionListener(this);
        this.add(registerButton);

        //------------Creando JFrame------------------
        this.setTitle("Registro");
        this.setBounds(650, 400, 500, 300);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cargarButton) {
             matrizLeida= null;
             
            JFileChooser My_fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos CSV", "csv");

            My_fileChooser.setFileFilter(filter);
            int seleccion = My_fileChooser.showOpenDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File archivoSeleccionado = My_fileChooser.getSelectedFile();

                matrizLeida = Clase6.lecturaCSVPatron(archivoSeleccionado);
            }
        } else if (e.getSource() == registerButton) {
            String codigo = codigoField.getText();
            String nombre = nombreField.getText();
            Clase6.agregarMatriz(codigo, nombre, matrizLeida);
            JOptionPane.showMessageDialog(this, "Matriz Creado Exitosamente", "Creación", JOptionPane.INFORMATION_MESSAGE);
            
            matrizLeida= null;
            this.dispose();
            
            Administrador vtn_admi = new Administrador();
        }
    }
}
