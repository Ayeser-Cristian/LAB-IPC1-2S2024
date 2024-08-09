package ejemplo1;

public class Ejemplo1 {

    public static void main(String[] args) {
        /*DECLARACIÓN DE OBJETO
        La forma de declarar un objeto es de la siguiente forma:
            NombreClase variable = new NombreClase();
         */
        //Creando una instanacia de la clase "Persona", es decir, un objeto
        //Creando Objeto 1
        System.out.println("=================PERSONA 1===================");
        //Para crear el objeto llenamos los parametros que solicitamos en el costructor de la clase,
        //lo cual sirve para ponerle valores iniciales a sus atributos.
        Persona perso_1 = new Persona("Ayeser", 23, 'M', 1.66);

        //Podemos acceder a los atributos de la clase de la siguient forma:
        System.out.println("Nombre de Perso_1: " + perso_1.getNombre());
        /*
        Cabe mencionar que podemos acceder a sus atributos de la siguiente forma, si en dado caso los dejaramos publicos:
        System.out.println("Nombre de Perso_1: "+ perso_1.nombre);
        
        Pero se recomienda poner los atributos privados y hacer el encapsulamineto (métodos get y set)
         */

        //Podemos modificar los atributos de la clase de la siguient forma:
        perso_1.setNombre("Cristian");
        /*
        Cabe mencionar que podemos modificar sus atributos de la siguiente forma, si en dado caso los dejaramos publicos:
        perso_1.nombre="Cristian";
        
        Pero se recomienda poner los atributos privados y hacer el encapsulamineto (métodos get y set)
         */
        //Imprimos el nombre ya modificado
        System.out.println(perso_1.getNombre());

        //Podemos acceder a sus métodos creados en la clase de la siguiente forma (los métodos son las acciones que puede realizar el objeto): 
        perso_1.presentarme(); //En este método el objeto 1 se presenta
        perso_1.comer("Tamales"); //En este método el objeto indica que esta comientod

        System.out.println("===============PERSONA 2=====================");

        /*Creando Objeto 2
        De la misma clase vamos a crear otra instancia, pero ahora los atributos tendrán diferentes valores
        Pensemos que ahora tenemos dos personas diferentes creados por el molde de la clase "Persona"*/
        //Para crear el objeto llenamos los parametros que solicitamos en el costructor de la clase,
        //lo cual sirve para ponerle valores iniciales a sus atributos.
        Persona perso_2 = new Persona("Belen", 22, 'F', 1.60);

        //Llamando método de la persona 2 para que se presnete
        perso_2.presentarme();

        System.out.println("================ESTUDIANTE 1==================");

        //Ahora tenemos otra clase, una clase llamada "Estudiante"
        //Recordemos que para fines de ejemplo esta clase hereda los atributos y métodos que tiene la clase "Persona"
        Estudiante student_1 = new Estudiante("Ricardo", 19, 'M', 1.80, 202310025, "Sistemas");

        //A pesar de que este método "presentarme()" no existe en la clase "Estudiante", podemos usarlo, ya que como se mencionó
        //la clase "Estudiante" hereda los atributos y métodos de la clase "Persona", en la cual se encuentra el método "presentarme()".
        student_1.presentarme();

        //Llamamos el método "VerMiNota()" de la clase Estudiante.
        student_1.verMiNota(95);
    }

}
