DROP DATABASE IF EXISTS concesionario;
CREATE DATABASE concesionario;
USE concesionario;

CREATE TABLE usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  email VARCHAR(150) NOT NULL UNIQUE,
  rol ENUM('cliente', 'vendedor') DEFAULT 'cliente'
);

CREATE TABLE vehiculos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  marca VARCHAR(100) NOT NULL,
  modelo VARCHAR(100) NOT NULL,
  anio INT NOT NULL,
  precio DECIMAL(10,2) NOT NULL,
  kilometros INT NOT NULL,
  combustible ENUM('gasolina', 'diesel', 'hibrido', 'electrico') NOT NULL,
  estado ENUM('disponible', 'reservado', 'vendido') DEFAULT 'disponible'
);

CREATE TABLE solicitudes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  usuario_id INT NOT NULL,
  vehiculo_id INT NOT NULL,
  mensaje TEXT,
  fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

  FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
  FOREIGN KEY (vehiculo_id) REFERENCES vehiculos(id)
);



INSERT INTO vehiculos (marca, modelo, anio, precio, kilometros, combustible, estado) VALUES
('BMW', 'X5', 2021, 58900.00, 42000, 'diesel', 'disponible'),
('Mercedes-Benz', 'Clase E', 2020, 47500.00, 51000, 'diesel', 'disponible'),
('Porsche', 'Macan', 2019, 62000.00, 38000, 'gasolina', 'reservado'),
('Tesla', 'Model S', 2022, 79900.00, 22000, 'electrico', 'disponible'),
('Audi', 'A7', 2021, 68500.00, 30000, 'diesel', 'vendido'),
('Audi', 'A3', 2006, 3900.00, 215000, 'diesel', 'disponible');

INSERT INTO usuarios (nombre, email, rol) VALUES
('Juan Pérez', 'juan@correo.com', 'cliente'),
('Laura Gómez', 'laura@correo.com', 'cliente'),
('Carlos Martín', 'carlos@concesionario.com', 'vendedor');

INSERT INTO solicitudes (usuario_id, vehiculo_id, mensaje) VALUES
(1, 1, 'Estoy interesado en este vehículo. ¿Sigue disponible?'),
(2, 3, '¿Es posible probar el coche antes de decidirme?'),
(1, 4, '¿Aceptáis coche antiguo como parte del pago?'),
(2, 2, '¿Cuál es el consumo real en ciudad?');


SELECT u.nombre, v.marca, v.modelo, s.mensaje, s.fecha
FROM solicitudes s
JOIN usuarios u ON s.usuario_id = u.id
JOIN vehiculos v ON s.vehiculo_id = v.id;

SELECT * FROM usuarios;
SELECT * FROM vehiculos;
SELECT * FROM solicitudes;



