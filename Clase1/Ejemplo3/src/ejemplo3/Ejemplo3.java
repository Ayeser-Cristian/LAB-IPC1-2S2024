package ejemplo3;

public class Ejemplo3 {

    //AQUÍ SE DECLARÁN LAS VARIABLES GLOBALES
    public static int enteroGlobal = 10;
    //Una Variable global la podemos usar en cualquier parte del código (cualquier procedimiento o función)

    public static void main(String[] args) {
        // VARIABLE LOCAL: estás variables solo la podemos usar en el procedimiento o función donde lo declaramos
        int enteroLocal = 5;

        System.out.println("Imprimiendo Variable global desde main: " + enteroGlobal); //Accediendo a variable global
        //---LLAMANDO PROCEDIMIENTOS----
        System.out.println("-------LLAMANDO PROCEDIMIENTOS----------------");
        //Para llamar el procedimiento simplemente lo llamamos por su indentificador
        //Podemos llamarlo las veces que deseemos
        NombreProcedimiento();
        System.out.println("----------------------");
        NombreProcedimiento();
        System.out.println("-----------------------");
        NombreProcedimiento();
        System.out.println("Imprimiendo Variable global desde main: " + enteroGlobal); //Accediendo a variable global
        System.out.println("");

        System.out.println("-------LLAMANDO PROCEDIMIENTOS CON PARAMETROS------");
        //Un parametro es un valor que si o si debemos mandarle al procedimiento, estos parametros se solicitan 
        //cuando se crea el procedimiento. En este caso en este procedimiento se solicitaron 3 parametros: dos enteros (int) y un texto (String)
        ProcedimientoParametros(enteroLocal, 50, "Ayeser");

        System.out.println("");

        System.out.println("-------LLAMANDO FUNCION------");
        //Para llamar una función simplemente lo llamamos por su indentificador
        //Podemos llamarlo las veces que deseemos
        //La diferencia entre un procedimiento y una función, es que el procedimiento no retorna nada, mientras que la función si nos retorna algo,
        // el tipo de dato que nos retorna dependerá de con que tipo de dato lo creamos.

        System.out.println("Respuesta de la division en funcion: " + dividir());//Lo que nos retorna lo podemos imprimir directamente, en este caso retorna 2 (ver la función)

        double resultadoFuncion = dividir();  //Lo que nos retorna lo podemos guardar en una variable, en este caso retorna 2 (ver la función)
        System.out.println("Respuesta de la division en funcion: " + resultadoFuncion);
        System.out.println("");

        System.out.println("-------LLAMANDO FUNCION CON PARAMETROS------");
        //Al igual que los procedimientos, en las funciones podemos enviar parametros
        System.out.println("Respuesta de la suma en funcion: " + suma(10.5, 5)); //Retorna el valor de la suma

        double resultadoFuncion2 = suma(100, 55); //Guardamos el valor de la suma que nos retorna

        System.out.println("Respuesta de la suma en funcion: " + resultadoFuncion2);
    }

    //Procedimiento sin parametros (notar que al crear un procedimiento usamos "void ")
    //Un procedimiento básicamente es un bloque de código que solo se ejecuta cuando lo mandamos a llamar
    public static void NombreProcedimiento() {
        enteroGlobal = enteroGlobal + 10;
        System.out.println("Imprimiendo Variable global desde procedimiento: " + enteroGlobal);
    }

    //Procedimiento con parametros (notar que al crear un procedimiento usamos "void ")
    //Como se mencinó anterimente, los parametros son datos que solicita el procedimiento para poder usarlos
    //Para solicitar dichos parametros debemos solicitarlo dento de los parentisis al momento de crear el procedimiento
    //Cabe aclarar que teemos que colocar de que tipo será el parametro que solicitamos
    //(Tipo Identificador, Tipo Identificado2)
    public static void ProcedimientoParametros(int numero1, int numero2, String nombre) {

        //Realizamos las operaciones que deseemos con los parametros que nos mandan desde el llamado
        System.out.println("Suma de los numeros: " + (numero1 + numero2));
        System.out.println("Tu nombre es: " + nombre);

        //También podemos llamar procedimientos y funciones desde los procedimientos
        NombreProcedimiento();
    }

    // Funcion sin parametros
    //Una función básicamente es un bloque de código que solo se ejecuta cuando lo mandamos a llamar, pero la función siempre retorna un valor cuando es llamado
    //Además, podemos notar que en una función al momento de crearlo no usamos "void", sino que en lugar de ello colocamos un Tipo de dato a la función.
    public static double dividir() {
        //Aquí al igual que el procedimiento podemos realizar las operaciones que deseemos
        double n1 = 16, n2 = 8;
        double resultado = n1 / n2;
        //La gran diferencia con los procedimientos, es que si o si debemos retorna un valor con el mismo tipo que creamos la función
        //En este caso creamos la función con un tipo "double", por lo cual debemos retornar un valor de tipo "double", si lo hacemos con otro tipo nos dará error.
        return resultado;
    }

    // Función con paramtros
    //Como se mencinó anterimente, los parametros son datos que solicita la función para poder usarlos
    //En este caso la función solicita que al momento de ser llamado se le envié dos Tipos de dato Int
    public static int suma(double n1, int n2) {
        //En este caso solicitamos un double y un int, y deseamos sumar esos dos valores para luego retornarlo como int, ya que la función es de tipo int.
        //Sin embargo, la suma de un int y doble, nos da como resultado double, por lo cual realizamos un casteo del double a int, para tener un resultado de tipo int.
        int res = (int) n1 + n2;

        //Notar que lo que estamos retornando es un int, ya que la función fue creado como tipo int
        return res;
    }
}
