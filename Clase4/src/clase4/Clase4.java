/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase4;

/**
 *
 * @author coxla
 */
import clase4.ui.Login;
import clase4.ui.Administrador;
import clase4.modals.Estudiante;
import clase4.modals.Matrix;
import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Clase4 {

    /**
     * @param args the command line arguments
     */
    //Lista para almacenar los objetos "Estudiante"
    public static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
    public static ArrayList<Matrix> listaMatrix = new ArrayList<>();

    public static void main(String[] args) {
        //Login vtn_login = new Login();
        Administrador vtn_admin = new Administrador();

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

                
                int cont=0;
                for (int i = 0; i < matrizTemp.length; i++) {

                    for (int j = 0; j < matrizTemp[i].length; j++) {
                        matrizTemp[i][j] = Integer.parseInt(numerosStr[cont].trim());
                        cont++;
                    }
                }
                
                
                for (int i = 0; i < matrizTemp.length; i++) {

                    for (int j = 0; j < matrizTemp[i].length; j++) {
                        System.out.print("["+matrizTemp[i][j]+"] ");
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
    
    
    public static Matrix buscarCodigo(String codigo){
        
        for(Matrix obtenido_matrix:listaMatrix ){
            
            if(obtenido_matrix.getCodigo().equals(codigo)){
                return obtenido_matrix;
            }
        }
        
        return null;
    }
    
    public static void EscrituraHTML(String codigo){
        
        Matrix obteniedoMatriz=buscarCodigo(codigo);
        int [][] matrizImprimir;
        String name;
        
        if(obteniedoMatriz!=null){
            matrizImprimir=obteniedoMatriz.getPatron();
            name=obteniedoMatriz.getNombre();
        }else{
            matrizImprimir= new int[0][0];
            name="nofound";
        }
                            //name = Matriz.html
                            //./Reportes/Matriz.html
        String direccionFile="./Reportes/"+name+".html";
        try (PrintWriter write = new PrintWriter(new File (direccionFile))){
            
            //println -- con salto de línea
            // print -- sin salto de línea
            String inicioHtml="""
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
                    write.println("<td>"+matrizImprimir[i][j]+"</td>");
                }
                
                write.println("</tr>");
                //System.out.println("");
            }
            
            write.println("</table>");
            write.println("</body>");
            
            write.println("</html>");
            
            System.out.println("Archivo creado exitosamente");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        
    }
}
