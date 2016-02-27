

CREATE TABLESPACE master_avanzado
      DATAFILE 'master avanzado' size 100 M;

CREATE USER mastera
      IDENTIFIED BY mastera
         DEFAULT TABLESPACE master_avanzado;

grant DBA to mastera;


******************************************************************************
******** TABLA: usuario_avion
******** BD: MASTER
******** DESCRIPCION:
******** CLAVE PRINCIPAL:nombre_clave + password
******** RELACIONES: roles
******** USO:
******** RESTRICCIONES:
******** MODIFICACION:
******************************************************************************

CREATE TABLE  "USUARIOAVION" 
   (	"NOMBRE_USUARIO" VARCHAR2(30),
	apellidos_usuario varchar2(30),
	domicilio_usuario varchar2(80),
	ciudad_usuario varchar2(100),
	provincia_usuario varcHAR2(100),
	pais_usuario varchar2(80),
	nombre_clave varchar2(20),
	"PASSWORD" VARCHAR2(10),
	email_usuario varchar2(50), 
	"CODIGO_ROL" NUMBER(2,0),
	fecha_alta date,
	fecha_baja date,
	carpeta_documentacion varchar2(250),
	idioma char(2),
	 CONSTRAINT "nombre_clave_PK" PRIMARY KEY (nombre_clave,password) ENABLE, 
	 CONSTRAINT "CODIGO_ROL_USUARIOS_FK" FOREIGN KEY ("CODIGO_ROL")
	  REFERENCES  "ROLES" ("CODIGO_ROL") ENABLE	 

   )



******************************************************************************
******** TABLA: vuelos
******** BD: MASTER
******** DESCRIPCION: todos los datos de los vuelos que se van a poder reservar
******** CLAVE PRINCIPAL: codigo_vuelo
******** RELACIONES:
******** USO:
******** RESTRICCIONES: aeropuertos
******** MODIFICACION:
******************************************************************************

create table vuelos(
	codigo_vuelo varchar2(10),
	origen_pais varchar2(80),
	origen_codigo_aeropuerto varchar2(3),
	destino_pais varchar2(80),
	destino_codigo_aeropuerto varchar2(3),
	codigo_compañia varchar2(2),
	fecha_salida date,
	fecha_llegada date,
	hora_salida date,
	hora_llegada date,
	numero_pasajeros number(3,0),
	asientos_vendidos number(3,0),
	tarifa_ida number (6,2),
	tarifa_vuelta number (6,2),
	tarifa_idavuelta number (7,2),
	constraint codigo_vuelo_PK primary key (codigo_vuelo),
	constraint origen_pais_FK foreign key (origen_pais,origen_codigo_aeropuerto)
	references aeropuertos (pais,codigo_aeropuerto),
	constraint destino_pais_FK foreign key (destino_pais,destino_codigo_aeropuerto)
	references aeropuertos (pais,codigo_aeropuerto)

)

******************************************************************************
******** TABLA: aeropuertos
******** BD: MASTER
******** DESCRIPCION: los datos identificativos de los aeropuertos(de momento españoles)
******** CLAVE PRINCIPAL:pais + codigo_aeropuerto
******** RELACIONES:
******** USO:
******** RESTRICCIONES:
******** MODIFICACION:
******************************************************************************
create table aeropuertos(
	pais varchar2(80),
	codigo_aeropuerto varchar2(3),
	ciudad_aeropuerto varchar2(45),
	nombre_aeropuerto varchar2(45),
	constraint codigo_aeropuerto_PK primary key (codigo_aeropuerto,pais)
)

******************************************************************************
******** TABLA: reservas
******** BD: MASTER
******** DESCRIPCION: un registro por cada reserva echa en el sistema para una sola persona
******** CLAVE PRINCIPAL: localizador_reserva
******** RELACIONES:
******** USO:
******** RESTRICCIONES:tipo_pasaje EL no se ouede cambiar AG admite cambios
******** RESTRICCIONES:documento_tipo DNI sera el cif TAR tarjeta residente pas pasaporte
******** MODIFICACION:
******************************************************************************

create table reservas(
	localizador_reserva varchar2(10),
	codigo_vuelo varchar2(10),
	nombre_clave varchar2(20),
	password varchar2(10),
	tipo_pasaje char(2),
	tarifa_pagada number (7,2),
	tarjeta_credito varchar2(16),
	tarjeta_credito_digito varchar2(3),
	fecha_reserva date,
	hora_reserva date,
	documentacion_tipo char(3),
	documentacion_numero varchar2(15),
	numero_maletas number(2),
	hora_limite_cheking date,
	constraint localizador_reserva_PK primary key (localizador_reserva)
)

