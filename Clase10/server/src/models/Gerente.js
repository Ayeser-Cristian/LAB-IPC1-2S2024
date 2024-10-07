class Gerente{
    constructor(codigo, nombre, password, edad){
        this.codigo=codigo
        this.nombre= nombre
        this.password=password;
        this.edad=edad
        this.proyectos=[]
    }
    saludar(){
        console.log("Hola soy: "+this.nombre)
    }
}

module.exports=Gerente