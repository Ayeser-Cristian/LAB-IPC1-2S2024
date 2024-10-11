import React, { useState, useRef, useEffect } from 'react'
import Navbar from '../../components/NabBar';
import '../styles/admin.css'
import {adminCargarGerente, obtenerGerentes} from '../../services/admin'
const Gerente = () => {

    const [Listagerentes, setListaGerentes] = useState([]);

    const [selectedFile, setSelectedFile] = useState(null);
    const fileInputRef = useRef(null);

    useEffect(() => {
        obtenerGerente()
    }, [])

    const obtenerGerente = async (event) => {
        

        const result = await obtenerGerentes()

        if (result.state === true) {
            setListaGerentes(result.usuarios)
        } else {
            alert("Error al obtener los empleados")
        }
    }


    const handleCargar = (event) => {
        const file = event.target.files[0];
        if (file) {
            setSelectedFile(file);
        }
    }

    const handleEnviar = async () => {
        if (!selectedFile) {
            console.log("No se ha seleccionado ninngún archivo")
        } else {

            const jsonData = await selectedFile.text()
            const gerenteArray = JSON.parse(jsonData)

            const resultado= await adminCargarGerente(gerenteArray)

            if (resultado.state !== true) {
                alert("Error al enviar los datos al backend")
            } else {
                alert(resultado.mensaje)
                obtenerGerente()
            }
            setSelectedFile(null)
            fileInputRef.current.value = ""
            
        }
    }
    return (
        <div className='conteiner-admin'>
            <Navbar />
            <div>
                <h2>Lista de Gerentes</h2>
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
                        {Listagerentes.map((user) => (
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

export default Gerente;