import React, { Component } from 'react';

import logo from '../image/e-book.png';
import './login.css';

class Home extends Component {
  search(){
    const inpVal = this.input.value;
    alert(inpVal);
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
                <input ref={input=>this.input=input} type="text" id="username" className="text_field" defaultValue="Mike"/>
              </p>
              <p>
                <label className="label_input">密码</label>
                <input type="text" id="password" className="text_field" defaultValue="******"/>
              </p>
              <div id="login_control">
                <input type="button" id="btn_login" value="登录" onClick={this.search.bind(this)}/>
                <a id="forget_pwd" href="forget_pwd.html">忘记密码？</a>
              </div>
            </form>
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
