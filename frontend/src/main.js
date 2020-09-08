import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import axios from "axios";

createApp(App).use(router).mount('#app')
export const AXIOS = axios.create({
  baseURL: `http://localhost:8080`,
  headers: {
    'Access-Control-Allow-Origin': 'http://localhost:8081'
  }
})
