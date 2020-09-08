<template>
  <div>
    <ul>
      <Transaction
          v-for="tr of trx"
          v-bind:tr="tr"
          v-bind:key="tr"/>
    </ul>
  </div>
</template>

<script>
  import Transaction from '@/components/Transaction'
  export default {
    name: "TransactionList",
    props: ["trx"],
    components: {
      Transaction
    }
  }
</script>

<style scoped>
  ul {
    list-style: none;
    margin: 0;
    padding: 0;
  }
</style>