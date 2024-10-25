const express = require('express')
const router = express.Router() // Creación de un  Express router

//Importamos los controladores que usaremos
const { saludar } = require('../controllers/holamundo')
const { CargarEmpleados,
    GetAllEmpleados,
    CargarGerentes,
    GetAllGerentes,
    CargarProyectos,
    EditarGerente } = require('../controllers/Admin')

const { login } = require('../controllers/login')
/* 
Tipos de Peticiones:
    get ---Envía datos al cliente
    post -- Recibe datos del cliente y le envia una resuesta
    put -- Recibe datos del cliente (son para actulizar) y le envia una respusta
    delete -- Recibe datos del cliente y le envia una respuesta
*/

//Endpoint tipo Get
router.get('/saludo', saludar)
router.get('/getEmpleados', GetAllEmpleados)
router.get('/getGerentes', GetAllGerentes)
//Endpoint tipo post
router.post('/cargarempleado', CargarEmpleados)
router.post('/cargargerente', CargarGerentes)
router.post('/cargarproyecto', CargarProyectos)
router.post('/login', login)


// PUT
router.put('/editargerente', EditarGerente);

module.exports = router  //Importamos el router para usarlo en "app.js"