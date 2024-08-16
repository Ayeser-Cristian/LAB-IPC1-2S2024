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
import clase4.modals.Estudiante;
import java.util.ArrayList;

public class Clase4 {

    /**
     * @param args the command line arguments
     */
    //Lista para almacenar los objetos "Estudiante"
    public static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

    public static void main(String[] args) {
        Login vtn_login = new Login();

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
}
