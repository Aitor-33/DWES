-- ==============================================
--  CREAR BASE DE DATOS
-- ==============================================
CREATE DATABASE simmanytoone;
USE simmanytoone;

-- ==============================================
--  enunciado para practicar
-- GET de todos los empleados
-- GET de un empleado por su id
-- GET de los empleados de una empresa por el id de la empresa
-- POST de crear un empleado
-- PUT para actualizar un empleado para asignarle a una nueva empresa se piden los dos ids empresa y empleado
-- DELETE para eliminar un empleado por su id
-- DELETE eliminar una empresa por su id
-- { esto es un ejemplo del json para el POST
--  "nombre": "Lucía Torres",
--  "fechaIncorporacion": "2023-10-05",
--  "sueldo": 3500.75,
--  "empresaId": 1
-- }
-- ==============================================
CREATE TABLE empresa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);


CREATE TABLE empleado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fecha_incorporacion DATE NOT NULL,
    sueldo DECIMAL(10,2) NOT NULL,
    empresa_id INT NOT NULL,
    CONSTRAINT fk_empleado_empresa
        FOREIGN KEY (empresa_id)
        REFERENCES empresa(id)
        ON DELETE CASCADE
);


INSERT INTO empresa (nombre) VALUES
('Google'),
('Amazon'),
('Microsoft');


INSERT INTO empleado (nombre, fecha_incorporacion, sueldo, empresa_id) VALUES
('Juan Pérez', '2021-05-10', 2500.00, 1),
('Ana López', '2020-11-03', 3200.50, 1),
('Carlos Ruiz', '2019-01-20', 2800.75, 2),
('María Díaz', '2022-03-12', 3100.00, 2),
('Pedro Sánchez', '2018-07-22', 4000.00, 3);

-- ==============================================
--  CONSULTAS DE COMPROBACIÓN
-- ==============================================
-- Ver empresas
SELECT * FROM empresa;

-- Ver empleados
SELECT * FROM empleado;

-- Ver empleados con nombre de su empresa
SELECT e.id, e.nombre, e.fecha_incorporacion, e.sueldo, emp.nombre AS empresa
FROM empleado e
JOIN empresa emp ON e.empresa_id = emp.id;
