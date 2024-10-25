import React, { useState, useRef, useEffect } from 'react'
import Navbar from '../../components/NabBar';
import '../styles/admin.css'
import { adminCargarGerente, obtenerGerentes , updateGerente} from '../../services/admin'
const Gerente = () => {

    const [showModal, setShowModal] = useState(false); //Para el modal
    const [gerenteEdit, setGerenteEdit] = useState(
        {
            codigo: '',
            nombre: '',
            password: '',
            edad: ''
        });

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

            const resultado = await adminCargarGerente(gerenteArray)

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

    const handleEdit = (gerente) => {
        setGerenteEdit(gerente); // Llenar el estado con los datos del gerente seleccionado
        setShowModal(true); // Mostrar el modal
    };


    const handleChange = (e) => {
        // Actualizamos el estado 'gerenteEdit' usando 'setGerenteEdit'
        setGerenteEdit({
            // Copiamos todas las propiedades actuales de 'gerenteEdit' 
            // para mantener los valores que ya tiene
            ...gerenteEdit,

            // Usamos 'e.target.name' como clave dinámica para identificar 
            // qué campo (por su atributo 'name') se está modificando
            [e.target.name]: e.target.value

            // El valor del campo que se está modificando ('e.target.value') 
            // se asigna a la clave correspondiente. De esta manera, 
            // actualizamos solo el campo que ha cambiado en el formulario.
        });
    };

    const handleUpdate = async () => {

        const result = await updateGerente(gerenteEdit)
        if (result.state) {
            alert(result.mensaje);
            setShowModal(false); // Cerrar el modal después de actualizar
            obtenerGerente(); // Refresca la lista
        } else {
            alert(result.mensaje);
        }

    };

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
                            <th>Contraseña</th>
                            <th>Edad</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        {Listagerentes.map((user) => (
                            <tr key={user.codigo}>
                                <td>{user.codigo}</td>
                                <td>{user.nombre}</td>
                                <td>{user.password}</td>
                                <td>{user.edad}</td>
                                <td>
                                    <button className="btn btn-warning" onClick={() => handleEdit(user)}>
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

            {
                showModal && (
                    <div className="modal fade show d-block" tabIndex="-1">
                        <div className="modal-dialog">
                            <div className="modal-content">
                                <div className="modal-header">
                                    <button className="btn btn-danger" onClick={() => setShowModal(false)}>
                                        X
                                    </button>
                                </div>
                                <div className="modal-body">
                                    <h5 className="modal-title">Editar Gerente</h5>
                                    <div className="form-group">
                                        <label>Código:</label>
                                        <input disabled type="text" className="form-control" name="codigo" value={gerenteEdit.codigo} onChange={handleChange} />
                                    </div>
                                    <div className="form-group">
                                        <label>Nombre:</label>
                                        <input type="text" className="form-control" name="nombre" value={gerenteEdit.nombre} onChange={handleChange} />
                                    </div>
                                    <div className="form-group">
                                        <label>Contraseña:</label>
                                        <input type="text" className="form-control" name="password" value={gerenteEdit.password} onChange={handleChange} />
                                    </div>
                                    <div className="form-group">
                                        <label>Edad:</label>
                                        <input type="text" className="form-control" name="edad" value={gerenteEdit.edad} onChange={handleChange} />
                                    </div>
                                </div>
                                <div className="modal-footer">
                                    <button type="button" className="btn btn-secondary" onClick={() => setShowModal(false)}>Cancelar</button>
                                    <button type="button" className="btn btn-primary" onClick={handleUpdate}>Actualizar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                )
            }

        </div>

    )

}

export default Gerente;