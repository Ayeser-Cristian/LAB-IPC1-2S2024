const express = require('express')
const router = express.Router() // Creación de un  Express router

const {GetProyectosByGerente, asignarProyectos, GetEmpleadosByProyecto} = require('../controllers/gerente')

//get
router.get('/gerente/myproyectos/:gerenteId', GetProyectosByGerente)
router.get('/gerente/detalles/:codigoProyecto', GetEmpleadosByProyecto);
//
//post
router.post('/gerente/asignar', asignarProyectos);




module.exports = router  //Importamos el router para usarlo en "app.js"