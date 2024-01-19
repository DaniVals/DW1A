SELECT * FROM scott.emp;
SELECT * FROM scott.dept;
--Obtén la estructura de la tabla EMP.
DESC scott.emp;

--Obtén la estructura de la tabla DEPT.
DESC scott.dept;

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
--	Muéstralo junto a los nombres de los empleados y el salario anual actual sin modificar. 
--	Están ordenador por sueldo.
SELECT ename, sal*12 AS sal_actual , sal*12*1.2 AS sal_nuevo FROM scott.emp WHERE job='ANALYST' OR job='SALESMAN' ORDER BY sal;

--Muestra el nombre y el trabajo de todos los empleados del departamento 30 
--	que no sean oficinistas y hayan sido contratados antes de septiembre de 1981. Las columnas se deben llamar "nombre", "puesto" y "fecha_entrada".
SELECT ename, sal*12 AS sal_actual , sal*12*1.2 AS sal_nuevo FROM scott.emp WHERE job='ANALYST' OR job='SALESMAN';

--Mostrar todos los empleados que entraron en la empresa durante el año 1982.
SELECT ename, hiredate FROM scott.emp WHERE hiredate>=DATE '1982-01-01' AND hiredate<=DATE '1982-12-31' ;

--Mostrar el nombre de los empleados que alfabéticamente estén entre JAMES y SCOTT.
SELECT ename FROM scott.emp WHERE ename BETWEEN 'JAMES' AND 'SCOTT';

--Mostrar el número de empleado, nombre y fecha de entrada de todos los empleados que no fueron contratados durante 1981. 
--  Ordénalos por fecha de entrada.
SELECT empno ,ename, hiredate FROM scott.emp WHERE NOT(hiredate BETWEEN DATE '1981-01-01' AND DATE '1981-12-31') ORDER BY hiredate ;

--Mostrar todos los empleados que no trabajen en el departamento 20 o 30.
SELECT ename, deptno FROM scott.emp WHERE deptno!=20 AND deptno!=30;

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


--                      PARTE 2

--Obtén cuántos empleados tiene la empresa.
SELECT COUNT(ename) FROM scott.emp;

--Saca el máximo y mínimo salario de los empleados que sean oficinistas y cobren más de 750$.
SELECT MAX(sal),MIN(sal) FROM scott.emp WHERE job IN ('CLERK') AND 750<sal;

--Muestra cuántos empleados cobran comisión.
SELECT ename,comm FROM scott.emp WHERE 0<comm;

--Saca el número de empleados tiene el departamento 20.
SELECT COUNT(deptno) FROM scott.emp WHERE deptno=20;

--Suma del salario de los empleados cuyo salario es superior a 1800.
SELECT SUM(sal) FROM scott.emp WHERE 1800<sal;

--Muestra el número empleados han entrado en la empresa durante el año 1982.
SELECT COUNT(ename) FROM scott.emp WHERE DATE '1982-01-01'<=hiredate AND hiredate<=DATE '1982-12-31';
SELECT COUNT(ename) FROM scott.emp WHERE EXTRACT(YEAR FROM hiredate)=1982; -- otra forma de hacerlo

--Obtén qué trabajos diferentes hay en el departamento 10.
SELECT DISTINCT job FROM scott.emp WHERE deptno=10;

--Salario medio de los empleados cuyo nombre empiece por J.
SELECT AVG(sal) FROM scott.emp WHERE ename LIKE 'J%';
--Mostrar el nombre y el salario con un incremento del 3.25%. Ten en cuenta que el dólar usa dos dígitos en los centavos para mostrarlo correctamente.
SELECT ename, TRUNC(sal*1.0325,2) FROM scott.emp;

--Mostrar el número de empleado, nombre, oficio y salario de aquellos empleados que, de subirles su sueldo un 10%, su salario estaría entre 1500$ y 2100$. 
--  Mostrar su salario aumentado con dos cifras decimales.
SELECT empno, ename, job, sal, TRUNC(sal*1.1,2) AS sal_aumentado FROM scott.emp WHERE 1500<=sal*1.1 AND sal*1.1<=2100;

