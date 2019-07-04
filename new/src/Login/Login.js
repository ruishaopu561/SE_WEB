import React, { Component } from 'react';

import logo from '../image/e-book.png';
import './login.css';
import { Link } from 'react-router-dom';

class Home extends Component {
  constructor(){
    super(...arguments);
    this.state={
      username:"Mike",
      password:"ljkfhdjgf"
    }
  }

  handleSubmit(e){
    //进入数据库验证结果，先写死
  }

  handleInput1(e){
    this.setState({username: e.target.value})
  }

  handleInput2(e){
    this.setState({password: e.target.value})
  }

  render(){
    return(
      <div>
        <head>
          <title>登录界面</title>
        </head>
        <body>
          <div id="login_frame">
            <p id="image_logo"><img src={logo} alt="logo"/></p>
            <form method="post" action="">
              <p>
                <label className="label_input">用户名</label>
                <input type="text" id="username" className="text_field" value={this.state.username} onChange={this.handleInput1.bind(this)} defaultValue="Mike"/>
              </p>
              <p>
                <label className="label_input">密码</label>
                <input type="text" id="password" className="text_field" value={this.state.password} onChange={this.handleInput2.bind(this)} defaultValue="******"/>
              </p>
              <div id="login_control">
                {/* <input type="button" id="btn_login" value="登录" onClick={this.handleSubmit.bind(this)}/> */}
                {/* <a id="forget_pwd" href="forget_pwd.html">忘记密码？</a> */}
                <button id="btn_login">
                  <Link to='../Inquiry/Inquiry'>登录</Link>
                </button>
              </div>
              <div>
                <button id="btn_login">
                  <Link to="../Inquiry/ManageBooks">管理员登录</Link>
                </button>
              </div>
            </form>
            <br/>
            <br/>
            <div>
              <Link to='./Signup'>未注册？点击进行注册</Link>
            </div>
          </div>
        </body>
      </div>
    );
  }
}

export default Home;



  // login() {
  //   //need to update 
  //   var username = document.getElementById("username");
  //   var pass = document.getElementById("password");
 
  //   if (username.value === "") {
  //       alert("请输入用户名");
  //   } else if (pass.value  === "") {
  //       alert("请输入密码");
  //   } else if(username.value === "admin" && pass.value === "123456"){
  //       window.location.href="welcome.html";
  //   } else {
  //       alert("请输入正确的用户名和密码！")
  //   }
  // }
