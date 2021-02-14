<template>
<div id="page-top">
  <div id="wrapper">

    <div id="content-wrapper" class="d-flex flex-column">
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

            <div class="topbar-divider d-none d-sm-block"></div>

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow" v-if="!login">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <router-link class="nav-link" :to="{ path: '/login'}">
                  <i class="fas fa-fw fa-tachometer-alt"></i>
                  <span>Sign In</span>
                </router-link>
                <router-link class="nav-link" :to="{ path: '/register'}">
                  <i class="fas fa-fw fa-tachometer-alt"></i>
                  <span>Sign Up</span>
                </router-link>
              </a>
            </li>
            <li class="nav-item dropdown no-arrow" v-else-if="login" @click="handleLogOut">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">{{this.$store.getters.get_user_email}}</span>
                <img class="img-profile rounded-circle" :src="image">
                <router-link class="nav-link" :to="{ path: '/login'}">
                  <i class="fas fa-fw fa-tachometer-alt"></i>
                  <span>Sign out</span>
                </router-link>
              </a>
            </li>
          </ul>
        </nav>
        <!-- End of Topbar -->

        <div class="container-fluid">
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <div id="content-wrapper" class="d-flex flex-column">
                <div class="col-xs-12 col-md-7" id="row">
                  <p>
                    <img class="detail" :src="item.image"/>
                  </p>
                  <p>
                    邮箱：{{item.email}}
                  </p>
                  <p>
                    姓：<el-input class="modify" v-model="item.firstname" placeholder="">
                    </el-input>
                  </p>
                  <p>
                    名：<el-input class="modify" v-model="item.lastname" placeholder="">
                    </el-input>
                  </p>
                  <p>
                    密码：<el-input class="modify" v-model="item.password" placeholder="">
                    </el-input>
                  </p>
                  <a tabindex="0" id="addcart" class="btn btn-primary btn-user" role="button" @click="handleModify" data-trigger="focus"
                    data-placement="bottom" data-content="修改成功">修改
                    <span class="glyphicon glyphicon-shopping-cart"></span>
                  </a>
                  <a tabindex="0" id="addcart" class="btn btn-primary btn-user" role="button" @click="handleReturn" data-trigger="focus"
                    data-placement="bottom" data-content="返回成功">返回
                    <span class="glyphicon glyphicon-shopping-cart"></span>
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; EBOOK Store 2019</span>
          </div>
        </div>
      </footer>
    </div>
  </div>
</div>
</template>

<script>
import http from '../../http-common.js'

export default {
  name: 'user',
  data () {
    return {
      login: false,
      image: '',
      item: {
        email: '',
        firstname: '',
        lastname: '',
        password: '',
        image: '',
      }
    }
  },
  methods: {
    handleLogOut () {
      let user = {
        id: 0,
        email: '',
        firstname: '',
        lastname: '',
        password: '',
        logged: false
      }
      sessionStorage.setItem('id', user.id)
      sessionStorage.setItem('email', user.email)
      sessionStorage.setItem('firstname', user.firstname)
      sessionStorage.setItem('lastname', user.lastname)
      sessionStorage.setItem('password', user.password)
      sessionStorage.setItem('logged', user.logged)

      this.$store.dispatch('setStatus')
      this.$router.replace({path: '/login'})
    },
    handleModify () {
      if(this.item.password.length < 8){
          alert('Your password length must more than 8!')
          return
      }
      let data = {
          email: this.item.email,
          firstname: this.item.firstname,
          lastname: this.item.lastname,
          password: this.item.password
      }
      http
        .post('/modifyuser', data)
        .then(response => {
            // console.log(response.data)
            if(response.data){
                alert('Modify successfully!')
            }else{
                alert('Modify Failed!')
            }
        })
        .catch(e => {
            console.log(e)
        })
    },
    handleReturn () {
        this.$router.go(-1)
    }
  },
  mounted () {
    this.login = this.$store.getters.get_user_logged
    this.image = this.$store.getters.get_user_image
    this.item.image = this.$store.getters.get_user_image
    this.item.email = this.$store.getters.get_user_email
    this.item.firstname = this.$store.getters.get_user_firstname
    this.item.lastname = this.$store.getters.get_user_lastname
    this.item.password = this.$store.getters.get_user_password
  }
}
</script>

<style scoped>
.page-top {
  background-color: white;
}
h1 {
  font-size: 300%;
  margin-bottom: 10%;
}
.form-control {
  width: 50px;
}
.btn {
  margin-top: 4%;
  font-size: 125%;
  padding-left: 20px;
  padding-right: 20px;
  padding-top: 10px;
  padding-bottom: 10px;
}
.modify {
  width: 140px
}
.detail{
  height: 240px;
  width: 240px;
}
</style>
