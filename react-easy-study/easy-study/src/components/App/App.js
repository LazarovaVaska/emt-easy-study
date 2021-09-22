import './App.css';
import React, {Component} from 'react';
import Routes from './../../routes/Routes';
import {BrowserRouter} from "react-router-dom";
import Navbar from "../Navbar/Navbar";

class App extends Component {
    render() {
        return (
            <div className="App">
                <Navbar/>
                <BrowserRouter>
                    <Routes/>
                </BrowserRouter>
            </div>
        );
    }
}

export default App;
