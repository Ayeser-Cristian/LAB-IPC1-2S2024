import React from 'react'; 
import { useNavigate, Link } from 'react-router-dom';  // Importamos useNavigate para redirección y Link para la navegación

const Navbar = () => {
    const navigate = useNavigate(); // Usamos el hook useNavigate para redirigir entre rutas

    const handleLogout = () => {
        // Redirigir a la página de login
        navigate('/login');
    }

    return (
        // Componente de barra de navegación de Bootstrap
        <nav className="navbar navbar-expand-lg navbar-light fixed-top" style={{ backgroundColor: "#e3f2fd" }}>
            {/* 'navbar': Clase de Bootstrap que define una barra de navegación 
                'navbar-expand-lg': Se expande y muestra todos los elementos en pantallas grandes
                'navbar-light': Aplica un esquema de colores claros 
                'fixed-top': Fija la barra en la parte superior de la ventana, siempre visible */}
            
            <div className='container-fluid'> {/* Contenedor fluido que ocupa todo el ancho de la pantalla */}
                <a className="navbar-brand" href="#">COESYS</a>
                {/* 'navbar-brand': Estilo de Bootstrap para el logotipo o nombre de la marca */}

                <div className="collapse navbar-collapse" id="navbarNavAltMarkup"> 
                    {/* Contenido que puede colapsar en pantallas pequeñas */}
                    <div className="navbar-nav"> {/* Lista de enlaces de navegación */}
                       
                        <Link className="nav-link" to="/admin/gerente">Gerentes</Link>
                        {/* 'nav-link': Clase de Bootstrap para los enlaces de la barra de navegación */}
                        <Link className="nav-link" to="/admin/empleado">Empleado</Link>
                        <a className="nav-item nav-link" href="#">Proyectos</a>
                    </div>
                </div>

                <button className="btn btn-danger ms-auto" onClick={handleLogout}>Logout</button>
                {/* Botón de cierre de sesión, alineado a la derecha con 'ms-auto' */}
            </div>
        </nav>
    )
}

export default Navbar; // Exportamos el componente Navbar para su uso en otras partes de la aplicación
