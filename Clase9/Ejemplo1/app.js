// Importar Express.js
const express = require('express')

const app=express()
//Get 
//rep --> Los datos que recibe desde el cliente
//res --> Los datos que se envian al cliente como respuesta
app.get("/saludo", (rep, res)=>{

    res.send("Hola Clase de IPC1")
})
const port=5000

app.listen(port, ()=>{
    console.log("Servidor Express escuchando en el puerto:" +port)
})

