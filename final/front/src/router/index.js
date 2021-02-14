import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/login/Login.vue'
import Register from '../components/login/Register.vue'
import Main from '../components/bookTable/Main.vue'
import Book from '../components/bookTable/Book.vue'
import User from '../components/bookTable/User.vue'
import Cart from '../components/bookTable/Cart.vue'
import Order from '../components/bookTable/Order.vue'
import BookManage from '../components/manage/BookManage.vue'
import UserManage from '../components/manage/UserManage.vue'
import NegativeUser from '../components/manage/negativeUser.vue'
import OrderManage from '../components/manage/OrderManage.vue'

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
            name: 'main',
            component: Main
        },
        {
            path: '/book',
            name: 'book',
            component: Book
        },
        {
            path: '/user',
            name: 'user',
            component: User
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
        },
        {
            path: '/bookmanager',
            name: 'bookmanager',
            component: BookManage
        },
        {
            path: '/usermanager',
            name: 'usermanager',
            component: UserManage
        },
        {
            path: '/negativeuser',
            name: 'negativeuer',
            component: NegativeUser
        },
        {
            path: '/ordermanager',
            name: 'ordermanager',
            component: OrderManage
        }
    ]
})