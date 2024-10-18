import React, { useState, useEffect, useRef } from 'react';
import { useCookies } from 'react-cookie';
import NavbarGerente from '../../components/NavbarGerente';
import { useNavigate } from 'react-router-dom';
import '../styles/gerente.css'

const HomeGerente = () => {

    const navigate = useNavigate();

    const [cookies, _setCoookies] = useCookies(['usuario'])
    const datoUser = cookies.usuario

    const [listaProyectos, setListaProyectos] = useState([]);

    useEffect(() => {
        getMyProyects()
    }, []);


    

    const getMyProyects = async () => {
        //Colocat try-catch a todos los fetch

        const idGerente = await datoUser.codigo
        try {
            const response = await fetch(`http://localhost:5000/gerente/myproyectos/${idGerente}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                },
            });

            const result = await response.json()

            if (result.state === true) {
                setListaProyectos(result.proyectos)
            } else {
                alert('Error al obtener los empleados');
            }



        } catch (error) {
            console.log('Error al obtener los listaProyectos:', error);
        }
    }


    const handleDetallesClick=(codigo, nombre)=>{
        const proyectoDetalles={
            codigo: codigo,
            nombre:nombre
        }

        localStorage.setItem("proyectoDetalles", JSON.stringify (proyectoDetalles) )

        navigate("/gerente/detalles-proyecto")
    }

    return (
        <div>
            <NavbarGerente />

            <div className='conteiner-gerente'>


                {
                    listaProyectos.map((proyecto, index) => (
                        <div key={index} className="card w-50">
                            <div className="card-header">
                                <h5>{proyecto.codigo}</h5>
                            </div>
                            <div className="card-body">
                                <p className="card-text">{proyecto.nombre}</p>
                                <button className="btn btn-primary" onClick={() => handleDetallesClick(proyecto.codigo, proyecto.nombre)}>
                                    Detalles
                                </button>
                            </div>
                            <div className="card-footer">
                                Empleados: {proyecto.cantidadEmpleados}
                            </div>
                        </div>
                    ))

                }


            </div>
        </div>

    )
}

export default HomeGerente;