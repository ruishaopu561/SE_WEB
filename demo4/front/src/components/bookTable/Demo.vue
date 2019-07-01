<template>
    <div>
        <button class="btn btn-user" v-on:click="sendID()">show details</button>
    </div>
</template>

<script>

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
      sessionStorage.setItem('bookid', this.propsId)
      this.$router.push('/book')
    }
  }
}
</script>

<style scoped>
.btn {
  color: #4e73df;
}
</style>
