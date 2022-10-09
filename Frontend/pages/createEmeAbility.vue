<template>
    <form method="post">
      <div class="container">
        <div align="center" class="container my-2">
          <h1 style="color: white"> Ingresar requisitos para la emergencia</h1>
        </div>
        <br />
        <div class="f">
          <div class="row justify-content-center">
            <div class="col-12 col-md-8">
              <div class="form-group">
                <div>
                  <label>Habilidad requerida</label> 
                </div>
                <select class="form-select" v-model="formData.id_ability" aria-label="Default select example" v-on:click="getAbilities()">
                  <option value="">Seleccione</option>
                  <option v-for="(ability, index) in abilities" :value="ability.id_ability" :key="index">
                    {{ability.name_ability}}
                  </option>
                </select>
              </div>
              <button type="button" class="btn btn-primary" v-on:click="sendData()">
                Ingresar requerimiento
              </button>
            </div>
          </div>
        </div>
      </div>
    </form>
  </template>
  <script>
  export default {
    data() {  
      return {
        formData: {
          id_ability: "",
          // REVISAR QUE ESTÉ BIEN ACÁ
          id_emergency: "",
        },
        
        abilities: [],
      };
    },
    methods: {
      getAbilities: async function () {
        try {
          let response = await this.$axios.get("/abilities");
          this.abilities = response.data;
          console.log(response);
        } catch (error) {
          console.log("error", error);
        }
      },
      sendData: function () {
       try {
         let response = this.$axios.post("/eme-abilities", this.formData);
         console.log(response);
       } catch (error) {
         console.log("error", error);
       }
      //console.log(this.formData)
    },
      // created: function () {
      //   getInstitutions();
      // }
    },
  };
  </script>
  <style>
  body {
    background: #262626
  }
  textarea {
    width: 300px;
    height: 500px;
  }
  .f {
    color: white;
  }
  </style>