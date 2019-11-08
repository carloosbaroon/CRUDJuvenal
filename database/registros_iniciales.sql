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
