-- 0. Haz un procedimiento mostrarEmpleados(p_nombre_empleo) que muestre los trabajadores que tienen asignado el empleo que se pasa como parámetro ("Programmer", "Sales Representative", etc.).
--! COPIADO DEL PROFE
CREATE PROCEDURE mostrarEmpleados(p_nombre_empleo VARCHAR2)
IS
    CURSOR c_empleados(pc_puesto VARCHAR2) IS SELECT * FROM employees WHERE job_title = pc_puesto;
	v_fila c_empleados%ROWTYPE;
BEGIN
    OPEN c_empleados(p_nombre_empleo);
	-- Aquí empieza el copieteo:
	FETCH c_empleados INTO v_fila;
	WHILE c_empleados%FOUND LOOP
		DBMS_OUTPUT.PUT_LINE(v_fila.first_name || ' trabaja como ' || p_nombre_empleo);
		FETCH c_empleados INTO v_fila;
    END LOOP;
    CLOSE c_empleados;
END;
/
EXEC mostrarEmpleados('Sales Representative');

-- 1. Crea un procedimiento verCargosDirectivos() que muestre aquellos empleados que dependen directamente del presidente de SouthWind (tiene el ID de empleado 1) junto con los años que llevan en la empresa. Haz el ejercicio con WHILE y luego con FOR.
CREATE OR REPLACE PROCEDURE verCargosDirectivos
IS
    CURSOR c_empleados IS SELECT * FROM employees WHERE MANAGER_ID = 1;
	v_fila c_empleados%ROWTYPE;
BEGIN
    
    OPEN c_empleados;
	FETCH c_empleados INTO v_fila;

	-- con while
    DBMS_OUTPUT.PUT_LINE(' ==== CON WHILE ==== ');
	WHILE c_empleados%FOUND LOOP
		DBMS_OUTPUT.PUT_LINE(v_fila.first_name);
		FETCH c_empleados INTO v_fila;
    END LOOP;
    CLOSE c_empleados;



    OPEN c_empleados;
	FETCH c_empleados INTO v_fila;

	-- con for
    DBMS_OUTPUT.PUT_LINE(' ==== CON FOR   ==== ');
    FOR v_fila IN c_empleados LOOP
    	DBMS_OUTPUT.PUT_LINE(v_fila.first_name);
    END LOOP;
    CLOSE c_empleados;
END;
/
EXEC verCargosDirectivos();

-- 2. Escribe un procedimiento verAlmacenes(p_nombre_ciudad) que enseñe todos los almacenes que están en una determinada ciudad. Se debe mostrar error si no existen almacenes o la ciudad.
CREATE OR REPLACE PROCEDURE verAlmacenes(p_nombre_ciudad VARCHAR2)
IS
    CURSOR c_almacenes IS SELECT * FROM warehouses alm JOIN locations loc ON alm.LOCATION_ID = loc.LOCATION_ID WHERE loc.CITY LIKE p_nombre_ciudad;
	v_fila c_almacenes%ROWTYPE;
	v_cont NUMBER := 0;
BEGIN
    FOR v_fila IN c_almacenes LOOP
    	v_cont := v_cont+1;
    	DBMS_OUTPUT.PUT_LINE(v_fila.WAREHOUSE_NAME);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Se han encontrado ' || v_cont || ' almacenes');
END;
/
EXEC verAlmacenes('Southlake');

-- 3. Haz un procedimiento verPedidos(p_nombre_cliente, p_fecha) que obtenga un listado con todos los pedidos que ha realizado un cliente desde una fecha determinada. Por ejemplo, si se ejecutara verPedidos('Mastercard', DATE '2002-01-01'), se obtendría:
--      Pedido con ID 15 realizado por el vendedor Lilly Fisher el 2002-05-01.
--      Pedido con ID 26 realizado por el vendedor Gracis Ellis el 2004-06-25.
--      Total de pedidos: 2

CREATE OR REPLACE PROCEDURE verPedidos(p_nombre_cliente VARCHAR2, p_fecha DATE)
IS
    CURSOR c_pedidos IS SELECT * FROM orders ord JOIN customers cus ON ord.CUSTOMER_ID = cus.CUSTOMER_ID;
    -- WHERE cus.NAME LIKE p_nombre_cliente;
	v_fila c_pedidos%ROWTYPE;
	v_cont NUMBER := 0;
BEGIN
    FOR v_fila IN c_pedidos LOOP
    	IF p_fecha < v_fila.order_date THEN
    		v_cont := v_cont+1;
    		DBMS_OUTPUT.PUT_LINE('- Pedido con ID '|| v_fila.order_id ||' realizado por el vendedor '||v_fila.name||' el '||v_fila.order_date);
		END IF;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Se han encontrado ' || v_cont || ' pedidos');
END;
/
EXEC verPedidos('DTE Energy', DATE '2016-01-01');
