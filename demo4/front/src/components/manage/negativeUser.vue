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
        <div class="sidebar-brand-text mx-3">EBOOK</div>
      </div>
      <!-- Divider -->

      <hr class="sidebar-divider my-0">

      <li class="nav-item">
        <router-link class="nav-link" :to="{ path: '/bookmanager' }">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Books</span>
        </router-link>
      </li>

      <hr class="sidebar-divider my-0">

      <li class="nav-item">
        <router-link class="nav-link" :to="{ path: '/usermanager' }">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Active User</span>
        </router-link>
      </li>

      <hr class="sidebar-divider my-0">

      <li class="nav-item">
        <router-link class="nav-link" :to="{ path: '/ordermanager' }">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Orders</span>
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

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
      <!-- Main Content -->
      <div id="content">
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
          <ul class="navbar-nav ml-auto">
            <div class="topbar-divider d-none d-sm-block"></div>
            <li class="nav-item dropdown no-arrow" @click="handleLogOut">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Admin</span>
                <img class="img-profile rounded-circle" :src="image">
                <router-link class="nav-link" :to="{ path: '/login'}">
                  <i class="fas fa-fw fa-tachometer-alt"></i>
                  <span>Sign out</span>
                </router-link>
              </a>
            </li>
          </ul>
        </nav>

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">已禁用用户</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <div>Filter by Name:</div>
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
                        <th>ID</th>
                        <th>Cover</th>
                        <th>FirstName</th>
                        <th>LastName</th>
                        <th>Email</th>
                        <!-- <th>Active</th> -->
                      </thead>
                      <tbody slot="body" slot-scope="{displayData}">
                        <v-tr
                            v-for="row in displayData"
                            :key="row.id"
                            :row="row"
                        >
                          <td>{{ row.userId }}</td>
                          <td>
                            <img class="picture" :src="row.image"/>
                          </td>
                          <td>{{ row.firstname }}</td>
                          <td>{{ row.lastname }}</td>
                          <td>{{ row.email }}</td>
                          <!-- <td>{{ row.active }}</td> -->
                        </v-tr>
                      </tbody>
                    </v-table>
                    <smart-pagination :currentPage.sync="currentPage" :totalPages="totalPages"/>
                    <strong>Selected:</strong>
                    <div v-if="selectedRows.length === 0" class="text-muted">No Rows Selected</div>
                    <ul>
                      <li v-for="selected in selectedRows" :key="selected.userId">
                        {{ selected.firstname }} {{ selected.lastname }}
                      </li>
                    </ul>
                    <div>
                      <div>
                        <button class="btn btn-primary btn-user" v-on:click="handleOpenClick()">启用</button>
                        <!-- <button class="btn btn-primary btn-user" v-on:click="handleCloseClick()">禁用</button> -->
                      </div>
                    </div>
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

export default {
  name: 'negativeuser',
  data () {
    return {
      showDialog: true,
      loading: true,
      login: false,
      image: '',
      tableData: [],
      currentPage: 1,
      pageSize: 8,
      totalPages: 0,
      selectedRows: [],
      filters: {
        name: { value: '', keys: ['firstname', 'lastname', 'email', 'active'] }
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
    handleOpenClick () {
      let data = []
      for (var i = 0; i < this.selectedRows.length; i++) {
        if (this.selectedRows[i]) {
          data.push(this.selectedRows[i].id)
        }
      }
      console.log(data)
      http
        .post('/user/active', data)
        .then(response => {
          this.methods.handleUserClick()
        }).finally()
        .catch(e => {
          console.log(e)
        })
    }
  },
  mounted () {
    this.login = this.$store.getters.get_user_logged
    this.image = this.$store.getters.get_user_image
    http
      .get('/nuser')
      .then(response => {
        this.tableData = response.data
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

</style>
