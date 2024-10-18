import React, { useState, useEffect, useRef } from 'react';
import { useNavigate } from 'react-router-dom';


const DetallesProyecto = () => {

    const navigate = useNavigate();

    const proyectoDetalles = JSON.parse(localStorage.getItem('proyectoDetalles'));
    const [nombreProyecto, _setNombreProyecto] = useState(proyectoDetalles.nombre || "");
    const [codigoProyecto, _setCodigoProyecto] = useState(proyectoDetalles.codigo || "0");

    const [listaEmpleadosProyecto, setListaEmpleadosProyecto] = useState([]);

    const [selectedFile, setSelectedFile] = useState(null);
    const fileInputRef = useRef(null);

    const handleCargar = (event) => {
        const file = event.target.files[0];
        if (file) {
            setSelectedFile(file);
        }
    };

    useEffect(() => {
        obtenerDetallesCurso();
    }, []);

    const obtenerDetallesCurso = async () => {
        const response = await fetch(`http://localhost:5000/gerente/detalles/${codigoProyecto}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        });
        const result = await response.json();
        if (result.state === true) {
            setListaEmpleadosProyecto(result.empleados);
        } else {
            alert(result.mensaje);
        }
    };


    const handleEnviar = async () => {

        if (!selectedFile) {
            alert('No se ha seleccionado ningún archivo.');
        } else {

            const jsonData = await selectedFile.text();
            const empleadosArray = JSON.parse(jsonData);

            const EnviarDatos = {
                codigoProyecto: codigoProyecto,
                ListaAsignacion: empleadosArray
            }

            const response = await fetch('http://localhost:5000/gerente/asignar', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(EnviarDatos),
            });

            const result = await response.json();

            if (result.state !== true) {
                alert(result.mensaje);
            } else {
                obtenerDetallesCurso()
            }
        }
    }


    return (
        <div>
            <h2>Proyecto: {nombreProyecto}</h2>
            <h2>Codigo: {codigoProyecto}</h2>

            <div className="button-group" style={{ marginBottom: '20px' }}>

                <button
                    style={{ marginRight: '10px' }}
                    className="btn btn-secondary"
                    onClick={() => navigate('/gerente/home')}
                >
                    Regresar
                </button>


                <input
                    style={{ marginRight: '10px' }}
                    type="file"
                    accept=".json"
                    onChange={handleCargar}
                    ref={fileInputRef}
                />

                <button
                    style={{ marginRight: '10px' }}
                    onClick={handleEnviar}
                    className="btn btn-success"
                >
                    Enviar
                </button>
            </div>
            <table className="table table-striped w-80">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nombre Completo</th>
                    </tr>
                </thead>
                <tbody>
                    {listaEmpleadosProyecto.map((user) => (
                        <tr key={user.codigo}>
                            <td>{user.codigo}</td>
                            <td>{user.nombreCompleto}</td>
                        </tr>
                    ))}
                </tbody>
            </table>

        </div>
    )
};

export default DetallesProyecto;