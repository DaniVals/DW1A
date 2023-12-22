CREATE TABLE Autor(
    id NUMBER(20), --PK
    nombre VARCHAR(30),
    apellido VARCHAR(30),
    nacionalidad VARCHAR(50),
    numero_premios NUMBER(11),
	fecha_nacimiento DATE,
    CONSTRAINT id_Autor_PK PRIMARY KEY(id)
);
CREATE TABLE Usuario(
    id NUMBER(20), --PK
    nombre VARCHAR(30),
    apellido VARCHAR(30),
    direccion VARCHAR(50),
    email VARCHAR(50),
    telefono NUMBER(11),
    CONSTRAINT id_Usuario_PK PRIMARY KEY(id)
);
CREATE TABLE Libro(
    isbn NUMBER(13), --PK
    titulo VARCHAR(30),
    autor NUMBER(20), --FK
	fecha_publicacion DATE,
    numero_copias NUMBER(30),
	esta_descatalogado NUMBER(1), --boolean
    CONSTRAINT isbn_Libro_PK PRIMARY KEY(isbn),
    CONSTRAINT autor_Libro_FK FOREIGN KEY(autor) REFERENCES Autor(id),
    CONSTRAINT esta_descatalogado_Libro_CK CHECK (esta_descatalogado BETWEEN 0 AND 1)
);
CREATE TABLE Prestamo(
    libro_prestado NUMBER(13), --PK FK
    usuario NUMBER(20), --PK FK
	fecha_prestamo DATE, --PK
	fecha_devolucion DATE,
	estado_devuelto VARCHAR(1), -- Correcto / Desperfectos / Inservible”. 
    CONSTRAINT LpUFp_Prestamo_PK PRIMARY KEY(libro_prestado,usuario,fecha_prestamo),
    CONSTRAINT usuario_Prestamo_FK FOREIGN KEY(usuario) REFERENCES Usuario(id),
    CONSTRAINT libro_prestado_Prestamo_FK FOREIGN KEY(libro_prestado) REFERENCES Libro(isbn),
    CONSTRAINT estado_devuelto_Prestamo_CK CHECK (estado_devuelto IN ('C','D','I'))
);

DESC Autor;
DESC Usuario;
DESC Libro;
DESC Prestamo;

DROP TABLE Prestamo;
DROP TABLE Libro;
DROP TABLE Usuario;
DROP TABLE Autor;