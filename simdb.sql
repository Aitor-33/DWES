create database if not exists simulacrodb;
USE  simulacrodb;

CREATE TABLE vw (
id BIGINT AUTO_INCREMENT  PRIMARY KEY,
nombre varchar(30),
caballos decimal(6,2),
peso decimal(6,2),
tipo enum('SUV','DEPORTIVO','HTBACH'),
fechaDeCreacion date
);

CREATE TABLE seat (
id BIGINT AUTO_INCREMENT  PRIMARY KEY,
nombre varchar(30),
caballos decimal(6,2),
peso decimal(6,2),
tipo enum('SUV','DEPORTIVO','HTBACH'),
fechaDeCreacion date
);

CREATE TABLE bmw (
id BIGINT AUTO_INCREMENT  PRIMARY KEY,
nombre varchar(30),
caballos decimal(6,2),
peso decimal(6,2),
tipo enum('SUV','DEPORTIVO','HTBACH'),
fechaDeCreacion date
);

INSERT INTO vw (nombre, caballos, peso, tipo, fechaDeCreacion) VALUES
('VW Tiguan', 150.00, 1650.50, 'SUV', '2023-05-12'),
('VW Golf GTI', 245.00, 1430.20, 'DEPORTIVO', '2022-11-08'),
('VW Polo', 95.00, 1180.00, 'HTBACH', '2021-04-15'),
('VW T-Roc', 150.00, 1490.75, 'SUV', '2023-01-25'),
('VW Passat', 190.00, 1605.30, 'HTBACH', '2020-09-11'),
('VW Touareg', 286.00, 2100.00, 'SUV', '2019-03-30'),
('VW Scirocco', 200.00, 1370.40, 'DEPORTIVO', '2018-07-19'),
('VW Arteon', 280.00, 1700.00, 'DEPORTIVO', '2021-12-02'),
('VW Golf', 115.00, 1250.22, 'HTBACH', '2022-04-17'),
('VW T-Cross', 110.00, 1255.10, 'SUV', '2023-08-05');


INSERT INTO seat (nombre, caballos, peso, tipo, fechaDeCreacion) VALUES
('Seat Ibiza', 95.00, 1150.00, 'HTBACH', '2022-02-10'),
('Seat Leon FR', 150.00, 1380.50, 'DEPORTIVO', '2021-06-15'),
('Seat Ateca', 150.00, 1550.75, 'SUV', '2020-10-01'),
('Seat Tarraco', 190.00, 1800.20, 'SUV', '2019-12-30'),
('Seat Arona', 110.00, 1200.00, 'HTBACH', '2023-03-21'),
('Seat Alhambra', 150.00, 1780.60, 'SUV', '2018-05-27'),
('Seat Leon Cupra', 300.00, 1420.10, 'DEPORTIVO', '2020-08-16'),
('Seat Toledo', 120.00, 1300.00, 'HTBACH', '2019-04-08'),
('Seat Mii', 75.00, 950.50, 'HTBACH', '2017-11-19'),
('Seat Exeo', 200.00, 1550.40, 'DEPORTIVO', '2015-09-02');


INSERT INTO bmw (nombre, caballos, peso, tipo, fechaDeCreacion) VALUES
('BMW X1', 192.00, 1650.00, 'SUV', '2022-07-14'),
('BMW X3', 252.00, 1850.50, 'SUV', '2021-03-19'),
('BMW M3', 480.00, 1680.90, 'DEPORTIVO', '2023-11-01'),
('BMW Serie 1', 140.00, 1320.20, 'HTBACH', '2020-05-23'),
('BMW X5', 340.00, 2200.00, 'SUV', '2019-10-10'),
('BMW Z4', 258.00, 1520.40, 'DEPORTIVO', '2018-04-14'),
('BMW M2', 410.00, 1550.80, 'DEPORTIVO', '2022-01-09'),
('BMW Serie 2', 192.00, 1450.50, 'HTBACH', '2021-09-17'),
('BMW iX3', 286.00, 2180.30, 'SUV', '2023-06-28'),
('BMW Serie 3', 190.00, 1500.75, 'HTBACH', '2020-02-05');

-- Traer todos los datos de la tabla vw
SELECT * FROM vw;

-- Traer todos los datos de la tabla seat
SELECT * FROM seat;

-- Traer todos los datos de la tabla bmw
SELECT * FROM bmw;

ALTER TABLE vw CHANGE fechaDeCreacion fecha DATE;


