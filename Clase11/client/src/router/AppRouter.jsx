import { Route, Routes, BrowserRouter, Navigate } from 'react-router-dom';
import Login from '../pages/login'

import Gerente from '../pages/Admin/Gerente';
import Empleado from '../pages/Admin/Empleado';

import Home from '../pages/home';

import HomeGerente from '../pages/gerente/HomeGerente';
export const AppRouter = () => {

    return (
        <BrowserRouter>
            <Routes>
            <Route path='/' element={<Home/>}/>
                <Route path='/login' element={<Login/>}/>
                <Route path='/admin/gerente' element={<Gerente/>}/>
                <Route path='/admin/empleado' element={<Empleado/>}/>
                <Route path='/gerente/home' element={<HomeGerente/>}/>
            </Routes>
        </BrowserRouter>

    )

}





