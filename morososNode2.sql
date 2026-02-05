-- DROP TABLE IF EXISTS reservas;
-- DROP TABLE IF EXISTS pistas;

-- DROP DATABASE IF EXISTS club_padel_db;
-- CREATE DATABASE club_padel_db
 -- CHARACTER SET utf8mb4
 -- COLLATE utf8mb4_unicode_ci;
USE club_padel_db;
-- =========================
-- TABLA: pistas
-- =========================
CREATE TABLE pistas (
 id INT AUTO_INCREMENT PRIMARY KEY,
 nombre VARCHAR(60) NOT NULL,
 tipo ENUM('INDOOR','OUTDOOR') NOT NULL DEFAULT 'INDOOR',
 precio_hora DECIMAL(7,2) NOT NULL DEFAULT 0.00,
 created_at DATETIME NOT NULL,
 updated_at DATETIME NOT NULL,
 UNIQUE KEY uq_pistas_nombre (nombre)
);
-- =========================
-- TABLA: reservas
-- =========================
CREATE TABLE reservas (
 id INT AUTO_INCREMENT PRIMARY KEY,
 pista_id INT NOT NULL,
 fecha DATE NOT NULL,
 hora_inicio TIME NOT NULL,
 hora_fin TIME NOT NULL,
 created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
 updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE
CURRENT_TIMESTAMP,
 CONSTRAINT fk_reservas_pistas
 FOREIGN KEY (pista_id) REFERENCES pistas(id)
 ON DELETE RESTRICT
 ON UPDATE CASCADE,
 -- Evita duplicados exactos
 UNIQUE KEY uq_reserva_tramo (pista_id, fecha, hora_inicio, hora_fin),
 CHECK (hora_fin > hora_inicio)
);
-- =========================
-- DATOS DE EJEMPLO
-- =========================
-- INSERT INTO pistas (nombre, tipo, precio_hora)
-- VALUES
 -- ('Pista 1 - Central', 'INDOOR', 22.00),
 -- ('Pista 2 - Outdoor', 'OUTDOOR', 16.50);
-- INSERT INTO reservas (pista_id, fecha, hora_inicio, hora_fin)
-- VALUES
 -- (1, '2026-01-12', '18:00:00', '19:00:00');