--Mostrar para los empleados del departamento 20 un mensaje del tipo 'Allen gana 1800 dólares'. El nombre debe empezar por mayúsculas y seguir en minúsculas.
SELECT initcap(ename)||' gana '||sal||' dolares ' FROM scott.emp WHERE deptno=20;

--Obtén todos los empleados cuyo nombre tenga cinco o más caracteres, siempre y cuando no sea Martin
SELECT initcap(ename) FROM scott.emp WHERE ename LIKE '_____%' AND ename NOT LIKE 'MARTIN';

--Mostrar el nombre, nombre en minúsculas y el nombre con la primera letra en mayúscula y el resto en minúscula de todos los empleados que: entraron a trabajar en 1981 y tienen un A en su trabajo.
SELECT ename,LOWER(ename),initcap(ename) FROM scott.emp WHERE (DATE '1981-01-01'<=hiredate AND hiredate<=DATE '1981-12-31') AND job LIKE 'A%';

--Obtén la media del salario de aquellos empleados cuyo trabajo tenga 7 caracteres, ordénalos por la media.
SELECT AVG(sal) FROM scott.emp WHERE job LIKE '_______%';

--Mostrar el nombre, el nombre rellenado con * por la izquierda hasta una longitud de diez carácter y lo mismo por la derecha. Solo para los empleados del departamento 20.
SELECT ename, LPAD(ename,10,'*'), RPAD(ename,10,'*') FROM scott.emp WHERE deptno=20;



--Obtén la fecha del sistema.
SELECT SYSDATE FROM dual;
--Obtén la fecha y hora del sistema.
SELECT SYSDATE, SYSTIMESTAMP FROM dual;

--Muestra la fecha del próximo miércoles.
--Obtén cuál es la última fecha de este mes.
SELECT LAST_DAY(SYSDATE) FROM dual;

--Mostrar el número de empleado, fecha de contratación y la fecha de cobro de la primera nomina.
--Mostrar cuántos meses y cuantos años llevan los empleados en la compañía.
--Los empleados cobran un plus de 40$ al año por cada trienio (es decir por cada 3 años contratados). Mostrar: el salario, número de trienios, la cuantía del plus y el total que se cobra anualmente.
--Mostrar la fecha en la que los empleados fueron contratados usando el formato normal tipo 31/07/2018.
SELECT TO_CHAR(hiredate,'dd/mm/yyyy') FROM scott.emp;

--Obtén el día de la semana en que cae el último día de este mes.
SELECT TO_CHAR(LAST_DAY(hiredate),'DAY') FROM scott.emp;

--Mostrar los empleados entraron a trabajar un viernes.
SELECT TO_CHAR(hiredate,'DAY') FROM scott.emp WHERE TO_CHAR(hiredate,'DAY')='FRIDAY   ';

--Mostrar el nombre, núm. de departamento y oficio de todos los empleados que entraron a trabajar en un mes con 30 días.
SELECT ename, deptno, job FROM scott.emp WHERE EXTRACT(DAY FROM LAST_DAY(hiredate))=30;
--Obtén la fecha del primer lunes en que trabajaron los empleados del departamento 10.
--Mostrar un informe que muestre el nombre, fecha de entrada, meses que lleva trabajando el empleado y fecha del siguiente viernes a su fecha de entrada.
--Mostrar un listado con el nombre, salario y comisión de los empleados del departamento 30. Si no tienen comisión, poner 0.
--Modifica el ejercicio anterior, si no tienen comisión, poner la cadena de texto "(sin comisión)".
--Para todos los empleados cuyo nombre tiene una A, mostrar un listado con el nombre, comisión y la cadena "Tiene" en el caso de que tenga comisión y "NO tiene" en caso contrario.
--Mostrar una tabla que muestre el nombre del empleado y una columna que, dependiendo de la fecha de contrario del empleado, contenga:
SELECT MONTHS_BETWEEN(SYSDATE, hiredate) FROM scott.emp;
--   Si entró en el 80 → 'ENTRÓ EN EL 80'.
--   Si entró en el 81 → 'ENTRÓ EN EL 81’.
--   Si no → 'MÁS TARDE'.