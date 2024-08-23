/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase5.ui;

/**
 *
 * @author coxla
 */
import clase5.Clase5;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import clase5.modals.Estudiante;

public class FormularioEstudiante extends JFrame implements ActionListener {

    private JTextField carnetField;
    private JTextField nombreField;
    private JPasswordField passwordField;

    private JComboBox<String> genderComboBox;

    JButton registerButton;

    public FormularioEstudiante() {
        
        //Titulo de la ventana
        JLabel titleLabel = new JLabel("Registro");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20));
        titleLabel.setBounds(200, 10, 100, 30);
        this.add(titleLabel);
        
        //Etiqueta de Carnet
        JLabel carnetLabel = new JLabel("Carnet:");
        carnetLabel.setBounds(70, 50, 80, 25);
        this.add(carnetLabel);
        
        //Campo de Carnet
        carnetField = new JTextField();
        carnetField.setBounds(130, 50, 260, 25);
        this.add(carnetField);
        
        //Etiqueta de nombre
        JLabel nameLabel = new JLabel("Nombre:");
        nameLabel.setBounds(70, 90, 80, 25);
        this.add(nameLabel);
        
        //Campo de Nombre
        nombreField = new JTextField();
        nombreField.setBounds(130, 90, 260, 25);
        this.add(nombreField);
        
        //Etiqueta de Contrasenia
        JLabel passwordLabel = new JLabel("Contrasenia:");
        passwordLabel.setBounds(70, 130, 80, 25);
        this.add(passwordLabel);
        
        //Campo de contrasenia
        passwordField = new JPasswordField();
        passwordField.setBounds(130, 130, 260, 25);
        this.add(passwordField);

        //Crear lista para mostrar opciones en el comboBox
        String[] genders = {"Masculino", "Femenino"};
        
        //Crear el comboBox con las opciones de la lista
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setBounds(130, 170, 150, 25);
        this.add(genderComboBox); //Agregarlo a la ventana
        
        //Botón para registrarse
        registerButton = new JButton("Registrarse");
        registerButton.setBounds(180, 220, 150, 25);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(new Color(214, 225, 50));
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
    
    //=========Método Abstracto para los eventos==============
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            //Obtenemos los datos ingresados en los campos
            String carnet = carnetField.getText();
            String nombre = nombreField.getText();
            String contrasenia = new String(passwordField.getPassword());
            String genero = (String) genderComboBox.getSelectedItem();
            
            //Creamos un nuevo objeto Estudiante con los datos ingresados
            Estudiante nuevo = new Estudiante(carnet, nombre, contrasenia, genero);
            
            //Lo agregamos a la lista de Estudiantes por medio de la función agregarEstudiante()--- (Ver la función en el archivo Clase4.java)
            Clase5.agregarEstudiante(nuevo);

            //Mostrar ventana de dialogo con Mensaje Exitoso
            JOptionPane.showMessageDialog(this, "Usuario Creado Exitosamente", "Creación", JOptionPane.INFORMATION_MESSAGE);
            
            //Cerrar la ventana Actual
            this.dispose();
            //Crear una ventana de Administrador
            Administrador vtn_admi = new Administrador();
            
            Clase5.SerealizarEstudiante();
        }

    }

}
