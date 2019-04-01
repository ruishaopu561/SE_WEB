import React, { Component } from 'react';
import { BrowserRouter, Route, Link, Switch } from 'react-router-dom';

import Scan from './Scan/Scan';
import Home from './Login/Login';
import Inquiry from './Inquiry/Inquiry';
import Detail from './Detail/Detail';

class Approute extends Component {
    render(){
        return(
            <BrowserRouter className="route">
                <header>
                    <ul>
                        <li><Link to="home">Home</Link></li>
                        <li><Link to="scan">Scan</Link></li>
                        <li><Link className="right" to="detail">Detail</Link></li>
                        <li><Link to="inquiry">Inquiry</Link></li>
                    </ul>
                    <Switch>
                        <Route path="/home" component={Home}/>
                        <Route path="/scan" component={Scan}/>
                        <Route path="/detail" component={Detail}/>
                        <Route path="/inquiry" component={Inquiry}/>
                    </Switch>
                </header>
            </BrowserRouter>
        )
    }
}

export default Approute;