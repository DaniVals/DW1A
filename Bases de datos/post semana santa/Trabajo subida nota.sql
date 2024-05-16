-- 1. Implementar la función nombreOficio(p_id_empleado) que devuelva como resultado el nombre del puesto de trabajo que tiene el empleado cuyo ID se pasa como argumento. Muestra "El empleado no existe." en caso de que no se encuentre el ID.
CREATE OR REPLACE FUNCTION nombreOficio(p_id_empleado NUMBER)
RETURN VARCHAR2
IS
	v_select hr.employees.JOB_ID%TYPE;
	v_job_name hr.jobs.job_title%TYPE;
BEGIN
    SELECT JOB_ID INTO v_select FROM hr.employees WHERE EMPLOYEE_ID = p_id_empleado;
    SELECT job_title INTO v_job_name FROM hr.jobs WHERE JOB_ID = v_select;
	RETURN v_job_name;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
		RETURN 'El empleado no existe.';
END;
/
-- 2. Desarrollar el procedimiento listadoEmpleados(p_id_departamento) que muestre todos los empleados que tiene un determinado ID de departamento:
-- Para cada empleado muestra: su ID, nombre, apellidos y nombre de su puesto de trabajo.
-- El puesto de trabajo debes obtenerlo usando la función que has realizado antes.
-- Si el departamento no existe, informa de ello. 
-- Ejemplo al ejecutar listadoEmpleados(60):
-- Empleado/a 103: Alexander Hunold trabaja como Programmer
-- Empleado/a 104: Bruce Ernst trabaja como Programmer
-- Empleado/a 105: David Austin trabaja como Programmer
-- Empleado/a 106: Valli Pataballa trabaja como Programmer
-- Empleado/a 107: Diana Lorentz trabaja como Programmer
CREATE OR REPLACE PROCEDURE listadoEmpleados(p_id_departamento NUMBER)
IS
    CURSOR c_empleados IS SELECT * FROM hr.employees WHERE DEPARTMENT_ID = p_id_departamento;
	v_fila c_empleados%ROWTYPE;
BEGIN
    OPEN c_empleados;
    FETCH c_empleados INTO v_fila;
    IF c_empleados%FOUND THEN
    	WHILE c_empleados%FOUND LOOP
        	DBMS_OUTPUT.PUT_LINE('- Empleado/a '|| v_fila.EMPLOYEE_ID ||': '||v_fila.FIRST_NAME||' '||v_fila.LAST_NAME||' trabaja como '||nombreOficio(v_fila.EMPLOYEE_ID));
    		FETCH c_empleados INTO v_fila;
        END LOOP;
	ELSE
    	DBMS_OUTPUT.PUT_LINE('No existe el departamento');
    END IF;
EXCEPTION
    WHEN OTHERS THEN
    	DBMS_OUTPUT.PUT_LINE('Se encontro otra excepcion ' || SQLCODE);
END;
/
execute listadoEmpleados(60);

-- 3. Desarrollar una vista con los 5 empleados que más ganan de la empresa, pero solo si entraron a trabajar a partir del 2004 . Muestra el nombre, apellidos, sueldo y años que llevan contratados.
CREATE OR REPLACE VIEW los_cinco_primeros AS (SELECT FIRST_NAME, LAST_NAME, SALARY, HIRE_DATE FROM hr.employees WHERE HIRE_DATE >= DATE '2004-01-01' ORDER BY SALARY DESC FETCH FIRST 5 ROWS ONLY);

SELECT * FROM los_cinco_primeros