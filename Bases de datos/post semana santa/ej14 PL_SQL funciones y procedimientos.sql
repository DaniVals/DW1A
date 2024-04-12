--1 Crear el procedimiento multiplicar(p_numero1, p_numero2), que muestre por pantalla el resultado de producto entre ambos números. 
-- !COPIADO!
EXECUTE tablaMultiplicar(4);
CREATE OR REPLACE PROCEDURE tablaMultiplicar(p_numero NUMBER)
IS
BEGIN
	-- Iterar desde 1 hasta 10, multiplicando el i * p_numero
    FOR v_i IN 1 .. 10 LOOP
    	 multiplicar(v_i, p_numero);
    END LOOP;
END;

--2 Ahora escribe el procedimiento tablaMultiplicar(p_numero) que muestre la tabla de multiplicar de ese número usando el procedimiento anterior multiplicar(numero1, numero2).
-- !COPIADO!
CREATE OR REPLACE PROCEDURE multiplicar(p_numero1 NUMBER, p_numero2 NUMBER)
IS
	v_resultado NUMBER;
BEGIN
    v_resultado := p_numero1 * p_numero2;
	DBMS_OUTPUT.PUT_LINE(v_resultado);
END;

--3 Desarrollar el procedimiento dividir(p_dividendo, p_divisor) que muestre por pantalla el resultado de la división entre ambos. Se debe tratar la excepción ZERO_DIVIDE y OTHERS. 
CREATE OR REPLACE PROCEDURE dividir(p_dividendo NUMBER, p_divisor NUMBER)
IS
	v_resultado NUMBER;
BEGIN
    v_resultado := p_dividendo / p_divisor;
	DBMS_OUTPUT.PUT_LINE(v_resultado);
EXCEPTION
    WHEN ZERO_DIVIDE THEN
		DBMS_OUTPUT.PUT_LINE('No se puede dividir entre cero');
    WHEN OTHERS THEN
    	DBMS_OUTPUT.PUT_LINE('Se encontro otra excepcion ' || SQLCODE);
	
END;
/
execute dividir(1,9);
DROP PROCEDURE dividir;
--4 Crea una función diferenciaAnios(p_fecha) que reciba un tipo DATE y retorne la cantidad de años que han transcurrido desde la fecha hasta la actualidad.

--5 Escribe un procedimiento mostrarEmpleados(p_id) que reciba un ID de empleado y muestre su nombre y los años que lleva en SouthWind. Usa la función diferenciaAnios para mostrar los años.

--6 Desarrollar la función numSubordinados(p_nombre, p_apellidos) que devuelva el número de subordinados que tiene un empleado. Implementar las excepciones necesarias y una para error inesperado.
