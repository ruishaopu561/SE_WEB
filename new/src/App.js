import React, { Component } from 'react';
import './App.css';

import AppRoute from './AppRoute';

import pic1 from './image/1.jpg';

class App extends Component {
  render() {
    return (
      <div className="App">
        <div className="header">
          <img class  Name="pic" src={pic1} alt="pic"/>
        </div>
        <AppRoute className="route"/>
        <div className="footer">
          Ruishaopu ©2019 Created, all rights reserved.
        </div>
      </div>
    );
  }
}

export default App;
