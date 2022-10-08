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
              <label for="requirements" class="control-label">Lista Requisitos</label>
              <textarea v-model="formData.requirements" type="large-text" class="form-control" id="name"
                placeholder="Ingrese detalles emergencia" />
            </div>
            <div class="row justify-content-center">
              <a href="/showVoluntary" class="btn btn-primary" role="button" aria-pressed="true">Volver a la lista de
                Voluntarios</a>
            </div>
            <div class="form-group">
              <button type="submit" v-on:click="sendData()" class="btn btn-primary">
                Registrarse
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
        emergency_details: "",
        requirements: "",
        status: 0,
        id_institution: 1,
      },
    };
  },
  methods: {
    sendData: async function () {
      // Envío de datos
      try {
        this.$axios.post("/emergencies", this.formData);
        console.log(this.formData);
      } catch (error) {
        console.log("error", error);
      }
    },
    /*
            await this.$axios.post('/voluntaries', {
                name: this.nombre,
                age: this.edad,
                health: this.salud,
                inventory: this.equipamiento
            }).then(data => {
                console.log(this.nombre)
            })
        }*/
    /*
      //Función asíncrona para consultar los datos
      getData: async function(){
        try {
          let response = await this.$axios.post('/voluntaries');
          this.items = response.data;
          console.log(response)
        } catch (error) {
          console.log('error', error);
        }
      } */
  },
  //Función que se ejecuta al cargar el componente
  //   created:function(){
  //   this.sendData();
  // }
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