CREATE DATABASE IF NOT EXISTS simulacrotoone
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;
 
USE simulacrotoone;
 

CREATE TABLE IF NOT EXISTS empresas (
  id varchar(200) NOT NULL,
  nombre VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;
 

CREATE TABLE IF NOT EXISTS empleados (
  id varchar(200) NOT NULL,
  empresa_id VARCHAR(200) NOT NULL,   
  nombre VARCHAR(255) NOT NULL,
  apellido VARCHAR(255) NOT NULL,
  edad INT,
  PRIMARY KEY (id),
  INDEX idx_empleados_empresa_id (empresa_id),
  CONSTRAINT fk_empleados_empresas
    FOREIGN KEY (empresa_id)
    REFERENCES empresas(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
) ENGINE=InnoDB;
 
-- Datos de prueba para EMPRESAS
INSERT INTO empresas (id, nombre) VALUES ('dfadsadsa212ads','Empresa A');
INSERT INTO empresas (id, nombre) VALUES ('sdfsdfsdfds212sa','Empresa B');
