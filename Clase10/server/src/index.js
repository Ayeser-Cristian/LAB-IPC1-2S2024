// Importación de la aplicación Express desde el archivo 'app.js'
const MyApp = require('./app')
// Definición del puerto en el que la aplicación escuchará las solicitudes
const port = 5000
// Inicio del servidor y escucha de solicitudes en el puerto especificado
MyApp.listen(port, ()=>{
    console.log(`The API is listening at http://localhost:${port}`); 
})