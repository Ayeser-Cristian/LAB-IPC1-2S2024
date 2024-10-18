// Importa los modelos (clases) de Gerente y Empleado desde la carpeta de models
const Gerente = require('../models/Gerente');
const Empleado = require('../models/Empleado');
const Proyecto = require("../models/Proyecto")
// Importa las listas donde se almacenan los empleados y gerentes desde la base de datos
const { list_empleados, list_gerentes, list_Proyectos } = require('../database/dataList');


function GetProyectosByGerente(req, res) {
    try {
        /*
        {
            codigo: "PU98"
        }

        /gerente/PU98
        */
        const { gerenteId } = req.params

        const gerenteEncontrado = list_gerentes.find(g => g.codigo === gerenteId);

        if (gerenteEncontrado) {
            const MyProyectos = []

            for (const proyectoCodigo of gerenteEncontrado.proyectos) {
                const proyectoEncontrado = list_Proyectos.find(p => p.codigo === proyectoCodigo)

                if (proyectoEncontrado) {
                    const JPSONProyecto = {
                        codigo: proyectoEncontrado.codigo,
                        nombre: proyectoEncontrado.nombre,
                        gerente: proyectoEncontrado.gerente,
                        empleados: proyectoEncontrado.empleados,
                        cantidadEmpleados: proyectoEncontrado.empleados.length
                    }
                    MyProyectos.push(JPSONProyecto)
                }
            }

            res.json({
                proyectos: MyProyectos,
                state: true
            })

        }


    } catch (error) {
        res.json({
            mensaje: 'Ocurrió un error al procesar la solicitud',
            state: false
        });
    }

}


function asignarProyectos(req, res) {
    try {
        const { codigoProyecto, ListaAsignacion } = req.body;

        // Buscar el proyecto por su código
        const proyectoEncontrado = list_Proyectos.find(p => p.codigo === codigoProyecto);

        if (proyectoEncontrado===null) {
            return res.json({
                mensaje: `Proyecto con código ${codigoProyecto} no encontrado`,
                state: false
            });
        }
        // Iterar sobre la lista de asignación
        for (const asignacion of ListaAsignacion) {
            const { codigo } = asignacion;

            // Buscar al empleado en la lista de empleados
            const empleadoEncontrado = list_empleados.find(e => e.codigo === codigo);

            if (empleadoEncontrado) {
                // Agregar el empleado al proyecto
                proyectoEncontrado.empleados.push(codigo);

                // Asignar el proyecto al empleado
                empleadoEncontrado.MisProyectos.push(codigoProyecto);
            }
        }

        // Respuesta final
        res.json({
            mensaje: 'Asignación de empleados completada',
            state: true
        });

    } catch (error) {
        res.json({
            mensaje: 'Ocurrió un error al procesar el JSON',
            state: false
        });
    }
}


function GetEmpleadosByProyecto(req, res) {
    try {
        const { codigoProyecto } = req.params;

        // Buscar el proyecto por su código
        const proyectoEncontrado = list_Proyectos.find(p => p.codigo === codigoProyecto);

        if (!proyectoEncontrado) {
            return res.json({
                mensaje: `Proyecto con código ${codigoProyecto} no encontrado`,
                state: false
            });
        }

        // Inicializar un array para los detalles de los empleados
        const empleadosDetalles = [];

        // Iterar sobre los códigos de empleados asignados al proyecto
        for (const codigoEmpleado of proyectoEncontrado.empleados) {
            // Buscar al empleado en la lista de empleados
            const empleado = list_empleados.find(e => e.codigo === codigoEmpleado);
            if (empleado) {
                // Agregar el empleado a la lista de detalles
                const EmpleadoDatos={ 
                    codigo: empleado.codigo, 
                    nombreCompleto: empleado.nombre 
                }
                empleadosDetalles.push(EmpleadoDatos);
            }
        }

        // Respuesta final
        res.json({
            empleados: empleadosDetalles,
            state: true
        });

    } catch (error) {
        res.json({
            mensaje: 'Ocurrió un error al procesar la solicitud',
            state: false
        });
    }
}


module.exports = {
    GetProyectosByGerente,
    asignarProyectos,
    GetEmpleadosByProyecto
};
