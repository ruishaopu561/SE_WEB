<template>

<div class="bg-gradient-primary">

  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
              </div>
              <form class="user">
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="exampleFirstName" required v-model="user.firstname" placeholder="First Name">
                  </div>
                  <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="exampleLastName" required v-model="user.lastname" placeholder="Last Name">
                  </div>
                </div>
                <div class="form-group">
                  <input type="email" class="form-control form-control-user" id="exampleInputEmail" required v-model="user.email" placeholder="Email Address">
                </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="password" class="form-control form-control-user" id="exampleInputPassword" required v-model="user.password" placeholder="Password">
                  </div>
                  <div class="col-sm-6">
                    <input type="password" class="form-control form-control-user" id="exampleRepeatPassword" required v-model="user.repeatpasswd" placeholder="Repeat Password">
                  </div>
                </div>
                <!-- <a href="login.html" class="btn btn-primary btn-user btn-block">
                  Register Account
                </a> -->
                <button class="btn btn-primary btn-user btn-block" v-on:click="handleRegisterClick">
                Register Account</button>
                <hr>
                <div class="btn btn-google btn-user btn-block">
                  <i class="fab fa-google fa-fw"></i> Register with JAccount
                </div>
                <!-- <a href="index.html" class="btn btn-facebook btn-user btn-block">
                  <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                </a> -->
              </form>
              <hr>
              <!-- <div class="text-center">
                <a class="small"><router-link :to="{path:'/forgetpw'}">Forgot Password?</router-link></a>
              </div> -->
              <div class="text-center">
                <a class="small"><router-link :to="{ path:'/login' }">Already have an account? Login!</router-link></a>
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
// import router from '../../router/index.js'

export default {
  name: 'register',
  data () {
    return {
      user: {
      },
      register: false,
      // loading: true,
      // submitted: false
    }
  },
  methods: {
    handleRegisterClick () {
      if (this.user.password !== this.user.repeatpasswd) {
        alert('Not same password.')
        return
      }

      var data = {
        firstname: this.user.firstname,
        lastname: this.user.lastname,
        email: this.user.email,
        password: this.user.password,
        active: true
      }
      http
        .post('/register', data)
        .then(response => {
          this.register = response.data
          if (this.register) {
            alert("Register Succeed! Sign In Now!")
          } else {
            alert('Register failed! Try again!')
          }
        })
        .catch(e => {
          console.log(e)
        })
    }
  }
}
</script>

<style>

</style>
