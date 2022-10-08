<template>
  <form method="post">
    <div class="container">
      <div align="center" class="container my-2">
        <h1 style="color: white"> Ingresar una nueva emergencia</h1>
      </div>
      <br />
      <div class="f">
        <div class="row justify-content-center">
          <div class="col-12 col-md-8">
            <div class="form-group">
              <label for="emergency_details" class="control-label">Detalles Emergencia</label>
              <textarea v-model="formData.emergency_details" type="large-text" class="form-control" id="name"
                placeholder="Ingrese detalles emergencia" />
            </div>
            <div class="form-group">
              <div>
                <label>Institucion</label> 
              </div>
              <select class="form-select" v-model="formData.id_institution" aria-label="Default select example" v-on:click="getInstitutions()">
                <option value="">Seleccione</option>
                <option v-for="(institution, index) in institutions" :value="institution.id_institution" :key="index">
                  {{institution.name}}
                </option>
              </select>
            </div>
            <div class="form-group">
              <div>
                <label>Requisitos</label> 
              </div>
              <select class="form-select" v-model="formData.requirements" aria-label="Default select example" v-on:click="getAbilities()">
                <option value="">Seleccione</option>
                <option v-for="(ability, index) in abilities" :value="ability.id_ability" :key="index">
                  {{ability.name_ability}}
                </option>
              </select>
            </div>
            <button type="button" class="btn btn-primary col text-center" v-on:click="sendData()">
              Ingresar Emergencia
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
        emergency_details: "",
        requirements: "",
        status: "Activo",
        id_institution: "",
      },
      institutions: [],
      abilities: [],
    };
  },
  methods: {
    getInstitutions: async function () {
      try {
        let response = await this.$axios.get("/institutions");
        this.institutions = response.data;
        console.log(response);
      } catch (error) {
        console.log("error", error);
      }
    },
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
      console.log(this.formData)
    },
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