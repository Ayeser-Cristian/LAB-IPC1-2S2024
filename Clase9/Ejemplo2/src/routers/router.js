const express = require('express')

const router = express.Router() // Creación de un  Express router

//Exportamos todos los "controllers" que creamos
const {saludar} = require('../controllers/holamundo')


//Creamos las rutas para cada EndPoint con su respectivo controlador

//Get 
router.get('/saludo', saludar)
//Post


module.exports= router //Importamos el router para usarlo en "app.js"