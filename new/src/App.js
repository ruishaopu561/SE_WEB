import React, { Component } from 'react';
import './App.css';

import AppRoute from './AppRoute';
import Footer from './Footer/Footer';
import Inquiry from './Inquiry/Inquiry';

class App extends Component {
  render() {
    return (
      <div className="App">
        {/* <AppRoute className="route"/> */}
        <Inquiry></Inquiry>
        {/* <Footer>Ruishaopu ©2019 Created, all rights reserved.</Footer> */}
      </div>
    );
  }
}

export default App;
