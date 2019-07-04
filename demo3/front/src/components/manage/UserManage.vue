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
        <router-link class="nav-link" :to="{ path: '/login' }">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Log out</span>
        </router-link>
      </li>
    </ul>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown no-arrow d-sm-none">
              <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                <form class="form-inline mr-auto w-100 navbar-search">
                  <div class="input-group">
                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                      <button class="btn btn-primary" type="button">
                        <i class="fas fa-search fa-sm"></i>
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </li>
          </ul>
        </nav>

        <!-- Begin Page Content -->
        <div class="container-fluid">

        <div>
        <div class="text-center">
            <a class="small"><router-link :to="{path:'/usermanage'}">User</router-link></a>
        </div>
        <div class="text-center">
            <a class="small"><router-link :to="{path:'/bookmanage'}">Book</router-link></a>
        </div>
        </div>

          <button class="btn btn-primary btn-user" v-on:click="handleUserClick()">用户浏览</button>
          <!-- <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the <a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p> -->

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Users</h6>
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
                        selectionMode="multiple"
                        selectedClass="table-info"
                        @selectionChanged="selectedRows = $event"
                        class="table table-bordered"
                        id="dataTable"
                        width="100%"
                        cellspacing="0"
                    >
                      <thead slot="head">
                        <th>FirstName</th>
                        <th>LastName</th>
                        <th>Email</th>
                        <th>Active</th>
                      </thead>
                      <tbody slot="body" slot-scope="{displayData}">
                        <v-tr
                            v-for="row in displayData"
                            :key="row.id"
                            :row="row"
                        >
                          <td>{{ row.firstname }}</td>
                          <td>{{ row.lastname }}</td>
                          <td>{{ row.email }}</td>
                          <td>{{ row.active }}</td>
                        </v-tr>
                      </tbody>
                    </v-table>
                    <strong>Selected:</strong>
                    <div v-if="selectedRows.length === 0" class="text-muted">No Rows Selected</div>
                    <ul>
                      <li v-for="selected in selectedRows" :key="selected.id">
                        {{ selected.email }}
                      </li>
                    </ul>
                    <div>
                      <div>
                        <button class="btn btn-primary btn-user" v-on:click="handleOpenClick()">启用</button>
                        <button class="btn btn-primary btn-user" v-on:click="handleCloseClick()">禁用</button>
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

var ta = [
  {
    firstname: 'Chris',
    lastname: 'mas',
    email: '1747836307@qq.com',
    paied: 'true'
  },
  {
    firstname: 'Chris',
    lastname: 'm',
    email: '134@qq.com',
    paied: 'false'
  },
  {
    firstname: 'Chris',
    lastname: 'ma',
    email: '360@qq.com',
    paied: 'true'
  },
  {
    firstname: 'yth',
    lastname: 'qichao',
    email: '1347846732@qq.com',
    paied: 'true'
  },
  {
    firstname: 'yuan',
    lastname: 'wqew',
    email: '541645126@qq.com',
    paied: 'true'
  },
  {
    firstname: 'ni',
    lastname: 'ruijie',
    email: '541645@qq.com',
    paied: 'true'
  },
  {
    firstname: 'ruijie',
    lastname: 'ni',
    email: '3516236@com',
    paied: 'true'
  }
]

export default {
  name: 'table',
  data () {
    return {
      showDialog: true,
      loading: true,
      tableData: ta,
      currentPage: 1,
      totalPage: 0,
      selectedRows: [],
      filters: {
        name: { value: '', keys: ['firstname', 'lastname', 'email', 'active'] }
      }
    }
  },
  methods: {
    handleUserClick () {
      http
        .get('/user')
        .then(response => {
          this.tableData = response.data
        }).finally(() => {
          this.loading = false
        })
        .catch(e => {
          console.log(e)
        })
    },
    handleOpenClick () {
      http
        .post('/user/active', this.selectedRows)
        .then(response => {
          this.methods.handleUserClick()
        }).finally()
        .catch(e => {
          console.log(e)
        })
    },
    handleCloseClick () {
      http
        .post('/user/disactive', this.selectedRows)
        .then(response => {
          this.methods.handleUserClick()
        })
        .catch(e => {
          console.log(e)
        })
    }
  },
  mounted () {
    http
      .get('/user')
      .then(response => {
        this.tableData = response.data
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
