<template>
  <h1>Transactions History</h1>
  <div class="transaction-list">
    <TransactionList v-bind:trx="transactions"/>
  </div>
</template>

<script>

  import TransactionList from '@/components/TransactionList.vue'
  export default {
    name: 'Home',
    data() {
      return {
        transactions: []
      }
    },
    mounted() {
      fetch('http://localhost:8080/api/transactions')
        .then(response => response.json())
        .then(json => {
          this.transactions = json;

        })
    },
    components: {
      TransactionList
    }
  }
</script>
