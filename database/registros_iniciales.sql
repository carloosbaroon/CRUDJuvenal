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
VALUES ("Sala 1", "no disponible");

INSERT INTO sala (nombre, disponibilidad) 
VALUES ("Sala 2", "no disponible");

INSERT INTO sala (nombre, disponibilidad) 
VALUES ("Sala 3", "no disponible");

INSERT INTO sala (nombre, disponibilidad) 
VALUES ("Sala 4", "no disponible");

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

INSERT INTO consultas (fecha, hora_inicial, hora_final, id_empleado, id_sala, id_paciente, correo, observaciones, estado) 
VALUES ('2019-12-06','15:00:00','20:40:00',1,1,1,"example@gmail.com",'Cirugia','Programado');

INSERT INTO consultas (fecha, hora_inicial, hora_final, id_empleado, id_sala, id_paciente, correo, observaciones, estado) 
VALUES ('2019-12-06','10:00:00','21:00:00',1,2,3,"example@gmail.com",'Consulta','Programado');

INSERT INTO consultas (fecha, hora_inicial, hora_final, id_empleado, id_sala, id_paciente, correo, observaciones, estado) 
VALUES ('2019-12-06','12:00:00','21:20:00',3,3,1,"example@gmail.com",'Consulta','Programado');

INSERT INTO consultas (fecha, hora_inicial, hora_final, id_empleado, id_sala, id_paciente, correo, observaciones, estado) 
VALUES ('2019-12-06','12:00:00','21:10:00',3,4,2,"example@gmail.com",'Consulta','Programado');

INSERT INTO consultas (fecha, hora_inicial, hora_final, id_empleado, id_sala, id_paciente, correo, observaciones, estado) 
VALUES ('2019-12-06','12:00:00','21:10:00',2,5,3,"example@gmail.com",'Cirugia','Programado');

INSERT INTO consultas (fecha, hora_inicial, hora_final, id_empleado, id_sala, id_paciente, correo, observaciones, estado) 
VALUES ('2019-12-06','17:00:00','21:30:00',3,4,2,"example@gmail.com",'Consulta','Programado');

INSERT INTO consultas (fecha, hora_inicial, hora_final, id_empleado, id_sala, id_paciente, correo, observaciones, estado) 
VALUES ('2019-12-06','17:00:00','22:20:00',2,5,3,"example@gmail.com",'Cirugia','Programado');

/*	
El query de validacion de salas disponibles para hacer una reservacion

select sala.id_sala, sala.nombre from sala left join 
(select * from consultas where fecha = '2019/11/05' and ((hora_inicial between '11:30' and '12:30') or (hora_final between '11:30' and '12:30'))) consultas
on sala.id_sala = consultas.id_sala where sala.disponibilidad = 'disponible' and consultas.id_sala is null;

Query para filtrar citas por dueños

select consultas.id_consulta, consultas.fecha, consultas.hora_inicial, consultas.hora_final, consultas.id_empleado, consultas.id_sala, consultas.id_paciente, consultas.observaciones, consultas.estado 
from paciente inner join consultas 
where paciente.id_propietario = 2 and paciente.id_paciente = consultas.id_paciente;

Query para ultimo caso de Atencion
select consultas.id_sala, consultas.hora_final from (select * from consultas order by consultas.hora_final desc) consultas group by consultas.id_sala;
 */