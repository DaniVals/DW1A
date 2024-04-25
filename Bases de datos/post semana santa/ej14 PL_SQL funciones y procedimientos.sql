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
CREATE OR REPLACE FUNCTION numSubordinados(p_nombre VARCHAR2, p_apellido VARCHAR2)
RETURN NUMBER
IS
	v_select Employees.EMPLOYEE_ID%TYPE;
	v_count NUMBER;
BEGIN
    SELECT EMPLOYEE_ID INTO v_select FROM Employees WHERE FIRST_NAME = p_nombre AND LAST_NAME = p_apellido;
	v_count := 3;
	RETURN v_count;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
		DBMS_OUTPUT.PUT_LINE('No se encontro al empleado');
    WHEN OTHERS THEN
    	DBMS_OUTPUT.PUT_LINE('Se encontro otra excepcion ' || SQLCODE);
END;
/
BEGIN
    DBMS_OUTPUT.PUT_LINE(numSubordinados('Rose','Stephens'));
END;
--7 Crea un procedimiento crearProducto(p_nombre, p_descripcion, p_categoria, p_coste, p_precio). Ten en cuenta que:
--    p_categoria es el nombre (texto) de una categoría, y se debe comprobar que ya exista. 
--    El coste del producto no puede ser inferior al precio de venta. Además, como mínimo SouthWind exige un beneficio del 10% al vender.
--    El nombre del producto no puede estar repetido.
-- !SIN ACABAR
CREATE OR REPLACE PROCEDURE crearProducto(p_nombre VARCHAR2, p_descripcion VARCHAR2, p_categoria NUMBER, p_coste NUMBER, p_precio NUMBER)
IS
	v_resultado NUMBER;
BEGIN
    v_resultado := p_dividendo / p_divisor;
	DBMS_OUTPUT.PUT_LINE(v_resultado);
END;
/
execute crearProducto('Intel D4N1', 'corre a todo lo que da',4,255.5,1234);
DROP PROCEDURE crearProducto;

-- SELECT * FROM Products;
--8 Escribe un procedimiento cerrarAlmacen(p_nombre_almacen), que elimine un almacén de la base de datos, pero únicamente si tiene menos de 100 unidades de productos en sus instalaciones. Controla los errores que pueda haber, muestra el resultado y la cantidad de unidades que tiene disponibles.


--9 Haz un procedimiento reubicarComercial(p_id_comercial, p_min_pedidos, p_nuevo_puesto) que cambie de puesto de trabajo ("job_title") a un comercial que no haya llegado a un mínimo de pedidos. Ten en cuenta:
-- Hay que comprobar que el empleado es realmente un comercial.
-- Muestra el nombre y cuántos pedidos ha logrado.
-- Si lleva contratado menos de 6 meses, se asume que está aprendiendo y se le perdona (indícalo).
-- !SIN ACABAR
CREATE OR REPLACE PROCEDURE reubicarComercial(p_id_comercial NUMBER, p_min_pedidos NUMBER, p_nuevo_puesto VARCHAR2)
IS
	v_select Employees%ROWTYPE;
	v_count_orders NUMBER;
BEGIN

    SELECT COUNT(order_id) INTO v_count_orders FROM ORDERS WHERE SALESMAN_ID = p_id_comercial;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
		DBMS_OUTPUT.PUT_LINE('No se encontro al empleado');
END;
/
execute reubicarComercial(1,2,'job_title');


--10 Modifica el ejercicio anterior para que muestre además el número de subordinados que el comercial tiene a su cargo. Usa para ello la función numSubordinados que tienes.
