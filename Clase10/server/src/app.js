
// Importación de los módulos necesarios
const express = require('express') // Importa el framework Express para la creación de la aplicación web
const cors = require('cors') // Importa el módulo CORS para habilitar el intercambio de recursos entre diferentes orígenes (Cross-Origin Resource Sharing)
const bodyParser = require('body-parser'); // Importa el middleware para analizar los cuerpos de las solicitudes HTTP

// Creación de la aplicación Express
const MyApp = express(); // Inicializa la aplicación utilizando el framework Express

// Configuración del body-parser para manejar solicitudes con cuerpos JSON grandes
MyApp.use(bodyParser.json({ limit: '15mb' })); // Establece un límite de tamaño máximo de 15 MB para el cuerpo de la solicitud en formato JSON

// Middleware para analizar los cuerpos de las solicitudes en formato JSON
MyApp.use(express.json()) 

// Middleware para permitir solicitudes CORS (Cross-Origin Resource Sharing) desde el frontend
MyApp.use(cors()) // Habilita la posibilidad de que el servidor reciba solicitudes desde otros dominios o puertos (fuera del origen)

// Importación y uso de las rutas definidas en el archivo './routers/router.js'
const MyRouter = require('./routers/router')

// Usar las rutas importadas en la aplicación
MyApp.use(MyRouter) // Asocia las rutas al servidor Express

// Exportación del módulo MyApp para que pueda ser utilizado en otros archivos
module.exports = MyApp