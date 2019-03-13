import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';

import Scan from './Scan';
import Home from './Home';
import Detail from './Detail';

class Approute extends Component {
    render(){
        return(
            <Router className="route">
                <header>
                    <ul>
                        <li><Link to="home">Home</Link></li>
                        <li><Link to="scan">Scan</Link></li>
                        <li><Link className="right" to="detail">Detail</Link></li>
                    </ul>
                    <Route path="/home" component={Home}/>
                    <Route path="/scan" component={Scan}/>
                    <Route path="/detail" component={Detail}/>
                </header>
            </Router>
        )
    }
}

export default Approute;