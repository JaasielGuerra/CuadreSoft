--  Administrador de Base de Datos: SQLite
--  Diagrama: BaseDeDatos
--  Autor: Jaasiel
--  Fecha y hora: 22/11/2019 18:45:47
PRAGMA foreign_keys = ON;

-- GENERANDO TABLAS
CREATE TABLE IF NOT EXISTS registro_cuadres (
	fecha TEXT NOT NULL ,
	inicio_caja TEXT NOT NULL ,
	ventas TEXT NOT NULL ,
	gastos TEXT NOT NULL ,
	dinero_real TEXT NOT NULL ,
	sobra_falta TEXT NOT NULL ,
	cuadre_final TEXT NOT NULL 
);