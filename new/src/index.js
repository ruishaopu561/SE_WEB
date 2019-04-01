import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import { HashRouter as Router, Route, Switch } from 'react-router-dom'

import Scan from './Scan/Scan';
import ManageBooks from './Inquiry/ManageBooks';
import Signup from './Login/Signup';
import Inquiry from './Inquiry/Inquiry';
import Detail from './Detail/Detail';
import Shopcart from './Inquiry/Shopcart';

ReactDOM.render(    
    <Router className="route">
        <Switch>
            <Route exact path="/" component={App}/>
            <Route path="/scan" component={Scan}/>
            <Route path="/signup" component={Signup}/>
            <Route path="/detail" component={Detail}/>
            <Route path="/inquiry" component={Inquiry}/>
            <Route path="/Shopcart" component={Shopcart}/>
            <Route path="/ManageBooks" component={ManageBooks}/>
        </Switch>
    </Router>, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.register();