******************************************************************************
******** TABLA:compañias_aereas
******** BD: MASTER
******** DESCRIPCION:
******** CLAVE PRINCIPAL:codigo_compañia
******** RELACIONES:
******** USO:
******** RESTRICCIONES:
******** MODIFICACION:
******************************************************************************
create table compañias_aereas(
	codigo_compañia char(3),
	nombre_compañia varchar2(45),
	pais_compañia varchar2(80),
	constraint codigo_compañia_PK primary key (codigo_compañia)
)

******************************************************************************
******** TABLA:pais
******** BD: MASTER
******** DESCRIPCION: los diferentes paises del mundo con informacion ISO
******** CLAVE PRINCIPAL:
******** RELACIONES:
******** USO:
******** RESTRICCIONES:
******** MODIFICACION:
******************************************************************************
CREATE TABLE  pais  (
   codigo_pais  number(11,0) NOT NULL,
   PAIs_ISONUM  number(6,0),
   PAIs_ISO2  char(2),
   PAIs_ISO3  char(3),
   PAIs_NOMBRE  varchar2(80),
  constraint pais_codigo_pais_PK PRIMARY KEY  ( codigo_pais )
);

******************************************************************************
******** TABLA:provincias
******** BD: MASTER
******** DESCRIPCION: las provincias de españa incluida ceuta y melilla
******** CLAVE PRINCIPAL:
******** RELACIONES:
******** USO:
******** RESTRICCIONES:
******** MODIFICACION:
******************************************************************************
CREATE TABLE  provincias  (
   codigo_provincia  number(2,0) NOT NULL ,
   provincia  varchar2(255) NOT NULL,
  constraint provincias_codigo_provincia_PK primary key (codigo_provincia)
);

******************************************************************************
******** TABLA: municipios
******** BD: MASTER
******** DESCRIPCION: los municipios de españa
******** CLAVE PRINCIPAL:
******** RELACIONES:
******** USO:
******** RESTRICCIONES:
******** MODIFICACION:
******************************************************************************
CREATE TABLE  municipios (
   codigo_municipio  number(11,0) NOT NULL,
   provincia number(2,0) NOT NULL,
   municipio  varchar2(255) NOT NULL,
  constraint municipios_PK PRIMARY KEY (codigo_municipio,provincia)
);

******************************************************************************
******** TABLA:
******** BD: MASTER
******** DESCRIPCION:
******** CLAVE PRINCIPAL:
******** RELACIONES:
******** USO:
******** RESTRICCIONES:
******** MODIFICACION:
******************************************************************************

CREATE TABLE  "ROLES_TAREAS" 
   (	"CODIGO_ROL" NUMBER(2,0), 
	"CODIGO_TAREA" NUMBER(2,0), 
	 CONSTRAINT "ROLES_TAREAS_PK" PRIMARY KEY ("CODIGO_ROL", "CODIGO_TAREA") ENABLE, 
	 CONSTRAINT "CODIGO_ROL_FK" FOREIGN KEY ("CODIGO_ROL")
	  REFERENCES  "ROLES" ("CODIGO_ROL") ENABLE, 
	 CONSTRAINT "CODIGO_TAREA_FK" FOREIGN KEY ("CODIGO_TAREA")
	  REFERENCES  "TAREAS" ("CODIGO_TAREA") ENABLE
   )

******************************************************************************
******** TABLA: roles
******** BD: MASTER
******** DESCRIPCION: Contiene los roles que se aplican
******** CLAVE PRINCIPAL: codigo_rol
******** RELACIONES:
******** USO:
******** RESTRICCIONES:
******** MODIFICACION:
******************************************************************************
CREATE TABLE  "ROLES" 
   (	"CODIGO_ROL" NUMBER(2,0), 
	"DESCRIPCION_ROL" VARCHAR2(100), 
	 CONSTRAINT "CODIGO_ROL_PK" PRIMARY KEY ("CODIGO_ROL") ENABLE
   )

******************************************************************************
******** TABLA: tareas
******** BD: MASTER
******** DESCRIPCION: La informacion necesaria para crear el menu de apliciacion
******** CLAVE PRINCIPAL: codigo_tarea
******** RELACIONES:
******** USO:
******** RESTRICCIONES:
******** MODIFICACION:
******************************************************************************

CREATE TABLE  "TAREAS" 
   (	"CODIGO_TAREA" NUMBER(2,0), 
	"DESCRIPCION_TAREA" VARCHAR2(2000), 
	"VINCULO" VARCHAR2(50), 
	 CONSTRAINT "CODIGO_TAREA_PK" PRIMARY KEY ("CODIGO_TAREA") ENABLE
   )

******************************************************************************
*******   SECUENCIADOR PARA LA TABLA  VUELOS  ********************************

CREATE SEQUENCE  "MASTERA"."CODIGO_VUELO"