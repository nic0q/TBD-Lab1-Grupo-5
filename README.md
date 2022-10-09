# Laboratorio N°1 - Laboratorio de Taller de Base de Datos
Este repositorio contiene todos los archivos relacionados con el Laboratorio N°1 del
Laboratorio de Taller de Base de Datos (Base de Datos Avanzadas 13317) desarrollado
por el equipo 5. 

* **IMPORTANTE: Para poder conectarse correctamente a la Base de Datos, se debe utilizar el usuario "root" y la contraseña "password"**

## Integrantes del equipo 5
* [Vanina Correa](https://github.com/Vanina11)
* [Nícolas Farfán](https://github.com/nic0q)
* [Vicente Muñoz](https://github.com/LeVixo)
* [Xavier Muñoz](https://github.com/iChavy)
* [John Serrano](https://github.com/PodssilDev)
* [Nicolas Venegas](https://github.com/nicovenegas2)

## Descripción
El Laboratorio consiste en desarrollar CRUD utilizando Java y el servicio REST API con Sql2 y crear vistas utilizando VUE + Nuxt.JS para poder realizar ciertos requisitos del Laboratorio N°1 del curso. Para ello,
se decidio utilizar la tabla de "Voluntary" <br>

El repositorio incluye tres carpetas principales:  <br>
* [Carpeta Backend](https://github.com/nic0q/TBD-Lab1-Grupo-5/tree/master/Backend): Contiene todos los archivos del Backend del proyecto y las clases de la entidades del modelo. 
Se distribuyen las clases en los paquetes Services, Repositories y Models
* [Carpeta Database](https://github.com/nic0q/TBD-Lab1-Grupo-5/tree/master/DataBase): Contiene los archivos dbCreate.sql, el cual contiene los scripts necesarios para crear
la Base de Datos y las tablas del modelo, y el archivo loadData.sql, el cual contiene datos dummy para poblar las tablas.
* [Carpeta Frontend](https://github.com/nic0q/TBD-Lab1-Grupo-5/tree/master/Frontend): Contiene todos los archivos del Frontend y las vistas realizas utilizando Vue + Nuxt.JS. 
Principalmente, esta el formulario para crear emergencias, el cual es uno de los requisitos solicitados para nuestro equipo.

## Modelo a seguir para el Laboratorio N°1

![image](https://user-images.githubusercontent.com/91446330/194765651-54627927-e275-40c0-9a8f-879d4f50b83a.png)


## Requisitos y herramientas de desarrollo
Para ejecutar correctamente todo el proyecto, además de los archivos del repositorio se requieren las siguientes tecnologías:

* [Postgres SQL](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads) versión 12 o superior. 
* [PgAdmin](https://www.pgadmin.org) versión 4.
* [IntelliJ IDEA Ultimate](https://www.jetbrains.com/es-es/idea/download/#section=windows) versión 2022.2.1, aunque deberia funcionar con cualquier versión.
* [Nuxt + VUE](https://nuxtjs.org) versión 3.

También, para el desarrollo del proyecto se utilizó:
* [Visual Studio Code](https://code.visualstudio.com) versión 1.72
* [GitKraken](https://www.gitkraken.com) versión 8.9.1

## Como ejecutar
* 1). En PgAdmin, seleccionar la opción "Query tool" y copiar la primera parte del script dbCreate.sql para solo crear la Base de Datos. 
* 2). Abrir la opción Query tool nuevamente, pero dentro de VoluntariadoDB (La Base de Datos que se crea en el paso 1) y copiar el resto de dbCreate
* 3). Copiar todo el contenido de loadData.sql y ejecutarlo dentro de Query tool
* 4). Utilizando IntelliJ IDEA Ultimate, asegurarse de que se detecte correctamente Spring Boot y Gradle. Luego, ir al archivo "application.properties" y asegurarse que el username y password sean los correctos de acuerdo a su configuración de PostGresSQL
* 5). Ejecutar la aplicación haciendo click en la opción "Run" dentro de IntelliJ IDEA
* 6). Dentro de la carpeta Frontend, abrir una terminal (CMD). Ejecutar "npm install"
* 7). Una vez el proceso anterior acabe, ejecutar "npm run dev"
* 8). ...
