-------------------------------------------------------
-- Crear VoluntariadoDB
-- Database: VoluntariadoDB
-------------------------------------------------------

DROP DATABASE IF EXISTS "VoluntariadoDB";

CREATE DATABASE "VoluntariadoDB"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Chile.1252'
    LC_CTYPE = 'Spanish_Chile.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE IF NOT EXISTS "voluntary" (
    "rut" VARCHAR(10) NOT NULL,
    "name" VARCHAR(45) NOT NULL,
    "age" INT NOT NULL,
	"avalaible" BOOLEAN NOT NULL,
    PRIMARY KEY ("rut"));
CREATE TABLE IF NOT EXISTS "voluntary" (
    "rut" VARCHAR(10) NOT NULL,
    "name" VARCHAR(45) NOT NULL,
    "age" INT NOT NULL,
	"avalaible" BOOLEAN NOT NULL,
    PRIMARY KEY ("rut"));

-------------------------------------------------------
--Table "hability"
-------------------------------------------------------
CREATE TABLE IF NOT EXISTS "hability" (
    "id_hability" SERIAL NOT NULL,
    "name" VARCHAR(45) NOT NULL,
    "description" VARCHAR(150) NOT NULL,
    PRIMARY KEY ("id_hability")
);
SELECT * FROM "voluntary";
-------------------------------------------------------
--Table "vol_hability"
-------------------------------------------------------
CREATE TABLE IF NOT EXISTS "vol_hability" (
    "id_vol_hability" SERIAL NOT NULL,
	"voluntary_rut" VARCHAR(10),
	"id_hability" int,
    PRIMARY KEY ("id_vol_hability"),
    CONSTRAINT "fk_voluntary"
        FOREIGN KEY ("voluntary_rut")
        REFERENCES "voluntary" ("rut")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
	CONSTRAINT "fk_hability"
        FOREIGN KEY ("id_hability")
        REFERENCES "hability" ("id_hability")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION	
);
-------------------------------------------------------
--Table "institution"
-------------------------------------------------------
CREATE TABLE IF NOT EXISTS "institution"(
    "id_institution" SERIAL NOT NULL,
    "name" VARCHAR(50) NOT NULL,
    "name_coordinator" VARCHAR(50) NOT NULL,
    PRIMARY KEY ("id_institution")
);

-------------------------------------------------------
--Table "emergency"
-------------------------------------------------------
CREATE TABLE IF NOT EXISTS "emergency" (
    "id_emergency" SERIAL NOT NULL,
    "emergency_details" VARCHAR(500) NOT NULL,
    "requirements" VARCHAR(200) NOT NULL,
	"id_institution" int,
    "status" VARCHAR(20) NOT NULL,
    PRIMARY KEY ("id_emergency"),
    CONSTRAINT "fk_institution"
        FOREIGN KEY ("id_institution")
        REFERENCES "institution" ("id_institution")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);
-------------------------------------------------------
--Table "eme_hability"
-------------------------------------------------------
CREATE TABLE IF NOT EXISTS "eme_hability" (
    "id_eme_hability" SERIAL NOT NULL,
	"id_hability" int,
	"id_emergency" int,
    PRIMARY KEY ("id_eme_hability"),
    CONSTRAINT "fk_emergency"
        FOREIGN KEY ("id_emergency")
        REFERENCES "emergency" ("id_emergency")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT "fk_hability"
        FOREIGN KEY ("id_hability")
        REFERENCES "hability" ("id_hability")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);
-------------------------------------------------------
--Table "state_task"
-------------------------------------------------------
CREATE TABLE IF NOT EXISTS "state_task"(
    "id_state_task" SERIAL NOT NULL,
    "state" BOOLEAN NOT NULL,
    PRIMARY KEY ("id_state_task")
);

-------------------------------------------------------
--Table "task"
-------------------------------------------------------
CREATE TABLE IF NOT EXISTS "task"(
    "id_task" SERIAL NOT NULL,
    "description" VARCHAR(300),
	"id_emergency" int,
	"id_state_task" int,
    PRIMARY KEY ("id_task"),
    CONSTRAINT "fk_emergency"
        FOREIGN KEY ("id_emergency")
        REFERENCES "emergency" ("id_emergency")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT "fk_state_task"
        FOREIGN KEY ("id_state_task")
        REFERENCES "state_task" ("id_state_task")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);
-------------------------------------------------------
--Table "task_hability" -------------------------------
-------------------------------------------------------
CREATE TABLE IF NOT EXISTS "task_hability"(
    "id_task_hability" SERIAL NOT NULL,
	"id_eme_hability" int,
	"id_task" int,
    PRIMARY KEY ("id_task_hability"),
    CONSTRAINT "fk_task"
        FOREIGN KEY ("id_task")
        REFERENCES "task" ("id_task")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT "fk_hability"
        FOREIGN KEY ("id_eme_hability")
        REFERENCES "eme_hability" ("id_eme_hability")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);
-------------------------------------------------------
--Table "ranking" -------------------------------------
-------------------------------------------------------
CREATE TABLE IF NOT EXISTS "ranking"(
    "id_ranking" SERIAL NOT NULL,
	"id_task" int,
	"rut_voluntary" VARCHAR(10) NOT NULL,
    PRIMARY KEY ("id_ranking"),
    CONSTRAINT "fk_task"
        FOREIGN KEY ("id_task")
        REFERENCES "task" ("id_task")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT "fk_voluntary"
        FOREIGN KEY ("rut_voluntary")
        REFERENCES "voluntary" ("rut")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);