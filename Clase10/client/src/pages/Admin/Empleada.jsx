import React, { useState } from 'react'
import Navbar from '../../components/NabBar';
import '../styles/admin.css'
const Empleado = () => {

    const Mydata = [
        { codigo: '101', nombre: 'Ana Gómez', congreseña: '123789', edad: 29 },
        { codigo: '102', nombre: 'Luis Rodríguez', congreseña: '456012', edad: 35 },
        { codigo: '103', nombre: 'Sofia Martínez', congreseña: '789456', edad: 27 },
    ];

    return (
        <div className='conteiner-admin'>
            <Navbar />
            <div>
                <h2>Lista de Empleados</h2>
                <div className='button-group'>
                    <button className="btn btn-primary" >
                        Cargar
                    </button>
                    <button className="btn btn-secondary">
                        Importar
                    </button>
                </div>



                <table className="table table-striped w-80">

                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Nombre</th>
                            <th>congreseña</th>
                            <th>Edad</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        {Mydata.map((user) => (
                            <tr key={user.codigo}>
                                <td>{user.codigo}</td>
                                <td>{user.nombre}</td>
                                <td>{user.congreseña}</td>
                                <td>{user.edad}</td>
                                <td>
                                    <button className="btn btn-warning">
                                        <i className="fas fa-edit"></i> {/*Modificar*/}
                                    </button>
                                    <button className="btn btn-danger" style={{ marginLeft: '10px' }}>
                                        <i class="fa-solid fa-trash"></i>
                                    </button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>

        </div>

    )

}

export default Empleado;