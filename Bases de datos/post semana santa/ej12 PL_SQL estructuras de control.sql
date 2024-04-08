--1 Escribe un bloque PL/SQL que reciba un número (es decir, que esté en una constante) e imprima si es par o impar.
DECLARE
    v_constante CONSTANT NUMBER := 2;
BEGIN
    IF MOD( v_constante, 2 ) = 0 THEN
    	DBMS_OUTPUT.PUT_LINE( v_constante ||' es par');
    ELSE
    	DBMS_OUTPUT.PUT_LINE( v_constante ||' es impar');
    END IF;
END;



--2 Desarrollar un script PL/SQL que reciba un numero del uno al doce (recuerda, en una constante) y muestre por pantalla cuantos días tiene el mes representado por ese número. 
DECLARE
    v_constante CONSTANT NUMBER := 4;
BEGIN
    CASE
        WHEN v_constante IN (1,3,5,7,8,10,12) THEN
    		DBMS_OUTPUT.PUT_LINE('31 dias');
        WHEN v_constante IN (4,6,9,11) THEN
    		DBMS_OUTPUT.PUT_LINE('30 dias');
        WHEN v_constante = 2 THEN
    		DBMS_OUTPUT.PUT_LINE('28 dias');
        ELSE
    		DBMS_OUTPUT.PUT_LINE('mamahuevo ese mes no existe');
    END CASE;
END;



--3 Haz un bloque PL que lea un numero entero de una constante e indique si es el numero es o no es primo.
DECLARE
    v_constante CONSTANT NUMBER := 6;
	v_contador NUMBER := 1;
BEGIN
    WHILE (MOD( v_constante, v_contador ) != 0 OR v_constante != v_contador) LOOP -- no funciona el while puta dislexia
    	v_contador := v_contador + 1;
    	DBMS_OUTPUT.PUT_LINE('CP1 '|| v_contador);
	END LOOP;

		IF v_constante = v_contador THEN
    		DBMS_OUTPUT.PUT_LINE('es primo');
        ELSE
    		DBMS_OUTPUT.PUT_LINE('no es primo');
        END IF;
END;

--4 Crea un bloque PL/SQL lea de dos constantes el nombre y apellido de un empleado: 
--    Si el empleado trabaja en SouthWind, mostrará un mensaje indicando su nombre y puesto de trabajo.
--    En caso contrario, mostrará un mensaje en el que se indica que ese empleado no trabaja en la empresa.






