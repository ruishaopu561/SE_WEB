import React, { Component } from 'react';
import './login.css';
import logo from '../image/e-book.png';

class Signup extends Component {
    constructor(){
        super(...arguments);
        this.state = {
            username:"",
            passwd:"",
            repeatPasswd:"",
            email:""
        }
    }
    
    handleOnClick(){
        let record_usrname = this.state.username;
        let record_passwd = this.state.passwd;;
        let record_email = this.state.email;
        let current_repeatPasswd = this.state.repeatPasswd;

        if(record_usrname === ""){
            alert("用户名不能为空");
        } else if (record_passwd === ""){
            alert("密码不能为空");
        } else if(record_email === ""){
            alert("邮箱不能为空");
        }else{
            if(record_passwd === current_repeatPasswd){
                //数据传回后端记录，待补充
                alert("注册成功，请回到上一页面登录")
            }else{
                this.setState({
                    username:"",
                    passwd:"",
                    repeatPasswd:"",
                    email:""
                });
                alert("两次密码不一致，请重新输入！");
            }
        }
    }

    handleInput1(e){
        this.setState({
            username: e.target.value
        });
    }

    handleInput2(e){
        this.setState({
            passwd: e.target.value
        });
    }    
    
    handleInput3(e){
        this.setState({
            repeatPasswd: e.target.value
        });
    }    
    
    handleInput4(e){
        this.setState({
            email: e.target.value
        });
    }

    render(){
        return(
            <div>
                <form id="login_frame">

                    <p id="image_logo"><img src={logo} alt="logo"/></p>
                    <div>
                        <label className="label_input">用户名</label>
                        <input className="text_field" id="username" type="text" defaultValue="" value={this.state.username} onChange={this.handleInput1.bind(this)}></input>
                    </div>
                    <div>
                        <label className="label_input">密码</label>
                        <input className="text_field" id="passwd" type="text" defaultValue="" value={this.state.passwd} onChange={this.handleInput2.bind(this)}></input>
                    </div>
                    <div>
                        <label className="label_input">重复密码</label>
                        <input className="text_field" id="rpasswd" type="text" defaultValue="" value={this.state.repeatPasswd} onChange={this.handleInput3.bind(this)}></input>
                    </div>
                    <div>
                        <label className="label_input">邮箱</label>
                        <input className="text_field" id="email" type="text" defaultValue="" value={this.state.email} onChange={this.handleInput4.bind(this)}></input>
                    </div>
                    <div>
                        <button id="btn_login" type="submit" onClick={this.handleOnClick.bind(this)}>提交</button>
                    </div>
                </form>
            </div>
        );
    }
}

export default Signup;