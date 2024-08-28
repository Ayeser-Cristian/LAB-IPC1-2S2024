/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase5;

/**
 *
 * @author coxla
 */
import clase5.ui.Login;
import clase5.ui.Administrador;
import clase5.modals.Estudiante;
import clase5.modals.Matrix;
import clase5.ui.FormularioMatrix;
import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

//Librería de LookAndFeel
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Clase5 {

    /**
     * @param args the command line arguments
     */
    //Lista para almacenar los objetos "Estudiante"
    public static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
    public static ArrayList<Matrix> listaMatrix = new ArrayList<>();

    public static void main(String[] args) {
        //Login vtn_login = new Login();
        //Administrador vtn_admin = new Administrador();

        try {

            listaMatrix = (ArrayList<Matrix>) DeserealizarMatriz();
            listaEstudiantes = (ArrayList<Estudiante>) DeserealizarEstudiante();

            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            //FormularioMatrix vtn = new FormularioMatrix();
            Login vtn_login = new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Procedimiento encargado de agregar un nuevo estudiante en la lista "listaEstudiantes"
    public static void agregarEstudiante(Estudiante new_Student) {
        listaEstudiantes.add(new_Student);
    }

    //Función encargada de pasar los datos  de la lista "listaEstudiantes", a una matriz de objetos para mostrarlo en la tabla
    public static Object[][] mostrarEstudiantes() {
        int filas = listaEstudiantes.size();
        Object[][] matrizObjetos = new Object[filas][4];

        for (int i = 0; i < filas; i++) {
            Estudiante temp_estudiante = listaEstudiantes.get(i);

            matrizObjetos[i][0] = temp_estudiante.getCarnet();
            matrizObjetos[i][1] = temp_estudiante.getNombre();
            matrizObjetos[i][2] = temp_estudiante.getContrasenia();
            matrizObjetos[i][3] = temp_estudiante.getGenero();

        }
        return matrizObjetos;
    }

    public static Object[][] mostrarMatriz() {
        int filas = listaMatrix.size();
        Object[][] matrizObjetos = new Object[filas][3];

        for (int i = 0; i < filas; i++) {
            Matrix temp_matriz = listaMatrix.get(i);

            matrizObjetos[i][0] = temp_matriz.getCodigo();
            matrizObjetos[i][1] = temp_matriz.getNombre();
            matrizObjetos[i][2] = temp_matriz.getVerBtn();

        }
        return matrizObjetos;
    }

    public static void lecturaCSV(File archivo_csv) {
        try {
            Scanner lectura = new Scanner(archivo_csv);
            boolean encabezado = true;

            while (lectura.hasNextLine()) {
                String linea = lectura.nextLine();

                if (encabezado == true) {
                    encabezado = false;
                    continue;
                }
                String[] datos = linea.split(","); //["1", "Matriz 1", "1;4;2;7"]

                for (String parte : datos) {
                    System.out.print(parte + "\t" + " |");
                }
                System.out.println("");
                System.out.println("-----------------------------------------");
                //1;4;2;7

                String[] numerosStr = datos[2].split(";"); //["1", "4", "2", "7"]

                int n = (int) Math.sqrt(numerosStr.length);

                int[][] matrizTemp = new int[n][n];

                int cont = 0;
                for (int i = 0; i < matrizTemp.length; i++) {

                    for (int j = 0; j < matrizTemp[i].length; j++) {
                        matrizTemp[i][j] = Integer.parseInt(numerosStr[cont].trim());
                        cont++;
                    }
                }

                for (int i = 0; i < matrizTemp.length; i++) {

                    for (int j = 0; j < matrizTemp[i].length; j++) {
                        System.out.print("[" + matrizTemp[i][j] + "] ");
                    }

                    System.out.println("");
                }

                listaMatrix.add(new Matrix(datos[0], datos[1], matrizTemp));

            }

            lectura.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Matrix buscarCodigo(String codigo) {

        for (Matrix obtenido_matrix : listaMatrix) {

            if (obtenido_matrix.getCodigo().equals(codigo)) {
                return obtenido_matrix;
            }
        }

        return null;
    }

    public static void EscrituraHTML(String codigo) {

        Matrix obteniedoMatriz = buscarCodigo(codigo);
        int[][] matrizImprimir;
        String name;

        if (obteniedoMatriz != null) {
            matrizImprimir = obteniedoMatriz.getPatron();
            name = obteniedoMatriz.getNombre();
        } else {
            matrizImprimir = new int[0][0];
            name = "nofound";
        }
        //name = Matriz.html
        //./Reportes/Matriz.html
        String direccionFile = "./Reportes/" + name + ".html";
        try (PrintWriter write = new PrintWriter(new File(direccionFile))) {

            //println -- con salto de línea
            // print -- sin salto de línea
            String inicioHtml = """
            <html>
                <head>
                              
                </head>
                <body>
                    <table border = "1">      
                              """;
            write.println(inicioHtml);

            for (int i = 0; i < matrizImprimir.length; i++) {
                write.println("<tr>");
                for (int j = 0; j < matrizImprimir[i].length; j++) {
                    write.println("<td>" + matrizImprimir[i][j] + "</td>");
                }

                write.println("</tr>");
                //System.out.println("");
            }
            //Cierre etiquetas HTML
            write.println("</table>");
            write.println("</body>");

            write.println("</html>");

            System.out.println("Archivo creado exitosamente");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void SerealizarMatriz() {
        try {
            String direccionFile = "./Archivos/MatrizSerial.bin";

            ObjectOutputStream salidaMatriz = new ObjectOutputStream(new FileOutputStream(direccionFile));

            salidaMatriz.writeObject(listaMatrix);

            salidaMatriz.close();

            System.out.println("Serelización exitosa");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object DeserealizarMatriz() {
        try {
            String direccionFile = "./Archivos/MatrizSerial.bin";

            ObjectInputStream entradaMatriz = new ObjectInputStream(new FileInputStream(direccionFile));

            ArrayList<Matrix> lista_temporal = (ArrayList<Matrix>) entradaMatriz.readObject();

            entradaMatriz.close();
            System.out.println("Archivo Deserealizado: MatrizSerial.bin ");
            return lista_temporal;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new ArrayList<>();

    }

    public static void SerealizarEstudiante() {
        try {
            String direccionFile = "./Archivos/EstudianteSerial.bin";

            ObjectOutputStream salidaMatriz = new ObjectOutputStream(new FileOutputStream(direccionFile));

            salidaMatriz.writeObject(listaEstudiantes);

            salidaMatriz.close();

            System.out.println("Serelización exitosa estudiantes");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object DeserealizarEstudiante() {
        try {
            String direccionFile = "./Archivos/EstudianteSerial.bin";

            ObjectInputStream entradaEstudiante = new ObjectInputStream(new FileInputStream(direccionFile));

            ArrayList<Estudiante> lista_temporal = (ArrayList<Estudiante>) entradaEstudiante.readObject();

            entradaEstudiante.close();
            System.out.println("Archivo Deserealizado: EstudianteSerial.bin ");
            return lista_temporal;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new ArrayList<>();

    }

    public static int[][] lecturaCSVPatron(File archivo_csv) {
         int[][] matrizTemp =null;
        try {

            Scanner lecturaTamanio = new Scanner(archivo_csv);
            Scanner lecturaMatrix = new Scanner(archivo_csv);

            int tamanio = 0;
            while (lecturaTamanio.hasNextLine()) {
                String linea = lecturaTamanio.nextLine();// 1,4,6,1,5,3
                String[] numerosLista = linea.split(","); //[1,4,6,1,5,3]
                tamanio = numerosLista.length; //Obtengo el tamaño de la lista
                break;
            }
            lecturaTamanio.close();

            matrizTemp = new int[tamanio][tamanio];
            int contFila=0;
            
            while (lecturaMatrix.hasNextLine()) {
                String linea = lecturaMatrix.nextLine();// 1,4,6,1,5,3
                String[] numerosLista = linea.split(","); //[1,4,6,1,5,3]

                for (int j = 0; j < matrizTemp[contFila].length; j++) {
                    matrizTemp[contFila][j]=Integer.parseInt(numerosLista[j].trim());
                }
                
                contFila++;
            }

            lecturaMatrix.close();
            
            for (int i = 0; i < matrizTemp.length; i++) {
                for (int j = 0; j < matrizTemp[i].length; j++) {
                    System.out.print("["+ matrizTemp[i][j]+"] ");
                }
                System.out.println("");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        if(matrizTemp==null){
            matrizTemp= new int[0][0];
        }
        
        return matrizTemp;
        
    }

    public static void agregarMatriz(String codigo, String nombre, int[][] patron){
        listaMatrix.add(new Matrix(codigo, nombre, patron));
    }
}
