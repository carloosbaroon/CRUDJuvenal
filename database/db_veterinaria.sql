/*
Created		26/10/2019
Modified		03/11/2019
Project		
Model		
Company		
Author		
Version		
Database		mySQL 5 
*/


drop table IF EXISTS Consultas;
drop table IF EXISTS Sala;
drop table IF EXISTS Paciente;
drop table IF EXISTS Propietario;
drop table IF EXISTS Empleado;
drop table IF EXISTS Usuario;


Create table Usuario (
	id_usuario Int NOT NULL AUTO_INCREMENT,
	id_empleado Int,
	password_user Varchar(30) NOT NULL,
	confirmar_password Varchar(30) NOT NULL,
	privilegios Varchar(20) NOT NULL,
	estado Varchar(20) NOT NULL,
	no_intentos Int,
 Primary Key (id_usuario)) ENGINE = MyISAM;

Create table Empleado (
	id_empleado Int NOT NULL AUTO_INCREMENT,
	nombre_completo Varchar(30),
	direccion Varchar(30) NOT NULL,
	telefono Varchar(20) NOT NULL,
	puesto Varchar(30) NOT NULL,
	especialidad Varchar(20) NOT NULL,
	turno Varchar(20) NOT NULL,
	estado Varchar(20) NOT NULL,
 Primary Key (id_empleado)) ENGINE = MyISAM;

Create table Propietario (
	id_propietario Int NOT NULL AUTO_INCREMENT,
	nombre Varchar(30) NOT NULL,
	direccion Varchar(30) NOT NULL,
	telefono Varchar(20) NOT NULL,
	rfc Varchar(20) NOT NULL,
 Primary Key (id_propietario)) ENGINE = MyISAM;

Create table Paciente (
	id_paciente Int NOT NULL,
	id_propietario Int NOT NULL,
	nombre Varchar(30) NOT NULL,
	categoria Varchar(20) NOT NULL,
	raza Varchar(20) NOT NULL,
	edad Int NOT NULL,
 Primary Key (id_paciente)) ENGINE = MyISAM;

Create table Sala (
	id_sala Int NOT NULL AUTO_INCREMENT,
	nombre Varchar(20) NOT NULL,
	disponibilidad Int NOT NULL,
 Primary Key (id_sala)) ENGINE = MyISAM;

Create table Consultas (
	fecha Date NOT NULL,
	id_empleado Int NOT NULL,
	id_sala Int NOT NULL,
	id_paciente Int NOT NULL,
	hora_inicial Time NOT NULL,
	hora_final Time NOT NULL) ENGINE = MyISAM;


Alter table Usuario add Foreign Key (id_empleado) references Empleado (id_empleado);
Alter table Consultas add Foreign Key (id_empleado) references Empleado (id_empleado);
Alter table Paciente add Foreign Key (id_propietario) references Propietario (id_propietario);
Alter table Consultas add Foreign Key (id_paciente) references Paciente (id_paciente);
Alter table Consultas add Foreign Key (id_sala) references Sala (id_sala);


/* Users permissions */


