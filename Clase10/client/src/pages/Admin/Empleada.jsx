import React, { useState, useRef, useEffect } from 'react'
import Navbar from '../../components/NabBar';
import '../styles/admin.css'
const Empleado = () => {

    const [Listaempleados, setListaEmpleados] = useState([]);

    const [selectedFile, setSelectedFile] = useState(null);
    const fileInputRef = useRef(null);

    useEffect(() => {
        obtenerEmpleados()
    }, [])

    const handleCargar = (event) => {
        const file = event.target.files[0];
        if (file) {
            setSelectedFile(file);
        }
    }

    const obtenerEmpleados = async (event) => {
        const response = await fetch('http://localhost:5000/getEmpleados', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        });

        const result = await response.json()

        if (result.state === true) {
            setListaEmpleados(result.usuarios)
        } else {
            alert("Error al obtener los empleados")
        }
    }


    const handleEnviar = async (event) => {
        if (!selectedFile) {
            console.log("No se ha seleccionado ninngún archivo")
        } else {
            const jsonData = await selectedFile.text()
            const gerentesArray = JSON.parse(jsonData)

            //Conexión con bancked (fetch)
            const response = await fetch('http://localhost:5000/cargarempleado', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(gerentesArray),
            });

            const result = await response.json()
            console.log(result)
            //------------------------------------

            if (result.state !== true) {
                alert("Error al enviar los datos al backend")
            } else {
                alert(result.mensaje)

                obtenerEmpleados()
            }
            setSelectedFile(null)
            fileInputRef.current.value = ""
        }
    }
    return (
        <div className='conteiner-admin'>
            <Navbar />
            <div>
                <h2>Lista de Empleados</h2>
                <div className='button-group'>
                    <input
                        type='file'
                        accept='.json'
                        onChange={handleCargar}
                        ref={fileInputRef}
                    />
                    <button onClick={handleEnviar} className="btn btn-primary" >
                        Enviar
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
                        {Listaempleados.map((user) => (
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
                                        <i className="fa-solid fa-trash"></i>
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