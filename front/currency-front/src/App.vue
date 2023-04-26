<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="msg"/>
  </div>
</template>

<script lang="ts">
import HelloWorld from './components/HelloWorld.vue'

import { Configuration, RatesControllerApi } from "rates-cli";
const configuration = new Configuration({
  basePath: "http://localhost:8006" ,
});
let api = new RatesControllerApi(configuration);
let currencies = api.getCurrencies("2023-04-01");
console.log(currencies);

export default {
  name: 'App',
  components: {
    HelloWorld
  },
  data() {
    return {
      msg : currencies
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
