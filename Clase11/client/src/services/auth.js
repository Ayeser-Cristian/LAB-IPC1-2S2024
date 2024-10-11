export const loginAuth = async (credentials) => {

    if (credentials.rol === "admin") {

        if (credentials.codigo === "admin" && credentials.password === "admin") {
            const response = {
                state: true,
                datos: {
                    codigo: "admin",
                    nombre: "admin",
                    edad: 28,
                    role: "admin"
                }
            }
            return response
        } else {
            const response = {
                state: false,
                error: "Credenciales incorrectas"
            }
            return response
        }

    } else {
        const response = await fetch('http://localhost:5000/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(credentials),
        });
        return response.json()
    }


}