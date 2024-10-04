import React, { useState } from 'react'
import Navbar from '../../components/NabBar';
import '../styles/admin.css'
const Gerente = () => {

    const Mydata = [
        { codigo: '001', nombre: 'Juan Pérez', congreseña: '123456', edad: 30 },
        { codigo: '002', nombre: 'María López', congreseña: '789012', edad: 25 },
        { codigo: '003', nombre: 'Carlos García', congreseña: '345678', edad: 28 },
    ];

    return (
        <div className='conteiner-admin'>
            <Navbar />
            <div>
                <h2>Lista de Gerentes</h2>
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

export default Gerente;