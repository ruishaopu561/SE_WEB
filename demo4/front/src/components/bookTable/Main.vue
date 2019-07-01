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

      <hr class="sidebar-divider my-0">

      <li class="nav-item" @click="handleClick">
        <router-link v-if="!login" class="nav-link" :to="{ path: '/' }">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Shop Cart</span>
        </router-link>
        <router-link v-else-if="login" class="nav-link" :to="{ path: '/cart' }">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Shop Cart</span>
        </router-link>
      </li>

      <hr class="sidebar-divider my-0">

      <li class="nav-item" @click="handleClick">
        <router-link v-if="!login" class="nav-link" :to="{ path: '/' }">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Order</span>
        </router-link>
        <router-link v-else-if="login" class="nav-link" :to="{ path: '/order' }">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Order</span>
        </router-link>
      </li>

      <hr class="sidebar-divider my-0">

      <li class="nav-item">
        <router-link v-if="login" class="nav-link" :to="{ path: '/user' }">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Setting</span>
        </router-link>
      </li>

      <hr v-if="login" class="sidebar-divider my-0">

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
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

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Books</h1>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Book Store</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <label>Filter Books:</label>
                <input class="form-control bg-light border-0 small" v-model="filters.name.value"/>

                <div>
                  <div>
                    <v-table
                        :data="tableData"
                        :filters="filters"
                        :currentPage.sync="currentPage"
                        :pageSize="pageSize"
                        selectionMode="multiple"
                        selectedClass="table-info"
                        @selectionChanged="selectedRows = $event"
                        class="table table-bordered"
                        id="dataTable"
                        width="100%"
                        cellspacing="0"
                    >
                      <thead slot="head">
                        <tr>
                          <th>ID</th>
                          <th>Cover</th>
                          <th>Name</th>
                          <th>Writer</th>
                          <th>ISBN</th>
                          <th>Price</th>
                          <th>Amount</th>
                          <th>Value</th>
                          <th>Inventory</th>
                          <th>Action</th>
                        </tr>
                      </thead>
                      <tbody slot="body" slot-scope="{displayData}">
                        <v-tr
                            v-for="row in displayData"
                            :key="row.bookId"
                            :row="row"
                        >
                          <td>{{ row.bookId }}</td>
                          <td>
                            <img class="picture" :src="row.image"/>
                          </td>
                          <td>{{ row.name }}</td>
                          <td>{{ row.writer }}</td>
                          <td>{{ row.isbn }}</td>
                          <td>{{ row.price }}</td>
                          <td>
                            <el-input-number v-model="row.amount" :min="1" :max="row.inventory-0" label="描述文字">
                            </el-input-number>
                          </td>
                          <td>{{ row.price * row.amount }}</td>
                          <td>{{ row.inventory }}</td>
                          <td>
                            <demo :props-id="row.BookId">
                            </demo>
                          </td>
                        </v-tr>
                      </tbody>
                    </v-table>
                    <smart-pagination :currentPage.sync="currentPage" :totalPages="totalPages"/>
                    <strong>Selected:</strong>
                    <div v-if="selectedRows.length === 0" class="text-muted">No Rows Selected</div>
                    <ul>
                      <li v-for="selected in selectedRows" :key="selected.id">
                        {{ selected.name }}
                      </li>
                    </ul>
                    <button class="btn btn-primary btn-user" v-on:click="handleAddClick()">加入购物车</button>
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
import Demo from '../bookTable/Demo'

export default {
  components: {
    'demo': Demo
  },
  name: 'maintable',
  data () {
    return {
      login: false,
      image: '',
      loading: true,
      tableData: [],
      currentPage: 1,
      pageSize: 4,
      totalPages: 0,
      selectedRows: [],
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
    handleAddClick () {
      if(!this.login){
        alert('Sign In Please.')
        return
      }
      if(this.selectedRows.length === 0){
        alert("Choose books Please.")
        return
      }
      let data = []
      let userid = this.$store.getters.get_user_id
      console.log(this.selectedRows)
      this.selectedRows.forEach(function (value) {
        let item = {
          userID: userid,
          bookID: value.bookId,
          amount: value.amount,
          price: value.price
        }
        data.push(item)
      })
      console.log(data)

      http
        .post('/addorder', data)
        .then(response => {
          alert('Add to cart successfully!')
        })
        .catch(e => {
          console.log(e)
      })
      
      this.selectedRows = []
    },
    setStatus(){
      if(this.$store.getters.get_user_id==0) {
        sessionStorage.setItem('id', 0)
        sessionStorage.setItem('email', '')
        sessionStorage.setItem('firstname', '')
        sessionStorage.setItem('lastname', '')
        sessionStorage.setItem('password', '')
        sessionStorage.setItem('logged', 'false')

        this.$store.dispatch('setStatus')

        alert('Set successfully!')
      }
    },
    getStatus(){
      let log = this.$store.getters.get_user_logged=='true'
      this.login = log
      this.image = this.$store.getters.get_user_image
    },
    handleClick(){
      if(!this.login){
        alert("Sign In Please!")
        return
      }
    }
  },
  mounted () {
    this.setStatus()
    this.getStatus()
    http
      .get('/book')
      .then(response => {
        let data = response.data
        // console.log(data[0])
        for (var i = 0; i < data.length; i++) {
          data[i]['amount'] = 1
        }
        this.tableData = data
        this.totalPages = Math.ceil(this.tableData.length / this.pageSize)
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
.picture {
  height: 120px;
  width: 100px
}
</style>
