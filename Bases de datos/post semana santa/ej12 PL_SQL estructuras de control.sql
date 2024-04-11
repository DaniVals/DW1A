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
-- !COPIADO DEL PROFE!
DECLARE
	c_nombre CONSTANT VARCHAR2(125) := 'Jude';
	c_apellido CONSTANT VARCHAR2(125) := 'Rivera';
	v_empleo VARCHAR2(125);
	v_contador NUMBER;
BEGIN
	SELECT COUNT(*) INTO v_contador FROM employees WHERE first_name=c_nombre AND last_name=c_apellido;
	
	-- Compruebo si está el empleado
	IF v_contador = 1 THEN
        SELECT job_title INTO v_empleo FROM employees WHERE first_name=c_nombre AND last_name=c_apellido;
        DBMS_OUTPUT.PUT_LINE(c_nombre || ' ' || c_apellido || ' trabaja de ' || v_empleo);
    ELSE
        DBMS_OUTPUT.PUT_LINE('El empleado no trabaja en SouthWind');
    END IF;
END;




-- 5 Desarrolla un script que calcule el factorial de un número almacenado en una constante. El factorial solo está definido para los números naturales (es decir, sin decimales) que son positivos. Debes comprobar ambas cosas e informar al usuario. Pista: usa funciones de matemáticas.
DECLARE
    v_factorizado CONSTANT NUMBER := 5;
	v_contador NUMBER;
	v_resultado NUMBER := 1;
BEGIN
    FOR v_contador IN 2 .. v_factorizado LOOP
    	DBMS_OUTPUT.PUT_LINE(v_resultado);
    	v_resultado := v_resultado * v_contador;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Resultado: '||v_resultado);
END;

-- 6 Escribe un bloque PL que incremente el precio de los productos un 4%, pero solo para aquellos productos cuyo ID 
--   estén en un rango. Este rango viene determinado por dos constantes que definas. Ten en cuenta que...
--     Hay que comprobar que cada producto existe antes de actualizarlo.
--     Debes imprimir el nombre del producto junto al incremento en euros que ha sufrido.
--     Informar del número de productos afectados en total.
-- !COPIADO DEL PROFE!
DECLARE
	c_min CONSTANT NUMBER := 1;
    c_max CONSTANT NUMBER := 999;
	v_cantidad NUMBER := 0;
	v_existe NUMBER := 0;
	v_dif_precio NUMBER;
	v_nombre VARCHAR2(125);
BEGIN
    -- Itero entre c_min y c_max
    FOR v_indice IN c_min .. c_max LOOP
    	-- Compruebo si el producto realmente existe
    	SELECT COUNT(*) INTO v_existe FROM products WHERE product_id=v_indice;
    	IF v_existe = 1 THEN
			-- Tengo que informar del incremento
			SELECT (list_price*1.04-list_price),product_name INTO v_dif_precio,v_nombre FROM products WHERE product_id=v_indice;
			-- El producto existe, así que lo actualizo
            UPDATE products SET list_price = list_price * 1.04 WHERE product_id=v_indice;
			-- Informo
			DBMS_OUTPUT.PUT_LINE('El producto ' || v_nombre || ' se ha incrementado ' || TRUNC(v_dif_precio,2) || '€');
			-- Incrementar el contador de productos que se han incrementado
			v_cantidad := v_cantidad+1;
    	END IF;
	END LOOP;
	DBMS_OUTPUT.PUT_LINE('== EN TOTAL SE HAN ACTUALIZADO ' || v_cantidad || ' PRODUCTOS ==');
END;


