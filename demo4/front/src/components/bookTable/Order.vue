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

      <hr class="sidebar-divider my-0">

      <li class="nav-item">
        <router-link v-if="login" class="nav-link" :to="{ path: '/user' }">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Setting</span>
        </router-link>
      </li>

      <hr class="sidebar-divider my-0">

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
          <h1 class="h3 mb-2 text-gray-800">Orders</h1>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Paied Orders</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <div>
                  <!-- <label></label> -->
                  起始时间：<input class="bg-light border-0" v-model="filters.start" placeholder="yyyy-mm-dd hh:mm:ss"/>
                  截止时间：<input class="bg-light border-0" v-model="filters.end" placeholder="yyyy-mm-dd hh:mm:ss"/>
                  <button class="btn btn-primary btn-user" @click="handleAll">统计</button>
                </div>
                <br/>

                <div>
                  <div>
                    <v-table
                        :data="tableData"
                        class="table table-bordered"
                        id="dataTable"
                        width="100%"
                        cellspacing="0"
                    >
                      <thead slot="head" v-if="tableData.length != 0">
                      </thead>
                      <tbody slot="body" slot-scope="{displayData}">
                        <div v-for="order in displayData" :key="order.id" :order="order">
                          <tr>
                            <th>orderID: {{ order.id }}</th>
                            <th>Order Time: {{ order.time }}</th>
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

                <div>
                  <div>
                    <v-table
                        :data="bookData"
                        class="table table-bordered"
                        id="dataTable"
                        width="100%"
                        cellspacing="0"
                    >
                      <thead slot="head" v-if="bookData.length != 0">
                        <tr>
                          <th>Book Name</th>
                          <th>Amount</th>
                        </tr>
                      </thead>
                      <tbody slot="body" slot-scope="{displayData}">
                        <v-tr v-for="row in displayData" :key="row.id" :row="row">
                          <td>{{ row.name }}</td>
                          <td>{{ row.amount }}</td>
                        </v-tr>
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

export default {
  name: 'order',
  data () {
    return {
      login: false,
      image: '',
      loading: true,
      tableData: [],
      originData: [],
      bookData: [],
      filters: {
        start: '',
        end: ''
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
    handleAll(){
      if(this.filters.start == '') {
        this.tableData = this.originData
        alert('请输入起始时间！')
        return
      }else if (this.filters.end == '') {
        this.tableData = this.originData
        alert('请输入截止时间！')
        return
      }
      let startTime = this.filters.start.split(' ')
      let endTime = this.filters.end.split(' ')
      console.log(startTime, endTime)
      if (startTime.length != 2 || endTime.length != 2) {
        alert('请按照要求输入正确格式的时间！')
        return
      }
      let startDay = startTime[0].split('-')
      let endDay = endTime[0].split('-')
      let startH = startTime[1].split(':')
      let endH = endTime[1].split(':')
      // console.log(startDay, endDay)
      // console.log(startH, endH)
      if(startDay.length!=3||startH.length!=3||endDay.length!=3||endDay.length!=3){
        alert('请按照要求输入正确格式的时间！')
        return
      }
      this.bookData = []
      for(let i=0; i<this.originData.length; i++) {
        let time = this.originData[i].time

        let splitTime = time.split(' ')
        let splitDay = splitTime[0].split('-')
        let splitH = splitTime[1].split(':')

        if (startTime[0]>splitTime[0] || splitTime[0]>endTime[0]) {
          continue
        }

        if(startTime[0]<splitTime[0] && splitTime[0]<endTime[0] ||
          startTime[0]==splitTime[0] && startTime[1]<=splitTime[1] ||
          endTime[0]==splitTime[0] && endTime[1]>=splitTime[1])
        {
          let items = this.originData[i].orderItems
          for(let j=0; j<items.length; j++) {
            let b=0
            let bookname = items[j].book.name
            console.log(bookname)
            for (let k=0; k<this.bookData.length; k++) {
              if (this.bookData[k]["name"]==bookname) {
                this.bookData[k]["amount"] = this.bookData[k]["amount"] + items[j].amount
                b=1
              }
            }
            if(b != 1){
              let newItem = []
              newItem['name'] = bookname
              newItem['amount'] = items[j].amount
              this.bookData.push(newItem)
              console.log(newItem)
            }
          }
        }
      }
      this.tableData=[]
      console.log(this.bookData)
    },
    getStatus(){
      this.login = this.$store.getters.get_user_logged
      this.image = this.$store.getters.get_user_image
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
        this.tableData = response.data
        this.originData = this.tableData
        // console.log(this.tableData)
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