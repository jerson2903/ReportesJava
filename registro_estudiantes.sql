-- Base de datos del Registro de Estudiantes
CREATE DATABASE registro_estudiantes;
USE registro_estudiantes;

-- Crear tabla estudiantes
CREATE TABLE estudiantes (
    id_estudiante INT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    fecha_nacimiento DATE,
    edad INT(5),
    id_estado_civil INT,
    id_estado INT,
    id_documento INT,
    direccion VARCHAR(100),
    FOREIGN KEY (id_estado) REFERENCES estados (id_estado),
    FOREIGN KEY (id_estado_civil) REFERENCES estado_civil (id_estado_civil),
    FOREIGN KEY (id_documento) REFERENCES documentos (id_documento)
);

-- Crear tabla estados
CREATE TABLE estados (
  id_estado INT PRIMARY KEY,
  nombre_estado VARCHAR(50)
);

INSERT INTO estados (id_estado, nombre_estado)
VALUES (1, 'LARA'),
       (2, 'YARACUY'),
	   (3, 'ZULIA'),
	   (4, 'TACHIRA'),
	   (5, 'FALCON');

-- Crear tabla estado_civil
CREATE TABLE estado_civil (
  id_estado_civil INT PRIMARY KEY,
  nombre_estado_civil VARCHAR(50)
);

INSERT INTO estado_civil (id_estado_civil, nombre_estado_civil)
VALUES (1, 'SOLTERO'),
       (2, 'CASADO');

-- Crear tabla documentos
CREATE TABLE documentos (
    id_documento INT PRIMARY KEY,
    nombre_documentos VARCHAR(20)
);

INSERT INTO documentos (id_documento, nombre_documentos)
VALUES (1, 'PENDIENTE'),
       (2, 'ENTREGADO');

INSERT INTO estudiantes (id_estudiante, nombre, apellido, fecha_nacimiento, edad, id_estado_civil, id_estado, id_documento, direccion)
VALUES (25401355, 'Jerson', 'gomez', '1997-03-29', 27, 1, 1, 1, 'calle 14 la antena'),
	   (25401354, 'Jesus', 'Rodriguez', '1998-03-25', 26, 1, 2, 1, 'calle 15 la antena'),
       (12333212, 'Jose', 'Torres', '1959-03-15', 78, 1, 5, 1, 'calle 16 la antena'),
       (15777222, 'Pepe', 'Linarez', '1979-03-15', 60, 1, 2, 1, 'calle 10 la antena');

SELECT * FROM estudiantes;