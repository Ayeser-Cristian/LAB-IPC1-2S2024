import React, { useState } from 'react'
import { loginAuth } from '../services/auth'
import { useNavigate } from 'react-router-dom';

import { useCookies } from 'react-cookie';
import './styles/login.css'



import Swal from 'sweetalert2';
const Login = () => {

    const [cookies, setCoookies] = useCookies(['usuario'])
    const navigate = useNavigate();

    const [carnet, setCarnet] = useState(0); // Estado para almacenar el carnet
    const [password, setPassword] = useState(''); // Estado para almacenar la contraseña
    const [role, setRole] = useState('admin'); // Estado para almacenar el rol seleccionado

    const handleSubmit = async (e) => {
        e.preventDefault();  // Evita el envío del formulario y la recarga de la página

        const credentials = {
            codigo: carnet,
            password: password,
            rol: role
        }

        const response = await loginAuth(credentials)

        if (response.state === true) {
            Swal.fire({
                title: 'Inicio de sesión!',
                text: `Bienvenido`,
                icon: 'success',
                confirmButtonText: 'Ok'
            }).then(() => {
                setCoookies("usuario", response.datos)
                if (response.datos.role === "admin") {
                    navigate("/admin/gerente")
                } if (response.datos.role === "gerente") {
                    navigate("/gerente/home")
                } else if (response.datos.role === "empleado") {
                    //navegamos a la ventana del empleado
                }
            });

        } else {
            Swal.fire({
                title: 'Error!',
                text: `Credenciales Incorrectas`,
                icon: 'error',
                confirmButtonText: 'Ok'
            });
        }
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