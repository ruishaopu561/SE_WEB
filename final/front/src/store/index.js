import Vue from 'vue'
import Vuex from 'vuex'
// import Axios from 'axios';

Vue.use(Vuex);

const store = new Vuex.Store({
    state: {
        user: {
            id: 0,
            email: '',
            firstname: '',
            lastname: '',
            password: '',
            logged: false,
            image: ''
        }
    },
    getters: {
        get_user_id: (state) => {
            return state.user.id
        },
        get_user_firstname: (state) => {
            return state.user.firstname
        },
        get_user_lastname: (state) => {
            return state.user.lastname
        },
        get_user_email: (state) => {
            return state.user.email
        },
        get_user_password: (state) => {
            return state.user.password
        },
        get_user_logged: (state) => {
            return state.user.logged
        },
        get_user_image: (state) => {
            return state.user.image
        }
    },
    mutations: {
        set_user_id: (state, data) => {
            if (data) {
                state.user.id = data
            } else {
                state.user.id = 0
                sessionStorage.setItem('id', state.id)
            }
        },
        set_user_firstname: (state, data) => {
            if (data) {
                state.user.firstname = data
            } else {
                state.user.firstname = ''
                sessionStorage.setItem('firstname', state.firstname)
            }
        },
        set_user_lastname: (state, data) => {
            if (data) {
                state.user.lastname = data
            } else {
                state.user.lastname = ''
                sessionStorage.setItem('lastname', state.lastname)
            }
        },
        set_user_email: (state, data) => {
            if (data) {
                state.user.email = data
            } else {
                state.user.email = ''
                sessionStorage.setItem('email', state.email)
            }
        },
        set_user_password: (state, data) => {
            if (data) {
                state.user.password = data
            } else {
                state.user.password = ''
                sessionStorage.setItem('password', state.password)
            }
        },
        set_user_logged: (state, data) => {
            if (data) {
                state.user.logged = data
            } else {
                state.user.logged = false
                sessionStorage.setItem('logged', state.logged)
            }
        },
        set_user_image: (state, data) => {
            if (data) {
                state.user.image = data
            } else {
                state.user.image = ''
                sessionStorage.setItem('image', state.image)
            }
        }
    },
    actions: {
        setStatus({ commit }) {
            commit('set_user_id', sessionStorage.getItem('id'))
            commit('set_user_email', sessionStorage.getItem('email'))
            commit('set_user_firstname', sessionStorage.getItem('firstname'))
            commit('set_user_lastname', sessionStorage.getItem('lastname'))
            commit('set_user_password', sessionStorage.getItem('password'))
            commit('set_user_logged', sessionStorage.getItem('logged'))
            commit('set_user_image', sessionStorage.getItem('image'))
        }
    }
})

export default store