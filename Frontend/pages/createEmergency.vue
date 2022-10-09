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
                <label>Habilidad | Requerimiento</label>
              </div>
                <select class="form-select" v-model="ability_id" aria-label="Default select example" v-on:click="getAbilities()">
                <option value="">Seleccione</option>
                <option v-for="(ability, index) in abilities" :value="ability.id_ability" :key="index">
                    {{ability.name_ability}}
                </option>
              </select>
              <br><br>
              <div>
                <h6>Lista de Requerimientos a ingresar</h6>
                <div v-for="(element, index) in names_abilities" :key="index">
                <h6>-> {{element}}</h6>
              </div>
              </div>
            </div>
            <button type="button" class="btn btn-success" v-on:click="()=>saveEmeAbility(this.ability_id)">
                Ingresar requerimiento
            </button>
            <button type="button" class="btn btn-danger" v-on:click="()=>deleteHability(this.ability_id)">
                Eliminar requerimiento
            </button>
            <div align="center" class="mt-4">
              <button type="button" class="btn btn-primary" v-on:click="sendDataEmergency()">
                Ingresar Emergencia
              </button>
            </div>
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
        id_emergency: this.generateId(),
        emergency_details: "",
        status: "Activo",
        id_institution: "",
      },
      ability_id: "",
      institutions: [],
      abilities: [],
      global_ability_array: [],
      names_abilities: [],
    };
  },
  methods: {
    // Getters de desplegables
    getInstitutions: async function () {
      try {
        let response = await this.$axios.get("/institutions");
        this.institutions = response.data;
      } catch (error) {
        console.log("error", error);
      }
    },
    getAbilities: async function () {
      try {
        let response = await this.$axios.get("/abilities");
        this.abilities = response.data;
      } catch (error) {
        console.log("error", error);
      }
    },
    // Genera el id de la emergencia
    generateId: function() {
      let id = Math.floor(Math.random() * 1000000000);
      return id;
    },
    // Obtiene el nombre de la habilidad
    getNameAbility: async function(id_ability){
      try {
        let response = await this.$axios.get(`abilities/${id_ability}`);
        return response.data;
      } catch (error) {
        console.log("error", error);
      }
    },
    // Guarda los json de la emergencia_habilidad
    saveEmeAbility: function(id_ability){
      const formData = {
        id_ability: id_ability,
        id_emergency: this.formData.id_emergency,
      }
      this.getNameAbility(id_ability).then((response) => {
        this.names_abilities.includes(response[0].name_ability) ? console.log("Ya existe") : this.names_abilities.push(response[0].name_ability);
      });
      this.global_ability_array.push(formData);
    },
    deleteHability: function(id_ability){
      this.global_ability_array = this.global_ability_array.filter((element) => element.id_ability != id_ability);
      this.getNameAbility(id_ability).then((response) => {
        this.names_abilities = this.names_abilities.filter((element) => element != response[0].name_ability);
      });
    },  
    // Postea la emergencia
    sendDataEmergency: function () {
       try {
         this.$axios.post("/emergencies", this.formData);
         this.global_ability_array.forEach(async (element) => {
           let response = await this.$axios.post("/eme-abilities", element);
           console.log(response);
         })
       } catch (error) {
         console.log("error", error);
       }
       this.formData.id_emergency = this.generateId();
       this.cleanArrays();
    },
    cleanArrays: function(){
      this.global_ability_array = [];
      this.names_abilities = [];
    }
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