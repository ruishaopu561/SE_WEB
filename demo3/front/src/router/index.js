import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/login/Login.vue'
import Register from '../components/login/Register.vue'
// import ForgetPassword from '../components/login/ForgetPassword.vue'
import Table from '../components/bookTable/Table.vue'
import Detail from '../components/bookTable/Detail.vue'
import Cart from '../components/bookTable/Cart.vue'
import BookManage from '../components/manage/BookManage.vue'
import UserManage from '../components/manage/UserManage.vue'
import Order from '../components/bookTable/Order.vue'

Vue.use(Router)

export default new Router({
    mode: 'hash',
    routes: [{
            path: '/login',
            name: 'login',
            component: Login
        },
        {
            path: '/register',
            name: 'register',
            component: Register
        },
        {
            path: '/bookmanage',
            name: 'bookmanage',
            component: BookManage
        },
        {
            path: '/usermanage',
            name: 'usermanage',
            component: UserManage
        },
        {
            path: '/',
            name: 'table',
            component: Table
        },
        {
            path: '/detail',
            name: 'detail',
            component: Detail
        },
        {
            path: '/cart',
            name: 'cart',
            component: Cart
        },
        {
            path: '/order',
            name: 'order',
            component: Order
        }
    ]
})