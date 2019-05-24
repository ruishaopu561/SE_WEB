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
                    <div class="btn btn-google btn-user btn-block">
                      <i class="fab fa-google fa-fw"></i> Login with JAccount
                    </div>
                    <!-- <a href="index.html" class="btn btn-facebook btn-user btn-block">
                      <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                    </a> -->
                  </form>
                  <hr>
                  <!-- <div class="text-center">
                    <a class="small"><router-link :to="{path:'/forgetpw'}">Forgot Password?</router-link></a>
                  </div> -->
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
import http from '../../http-common.js'
import global from '../../Global'

export default {
  name: 'login',
  data () {
    return {
      user: {
        email: '1747836307@qq.com',
        password: 123456789
      },
      resData: []
    }
  },
  methods: {
    handleLoginClick () {
      let data = {
        email: this.user.email,
        password: this.user.password
      }
      http
        .post('/login', data)
        .then(response => {
          this.resData = response.data
          if (this.resData.id) {
            let user = {
              id: this.resData.id,
              email: this.resData.email,
              password: this.resData.password,
              logged: true
            }
            alert("login successfully!")
            sessionStorage.setItem('id', user.id)
            sessionStorage.setItem('email', user.email)
            sessionStorage.setItem('password', user.password)
            sessionStorage.setItem('logged', user.logged)
            // alert(sessionStorage.getItem('id'))
            // alert(sessionStorage.getItem('email'))
            this.$router.replace({path: '/'})
            this.$store.dispatch('setStatus')
          } else {
            alert('Login failed. Please check your email and password.')
            // this.$router.replace({path: '/login'})
          }
        })
        .catch(e => {
          console.log(e)
        })
    }
  }
}
</script>

<style >

</style>
