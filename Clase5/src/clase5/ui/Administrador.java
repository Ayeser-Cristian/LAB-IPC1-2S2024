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
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import clase5.modals.Render;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Administrador extends JFrame implements ActionListener, MouseListener {

    JButton btn_salir, btnRegistro, btnCargarMatrix;
    JTable table_matriz;

    public Administrador() {

        // Crear un objeto JTabbedPane para gestionar pestañas
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        //Crear dos panales para las pestañas
        JPanel pest1 = new JPanel(null); //Se coloca null para tener control en la posicion de los elemntos en la pestaña
        JPanel pest2 = new JPanel(null);

        // Agregar los paneles a las pestañas del JTabbedPane
        tabbedPane.add("Estudiante", pest1);
        tabbedPane.add("Matrix", pest2);

        //===========================Pestaña Estudiantes============================00
        //Botones
        //Registro
        btnRegistro = new JButton("Crear");
        btnRegistro.setBounds(580, 150, 180, 50);
        btnRegistro.setEnabled(true);
        btnRegistro.addActionListener(this);
        pest1.add(btnRegistro); //Ojo que lo estamos agregando en la pestaña 1

        //Salir
        btn_salir = new JButton("Salir");
        btn_salir.setBounds(580, 250, 180, 50);
        btn_salir.addActionListener(this);
        pest1.add(btn_salir);  //Ojo que lo estamos agregando en la pestaña 1

        // Titulo
        // Crear un nuevo JLabel con el texto "Listado Oficial"
        JLabel lbl4 = new JLabel("Listado Oficial");
        // Estable_estudiantecer la posición y el tamaño del JLabel en el JPanel
        lbl4.setBounds(25, 25, 750, 50);
        // Estable_estudiantecer un borde alrededor del JLabel con un grosor de 2 píxeles y color negro
        lbl4.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        // Estable_estudiantecer el color de fondo del JLabel como GRIS CLARO
        lbl4.setBackground(Color.LIGHT_GRAY);
        // Hacer que el JLabel sea opaco para que se pueda ver el color de fondo
        lbl4.setOpaque(true);
        // Alinear vertical y horizontalmente el texto del JLabel al centro
        lbl4.setVerticalAlignment(SwingConstants.CENTER);
        lbl4.setHorizontalAlignment(SwingConstants.CENTER);
        // Estable_estudiantecer el tamaño de la fuente del JLabel, negrita y tamaño 24
        lbl4.setFont(new Font(lbl4.getFont().getFontName(), Font.BOLD, 24));
        // Hacer que el JLabel sea visible
        lbl4.setVisible(true);

        // Agregar el JLabel al JPanel llamado pest1
        pest1.add(lbl4);

        //Tabla
        // Creamos por medio de una lista el enabezado que tendrá la tabla
        String[] columnsName = {"Carnet", "Nombre", "Contrasenia", "Genero"};
        //Debemos crear una matriz de objetos que contenga los datos que deseamos mostrar

        /*
        Object[][] data = {
            {"202010025", "Ayeser Oxlaj", "1234", "M"}
        };*/
        //Creamos la función en el main "mostrarEstudiantes()" la cual se encargará de pasar los datos de nuestra lista a una matriz de objetos
        //(Ver la función en el archivo Clase4.java)
        Object[][] data = Clase5.mostrarEstudiantes();

        // Crear una instancia de JTable con los datos y nombres de columna
        JTable table_estudiante = new JTable(data, columnsName);

        // Crear un JScrollPane para la tabla (permite desplazarse por la tabla si es necesario)
        JScrollPane scrollpane = new JScrollPane(table_estudiante);
        scrollpane.setBounds(25, 80, 550, 300);

        pest1.add(scrollpane);

        //===========================Pestaña Matriz============================
        //Colocamos esto solo como ejemplo de como colocar un elemento en la pestaña 2
        JLabel titleLabel = new JLabel("Welcome");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20));
        titleLabel.setBounds(200, 10, 100, 30);
        pest2.add(titleLabel);

        //Botones
        //Carga
        btnCargarMatrix = new JButton("Carga Matrix");
        btnCargarMatrix.setBounds(580, 150, 180, 50);
        btnCargarMatrix.addActionListener(this);
        pest2.add(btnCargarMatrix);

        //Tabla                         0,      1,       2
        String[] columnsNameMatrix = {"Codigo", "Nombre", "Accion"};

        /*Object[][] dataMatriz = {
            {"1", "Matriz", new JButton("Ver")}
        };*/

        Object[][] dataMatriz = Clase5.mostrarMatriz();
        table_matriz = new JTable();

        DefaultTableModel ModeloTabla = new DefaultTableModel(dataMatriz, columnsNameMatrix) {
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        table_matriz.setModel(ModeloTabla);
        table_matriz.setDefaultRenderer(Object.class, new Render());
        table_matriz.addMouseListener(this);

        JScrollPane scrollpaneMatriz = new JScrollPane(table_matriz);
        scrollpaneMatriz.setBounds(25, 80, 550, 300);

        pest2.add(scrollpaneMatriz);

        //=====================================================================0
        // Agregar el JTabbedPane al contenido del JFrame
        this.getContentPane().add(tabbedPane);

        //------------Creando JFrame------------------
        this.setSize(800, 650); //Tamaño de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Cierra la aplicación al cerrar la ventana
        this.setLocationRelativeTo(null); //Despliega la ventana en el centro de la pantalla
        this.setResizable(false);  // No permite redimensionar la ventana
        this.setVisible(true); // Hace visible la ventana
    }

    private void actualizarTablaMatriz() {
        DefaultTableModel model = (DefaultTableModel) table_matriz.getModel();
        Object[][] data = Clase5.mostrarMatriz();
        String[] columnsNameMatrix = {"Codigo", "Nombre", "Accion"};
        model.setDataVector(data, columnsNameMatrix);
    }

    //=========Método Abstracto para los eventos==============
    @Override
    public void actionPerformed(ActionEvent Ae) {
        if (Ae.getSource() == btnRegistro) { //Si le da click al botón registro entra a este evento

            this.dispose(); //Cerrar la ventana actual
            FormularioEstudiante vtn_form = new FormularioEstudiante();  //Crear una ventana de FormularioEstudiante

        } else if (Ae.getSource() == btn_salir) {  //Si le da click al botón Salir entra a este evento
            this.dispose(); //Cerrar la ventana actual
            Login vtn_login = new Login(); //Crear una ventana de Login
        } else if (Ae.getActionCommand().equals("Carga Matrix")) {
            JFileChooser My_fileChooser = new JFileChooser();

            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos CSV", "csv");

            My_fileChooser.setFileFilter(filter);

            int seleccion = My_fileChooser.showOpenDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File archivoSeleccionado = My_fileChooser.getSelectedFile();
                Clase5.lecturaCSV(archivoSeleccionado);

            }
            
            actualizarTablaMatriz();
            Clase5.SerealizarMatriz();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int column = table_matriz.getColumnModel().getColumnIndexAtX(e.getX());
        int row = e.getY() / table_matriz.getRowHeight();

        if (row < table_matriz.getRowCount() && row >= 0 && column == 2) {
            Object codigo_get = table_matriz.getValueAt(row, 0);
            Object nombre_get = table_matriz.getValueAt(row, 1);
            
            String codigo= codigo_get.toString();
            System.out.println(codigo_get);
            
            Clase5.EscrituraHTML(codigo);

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
