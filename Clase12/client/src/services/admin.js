export const adminCargarGerente=async (EmpleadosArray)=>{
    const response = await fetch('http://localhost:5000/cargargerente', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(EmpleadosArray),
    });
    return response.json()

}

export const obtenerGerentes=async ()=>{
    const response = await fetch('http://localhost:5000/getGerentes', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    });
    return response.json()

}



export const updateGerente = async (gerenteEdit) => {
    const response = await fetch(`http://localhost:5000/editargerente`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(gerenteEdit),
    });

    return response.json();

}