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
            <button type="button" class="btn btn-primary" v-on:click="sendData()">
              Ingresar Emergencia
            </button>
            <button v-on:click="sendToEmeAbility()" type="button" class="btn btn-primary">
              Ingresar Requerimientos
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
        status: "Activo",
        id_institution: "",
      },
      institutions: [],
      abilities: [],
      id_emergency: "",
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
       try {
         let response = this.$axios.post("/emergencies", this.formData);
         console.log(response);
       } catch (error) {
         console.log("error", error);
       }
      //console.log(this.formData)
    },
    getIdEmergency: function () {
      // SACAR EL ID
    },
    // created: function () {
    //   getInstitutions();
    // }
    sendToEmeAbility: function () {
      this.$router.push({ name: "createEmeAbility", params: { id_emergency: this.id_emergency } });
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