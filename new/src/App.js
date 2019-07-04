import React, { Component } from 'react';
import './App.css';


import Footer from './Footer/Footer';
import Login from './Login/Login';
// import AppRoute from './AppRoute';
// import Inquiry from './Inquiry/Inquiry';
// import Book from './Inquiry/Book';
// import ManageBook from './Inquiry/ManageBooks';
// import Signup from './Login/Signup';

class App extends Component {
  render() {
    return (
      <div className="App">
        {/* <Signup/> */}
        {/* <AppRoute className="route"/> */}
        {/* <Inquiry/> */}
        {/* <Book></Book> */}
        {/* <ManageBook/> */}
        <Login/>
        <Footer>Ruishaopu ©2019 Created, all rights reserved.</Footer>
      </div>
    );
  }
}

export default App;
