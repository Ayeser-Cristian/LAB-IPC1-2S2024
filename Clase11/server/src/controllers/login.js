
const { list_empleados, list_gerentes } = require('../database/dataList');

function login(req, res) {
    try {
        /*
        Recibimos el siguiente JSON:
            {
                "codigo": "COD-4343",
                "password": "HolaMundo1*",
                "rol": "gerente"  // o "empleado"
            }
        */

        // Obtenemos los valores que nos mandan desde el JSON
        const codigo1 = req.body.codigo;
        const password1 = req.body.password;
        const rol = req.body.rol;

        if (rol === "gerente") {

            // Buscar el usuario en la lista de gerentes por su código y contraseña
            const usuarioEncontrado = list_gerentes.find(x_user => x_user.codigo === codigo1 && x_user.password === password1);
            //null
            // Si se encuentra el usuario, devolvemos sus datos (excepto la contraseña)
            if (usuarioEncontrado != null) {
                const userFind = {
                    codigo: usuarioEncontrado.codigo,
                    nombre: usuarioEncontrado.nombre,
                    edad: usuarioEncontrado.edad,
                    role: rol
                }
                res.json({
                    state: true,
                    datos: userFind
                })
            } else {
                 // Si no se encuentra, devolvemos un error de credenciales
                res.json({
                    state: false,
                    error: "Código o contraseña incorrectas"
                })
            }
        } 
        // Validamos si el rol es "empleado"
        else if (rol === "empleado") {


            // Buscar el usuario en la lista de gerentes por su código y contraseña
            const usuarioEncontrado = list_empleados.find(x_user => x_user.codigo === codigo1 && x_user.password === password1);
            //null

            // Si se encuentra el usuario, devolvemos sus datos (excepto la contraseña)
            if (usuarioEncontrado != null) {
                const userFind = {
                    codigo: usuarioEncontrado.codigo,
                    nombre: usuarioEncontrado.nombre,
                    edad: usuarioEncontrado.edad,
                    role: rol
                }
                res.json({
                    state: true,
                    datos: userFind
                })
            } else {
                res.json({
                    state: false,
                    error: "Código o contraseña incorrectas"
                })
            }

        } else {
            res.json({
                state: false,
                error: "Rol inválido"
            })
        }

    } catch (error) {
        res.json({
            state: false,
            error: "Ocurrió un error en el endpoint del login"
        })
    }
}


module.exports = {
    login
}