CREATE TABLE pais(
    --tipos normales
    numero NUMBER(9,8),--nueve numeros y ocho de ellos decimal
    texto VARCHAR(32), --un texto de 32 caracteres 
    fechas DATE,       --una fecha (aaaa--dd--mm) / DATE '2005-08-20'
    hora TIMESTAMP,    --una hora
    --FALTAN LOS DE ARCHIVOS QUE YA LOS DAREMOS

    nombrecolumna NUMBER CONSTRAINT nombretabla_nombrecolumna_tipoderestriccion TIPO_RESTRICCION
    --PK PRIMARY KEY    (claves primarias)
    --UK UNIQUE         (claves unicas pero no primarias)
    --FK REFERENCES nombre_otra_tabla(nombre_otra_columna)    (claves foraneas)
        --se suele poner ON DELETE SET NULL / SOLO se pueden referenciar UNIQUE o PRIMARY KEY
    --DF DEFAULT 
    --CK CHECK (nombrecolumna BETWEEN n1 AND n2) /version texto/ (nombrecolumna IN ('nombre1','nombre2','nombre3'))

    --ON DELETE SET NULL (si se borra el valor original de la clave foranea, que ponga null en vez de petar)
    );

DROP TABLE pais;