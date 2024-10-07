const Gerente = require('../models/Gerente')
const Empleado = require('../models/Empleado')
const {list_empleados, list_gerentes}= require('../database/dataList')

//Para Empleados
function CargarEmpleados(req, res){
    try {
        const userArray=req.body
        for(const userData of userArray){
            const {codigo, nombre, contrasenia, edad}=userData

            const newEmpleado= new Empleado(codigo, nombre, contrasenia, edad)
            list_empleados.push(newEmpleado)
        }
        res.json(
            {
                mensaje: "Empleados Agregados correctamente",
                state: true
            }
        )

    } catch (error) {
        console.log(error)
        res.json(
            {
                mensaje: "Ocurrió un error al procesar el JSON",
                state: false
            }
        )
    }
    
}

function GetAllEmpleados(req, res){
    try {
        
        res.json(
            {
                usuarios:list_empleados,
                state: true
            }
        )

    } catch (error) {
        console.log(error)
        res.json(
            {
                mensaje: "Ocurrió un error al obtener todos los empleados",
                state: false
            }
        )
    }
    
}

//Para Gerentes
function CargarGerentes(req, res){
    try {
        const userArray=req.body
        for(const userData of userArray){
            const {codigo, nombre, contrasenia, edad}=userData

            const newGerente= new Gerente(codigo, nombre, contrasenia, edad)
            list_gerentes.push(newGerente)
        }
        res.json(
            {
                mensaje: "Gerentes Agregados correctamente",
                state: true
            }
        )

    } catch (error) {
        console.log(error)
        res.json(
            {
                mensaje: "Ocurrió un error al procesar el JSON",
                state: false
            }
        )
    }
    
}

function GetAllGerentes(req, res){
    try {
        
        res.json(
            {
                usuarios:list_gerentes,
                state: true
            }
        )

    } catch (error) {
        console.log(error)
        res.json(
            {
                mensaje: "Ocurrió un error al obtener todos los gerentes",
                state: false
            }
        )
    }
    
}


module.exports= {
    CargarEmpleados,
    GetAllEmpleados,
    CargarGerentes,
    GetAllGerentes
}