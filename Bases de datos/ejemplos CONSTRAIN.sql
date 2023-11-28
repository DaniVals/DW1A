CREATE TABLE pais(
    id NUMBER CONSTRAINT usuario_id_PK PRIMARY KEY,
    nombre VARCHAR(32)
    );
INSERT INTO pais VALUES(1, 'Japon');

CREATE TABLE usuario (
    --id NUMBER(6) CONSTRAINT usuario_id_PK PRIMARY KEY,
    nombre VARCHAR2(20),
    --contrasena VARCHAR2(8)	CONSTRAINT usuario_contrasena_NN NOT NULL --NO HAY COMA 
    --						CONSTRAINT usuario_contrasena_UQ UNIQUE,
    localizacion NUMBER CONSTRAINT usuario_localizacion_FK REFERENCES pais(id)
    
	);
SELECT * FROM pais;
SELECT * FROM usuario;
DESC usuario;
DROP TABLE usuario;
DROP TABLE pais;