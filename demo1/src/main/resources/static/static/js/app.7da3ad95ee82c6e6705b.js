webpackJsonp([1],{NHnr:function(t,e,s){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=s("7+uW"),r={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"container-fluid",attrs:{id:"app"}},[this._m(0),this._v(" "),e("router-view")],1)},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"site-info"},[e("h1",[this._v("EBOOK")])])}]};var i=s("VU/8")({name:"App"},r,!1,function(t){s("VL/o")},null,null).exports,n=s("/ocq"),o=s("mtWM"),l=s.n(o).a.create({baseURL:"http://localhost:8080",headers:{"Content-type":"application/json"}}),c={name:"login",data:function(){return{user:{active:!1},submitted:!1}},methods:{handleLoginClick:function(){var t={firstname:"",lastname:"",email:this.user.email,password:this.user.password};l.post("/login",t).then(function(t){t.data?console.log(t.data):console.log("User don't exist.")}).catch(function(t){console.log(t)}),this.submitted=!0}}},m={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("html",{attrs:{lang:"en"}},[t._m(0),t._v(" "),s("body",{staticClass:"bg-gradient-primary"},[s("div",{staticClass:"container"},[s("div",{staticClass:"row justify-content-center"},[s("div",{staticClass:"col-xl-10 col-lg-12 col-md-9"},[s("div",{staticClass:"card o-hidden border-0 shadow-lg my-5"},[s("div",{staticClass:"card-body p-0"},[s("div",{staticClass:"row"},[s("div",{staticClass:"col-lg-6 d-none d-lg-block bg-login-image"}),t._v(" "),s("div",{staticClass:"col-lg-6"},[s("div",{staticClass:"p-5"},[t._m(1),t._v(" "),s("form",{staticClass:"user"},[s("div",{staticClass:"form-group"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.user.email,expression:"user.email"}],staticClass:"form-control form-control-user",attrs:{type:"email",id:"exampleInputEmail",required:"","aria-describedby":"emailHelp",placeholder:"Enter Email Address..."},domProps:{value:t.user.email},on:{input:function(e){e.target.composing||t.$set(t.user,"email",e.target.value)}}})]),t._v(" "),s("div",{staticClass:"form-group"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.user.passwd,expression:"user.passwd"}],staticClass:"form-control form-control-user",attrs:{type:"password",id:"exampleInputPassword",required:"",placeholder:"Password"},domProps:{value:t.user.passwd},on:{input:function(e){e.target.composing||t.$set(t.user,"passwd",e.target.value)}}})]),t._v(" "),t._m(2),t._v(" "),s("div",[s("button",{staticClass:"btn btn-primary btn-user btn-block",on:{click:function(e){return t.handleLoginClick()}}},[t._v("\r\n                        Login")])]),t._v(" "),s("hr"),t._v(" "),t._m(3),t._v(" "),t._m(4)]),t._v(" "),s("hr"),t._v(" "),s("div",{staticClass:"text-center"},[s("a",{staticClass:"small"},[s("router-link",{attrs:{to:{path:"/forgetpw"}}},[t._v("Forgot Password?")])],1)]),t._v(" "),s("div",{staticClass:"text-center"},[s("a",{staticClass:"small"},[s("router-link",{attrs:{to:{path:"/register"}}},[t._v("Create an Account!")])],1)])])])])])])])])])])])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("head",[e("meta",{attrs:{charset:"utf-8"}}),this._v(" "),e("meta",{attrs:{"http-equiv":"X-UA-Compatible",content:"IE=edge"}}),this._v(" "),e("meta",{attrs:{name:"viewport",content:"width=device-width, initial-scale=1, shrink-to-fit=no"}}),this._v(" "),e("meta",{attrs:{name:"description",content:""}}),this._v(" "),e("meta",{attrs:{name:"author",content:""}}),this._v(" "),e("title",[this._v("SB Admin 2 - Login")])])},function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"text-center"},[e("h1",{staticClass:"h4 text-gray-900 mb-4"},[this._v("Welcome Back!")])])},function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"form-group"},[e("div",{staticClass:"custom-control custom-checkbox small"},[e("input",{staticClass:"custom-control-input",attrs:{type:"checkbox",id:"customCheck"}}),this._v(" "),e("label",{staticClass:"custom-control-label",attrs:{for:"customCheck"}},[this._v("Remember Me")])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("a",{staticClass:"btn btn-google btn-user btn-block",attrs:{href:"index.html"}},[e("i",{staticClass:"fab fa-google fa-fw"}),this._v(" Login with Google\r\n                    ")])},function(){var t=this.$createElement,e=this._self._c||t;return e("a",{staticClass:"btn btn-facebook btn-user btn-block",attrs:{href:"index.html"}},[e("i",{staticClass:"fab fa-facebook-f fa-fw"}),this._v(" Login with Facebook\r\n                    ")])}]};var d=s("VU/8")(c,m,!1,function(t){s("dpct")},null,null).exports,u={name:"register",data:function(){return{user:{active:!1},submitted:!1}},methods:{handleRegisterClick:function(){if(this.user.password===this.user.repeatpasswd){var t={firstname:this.user.firstname,lastname:this.user.lastname,email:this.user.email,password:this.user.password};l.post("/register",t).then(function(t){t.data?console.log("User registered successfully."):console.log("User registered failed")}).catch(function(t){console.log(t)}),this.submitted=!0}else console.log("not corresponding password.")}}},v={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("html",{attrs:{lang:"en"}},[t._m(0),t._v(" "),s("body",{staticClass:"bg-gradient-primary"},[s("div",{staticClass:"container"},[s("div",{staticClass:"card o-hidden border-0 shadow-lg my-5"},[s("div",{staticClass:"card-body p-0"},[s("div",{staticClass:"row"},[s("div",{staticClass:"col-lg-5 d-none d-lg-block bg-register-image"}),t._v(" "),s("div",{staticClass:"col-lg-7"},[s("div",{staticClass:"p-5"},[t._m(1),t._v(" "),s("form",{staticClass:"user"},[s("div",{staticClass:"form-group row"},[s("div",{staticClass:"col-sm-6 mb-3 mb-sm-0"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.user.firstname,expression:"user.firstname"}],staticClass:"form-control form-control-user",attrs:{type:"text",id:"exampleFirstName",required:"",placeholder:"First Name"},domProps:{value:t.user.firstname},on:{input:function(e){e.target.composing||t.$set(t.user,"firstname",e.target.value)}}})]),t._v(" "),s("div",{staticClass:"col-sm-6"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.user.lastname,expression:"user.lastname"}],staticClass:"form-control form-control-user",attrs:{type:"text",id:"exampleLastName",required:"",placeholder:"Last Name"},domProps:{value:t.user.lastname},on:{input:function(e){e.target.composing||t.$set(t.user,"lastname",e.target.value)}}})])]),t._v(" "),s("div",{staticClass:"form-group"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.user.email,expression:"user.email"}],staticClass:"form-control form-control-user",attrs:{type:"email",id:"exampleInputEmail",required:"",placeholder:"Email Address"},domProps:{value:t.user.email},on:{input:function(e){e.target.composing||t.$set(t.user,"email",e.target.value)}}})]),t._v(" "),s("div",{staticClass:"form-group row"},[s("div",{staticClass:"col-sm-6 mb-3 mb-sm-0"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.user.password,expression:"user.password"}],staticClass:"form-control form-control-user",attrs:{type:"password",id:"exampleInputPassword",required:"",placeholder:"Password"},domProps:{value:t.user.password},on:{input:function(e){e.target.composing||t.$set(t.user,"password",e.target.value)}}})]),t._v(" "),s("div",{staticClass:"col-sm-6"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.user.repeatpasswd,expression:"user.repeatpasswd"}],staticClass:"form-control form-control-user",attrs:{type:"password",id:"exampleRepeatPassword",required:"",placeholder:"Repeat Password"},domProps:{value:t.user.repeatpasswd},on:{input:function(e){e.target.composing||t.$set(t.user,"repeatpasswd",e.target.value)}}})])]),t._v(" "),s("button",{staticClass:"btn btn-primary btn-user btn-block",on:{click:t.handleRegisterClick}},[t._v("\r\n                Register Account")]),t._v(" "),s("hr"),t._v(" "),t._m(2),t._v(" "),t._m(3)]),t._v(" "),s("hr"),t._v(" "),s("div",{staticClass:"text-center"},[s("a",{staticClass:"small"},[s("router-link",{attrs:{to:{path:"/forgetpw"}}},[t._v("Forgot Password?")])],1)]),t._v(" "),s("div",{staticClass:"text-center"},[s("a",{staticClass:"small"},[s("router-link",{attrs:{to:{path:"/"}}},[t._v("Already have an account? Login!")])],1)])])])])])])])])])},staticRenderFns:[function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("head",[s("meta",{attrs:{charset:"utf-8"}}),t._v(" "),s("meta",{attrs:{"http-equiv":"X-UA-Compatible",content:"IE=edge"}}),t._v(" "),s("meta",{attrs:{name:"viewport",content:"width=device-width, initial-scale=1, shrink-to-fit=no"}}),t._v(" "),s("meta",{attrs:{name:"description",content:""}}),t._v(" "),s("meta",{attrs:{name:"author",content:""}}),t._v(" "),s("title",[t._v("SB Admin 2 - Register")]),t._v(" "),s("link",{attrs:{href:"vendor/fontawesome-free/css/all.min.css",rel:"stylesheet",type:"text/css"}}),t._v(" "),s("link",{attrs:{href:"css/sb-admin-2.min.css",rel:"stylesheet"}})])},function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"text-center"},[e("h1",{staticClass:"h4 text-gray-900 mb-4"},[this._v("Create an Account!")])])},function(){var t=this.$createElement,e=this._self._c||t;return e("a",{staticClass:"btn btn-google btn-user btn-block",attrs:{href:"index.html"}},[e("i",{staticClass:"fab fa-google fa-fw"}),this._v(" Register with Google\r\n                ")])},function(){var t=this.$createElement,e=this._self._c||t;return e("a",{staticClass:"btn btn-facebook btn-user btn-block",attrs:{href:"index.html"}},[e("i",{staticClass:"fab fa-facebook-f fa-fw"}),this._v(" Register with Facebook\r\n                ")])}]};var p=s("VU/8")(u,v,!1,function(t){s("hYw1")},null,null).exports,h={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("html",{attrs:{lang:"en"}},[t._m(0),t._v(" "),s("body",{staticClass:"bg-gradient-primary"},[s("div",{staticClass:"container"},[s("div",{staticClass:"row justify-content-center"},[s("div",{staticClass:"col-xl-10 col-lg-12 col-md-9"},[s("div",{staticClass:"card o-hidden border-0 shadow-lg my-5"},[s("div",{staticClass:"card-body p-0"},[s("div",{staticClass:"row"},[s("div",{staticClass:"col-lg-6 d-none d-lg-block bg-password-image"}),t._v(" "),s("div",{staticClass:"col-lg-6"},[s("div",{staticClass:"p-5"},[t._m(1),t._v(" "),s("form",{staticClass:"user"},[t._m(2),t._v(" "),s("a",{staticClass:"btn btn-primary btn-user btn-block"},[s("router-link",{attrs:{to:{path:"/"}}},[t._v("Reset Password")])],1)]),t._v(" "),s("hr"),t._v(" "),s("div",{staticClass:"text-center"},[s("a",{staticClass:"small"},[s("router-link",{attrs:{to:{path:"/register"}}},[t._v("Create an Account!")])],1)]),t._v(" "),s("div",{staticClass:"text-center"},[s("a",{staticClass:"small"},[s("router-link",{attrs:{to:{path:"/"}}},[t._v("Already have an account? Login!")])],1)])])])])])])])])])])])},staticRenderFns:[function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("head",[s("meta",{attrs:{charset:"utf-8"}}),t._v(" "),s("meta",{attrs:{"http-equiv":"X-UA-Compatible",content:"IE=edge"}}),t._v(" "),s("meta",{attrs:{name:"viewport",content:"width=device-width, initial-scale=1, shrink-to-fit=no"}}),t._v(" "),s("meta",{attrs:{name:"description",content:""}}),t._v(" "),s("meta",{attrs:{name:"author",content:""}}),t._v(" "),s("title",[t._v("SB Admin 2 - Forgot Password")]),t._v(" "),s("link",{attrs:{href:"vendor/fontawesome-free/css/all.min.css",rel:"stylesheet",type:"text/css"}}),t._v(" "),s("link",{attrs:{href:"css/sb-admin-2.min.css",rel:"stylesheet"}})])},function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"text-center"},[e("h1",{staticClass:"h4 text-gray-900 mb-2"},[this._v("Forgot Your Password?")]),this._v(" "),e("p",{staticClass:"mb-4"},[this._v("We get it, stuff happens. Just enter your email address below and we'll send you a link to reset your password!")])])},function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"form-group"},[e("input",{staticClass:"form-control form-control-user",attrs:{type:"email",id:"exampleInputEmail","aria-describedby":"emailHelp",placeholder:"Enter Email Address..."}})])}]};var f=s("VU/8")({name:"forget_password"},h,!1,function(t){s("ckxx")},null,null).exports;a.a.use(n.a);var _=new n.a({mode:"history",routes:[{path:"/",name:"login",alias:"/login",component:d},{path:"/register",name:"register",component:p},{path:"/forgetpw",name:"forget_password",component:f}]});s("jcZh");a.a.config.productionTip=!1,new a.a({el:"#app",router:_,components:{App:i},template:"<App/>"})},"VL/o":function(t,e){},ckxx:function(t,e){},dpct:function(t,e){},hYw1:function(t,e){},jcZh:function(t,e){}},["NHnr"]);
//# sourceMappingURL=app.7da3ad95ee82c6e6705b.js.map