CREATE TABLE Paciente(
    dni VARCHAR(9) CONSTRAINT dni_Paciente_PK PRIMARY KEY,
    nombre VARCHAR(30),
    apellidos VARCHAR(30),
    fecha_nacimiento DATE
    );
CREATE TABLE Especialidad(
    codigo NUMBER(4) CONSTRAINT codigo_Especialidad_PK PRIMARY KEY,
    nombre VARCHAR(30),
    salario_base NUMBER(12)
    );
CREATE TABLE Medico(
    num_colegiado NUMBER(6) CONSTRAINT num_colegiado_Medico_PK PRIMARY KEY,
    nombre VARCHAR(30),
    apellidos VARCHAR(30),
	especialidad NUMBER(4) CONSTRAINT especialidad_Medico_FK REFERENCES Especialidad(codigo),
	turno_trabajo VARCHAR(10),
	hace_guardias NUMBER(1) CONSTRAINT hace_guardias_Medico_CK CHECK (hace_guardias BETWEEN 0 AND 1)
    );
CREATE TABLE Asignado(
    paciente VARCHAR(9) CONSTRAINT paciente_Asignado_PK_FK 	PRIMARY KEY 
    														REFERENCES Paciente(dni),
    medico_cabecera NUMBER(6) CONSTRAINT medico_cabecera_Asignado_FK REFERENCES Medico(num_colegiado),
    fecha_asignacion DATE
    );

INSERT INTO Paciente VALUES('1001001Z', 'Manuel', 'Gil', DATE '2010-10-10');
INSERT INTO Paciente VALUES('222222R', 'Darío', 'Herranz', DATE '2002-02-22');
INSERT INTO Especialidad VALUES('1234', 'traumatóloga', 10);
INSERT INTO Especialidad VALUES('6789', 'psiquiatra', 2000);
INSERT INTO Medico VALUES('303030', 'Laura', 'Sanz', '1234', 'mañana', 0);
INSERT INTO Medico VALUES('404040', 'Sara', 'López', '6789', 'tarde', 1);
INSERT INTO Asignado VALUES('1001001Z', '6789', DATE '2023-11-10');
INSERT INTO Asignado VALUES('222222R', '6789', DATE '2022-05-15');

SELECT * FROM Paciente;
SELECT * FROM Especialidad;
SELECT * FROM Medico;
SELECT * FROM Asignado;

DROP TABLE Asignado;
DROP TABLE Medico;
DROP TABLE Especialidad;
DROP TABLE Paciente; 