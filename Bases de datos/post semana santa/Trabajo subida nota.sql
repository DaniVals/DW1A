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
BEGIN
    DBMS_OUTPUT.PUT_LINE(nombreOficio(100));
END;

-- SELECT * FROM hr.employees
-- SELECT * FROM hr.jobs

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
-- 3. Desarrollar una vista con los 5 empleados que más ganan de la empresa, pero solo si entraron a trabajar a partir del 2004 . Muestra el nombre, apellidos, sueldo y años que llevan contratados.