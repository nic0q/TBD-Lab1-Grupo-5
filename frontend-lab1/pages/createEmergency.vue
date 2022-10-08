<template>
  <form method="post">
    <div class="container">
      <div align="center" class="container my-2">
        <h1 style="color: white"> Registrar un nuevo Voluntario</h1>
      </div>
      <br />
      <div class="f">
        <div class="row justify-content-center">
          <div class="col-12 col-md-8">
            <div class="form-group">
              <label for="name" class="control-label">Nombre</label>
              <input v-model="formData.name" type="text" class="form-control" id="name"
                placeholder="Ingrese su nombre" />
            </div>
            <div class="form-group">
              <label for="edad" class="control-label">Edad</label>
              <input v-model="formData.age" type="text" class="form-control" id="edad" name="edad"
                placeholder="Ingrese su edad" />
            </div>
            <div class="form-group">
              <label for="salud" class="control-label">Salud</label>
              <input v-model="formData.health" type="text" class="form-control" id="salud" name="salud"
                placeholder="Ingrese su estado de salud en la escala del 1 al 10" />
            </div>
            <div class="form-group">
              <label for="equipamiento" class="control-label">Equipamiento</label>
              <input v-model="formData.inventory" type="text" class="form-control" id="equipamiento" name="equipamiento"
                placeholder="Ingrese el tipo de equipamiento que tiene a su disposición" />
            </div>
            <div class="form-group">
              <button type="submit" v-on:click="sendData()" classnpm i @nuxtjs/axios="btn btn-primary">
                Registrarse
              </button>
            </div>
            <div class="row justify-content-center">
              <a href="/showVoluntary" class="btn btn-primary" role="button" aria-pressed="true">Volver a la lista de
                Voluntarios</a>
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
        name: "",
        age: "",
        health: "",
        inventory: "",
        avalaible: 1,
      },
    };
  },
  methods: {
    sendData: async function () {
      // Envío de datos
      try {
        this.$axios.post("/voluntaries", this.formData);
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

.f {
  color: white;
}
</style>