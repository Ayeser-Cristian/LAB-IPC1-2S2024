// Importa los modelos (clases) de Gerente y Empleado desde la carpeta de models
const Gerente = require('../models/Gerente');
const Empleado = require('../models/Empleado');

// Importa las listas donde se almacenan los empleados y gerentes desde la base de datos
const { list_empleados, list_gerentes } = require('../database/dataList');

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

// Exporta las funciones para que puedan ser usadas en otros archivos
module.exports = {
    CargarEmpleados,
    GetAllEmpleados,
    CargarGerentes,
    GetAllGerentes
};
