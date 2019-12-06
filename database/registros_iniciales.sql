use veterinaria;

INSERT INTO empleado (id_empleado, nombre_completo, direccion, telefono, puesto, especialidad, turno, estado, elegido) 
VALUES (1, "David", "Av de la vida", "7226483059", "puesto de prueba 1", "no se", "1", "Activo", 1);

INSERT INTO empleado (id_empleado, nombre_completo, direccion, telefono, puesto, especialidad, turno, estado, elegido) 
VALUES (2, "Mariana", "Av las torres", "123456789", "puesto de prueba 2", "no se 2", "2", "Baja", 1);

INSERT INTO empleado (id_empleado, nombre_completo, direccion, telefono, puesto, especialidad, turno, estado, elegido) 
VALUES (3, "Paola", "CU", "987654321", "puesto de prueba 3", "no se 2", "3", "Activo", 1);

INSERT INTO usuario (id_empleado, password_user, confirmar_password, privilegios, estado, no_intentos) 
VALUES (1, "hola", "hola", "Administrador", "activo", 5);

INSERT INTO usuario (id_empleado, password_user, confirmar_password, privilegios, estado, no_intentos) 
VALUES (2, "cactus", "cactus", "Usuario", "activo", 5);

INSERT INTO sala (nombre, disponibilidad) 
VALUES ("Sala 1", "disponible");

INSERT INTO sala (nombre, disponibilidad) 
VALUES ("Sala 2", "disponible");

INSERT INTO sala (nombre, disponibilidad) 
VALUES ("Sala 3", "disponible");

INSERT INTO sala (nombre, disponibilidad) 
VALUES ("Sala 4", "disponible");

INSERT INTO sala (nombre, disponibilidad) 
VALUES ("Sala 5", "no disponible");

INSERT INTO propietario (nombre, direccion, telefono, rfc, correo) 
VALUES ("Juan Martinez", "Toluca", "7223535654", "MASJ4534343", "example@gmail.com");

INSERT INTO propietario (nombre, direccion, telefono, rfc, correo) 
VALUES ("Alejandra Sanchez", "Cd. de Mexico", "7227863654", "SAMA126paciente4343", "example@gmail.com");

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

/*	
El query de validacion de salas disponibles para hacer una reservacion

select sala.id_sala, sala.nombre from sala left join 
(select * from consultas where fecha = '2019/11/05' and ((hora_inicial between '11:30' and '12:30') or (hora_final between '11:30' and '12:30'))) consultas
on sala.id_sala = consultas.id_sala where sala.disponibilidad = 'disponible' consultas.id_sala is null;

Query para filtrar citas por dueños

select consultas.id_consulta, consultas.fecha, consultas.hora_inicial, consultas.hora_final, consultas.id_empleado, consultas.id_sala, consultas.id_paciente, consultas.observaciones, consultas.estado 
from paciente inner join consultas 
where paciente.id_propietario = 2 and paciente.id_paciente = consultas.id_paciente;
 */