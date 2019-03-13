import React, { Component } from 'react';
// import AppRoute from './AppRoute';

class Home extends Component {
  search(){
    const inpVal = this.input.value;
    alert(inpVal);
  }

  render(){
    return(
      <div className="account">
        Username
        <input className="password" ref={input=>this.input=input} placeholder="UserName" defaultValue="Mike"></input>
        <br/>
        Password
        <input className="password" type="password" placeholder="Password" defaultValue="******"></input>
        <br/>
        <button type="submit" onClick={this.search.bind(this)}>Submit</button>
      </div>
    );
  }
}

export default Home;