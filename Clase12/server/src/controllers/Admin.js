// Importa los modelos (clases) de Gerente y Empleado desde la carpeta de models
const Gerente = require('../models/Gerente');
const Empleado = require('../models/Empleado');
const Proyecto= require("../models/Proyecto")
// Importa las listas donde se almacenan los empleados y gerentes desde la base de datos
const { list_empleados, list_gerentes, list_Proyectos } = require('../database/dataList');

// Función para cargar (agregar) empleados
function CargarEmpleados(req, res) {
    try {
        // Obtiene el array de empleados desde el cuerpo de la solicitud HTTP
        const userArray = req.body;

        // Recorre el array de empleados
        for (const userData of userArray) {
            // Extrae los campos necesarios de cada empleado
            const { codigo, nombre, contrasenia, edad } = userData;

            // Crea un nuevo empleado usando el modelo Empleado
            const newEmpleado = new Empleado(codigo, nombre, contrasenia, edad);

            // Agrega el nuevo empleado a la lista global de empleados
            list_empleados.push(newEmpleado);
        }

        // Envía una respuesta JSON indicando que los empleados fueron agregados correctamente
        res.json({
            mensaje: "Empleados Agregados correctamente",
            state: true
        });

    } catch (error) {
        // En caso de error, lo registra en la consola y envía una respuesta JSON con el estado de error
        console.log(error);
        res.json({
            mensaje: "Ocurrió un error al procesar el JSON",
            state: false
        });
    }
}

// Función para obtener todos los empleados
function GetAllEmpleados(req, res) {
    try {
        // Envía una respuesta JSON con la lista de empleados
        res.json({
            usuarios: list_empleados,
            state: true
        });

    } catch (error) {
        // En caso de error, lo registra en la consola y envía una respuesta JSON con el estado de error
        console.log(error);
        res.json({
            mensaje: "Ocurrió un error al obtener todos los empleados",
            state: false
        });
    }
}

// Función para cargar (agregar) gerentes
function CargarGerentes(req, res) {
    try {
        // Obtiene el array de gerentes desde el cuerpo de la solicitud HTTP
        const userArray = req.body;

        // Recorre el array de gerentes
        for (const userData of userArray) {
            // Extrae los campos necesarios de cada gerente
            const { codigo, nombre, contrasenia, edad } = userData;

            // Crea un nuevo gerente usando el modelo Gerente
            const newGerente = new Gerente(codigo, nombre, contrasenia, edad);

            // Agrega el nuevo gerente a la lista global de gerentes
            list_gerentes.push(newGerente);
        }

        // Envía una respuesta JSON indicando que los gerentes fueron agregados correctamente
        res.json({
            mensaje: "Gerentes Agregados correctamente",
            state: true
        });

    } catch (error) {
        // En caso de error, lo registra en la consola y envía una respuesta JSON con el estado de error
        console.log(error);
        res.json({
            mensaje: "Ocurrió un error al procesar el JSON",
            state: false
        });
    }
}

// Función para obtener todos los gerentes
function GetAllGerentes(req, res) {
    try {
        // Envía una respuesta JSON con la lista de gerentes
        res.json({
            usuarios: list_gerentes,
            state: true
        });

    } catch (error) {
        // En caso de error, lo registra en la consola y envía una respuesta JSON con el estado de error
        console.log(error);
        res.json({
            mensaje: "Ocurrió un error al obtener todos los gerentes",
            state: false
        });
    }
}



function CargarProyectos(req, res) {
    try {
        const proyectoArray = req.body
        var sinGerente = false
        for (const proyectoData of proyectoArray) {
            const { codigo, nombre, gerente } = proyectoData;
            //Buscar al gerente en la lista de gerentes por su código
            /*[
                Gerente {
                    codigo: 'GER-P01',   
                    nombre: 'Juan Pérez',
                    password: '1234',    
                    edad: 28,
                    proyectos: []
                },
                Gerente {
                    codigo: 'GER-P02',
                    nombre: 'Ana Gómez',
                    password: 'abcd',
                    edad: 32,
                    proyectos: []
                }
            ]*/
            const gerenteEncontrado = list_gerentes.find(g => g.codigo === gerente);
            if (gerenteEncontrado) {
                const newProyecto = new Proyecto(codigo, nombre, gerente);
                list_Proyectos.push(newProyecto);
                gerenteEncontrado.proyectos.push(codigo);
            } else {
                sinGerente = true
            }

        }

        if (sinGerente === true) {
            res.json(
                {
                    mensaje: 'No se agregaron todos los proyectos debido a que no se encuentro el gerente',
                    state: true
                }
            );
        } else {
            // Respondemos con un mensaje de éxito
            res.json(
                {
                    mensaje: 'Proyecto Agregados correctamente',
                    state: true
                }
            );
        }


    } catch (error) {

        res.json({
            mensaje: 'Ocurrió un error al procesar el JSON',
            state: false
        });
    }
}


// Exporta las funciones para que puedan ser usadas en otros archivos
module.exports = {
    CargarEmpleados,
    GetAllEmpleados,
    CargarGerentes,
    GetAllGerentes,
    CargarProyectos
};
