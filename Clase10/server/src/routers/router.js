const express = require('express')
const router=express.Router()

const {saludar}= require('../controllers/holamundo')
const {CargarEmpleados, 
    GetAllEmpleados, 
    CargarGerentes,
    GetAllGerentes
}=require('../controllers/Admin')

/* 
get ---Envía datos al cliente
post -- Recibe datos del cliente y le envia una resuesta
put -- Recibe datos del cliente (son para actulizar) y le envia una respusta
delete -- Recibe datos del cliente y le envia una respuesta
*/
//Endpoint tipo Get
router.get('/saludo',saludar )
router.get('/getEmpleados',GetAllEmpleados )
router.get('/getGerentes',GetAllGerentes )
//Endpoint tipo post
router.post('/cargarempleado',CargarEmpleados )
router.post('/cargargerente',CargarGerentes )

module.exports = router