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
                  </form>
                  <hr>
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

export default {
  name: 'login',
  data () {
    return {
      user: {
        email: '1747836307@com',
        password: 1234567890
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
          if (this.resData.userId) {
            let user = {
              id: this.resData.userId,
              firstname: this.resData.firstname,
              lastname: this.resData.lastname,
              email: this.resData.email,
              password: this.resData.password,
              logged: 'true',
              image: this.resData.image
            }
            // console.log(user)
            alert("login successfully!")
            sessionStorage.setItem('id', user.id)
            sessionStorage.setItem('firstname', user.firstname)
            sessionStorage.setItem('lastname', user.lastname)
            sessionStorage.setItem('email', user.email)
            sessionStorage.setItem('password', user.password)
            sessionStorage.setItem('logged', user.logged)
            sessionStorage.setItem('image', user.image)

            this.$store.dispatch('setStatus')

            let str = this.$store.getters.get_user_email
            if (str.search('Admin') != -1) {
              this.$router.replace({ path: '/bookmanager' })
            } else {
              this.$router.replace({ path: '/' })
            }
          } else {
            alert('Login failed. Please check your email and password.')
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
