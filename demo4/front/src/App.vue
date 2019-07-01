<template>
  <div id="app" class="container-fluid">
    <div class="site-info">
      <h1>EBOOK</h1>
      <!-- <h3>Vue SpringBoot example</h3> -->
    </div>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
.site-info {
  color: blue;
  margin-bottom: 20px;
}

.btn-primary {
  margin-right: 5px;
}

.container-fluid {
  text-align: center;
}
</style>
