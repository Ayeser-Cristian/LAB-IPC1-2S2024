import React from 'react';
import { useCookies } from 'react-cookie';
import NavbarGerente from '../../components/NavbarGerente';
const HomeGerente = () => {
    const [cookies, _setCoookies] = useCookies(['usuario'])

    const datoUser=cookies.usuario
    return (
        <div>
            <NavbarGerente/>

            <div>
            <h1>Gerente</h1>
            <h2>{datoUser.codigo}</h2>
            <h2>{datoUser.nombre}</h2>
        </div>
        </div>
        
    )
}

export default HomeGerente;