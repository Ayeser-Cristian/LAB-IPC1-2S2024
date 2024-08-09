package ejemplo1;

//Para heredar los atributos y métodos de una clase usamos la palabra "extends"
//En este caso nuestra clase padre será "Persona" y nuestra clase hijo será "Estudiante".
//Al hacer la herencia, obtenemos todos los atributos y métodos que tiene la clase "Persona", en la clase "Estudiante".
public class Estudiante extends Persona {

    //Atributos propios de la clase "Estudiante"
    private int carnet;
    private String carrera;

    //Constructor
    /*Al ser una clase que hereda atributos de la clase "Persona"
    en el constructor debemos solicitar los mismos parametros que en la clase "Persona" más los atributos propios de esta clase "Estudiante".
     */
    public Estudiante(String nombre, int edad, char genero, double altura, int My_carnet, String My_carrera) {
        //Esto hace referencia a que los atributos heredados de la clase "Persona" se están inicializando con los parametros solicitados.
        super(nombre, edad, genero, altura);
        //Estos son los atributos propos de esta clase, que se estan inicializando con los parametros solicitados.
        this.carnet = My_carnet;
        this.carrera = My_carrera;
    }

    //----------------------INICIO DE FUNCIONES/PROCEDMIENTOS CREADOS PARA EL ENCAPSULAMIENTO--------------------------
    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    //----------------------FIN DE FUNCIONES/PROCEDMIENTOS CREADOS PARA EL ENCAPSULAMIENTO--------------------------
    //Metodos
    //Método para ver que el estudiante diga si gano o perdió el curso, dependiendo de la nota que le manda como parametro.
    public void verMiNota(int nota) {
        if (nota >= 61) {
            System.out.println("Yo: " + this.getNombre() + " Con carnet:" + carnet + " gane la Clase :D");
        } else {
            System.out.println("Yo: " + this.getNombre() + " Con carnet:" + carnet + " perdi la Clase :c");
        }
    }
}
