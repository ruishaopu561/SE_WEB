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
                <div>
                    <el-upload
                      list-type="picture-card"
                      action="https://jsonplaceholder.typicode.com/posts/"
                      :limit="1"
                      :on-error="uploadError"
                      :on-success="uploadSuccess"
                      :before-upload="beforeAvatarUpload"
                      :on-remove="handleRemove"
                      >
                      <i class="el-icon-plus"></i>
                    </el-upload>
                </div>
                <br/>
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
              </form>
              <hr>
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

export default {
  name: 'register',
  data () {
    return {
      user: {
        firstname: '',
        lastname: '',
        email: '',
        password: '',
        repeatpasswd: '',
        picture: ''
      },
      register: false,
    }
  },
  methods: {
    // 上传成功后的回调
    uploadSuccess (response, file, fileList) {
      console.log('上传文件', response)
      let reader = new FileReader();
      reader.readAsDataURL(file.raw)
      reader.onload = (e) => {
        this.user.picture = e.target.result
        // console.log(this.user.picture)
      }
    },
    // 上传错误
    uploadError (response, file, fileList) {
      console.log(response)
      console.log('上传失败，请重试！')
    },
    // 删除回调
    handleRemove(file, fileList) {
      console.log(file)
    },
    // 上传前对文件的大小的判断
    beforeAvatarUpload (file) {
      const extension = file.name.split('.')[1] === 'jpg'
      const extension2 = file.name.split('.')[1] === 'jpeg'
      const extension3 = file.name.split('.')[1] === 'png'
      const extension4 = file.name.split('.')[1] === 'gif'
      const isLt2M = file.size / 1024 / 1024 < 10
      if (!extension && !extension2 && !extension3 && !extension4) {
        console.log('上传模板只能是 jpg、jpeg、png、gif 格式!')
      }
      if (!isLt2M) {
        console.log('上传模板大小不能超过 10MB!')
      }
      return extension || extension2 || extension3 || extension4 && isLt2M
    },
    handleRegisterClick () {
      if(this.user.firstname=='') {
        alert('FirstName can\'t be empty!')
        return
      }
      if(this.user.lastname=='') {
        alert('LastName can\'t be empty!')
        return
      }
      if(this.user.email=='') {
        alert('Email can\'t be empty!')
        return
      }
      if(this.user.password=='') {
        alert('Password can\'t be empty!')
        return
      }
      if (this.user.password !== this.user.repeatpasswd) {
        alert('Not same password.')
        return
      }
      if (this.user.password.length < 8) {
        alert('Your password length must more than 8!')
        return
      }

      let data = {
        firstname: this.user.firstname,
        lastname: this.user.lastname,
        email: this.user.email,
        password: this.user.password,
        image: this.user.picture
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
