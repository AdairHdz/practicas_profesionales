create database SistemaPP;

use SistemaPP;

create table usuario(
	idUsuario integer not null auto_increment, 
	nombres varchar(25) not null,
	apellidos varchar(30) not null,
	correo varchar(20) not null,
	contasenia varchar(20) not null,
	tipo varchar(12) not null,
	PRIMARY KEY (idUsuario)
);



create table organizacion_vinculada(
	idOV integer not null auto_increment,
	nombre varchar(30),
	direccion varchar(100),
	telefono varchar(15),
	PRIMARY KEY (idOV)
);

create table proyecto(
	idProyecto integer not null auto_increment,
	nombre varchar(50),
	descripcion text,
	status varchar(50),
	fecha date,
	horario text,
	metodologia text,
	actividades text,
	objetivoGeneral text,
	objetivosInmediatos text,
	objetivosMediatos text,
	numeroEstudiantesSolicitados integer,
	numeroEstudiantesAsignados integer,
	idOV integer,
	PRIMARY KEY (idProyecto)
);



create table estudiante(
	matricula varchar(10) not null,
	idUsuario integer not null,
	telefono varchar(14),
	PRIMARY KEY (matricula)
);



create table expediente(
	idProyecto integer not null,
	matricula varchar(10) not null,
	calificacionFinal float,
	comentarios text,
	totalHorasRealizadas integer,
	PRIMARY KEY (idProyecto, matricula)
);



create table documento(
	idDocumento integer auto_increment not null,
	nombre varchar(60),
	peso float,
	ruta varchar(500),
	fechaSubida datetime,
	idProyecto integer,
	matricula varchar(10),	
	PRIMARY KEY (idDocumento)
);



create table reporte(
	idDocumento integer not null,
	status varchar(50),
	fechaInicio date,
	fechaFin date,
	horasCubiertas integer,
	PRIMARY KEY (idDocumento)
);



create table participa_estudiante_proyecto(
	matricula varchar(10) not null,
	idProyecto integer not null,
	fechaInicio date,
	fechaFinal date,
	periodo varchar(35),
	PRIMARY KEY (matricula, idProyecto)
);



create table eleccion_estudiante_proyecto(
	matricula varchar(10) not null,
	idProyecto integer not null,
	periodo varchar(35),
	fecha date,
	nivelEleccion integer,
	PRIMARY KEY (matricula, idProyecto)
);



alter table estudiante add constraint
fk_estudiante_1 FOREIGN KEY (idUsuario)
REFERENCES usuario (idUsuario);

alter table participa_estudiante_proyecto add constraint
fk_participa_estudiante_proyecto_1 FOREIGN KEY (matricula)
REFERENCES estudiante (matricula);

alter table participa_estudiante_proyecto add constraint
fk_participa_estudiante_proyecto_2 FOREIGN KEY (idProyecto)
REFERENCES proyecto (idProyecto);

alter table eleccion_estudiante_proyecto add constraint
fk_eleccion_estudiante_proyecto_1 FOREIGN KEY (matricula)
REFERENCES estudiante (matricula);

alter table eleccion_estudiante_proyecto add constraint
fk_eleccion_estudiante_proyecto_2 FOREIGN KEY (idProyecto)
REFERENCES proyecto (idProyecto);

alter table proyecto add constraint
fk_proyecto_1 FOREIGN KEY (idOV)
REFERENCES organizacion_vinculada (idOV);

alter table documento add constraint
fk_documento_1 FOREIGN KEY (idProyecto, matricula)
REFERENCES expediente (idProyecto, matricula);



INSERT INTO Usuario VALUES(NULL, "Adair Benjamin", "Hernandez Ortiz", "adairho16@gmail.com", "123", "Estudiante");
INSERT INTO Estudiante VALUES("S18012122", 1, "2281244285");

INSERT INTO organizacion_vinculada VALUES(NULL, "Organizacion Vinculada 1", "Direccion OV 1", "2281101010");
INSERT INTO organizacion_vinculada VALUES(NULL, "Organizacion Vinculada 2", "Direccion OV 2", "2281111111");
INSERT INTO organizacion_vinculada VALUES(NULL, "Organizacion Vinculada 3", "Direccion OV 3", "2281121212");

INSERT INTO Proyecto VALUES(NULL, "Proyecto 1", "Descripcion proyecto 1", "Activo", CURDATE(), "Lunes a viernes de 7am a 2pm", "Metodologia proyecto 1", "actividades proyecto 1", "Objetivo general proy. 1", "Objetivos inmediatos proy. 1", "Objetivos mediatos proy. 1", 2, 0, 1);
INSERT INTO Proyecto VALUES(NULL, "Proyecto 2", "Descripcion proyecto 2", "Activo", CURDATE(), "Lunes a viernes de 10am a 5pm", "Metodologia proyecto 2", "actividades proyecto 2", "Objetivo general proy. 2", "Objetivos inmediatos proy. 2", "Objetivos mediatos proy. 2", 1, 0, 2);
INSERT INTO Proyecto VALUES(NULL, "Proyecto 3", "Descripcion proyecto 3", "Activo", CURDATE(), "Lunes a viernes de 8am a 3pm", "Metodologia proyecto 3", "actividades proyecto 3", "Objetivo general proy. 3", "Objetivos inmediatos proy. 3", "Objetivos mediatos proy. 3", 1, 0, 3);


INSERT INTO eleccion_estudiante_proyecto VALUES("S18012122", 1, 1, CURDATE(), 1);
INSERT INTO eleccion_estudiante_proyecto VALUES("S18012122", 2, 1, CURDATE(), 2);
INSERT INTO eleccion_estudiante_proyecto VALUES("S18012122", 3, 1, CURDATE(), 3);

INSERT INTO participa_estudiante_proyecto VALUES("S18012122", 1, CURDATE(), CURDATE(), 1);

INSERT INTO Expediente VALUES(1, "S18012122", 10, "FIERRO PARIENTE", 480);

INSERT INTO Documento VALUES(NULL, "Documento 1", 12.0, "path/path", CURDATE(), 1, "S18012122");

INSERT INTO Reporte VALUES(1, "Aceptado", CURDATE(), CURDATE(), 50);