import React, { useState } from 'react'

import './styles/login.css'
const Login = () => {

    const [carnet, setCarnet] = useState(0); // Estado para almacenar el carnet
    const [password, setPassword] = useState(''); // Estado para almacenar la contraseña
    const [role, setRole] = useState('admin'); // Estado para almacenar el rol seleccionado

    const handleSubmit=(e)=>{
        e.preventDefault();  // Evita el envío del formulario y la recarga de la página

        console.log(carnet)
        console.log(password)
        console.log(role)
    }
    return (
        <div className='login-body'>
            <div className='login-container '>
                <h1>LOGIN</h1>
                <form onSubmit={handleSubmit}>
                    <div className="form-group">
                        <label>Carnet:</label>
                        <input
                            type="text"
                            value={carnet}
                            onChange={(e) => setCarnet(e.target.value)}
                            placeholder='Ej: 202010025'
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label>Contraseña:</label>
                        <input
                            type="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                        />
                    </div>

                    <div className="form-group">
                        <label>Rol:</label>
                        <select value={role} onChange={(e) => setRole(e.target.value)} > {/* Selección del rol */}
                            <option value="admin">Admin</option> {/* Opción para Admin */}
                            <option value="gerente">Gerente</option> {/* Opción para Gerente */}
                            <option value="empleado">Empleado</option> {/* Opción para Empleado */}
                        </select>
                    </div>
                    <button type='submit' className='login-button'>Ingresar</button>
                </form>
            </div>

        </div>

    )

}

export default Login;