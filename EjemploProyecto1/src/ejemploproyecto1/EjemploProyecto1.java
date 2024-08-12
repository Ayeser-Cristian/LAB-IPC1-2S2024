package ejemploproyecto1;

import ejemploproyecto1.ui.Login;
import ejemploproyecto1.models.Estudiante;

import java.util.ArrayList;

public class EjemploProyecto1 {

    public static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

    public static void main(String[] args) {
        Login vtn_login = new Login();
        vtn_login.setVisible(true);
    }
    
    public static void agregarEstudiante( Estudiante new_Student){
        listaEstudiantes.add(new_Student);  
    }
    
    public static Object[][] mostrarEstudiantes(){
        int filas =  listaEstudiantes.size();
        Object[][] matrizObjetos = new Object[filas][4];
        for (int i = 0; i < filas; i++) {
            Estudiante temp_estudiante = listaEstudiantes.get(i);
            
            matrizObjetos[i][0]= temp_estudiante.getCarnet();
            matrizObjetos[i][1]= temp_estudiante.getNombre();
            matrizObjetos[i][2]= temp_estudiante.getContrasenia();
            matrizObjetos[i][3]= temp_estudiante.getGenero();
            
            
        }
        return matrizObjetos;
    }

}
