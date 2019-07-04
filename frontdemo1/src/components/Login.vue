<template>
<div class="bg-gradient-primary">
  <div class="container">
    <!-- Outer Row -->
    <div class="row justify-content-center">
      <div class="col-xl-10 col-lg-12 col-md-9">
        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                  </div>
                  <form class="user">
                    <div class="form-group">
                      <input type="email" class="form-control form-control-user" id="exampleInputEmail" required v-model="user.email" aria-describedby="emailHelp" placeholder="Enter Email Address...">
                    </div>
                    <div class="form-group">
                      <input type="password" class="form-control form-control-user" id="exampleInputPassword" required v-model="user.password" placeholder="Password">
                    </div>
                    <div class="form-group">
                      <div class="custom-control custom-checkbox small">
                        <input type="checkbox" class="custom-control-input" id="customCheck">
                        <label class="custom-control-label" for="customCheck">Remember Me</label>
                      </div>
                    </div>
                    <div>
                      <button class="btn btn-primary btn-user btn-block" v-on:click="handleLoginClick()">
                        Login</button>
                    </div>
                    <hr>
                    <a href="index.html" class="btn btn-google btn-user btn-block">
                      <i class="fab fa-google fa-fw"></i> Login with Google
                    </a>
                    <a href="index.html" class="btn btn-facebook btn-user btn-block">
                      <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                    </a>
                  </form>
                  <hr>
                  <div class="text-center">
                    <a class="small"><router-link :to="{path:'/forgetpw'}">Forgot Password?</router-link></a>
                  </div>
                  <div class="text-center">
                    <a class="small"><router-link :to="{path:'/register'}">Create an Account!</router-link></a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</template>

<script>
  export default{
    data(){
      return {
        user: {
          email: '1747836307@qq.com',
          password: '123456789'
        },
        checked: true,
        loading: false,
        exist: true,
        newPath: null
      }
    },
    methods: {
      handleLoginClick () {
        var _this = this
        this.loading = true
        this
          .postRequest('/login', {
            email: this.user.useremail,
            password: this.user.password
          })
          .then(response => {
            _this.loading = false
            if (response && response.status === 200) {
              var data = response.data
              _this.$store.commit('login', data.obj)
              var path = _this.$route.query.redirect
              _this.$router
                .replace({path: path === '/' || path === undefined ? '/home' : path})
            }
          })
      }
    }
}
</script>

<style>
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
  .login_remember {
    margin: 0px 0px 35px 0px;
    text-align: left;
  }
</style>
