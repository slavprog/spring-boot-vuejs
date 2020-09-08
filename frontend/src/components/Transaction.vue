<template>
  <li>
    <button class="accordion" v-on:click="expand"
            v-bind:class="{ active: isActive, 'credit': tr.type=='credit', 'debit': tr.type=='debit' }">
      Transaction type: {{tr.type}}   |   Transaction amount:{{tr.amount}}
    </button>
    <div class="panel" v-if="isActive">
      <p>Transaction date:{{tr.effectiveDate}}</p>
    </div>

  </li>
</template>

<script>
  export default {
    name: "Transaction",
    props: {
      tr: {
        type: Object,
        required: true
      }
    },
    data() {
      return {
        isActive: false
      }
    },
    methods: {
      expand: function () {
        this.isActive = !this.isActive;
      }
    }
  }
</script>

<style scoped>
  .accordion {
    background-color: #eee;
    color: #444;
    cursor: pointer;
    padding: 18px;
    width: 100%;
    border: none;
    text-align: left;
    outline: none;
    font-size: 15px;
    transition: 0.4s;

  }

  .credit {
    background-color: #42b983;
    color: #444;
  }

  .debit {
    background-color: #EA5E3D;
    color: #fff;
  }
  
  .active, .accordion:hover {
    background-color: #ccc;
    color: #000000;
  }

  .panel {
    display: block;
    padding: 0 18px;
    background-color: white;
    transition: max-height 0.2s ease-out;
  }
</style>