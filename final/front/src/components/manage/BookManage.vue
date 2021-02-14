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
        <router-link class="nav-link" :to="{ path: '/usermanager' }">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Active User</span>
        </router-link>
      </li>

      <hr class="sidebar-divider my-0">

      <li class="nav-item">
        <router-link class="nav-link" :to="{ path: '/negativeuser' }">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Negative User</span>
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
              <h6 class="m-0 font-weight-bold text-primary">Books</h6>
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
                        <tr>
                          <th>ID</th>
                          <th>Cover</th>
                          <th>Name</th>
                          <th>Writer</th>
                          <th>ISBN</th>
                          <th>Price</th>
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
                          <td>
                            <el-input v-model="row.name" placeholder="">
                            </el-input>
                          </td>
                          <td>
                            <el-input v-model="row.writer" placeholder="">
                            </el-input>
                          </td>
                          <td>
                            <el-input v-model="row.isbn" placeholder="">
                            </el-input>
                          </td>
                          <td>
                            <el-input v-model="row.price" placeholder="">
                            </el-input>
                          </td>
                          <td>
                            <el-input v-model="row.inventory" placeholder="">
                            </el-input>
                          </td>
                          <td>
                            <demo :props-id="row.bookId">
                            </demo>
                          </td>
                        </v-tr>
                      </tbody>
                    </v-table>
                    <smart-pagination :currentPage.sync="currentPage" :totalPages="totalPages"/>

                    <strong>Selected:</strong>
                    <div v-if="selectedRows.length === 0" class="text-muted">No Rows Selected</div>
                    <ul>
                      <li v-for="selected in selectedRows" :key="selected.bookId">
                        {{ selected.name }}
                      </li>
                    </ul>

                    <div>
                      <div>
                        <button class="btn btn-primary btn-user" type="text" @click="dialogFormVisible = true">新建</button>

                        <el-dialog title="创建新书" :visible.sync="dialogFormVisible">
                          <el-form>
                            <el-form-item label="书名" :label-width="formLabelWidth">
                              <el-input placeholder="书名" v-model="newBook.input1"></el-input>
                            </el-form-item>
                            <el-form-item label="作者" :label-width="formLabelWidth">
                              <el-input placeholder="作者" v-model="newBook.input2"></el-input>
                            </el-form-item>
                            <el-form-item label="价格" :label-width="formLabelWidth">
                              <el-input placeholder="价格" v-model="newBook.input3"></el-input>
                            </el-form-item>
                            <el-form-item label="ISBN" :label-width="formLabelWidth">
                              <el-input placeholder="ISBN" v-model="newBook.input4"></el-input>
                            </el-form-item>
                            <el-form-item label="库存" :label-width="formLabelWidth">
                              <el-input placeholder="库存" v-model="newBook.input5"></el-input>
                            </el-form-item>
                            <el-form-item label="上传封面" :label-width="formLabelWidth"> 
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
                            </el-form-item>
                          </el-form>
                          <div slot="footer" class="dialog-footer">
                            <el-button @click="dialogFormVisible = false">取 消</el-button>
                            <el-button type="primary" @click="handleCreateClick">确 定</el-button>
                          </div>
                        </el-dialog>

                        <button class="btn btn-primary btn-user" v-on:click="handleModifyClick()">修改</button>
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
  name: 'bookmanager',
  data () {
    return {
      dialogImageUrl: '',
      dialogVisible: false,
      dialogFormVisible: false,
      formLabelWidth: '120px',
      showDialog: true,
      dialogOption: '',
      loading: true,
      FileList: [],
      tableData: [],
      selectedRows: [],
      currentPage: 1,
      pageSize: 4,
      totalPages: 0,
      login: false,
      image: '',
      newBook: {
        input1: '',
        input2: '',
        input3: '',
        input4: '',
        input5: '',
        picture: ''
      },
      filters: {
        name: { value: '', keys: ['name', 'writer', 'price', 'isbn', 'inventory'] }
      }
    }
  },
  methods: {
    // 上传成功后的回调
    uploadSuccess (response, file, fileList) {
      console.log('上传文件', response)

      let reader = new FileReader();
      reader.readAsDataURL(file.raw)
      reader.onload = (e) => {
        this.newBook.picture = e.target.result
        console.log(this.newBook.picture)
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
    handleBookClick () {
      http
        .get('/book')
        .then(response => {
          this.tableData = response.data
        }).finally(() => {
          this.loading = false
        })
        .catch(e => {
          console.log(e)
        })
    },
    handleCreateClick () {
      if(this.newBook.input1==='' || this.newBook.input2==='' || this.newBook.input3==='' || this.newBook.input4===''|| this.newBook.input5===''){
        alert('Please finish all the blank about the book!')
        return
      }
      if(this.newBook.input1===null || this.newBook.input2===null || this.newBook.input3===null || this.newBook.input4===null|| this.newBook.input5===null){
        alert('Please finish all the blank about the book!')
        return
      }
      if(!isNaN(this.newBook.input1)) {
        alert('书名应设置为非数字，设置错误！')
        return
      }
      if(!isNaN(this.newBook.input2)) {
        alert('作者应设置为非数字，设置错误！')
        return
      }
      if(isNaN(this.newBook.input3)) {
        alert('价格应设置为数字，设置错误！')
        return
      }
      if(!isNaN(this.newBook.input4)) {
        alert('ISBN还应有"-"分割，设置错误！')
        return
      }
      if(isNaN(this.newBook.input5)) {
        alert('库存量应设置为正整数，设置错误！')
        return
      }

      let data = {
        name : this.newBook.input1,
        writer : this.newBook.input2,
        price : this.newBook.input3,
        isbn : this.newBook.input4,
        inventory : this.newBook.input5,
        image: this.newBook.picture
      }
      this.dialogFormVisible = false
      http
        .post('/addbook', data)
        .then(() => {
          alert('Add book successfully!')
      }).catch(e => {
        console.log(e)
      })
    },
    handleModifyClick () {
      if(this.selectedRows.length===0){
        return
      }
      console.log(this.selectedRows)
      http
        .post('/modifybooks', this.selectedRows)
        .then(response => {
          alert('Modify books successfully!')
        })
        .catch(e => {
          console.log(e)
        })
      this.selectedRows = []
    },
    handleDeleteClick () {
      if(this.selectedRows.length===0){
        return
      }

      let data = []
      for(var i = 0; i < this.selectedRows.length; i++) {
        if (this.selectedRows[i]) {
          data.push(this.selectedRows[i].bookId)
        }
      }
      console.log(data)
      http
        .post('/deletebooks', data)
        .then(response => {
          alert('Delete books successfully!')
        })
        .catch(e => {
          console.log(e)
        })
      this.selectedRows = [] 
    }
  },
  mounted () {
    this.login = this.$store.getters.get_user_logged
    this.image = this.$store.getters.get_user_image
    http
      .get('/book')
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
.picture {
  height: 120px;
  width: 100px
}
</style>
