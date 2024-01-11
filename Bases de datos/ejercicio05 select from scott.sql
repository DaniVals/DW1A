--Obtén la estructura de la tabla EMP.
DESC scott.emp;
SELECT * FROM scott.emp;

--Obtén la estructura de la tabla DEPT.
DESC scott.dept;
SELECT * FROM scott.dept;

--Mostrar el nombre de todos los departamentos.
SELECT dname FROM scott.dept;

--Mostrar el nombre y salario de todos los empleados.
SELECT ename , sal FROM scott.emp;

--Mostrar el trabajo y número de empleado de todos los empleados.
SELECT job , empno FROM scott.emp;

--Obtén el nombre del presidente de la compañía (PRESIDENT). 
SELECT ename AS presidente FROM scott.emp WHERE job='PRESIDENT';

--Mostrar un listado de los diferentes trabajos que hay (sin repetirlos).
SELECT DISTINCT job FROM scott.emp;

--Mostrar el nombre y el oficio de los empleados del departamento 20.
--Obtén la ciudad donde se encuentra el departamento de ventas (SALES).
--Mostrar el nombre y fecha de contratación de los empleados del departamento 30 que sean vendedores (SALESMAN).
--Muestra los nombres de todos los oficinistas (CLERK) que trabajan en el departamento número 10.
--Obtén  el nombre de los empleados que trabajan como oficinistas, vendedores o analistas (ANALYST) y su salario al menos son 3000$.
--Muestra los nombres de todos los empleados que trabajan como oficinistas y reciben un salario de más de 1500$.
--Mostrar el nombre, fecha de contratación y código de departamento de los empleados que hayan entrado en la empresa después del 2 de octubre de 1981.
--Sacar los empleados van alfabéticamente antes que MARTIN.
--Mostrar las ciudades donde la empresa tiene algún departamento, ordenadas de la Z a la A.
--Mostrar el nombre, trabajo y salario de los empleados del departamento 30. Ordenarlos por trabajo y salario en orden descendente.
--Mostrar el nombre y salario mensual total (es decir, salario mensual más su comisión) de todos los empleados que cobren comisión y el mensual sea más de 1000$.
--Mostrar nombre, salario y salario anual (asume 12 pagas en EE.UU.) de los empleados que pertenezcan al departamento 10. 
SELECT ename, sal , sal*12 FROM scott.emp WHERE deptno=10;

--Modifica el apartado anterior para que la columna se llame "salario_anual".
SELECT ename, sal , sal*12 AS salario_anual FROM scott.emp WHERE deptno=10;

--Obtener el nombre y el trabajo de todos los empleados del departamento 30 que no sean vendedores.
SELECT ename, job FROM scott.emp WHERE deptno=30 AND NOT job='SALESMAN';

--Obtén el nombre y trabajo de los empleados del departamento 10 que no sean ni managers (MANAGER) ni presidentes (PRESIDENT).
SELECT ename, job FROM scott.emp WHERE deptno=30 AND (NOT job='MANAGER' AND NOT job='PRESIDENT');

--Obtén cuál seria el salario anual de los analistas y los vendedores si se les subiera un 20% el sueldo. 
--Muéstralo junto a los nombres de los empleados y el salario anual actual sin modificar. 
--Están ordenador por sueldo.
SELECT ename, sal*12 AS sal_actual , sal*12*1.2 AS sal_nuevo FROM scott.emp WHERE job='ANALYST' OR job='SALESMAN' ORDER BY sal;

--Muestra el nombre y el trabajo de todos los empleados del departamento 30 
--que no sean oficinistas y hayan sido contratados antes de septiembre de 1981. Las columnas se deben llamar "nombre", "puesto" y "fecha_entrada".
SELECT ename, sal*12 AS sal_actual , sal*12*1.2 AS sal_nuevo FROM scott.emp WHERE job='ANALYST' OR job='SALESMAN';

--Mostrar todos los empleados que entraron en la empresa durante el año 1982.
--Mostrar el nombre de los empleados que alfabéticamente estén entre JAMES y SCOTT.
--Mostrar el número de empleado, nombre y fecha de entrada de todos los empleados que no fueron contratados durante 1981. Ordénalos por fecha de entrada.
--Mostrar todos los empleados que no trabajen en el departamento 20 o 30.
--Mostrar nombre, oficio y comisión de todos los empleados del departamento 30 que cobran una comisión.
--Mostrar el nombre y oficio de todos los empleados que tengan una E en su nombre.
--Mostrar el nombre y número de departamento de los empleados cuyo nombre termine en N. Ordénalos por número de departamento.
--Obtén la lista de ciudades donde la empresa tiene una sede y el nombre del departamento que alberga, quitando aquellas que empiecen por B o D.
--Obtén el número, nombre y ciudad de los 2 primeros departamentos al ordenarlos alfabéticamente por su número de departamento.
--Mostrar los empleados cuyo nombre tiene una A y después (aunque haya más letras) una S en su nombre. 
--Modifica el anterior para que el nombre tenga una A y una S, pero dé igual un orden u otro. Es decir, puede aparecer primero una A y después una S o al contrario.
--Mostrar el nombre de aquellas ciudades que tengan un código de departamento superior a 20 y que no alberguen ni el departamento de OPERATIONS ni el de RESEARCH.
--Mostrar un listado del tipo "MARTIN es un SALESMAN y gana 1100$", usando todos los empleados.
--Mostrar los empleados cuyo jefe no sea 7782 o 7839.
--Mostrar el nombre, fecha de contratación y fin del periodo de prueba de los 4 últimos empleados que entraron en la empresa.
--Obtén el nombre, número de empleado y salario de aquel que menos gana de entre los vendedores.
--Mostrar el nombre, número de empleado y salario del empleado que tiene un salario más alto, de entre los que son vendedores y y cobran más de 1300$.


