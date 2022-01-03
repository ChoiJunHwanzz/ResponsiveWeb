<template>
  <div>
    <v-app class="test">
      <nav-bar-component/>
        <v-main>
          <router-view/>
        </v-main>
        
    </v-app>
  </div>
</template>

<script>
import NavBarComponent from './components/navbar/NavBarComponent.vue'

export default {
  components: { NavBarComponent },
  name: 'App'
}
</script>

<style>
  
</style>