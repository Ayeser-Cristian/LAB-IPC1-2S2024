package ejemplo2;

//Es la librería que permite el ingreso de datos desde consola para el usuario(el Scanner)
import java.util.Scanner;

public class Ejemplo2 {

    public static void main(String[] args) {

        //Input: Ingresar datos en la consola (Pedir que se ingresen datos)
        System.out.println("------------INPUT---------------");
        //Crear un objeto para solicitar los datos
        //Como recomendación creemos dos Scanner, uno para solicitar números (decimales o enteros) y uno para solicitar texto.
        /*Scanner ingresoValor= new Scanner(System.in); //Scanner para solicitar valores númericos
        Scanner ingresoTexto= new Scanner(System.in); //Scanner para solicitar texto
        
        
        int edad; //Creamos una variable en la cual usaremos para almacenar el dato que el usario ingresará
        //Solicitamos al usuario que ingrese su edad (tipo int)
        System.out.print("Ingresa su edad: ");
        /* Para solicitar la edad y almacenarlo en la variable edad, hacemos lo siguiente:
            - Lllamos nuestro Scanner para numeros que anteriomente creamos (Scanner ingresoValor=new Scanner(System.in))
            - Lo igualamos con la variable donde queremos que se guarde el valor que se ingresará
         
        edad=ingresoValor.nextInt(); //Notar que al guardarlo en una variable de tipo int, el comando que usamos es ".nextInt()"  
        System.out.println("    *Tu edad es: "+edad);
        
        double peso;  //Solicitamos al usuario que ingrese su peso (tipo double)
        System.out.print("Ingresa tu peso:");
        /* Para solicitar el peso y almacenarlo en la variable peso, hacemos lo siguiente:
            - Lllamos nuestro Scanner para numeros que anteriomente creamos (Scanner ingresoValor=new Scanner(System.in))
            - Lo igualamos con la variable donde queremos que se guarde el valor que se ingresará
         */
 /*
        peso=ingresoValor.nextDouble(); //Notar que al guardarlo en una variable de tipo double, el comando que usamos es ".nextDouble()"
        System.out.println("    *Tu peso es: "+peso);
        
        
        //Solicitamos al usuario que ingrese su nombre (tipo String)
        String nombre;
        
        System.out.print("Ingresa tu nombre:");
        /* Para solicitar el nombre y almacenarlo en la variable nombre, hacemos lo siguiente:
            - Llamos nuestro Scanner para texto que anteriomente creamos (Scanner ingresoTexto=new Scanner(System.in))
            - Lo igualamos con la variable donde queremos que se guarde el valor que se ingresará
         */
 /*
        nombre=ingresoTexto.nextLine(); //Notar que al guardarlo en una variable de tipo String, el comando que usamos es ".nextLine()"
        System.out.println("    *Tu nombre es: "+nombre);*/

        //Operadores Aritmeticos
        System.out.println("-------Operadores Aritmeticos---------");
        int n1 = 50, n2 = -10;
        double val1 = 5.52;

        int resultado;
        //Podemos realizar operaciones aritmeticas y el compilador respetara la jerarquía de operaciones
        resultado = n1 - n2 * 8;
        System.out.println("Resultado de la operacion: " + resultado);

        double resultado2 = n1 - n2 * 8 * val1;
        System.out.println("Resultado de la operacion: " + resultado2);

        //Podemos realizar operaciones directamente en un sout
        System.out.println(5 + 5);
        System.out.println("Resultado de 5%7 es: " + (5 % 7));

        System.out.println("-------Operadores Compuestos--------");
        //Le suma a sí mismo un 1
        n1++; //Es igual a decir n1=n1+1;
        System.out.println("Resultado aumento: " + n1);

        n1 += 5; //Es igual a decir n1=n1+5;
        System.out.println("Resultado aumento: " + n1);
        n1 *= 2; //Es igual a decir n1=n1*2;
        System.out.println("Resultado aumento: " + n1);

        System.out.println("-------Operadores Relacionales--------");
        System.out.println(5 > 8);
        System.out.println(9 >= 8);
        System.out.println(8 == 8);
        System.out.println(8 != 8);

        //Comparar textos Iguales
        System.out.println("hola".equals("hola"));
        //Comparar textos diferentes
        System.out.println(!"hola".equals("hola"));

        System.out.println("-------Operadores Logicas--------");
        //Operador Lógico: AND
        //Recordar que solo es verdadero cuando ambas condiciones son verdaderas
        System.out.println(5 == 6 && 9 > 8);
        //Operador Lógico: OR
        //Recordar que es verdadero cuando una es verdadero o ambas son verdaderos
        System.out.println(5 == 6 || 9 > 8);
        //Operador logico: NOT
        System.out.println(!(5 == 6 && 9 > 8));
        //                   true && true && false || true
        //                      true && true
        System.out.println(5 < 7 || 6 > 7 && 67 <= 98 && !(6 < 8) || 8 == 8);
        //Si no se recuerdan de esto, puedo ver las tablas de verdad en google

        System.out.println("--------ESTRUCTUTA DE CONTROL IF------------");

        double notaLab = 94;
        // El bloque if evalúa si la variable notaLab está en el rango de 90 a 100
        if (notaLab >= 90 && notaLab <= 100) {
            // Si la condición es verdadera, se ejecuta este bloque de código
            System.out.println("Tuviste una excelente nota: " + notaLab);

            // Si la condición del if no es verdadera, se pasa al bloque else if para realizar otra verificación
        } else if (notaLab >= 70 && notaLab < 90) {

            // Este bloque se ejecuta si la nota no está en el rango entre 70 y 89
            System.out.println("Tuviste una muy buena nota: " + notaLab);

            // Si la condición del primer else if no es verdadera, se pasa al siguiente bloque else if para otra verificación    
        } else if (notaLab >= 61 && notaLab < 70) {

            // Este bloque se ejecuta si la nota no está en los rangos  entre 61 y 69
            System.out.println("Tuviste una nota regular: " + notaLab);

            // Si la nota no está en ninguno de los rangos anteriores, se pasa al siguiente bloque else if    
        } else if (notaLab < 61 && notaLab >= 0) {

            // Este bloque se ejecuta si la nota  es menor que 61 y igual o mayor a 0
            System.out.println("Pediste el Lab :c");

            // Si la nota no está en ninguno de los bloques anteriores, se ejecuta el bloque else
        } else {
            // Este bloque se ejecuta si la nota no cumple con ninguna de las condiciones anteriores
            System.out.println("La nota ingresa no es valida");

        }

        System.out.println("--------------ESTRUCTURA DE CONTROL SWITCH---------");

        String dia = "domingo";

        // La estructura switch evalúa la variable "dia"
        switch (dia) {

            // Case "lunes": Se verifica si "dia" es igual a "lunes"
            case "lunes":
                // Si la condición es verdadera, se ejecuta este bloque
                System.out.println("Es el dia Lunes");
                // El break indica que se debe salir del switch después de ejecutar este bloque
                break;

            // Case "martes": Se verifica si "dia" es igual a "martes"
            case "martes":
                // Si la condición es verdadera, se ejecuta este bloque
                System.out.println("Es el dia martes");
                // El break indica que se debe salir del switch después de ejecutar este bloque
                break;
            default:
                // Se ejecuta este bloque si no se encuentra un caso coincidente
                System.out.println("El dia ingresado no existe");
                // El break indica que se debe salir del switch después de ejecutar este bloque
                break;
        }

        System.out.println("--------------CICLO FOR---------");
        System.out.println("For Incremental: ");
        // Inicia un bucle for con la variable de control i inicializada en 0
        // La condición de continuación es que i sea menor que 5.
        // El bucle sigue ejecutándose mientras la condición i < 5 sea verdadera
        // Después de cada iteración, i se incrementa en 1
        for (int i = 0; i < 5; i++) {
            // En cada iteración, se ejecuta el siguiente bloque de código e i aumenta se suma así mismo 1
            System.out.println(i);
        }
        // Después de que el bucle ha completado todas las iteraciones, el programa continúa con el código siguiente

        System.out.println("For decremental: ");

        // Inicia un bucle for con la variable de control i inicializada en 5
        // La condición de continuación es que i sea mayor o igual a 0
        // El bucle sigue ejecutándose mientras la condición i >= 0 sea verdadera
        // Después de cada iteración, i se decrementa en 1
        for (int i = 5; i >= 0; i--) {
            // En cada iteración, se ejecuta el siguiente bloque de código e i decrementa en 1
            System.out.println(i);
        }
        // Después de que el bucle ha completado todas las iteraciones, el programa continúa con el código siguiente

        System.out.println("--------------CICLO WHILE---------");

        int contador = 0;

        // Este es el inicio del bucle while. La condición es que el valor de 'contador' sea menor que 10.
        /*El bucle se ejecutará mientras la condición contador < 10 sea verdadera. En cada iteración, se 
        imprimirá el valor actual de contador y se incrementará en 1. El bucle continuará hasta que la 
        condición sea falsa, es decir, cuando contador alcance o supere el valor de 10. */
        System.out.println("While 1: ");
        while (contador < 10) {
            // Imprime el valor actual de 'contador' en la consola.
            System.out.println(contador);

            // Incrementa el valor de 'contador' en 1 en cada iteración del bucle.
            contador++;
        }

        System.out.println("While 2: ");
        int cont2 = 0;
        //Este while se ejecuta siempre, ya que su condición siempre es verdadero (true)
        while (true) {
            System.out.println(cont2);
            cont2++;
            if (cont2 >= 5) {
                //Otra forma de detener un ciclo es usando 'break', el cual rompe el ciclo.
                //En este caso colocamos que cuando cont2 sea mayor o igual a 5, rompa el ciclo while.
                break;
            }
        }

        System.out.println("--------------CICLO DO WHILE---------");

        // Inicio de un bucle 'do-while'. Este bucle se ejecutará al menos una vez, ya que la condición se evalúa al final.
        int cont3 = 1;
        do {
            // Imprime un mensaje indicando que se ha ingresado al ciclo
            System.out.println("Entro al ciclo");
            // Incrementa el valor de 'cont3' en 1 en cada iteración
            cont3++;
        } while (cont3 <= 3); //Mientras 'cont3' sea menor o igual a 3 el ciclo se seguirá ejecutando.
    }

}
