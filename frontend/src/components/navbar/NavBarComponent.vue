<template>
    <div id="app">
  <v-app id="inspire">
      <v-app-bar
        absolute
        color="#6A76AB"
        dark
        shrink-on-scroll
        prominent
        src="https://picsum.photos/1920/1080?random"
        fade-img-on-scroll
        scroll-target="#scrolling-techniques-4"
      >
        <template v-slot:img="{ props }">
          <v-img
            v-bind="props"
            gradient="to top right, rgba(100,115,201,.7), rgba(25,32,72,.7)"
          ></v-img>
        </template>
  
  
        <v-toolbar-title>Relative Web</v-toolbar-title>
  
        <v-spacer></v-spacer>
  
        <v-btn color="transparent" elevation="0">
            로그인
        </v-btn>
  
        <v-btn color="transparent" elevation="0">
            회원가입
        </v-btn>
  
        
        <template v-slot:extension>
          <v-tabs align-with-title>
            <v-tab>Tab 1</v-tab>
            <v-tab>Tab 2</v-tab>
            <v-tab>Tab 3</v-tab>
          </v-tabs>
        </template>
      </v-app-bar>
      
  </v-app>
</div>
</template>

<script>



export default {
    data () {
        return {
            items: [
                    { title: 'Click Me' },
                    { title: 'Click Me' },
                    { title: 'Click Me' },
                    { title: 'Click Me 2' },
                    ],
        }
    },    
}
</script>

<style scoped>
h1 {
    margin: 10px;
}
p {
    padding: 10px;
    margin: 5px 10px;
}
</style>


