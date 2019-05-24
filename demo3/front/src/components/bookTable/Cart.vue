<template>
<div id="page-top">
  <!-- Page Wrapper -->
  <div id="wrapper">
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
        <router-link class="nav-link" :to="{ path: '/order' }">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Order</span>
        </router-link>
      </li>

      <hr class="sidebar-divider my-0">
    
    </ul>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

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
        
        <div class="container-fluid">
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Carts</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <div>Filter cart:</div>
                <input class="form-control bg-light border-0 small" v-model="filters.name.value"/>

                <div>
                  <div>
                    <v-table
                        :data="tableData"
                        :filters="filters"
                        selectionMode="multiple"
                        selectedClass="table-info"
                        @selectionChanged="selectedRows = $event"
                        class="table table-bordered"
                        id="dataTable"
                        width="100%"
                        cellspacing="0"
                    >
                      <thead slot="head">
                      </thead>
                      <tbody slot="body" slot-scope="{displayData}">
                        <v-tr v-for="row in displayData" :key="row.id" :row="row">
                          <tr>
                            <th>orderID: {{ row.id }}</th>
                          </tr>
                          <tr>
                            <th>OrderitemID</th>
                            <th>Name</th>
                            <th>Writer</th>
                            <th>Amount</th>
                            <th>Price</th>
                            <th>Value</th>
                            <th>Inventory</th>
                          </tr>
                          <v-tr v-for="item in row.orderItems" :key="item.id" :item="item">
                            <td>{{ item.id }}</td>
                            <td>{{ item.book.name }}</td>
                            <td>{{ item.book.writer }}</td>
                            <td>
                              {{ item.amount }}
                              <!-- <el-input-number v-model="item.amount" :min="1" :max="item.book.inventory-0" label="描述文字"></el-input-number> -->
                            </td>
                            <td>{{ item.book.price }}</td>
                            <td>{{ item.amount * item.book.price }}</td>
                            <td>{{ item.book.inventory }}</td>
                          </v-tr>
                          <tr>
                            <span>
                            </span>
                          </tr>
                          <div>
                            <span><br/></span>
                          </div>
                        </v-tr>
                      </tbody>
                    </v-table>
                    <!-- <strong>Selected:</strong>
                    <div v-if="selectedRows.length === 0" class="text-muted">No Rows Selected</div>
                    <ul>
                      <li v-for="selected in selectedRows" :key="selected.id">
                        {{ selected.id }}
                      </li>
                    </ul> -->
                    <div>
                      <div>
                        <button class="btn btn-primary btn-user" v-on:click="handleBuyClick()">购买</button>
                        <button class="btn btn-primary btn-user" v-on:click="handleDeleteClick()">删除</button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- End of Main Content -->
      <!-- Footer -->
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
  name: 'table',
  data () {
    return {
      login: false,
      loading: true,
      tableData: [],
      selectedRows: [],
      filters: {
        name: { value: '', keys: ['bookname', 'amount', 'writer'] }
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
    handleBuyClick () {
      if(!this.login){
        alert("Sign In Please!")
        return
      }
      if(this.selectedRows.length === 0){
        alert("Choose carts please.")
        return
      }
      this.selectedRows.forEach(function (item) {
        if(item){
          console.log(item)
          http
            .post('/modifyorder', item)
            .then(response=>{
              alert("add to order successfully!")
            })
            .finally(() => {
              this.loading = !this.loading
            })
            .catch(e => {
              console.log(e)
            })
        }
      })
      this.selectedRows = []
    },
    handleDeleteClick () {
      if(!this.login){
        alert("Sign In Please!")
        return
      }
      if(this.selectedRows.length === 0){
        alert("Choose carts please.")
        return
      }
      this.selectedRows.forEach(function (item) {
        if(item){
          console.log(item)
          http
            .post('/deleteorder', item)
            .then(response => {
              alert("delete carts successfully!")
            })
            .finally(() => {
              this.loading = !this.loading
            })
            .catch(e => {
              console.log(e)
            })
        }
      })
      this.selectedRows = []
    }
  },
  mounted () {
    this.login = this.$store.getters.get_user_logged
    let data = {
      userID: this.$store.getters.get_user_id,
      paied: 0
    }
    http
      .post('/order  ', data)
      .then(response => {
        this.tableData = response.data
        console.log(response.data)
      }).finally(() => {
        this.loading = !this.loading
      })
      .catch(e => {
        console.log(e)
      })
  }
}
</script>

<style>

</style>
