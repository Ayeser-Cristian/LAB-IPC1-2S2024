/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase6.ui;

/**
 *
 * @author coxla
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    private JTextField carnetFiel;
    private JPasswordField passwordFiel;
    private JButton loginButton, holaBtn;

    public Login() {

        // Etiqueta con el título "Login"
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 36));  // Establece el tipo de letra y el tamaño
        titleLabel.setBounds(180, 15, 110, 35); // Posición y tamaño (x, y, width, height)
        /*
        x: La posición horizontal de la esquina superior izquierda de la ventana en píxeles desde el borde izquierdo de la pantalla.
        y: La posición vertical de la esquina superior izquierda de la ventana en píxeles desde la parte superior de la pantalla.
        width: El ancho de la ventana en píxeles.
        height: La altura de la ventana en píxeles.
         */
        this.add(titleLabel);

        //Etiqueta para el carnet
        JLabel carnetLabel = new JLabel("Carnet: ");
        carnetLabel.setBounds(70, 110, 80, 20);
        this.add(carnetLabel);
        //Campo de texto para colocar el carnet
        carnetFiel = new JTextField();
        carnetFiel.setBounds(130, 110, 260, 25);
        this.add(carnetFiel);

        //Etiqeuta para la contraseña
        JLabel passwordLabel = new JLabel("Contraseña: ");
        passwordLabel.setBounds(50, 180, 80, 20);
        this.add(passwordLabel);
        //Campo para la contraseña
        passwordFiel = new JPasswordField();
        passwordFiel.setBounds(130, 180, 260, 25);
        this.add(passwordFiel);

        //--------------------
        //Boton de inicio de sesión
        loginButton = new JButton("Inicio Sesión");
        loginButton.setBounds(180, 250, 150, 25); //Ajuste de posición
        loginButton.setForeground(Color.WHITE); // Ajuste de color de letra
        loginButton.setBackground(new Color(92, 218, 29)); // Ajuste de color de boton, con color en RGB
        loginButton.addActionListener(this);   // Agregamos un ActionListener al botón
        this.add(loginButton);

        // Botón de hola (Solo imprime un mensaje de hola)
        holaBtn = new JButton("Hola");
        holaBtn.setBounds(180, 280, 150, 25);
        holaBtn.addActionListener(this);
        this.add(holaBtn);

        //Creación de la ventana de login
        this.setTitle("Login"); // Título de la ventana
        this.setLayout(null); // Diseño nulo (sin diseño predeterminado), para poder posicionar los componentes donde queramos
        this.setSize(500, 350); //Tamaño de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Cierra la aplicación al cerrar la ventana
        this.setResizable(false); // No permite redimensionar la ventana
        this.setLocationRelativeTo(null); //Despliega la ventana en el centro de la pantalla
        this.setVisible(true); // Hace visible la ventana
    }

    //=========Método Abstracto para los eventos==============
    @Override
    public void actionPerformed(ActionEvent e) {
        //Por medio de ifs identificamos a que botón fue el que se le dió click y debe realizar la acción
        if (e.getSource() == loginButton) { //Entra a este if si se le dio click al boton de Login
            
            //Obtenemos los datos ingresados en los campos
            String carnet = carnetFiel.getText();
            String password = new String(passwordFiel.getPassword());

            if (carnet.equals("202010025") && password.equals("1234")) { //Si los datos son correctos inicia sesión
                
                //Mostrar ventana de dialogo con Mensaje Exitoso
                JOptionPane.showMessageDialog(this, "Bienvenido Usuario", "Login Correcto", JOptionPane.INFORMATION_MESSAGE);
                Administrador vtn_admin = new Administrador(); //Crear una ventana de Administrador
                this.dispose(); //Cerrar la ventana actual
            } else {
                
                //Mostrar ventana de dialogo con Mensaje de Error
                JOptionPane.showMessageDialog(this, "Credenciales incorrectos", "Login Incorrecto", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == holaBtn) {  //Entra a este if si se le dio click al botón de Hola
            System.out.println("Hola, ¿Cómo estas?");
        }
    }

}
