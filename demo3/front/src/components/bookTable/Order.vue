<template>
<div id="page-top">
  <!-- Page Wrapper -->
  <div id="wrapper">
    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
      <!-- Sidebar - Brand -->
      <div class="sidebar-brand d-flex align-items-center justify-content-center">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">EBOOK STORE</div>
      </div>

    <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <li class="nav-item">
        <router-link class="nav-link" :to="{ path: '/' }">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Book Table</span>
        </router-link>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <li class="nav-item">
        <router-link v-if="!login" class="nav-link" :to="{ path: '/' }">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Shop Cart</span>
        </router-link>
        <router-link v-else-if="login" class="nav-link" :to="{ path: '/cart' }">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Shop Cart</span>
        </router-link>
      </li>
      <hr class="sidebar-divider d-none d-md-block">
    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
      <!-- Main Content -->
      <div id="content">
        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

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
                <img class="img-profile rounded-circle" src="../../assets/images/3.jpg">
                <router-link class="nav-link" :to="{ path: '/login'}">
                  <i class="fas fa-fw fa-tachometer-alt"></i>
                  <span>Sign out</span>
                </router-link>
              </a>
            </li>
          </ul>
        </nav>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Orders</h1>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Paied Orders</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <label>Filter Orders:</label>
                <input class="form-control bg-light border-0 small" v-model="filters.name.value"/>

                <div>
                  <div>
                    <v-table
                        :data="pOrderData"
                        :filters="filters"
                        class="table table-bordered"
                        id="dataTable"
                        width="100%"
                        cellspacing="0"
                    >
                      <thead slot="head">
                      </thead>
                      <tbody slot="body" slot-scope="{displayData}">
                        <div v-for="order in displayData" :key="order.id" :order="order">
                          <tr>
                            <th>orderID: {{ order.id }}</th>
                            <th>TotalPrice: ￥{{ order.value }}</th>
                          </tr>
                          <tr>
                            <th>OrderitemID</th>
                            <th>Name</th>
                            <th>Writer</th>
                            <th>Amount</th>
                            <th>Value</th>
                          </tr>
                          <tr v-for="item in order.orderItems" :key="item.id" :item="item">
                            <td>{{ item.id }}</td>
                            <td>{{ item.book.name }}</td>
                            <td>{{ item.book.writer }}</td>
                            <td>{{ item.amount }}</td>
                            <td>{{ item.value }}</td>
                          </tr>
                          <div>
                            <span><br/></span>
                          </div>
                        </div>
                      </tbody>
                    </v-table>
                  </div>
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
import global from '../../Global'

export default {
  name: 'order',
  data () {
    return {
      login: false,
      loading: true,
      pOrderData: [],
      filters: {
        name: { value: '', keys: ['name', 'writer', 'price', 'isbn', 'inventory'] }
      }
    }
  },
  methods: {
    handleLogOut () {
      let user = {
        id: 0,
        email: '',
        password: '',
        logged: false
      }
      sessionStorage.setItem('id', user.id)
      sessionStorage.setItem('email', user.email)
      sessionStorage.setItem('password', user.password)
      sessionStorage.setItem('logged', user.logged)

      this.$store.dispatch('setStatus')
      this.$router.replace({path: '/login'})
    },
    getStatus(){
      this.login = this.$store.getters.get_user_logged
    }
  },
  mounted () {
    this.getStatus()
    let data1 = {
      userID: this.$store.getters.get_user_id,
      paied: 1
    }
    http
      .post('/order', data1)
      .then(response => {
        this.pOrderData = response.data
        console.log(this.pOrderData)
      }).finally(() => {
        this.loading = false
      })
      .catch(e => {
        console.log(e)
      })    
  }
}
</script>

<style>

</style>
