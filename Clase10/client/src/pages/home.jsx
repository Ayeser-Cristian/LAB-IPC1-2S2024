import React from "react";
import { Link } from "react-router-dom";
const Home=()=>{

    return(
        <div>
            <h1>Home</h1>
            <button className="btn btn-info"> 
                <Link to="/login">Login</Link>
            </button>
        </div>
    )
}

export default Home;