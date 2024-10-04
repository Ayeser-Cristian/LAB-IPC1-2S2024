import { Route, Routes, BrowserRouter, Navigate } from 'react-router-dom';
import Login from '../pages/login'

import Gerente from '../pages/Admin/Gerente';
import Empleado from '../pages/Admin/Empleada';
export const AppRouter = () => {

    return (
        <BrowserRouter>
            <Routes>
                <Route path='/login' element={<Login/>}/>
                <Route path='/admin/gerente' element={<Gerente/>}/>
                <Route path='/admin/empleado' element={<Empleado/>}/>
            </Routes>
        </BrowserRouter>

    )

}





