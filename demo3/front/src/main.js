// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.

import Vue from 'vue'
import Vuex from 'vuex'
import App from './App'
import router from './router'
import './css/main.css'
import './css/cart.css'
import SmartTable from 'vuejs-smart-table'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

import store from './store'

// import defined from './defined'

Vue.use(Vuex)
Vue.use(ElementUI)
Vue.use(SmartTable)

Vue.config.productionTip = false
store.dispatch('setStatus')
console.log(store.getters)
new Vue({
    el: '#app',
    router,
    store,
    components: { App },
    template: '<App/>'
})