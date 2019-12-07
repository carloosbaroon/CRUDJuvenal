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
/*
Para acceder a la BD, el usuario debe ser root y sin password.
En caso contrario, modificar la BD ó editar el archivo Conexion.java los parametros necesarios.
src/main/java/itesm/database/Conexion.java.
*/

drop database veterinaria;
create database veterinaria;
use veterinaria;

Create table Usuario (
	id_usuario Int NOT NULL AUTO_INCREMENT,
	id_empleado Int,
	password_user Varchar(30) NOT NULL,
	confirmar_password Varchar(30) NOT NULL,
	privilegios Varchar(20) NOT NULL,
	estado Varchar(20) NOT NULL,
	no_intentos Int,
	UNIQUE (id_empleado),
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
	elegido Bool NOT NULL DEFAULT 0,
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
	disponibilidad Varchar(20) NOT NULL,
 Primary Key (id_sala)) ENGINE = MyISAM;

Create table Consultas (
	id_consulta Int NOT NULL AUTO_INCREMENT,
	fecha Date NOT NULL,
    hora_inicial Time NOT NULL,
	hora_final Time NOT NULL,
	id_empleado Int NOT NULL,
	id_sala Int NOT NULL,
	id_paciente Int NOT NULL,
    correo VARCHAR (30) NOT NULL,
    observaciones VARCHAR (100),
    estado VARCHAR (20) NOT NULL,
Primary Key (id_consulta)) ENGINE = MyISAM;

Create table Cancelaciones (
	id_consulta Int NOT NULL,
	fecha Date NOT NULL,
    motivo VARCHAR (100)) ENGINE = MyISAM;
    
    Create table Atenciones (
    id_atencion Int NOT NULL AUTO_INCREMENT,
	id_consulta Int NULL,
    id_sala Int NOT NULL,
    id_paciente Int NOT NULL,
    fecha Date NOT NULL,
	hora_entrada Time,
    hora_salida Time,
    detalle VARCHAR (500),
    monto Int,
    factura VARCHAR (20),
Primary Key (id_atencion)) ENGINE = MyISAM;


Alter table Usuario add Foreign Key (id_empleado) references Empleado (id_empleado);
Alter table Consultas add Foreign Key (id_empleado) references Empleado (id_empleado);
Alter table Paciente add Foreign Key (id_propietario) references Propietario (id_propietario);
Alter table Consultas add Foreign Key (id_paciente) references Paciente (id_paciente);
Alter table Consultas add Foreign Key (id_sala) references Sala (id_sala);
Alter table Cancelaciones add Foreign Key (id_consulta) references Consultas (id_consulta);
Alter table Atenciones add Foreign Key (id_consulta) references Consultas (id_consulta);
Alter table Atenciones add Foreign Key (id_paciente) references Paciente (id_paciente);
Alter table Atenciones add Foreign Key (id_sala) references Sala (id_sala);


/* Users permissions */


