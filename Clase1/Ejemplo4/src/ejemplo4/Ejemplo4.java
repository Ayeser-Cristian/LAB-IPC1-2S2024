package ejemplo4;

//Es la librería que permite el ingreso de datos desde consola para el usuario(el Scanner)
import java.util.Scanner;

public class Ejemplo4 {

    // Variables globales para solicitar datos al usuario
    public static Scanner ingresoNumeros = new Scanner(System.in); // Para solicitar datos numéricos
    public static Scanner ingresoTexto = new Scanner(System.in); // Para solicitar datos de texto

    public static void main(String[] args) {
        String opcion; // Variable para almacenar la opción del menú seleccionada por el usuario
        boolean ejecutar = true; // Variable para controlar el ciclo del menú

        do {
            // Menú principal del programa
            System.out.println("--------------Menu-------------");
            System.out.println(" 1. Ver si soy de mayor de edad");
            System.out.println(" 2. Imprimir numeros segun rangos");
            System.out.println(" 3. Calcular modulo");
            System.out.println(" 4. Salir");
            System.out.println("-------------------------------");
            System.out.print("Elige una opcion:");
            opcion = ingresoTexto.nextLine(); // Leer la opción ingresada por el usuario

            switch (opcion) {
                case "1":
                    opcion1(); // Llamada a la función que verifica la mayoría de edad
                    System.out.println("");
                    break;
                case "2":
                    opcion2(); // Llamada a la función que imprime números según un rango
                    System.out.println("");
                    break;
                case "3":
                    // Variables para almacenar los números ingresados por el usuario
                    int n1,
                     n2;
                    System.out.print("Ingresa un numero:");
                    n1 = ingresoNumeros.nextInt(); // Leer el primer número
                    System.out.print("Ingresa el segundo numero:");
                    n2 = ingresoNumeros.nextInt(); // Leer el segundo número

                    // Verificar que el divisor no sea cero antes de calcular el módulo
                    if (n2 == 0) {
                        System.out.println("El divisor no puede ser cero.");
                    } else {
                        //Notar que enviamos los datos ingresados por el usuario a la función "opcion3" por medio de parametros
                        System.out.println("Resultado: " + opcion3(n1, n2)); // Mostrar el resultado del módulo
                    }

                    System.out.println("");
                    break;
                case "4":
                    ejecutar = false; // Salir del ciclo y finalizar el programa
                    System.out.println("Gracias por Usar el Programa");
                    System.out.println("");
                    break;
                default:
                    // Opción no válida
                    System.out.println("Opción no valida");
                    System.out.println("");
                    break;
            }
        } while (ejecutar); // El ciclo se repite mientras ejecutar sea true
    }

    // Función para verificar si el usuario es mayor de edad
    public static void opcion1() {
        int edad; // Variable para almacenar la edad ingresada por el usuario
        String nombre; // Variable para almacenar el nombre ingresado por el usuario

        // Solicitar nombre y edad
        System.out.print("Ingresa tu nombre: ");
        nombre = ingresoTexto.nextLine();
        System.out.print("Ingresa tu edad: ");
        edad = ingresoNumeros.nextInt();

        // Verificar la mayoría de edad y mostrar el mensaje correspondiente
        if (edad >= 18) {
            System.out.println("Te llamas " + nombre + " y ya eres mayor de edad, tienes " + edad);
        } else if (edad >= 0 && edad < 18) {
            System.out.println("Te llamas " + nombre + " y eres menor de edad, tienes " + edad);
        } else {
            System.out.println("Edad ingresada no valida");
        }
    }

    // Función para imprimir números dentro de un rango dado
    public static void opcion2() {
        int inicio, fin; // Variables para almacenar el rango inicial y final

        // Solicitar el rango al usuario
        System.out.print("Ingresa el rango inicial:");
        inicio = ingresoNumeros.nextInt();
        System.out.println("");
        System.out.print("Ingresa el rango final:");
        fin = ingresoNumeros.nextInt();

        // Imprimir números desde el rango inicial hasta el final
        for (int i = inicio; i <= fin; i++) {
            System.out.println(i);
        }
    }

    // Función para calcular el módulo de dos números
    public static int opcion3(int num1, int num2) {
        int resultado = num1 % num2; // Calcular el módulo
        return resultado; // Retornar el resultado
    }
}
