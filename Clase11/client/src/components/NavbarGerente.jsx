import React from 'react'; // Importamos React para poder usar JSX y crear componentes
import { Link, useNavigate } from 'react-router-dom';  // Importa Link para la navegación
import { useCookies } from 'react-cookie';

const NavbarGerente = () => {

    const [_cookies, _setCoookies, removeCookie] = useCookies(['usuario'])
    const navigate = useNavigate(); // Usar el hook useNavigate

    const handleLogout = () => {
        // Redirigir a la página de login
        removeCookie('usuario');
        navigate('/login');
    };
    return (
        // Componente de navegación de Bootstrap
        <nav className="navbar navbar-expand-lg navbar-light fixed-top" style={{ backgroundColor: '#e3f2fd' }}>


            <div className="container-fluid">
                <a className="navbar-brand" href="#">COESYS</a>

                <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav">
                        <li className="nav-item active">

                            <Link className="nav-link" >Proyectos</Link>

                        </li>
                        <li className="nav-item">

                            <Link className="nav-link" >Reportes</Link>
                        </li>
                        
                    </ul>
                    <button className="btn btn-danger ms-auto" onClick={handleLogout}>Logout</button> {/* Alineado a la derecha */}
                </div>
            </div>
        </nav>
    );
};

export default NavbarGerente; // Exportamos el componente NavbarGerente para usarlo en otras partes de la aplicación
