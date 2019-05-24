<template>
    <div>
        <button class="btn btn-user" v-on:click="sendID()">show details</button>
    </div>
</template>

<script>
import global from '../../Global'

export default {
  name: 'demo',
  props: ['propsId'],
  data () {
    return {
      childId: this.propsId
    }
  },
  methods: {
    sendID () {
      // global.setid(this.propsId)
      sessionStorage.setItem('bookid', this.propsId)
      // console.log(sessionStorage.getItem('bookid'))
      this.$router.push('/detail')
    }
  }
}
</script>

<style scoped>
.btn {
  color: #4e73df;
}
</style>
