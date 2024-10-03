function saludar(rep, res){

    res.json(
        {
        mensaje: 'Hi, this is my first API',
        clase: "IPC1"
        }
   );
}


module.exports= {
    saludar
}