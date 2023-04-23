const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: process.env.PORT || 3000,
//    proxy: `http://localhost:${process.env.SERVER_PORT}`
  }
})
