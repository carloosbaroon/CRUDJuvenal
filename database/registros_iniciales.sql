use veterinaria;

INSERT INTO empleado (nombre_completo, direccion, telefono, puesto, especialidad, turno, estado) 
VALUES ("David", "Av de la vida", "7226483059", "puesto de prueba 1", "no se", "1", "Activo");

INSERT INTO empleado (nombre_completo, direccion, telefono, puesto, especialidad, turno, estado) 
VALUES ("Mariana", "Av las torres", "123456789", "puesto de prueba 2", "no se 2", "2", "Baja");

INSERT INTO empleado (nombre_completo, direccion, telefono, puesto, especialidad, turno, estado) 
VALUES ("Paola", "CU", "987654321", "puesto de prueba 3", "no se 2", "3", "Activo");

INSERT INTO usuario (id_empleado, password_user, confirmar_password, privilegios, estado, no_intentos) 
VALUES (1, "hola", "hola", "administrador", "activo", 5);

INSERT INTO usuario (id_empleado, password_user, confirmar_password, privilegios, estado, no_intentos) 
VALUES (2, "cactus", "cactus", "usuario", "activo", 5);

INSERT INTO sala (nombre, disponibilidad) 
VALUES ("Sala 1", "disponible");

INSERT INTO sala (nombre, disponibilidad) 
VALUES ("Sala 2", "no disponible");

INSERT INTO sala (nombre, disponibilidad) 
VALUES ("Sala 3", "disponible");

INSERT INTO sala (nombre, disponibilidad) 
VALUES ("Sala 4", "disponible");

INSERT INTO sala (nombre, disponibilidad) 
VALUES ("Sala 5", "no disponible");

INSERT INTO propietario (nombre, direccion, telefono, rfc) 
VALUES ("Juan Martinez", "Toluca", "7223535654", "MASJ4534343");

INSERT INTO propietario (nombre, direccion, telefono, rfc) 
VALUES ("Alejandra Sanchez", "Cd. de Mexico", "7227863654", "SAMA126paciente4343");

INSERT INTO paciente (id_paciente, id_propietario, nombre, categoria, raza, edad)
VALUES (1, 1, "Rambo", "perro", "Gran Danés", 4);

INSERT INTO paciente (id_paciente, id_propietario, nombre, categoria, raza, edad)
VALUES (2, 1, "Capuchino", "gato", "Siames", 3);

INSERT INTO paciente (id_paciente, id_propietario, nombre, categoria, raza, edad)
VALUES (3, 2, "Chapo", "perro", "Pug", 1);

INSERT INTO consultas (fecha, hora_inicial, hora_final, id_empleado, id_sala, id_paciente, observaciones, estado) 
VALUES ('2019-11-05','13:00:00','15:00:00',1,2,1,'Cirugia','Programado');

INSERT INTO consultas (fecha, hora_inicial, hora_final, id_empleado, id_sala, id_paciente, observaciones, estado) 
VALUES ('2019-11-06','10:00:00','11:00:00',1,1,3,'Consulta','Programado');

INSERT INTO consultas (fecha, hora_inicial, hora_final, id_empleado, id_sala, id_paciente, observaciones, estado) 
VALUES ('2019-11-06','12:00:00','13:00:00',3,2,1,'Consulta','Programado');

INSERT INTO consultas (fecha, hora_inicial, hora_final, id_empleado, id_sala, id_paciente, observaciones, estado) 
VALUES ('2019-11-05','12:00:00','13:00:00',3,1,2,'Consulta','Programado');

INSERT INTO consultas (fecha, hora_inicial, hora_final, id_empleado, id_sala, id_paciente, observaciones, estado) 
VALUES ('2019-11-05','12:00:00','15:00:00',2,3,3,'Cirugia','Programado');

INSERT INTO consultas (fecha, hora_inicial, hora_final, id_empleado, id_sala, id_paciente, observaciones, estado) 
VALUES ('2019-11-06','10:00:00','13:00:00',2,2,2,'Cirugia','Programado');

INSERT INTO consultas (fecha, hora_inicial, hora_final, id_empleado, id_sala, id_paciente, observaciones, estado) 
VALUES ('2019-11-06','14:00:00','15:00:00',2,2,3,'Consulta','Programado');