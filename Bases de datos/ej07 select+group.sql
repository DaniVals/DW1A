--usar esquema scott

--El sueldo medio de cada departamento.
SELECT deptno, AVG(sal) FROM scott.emp GROUP BY deptno;

--Media salarial por departamento y empleo.
SELECT deptno,job, AVG(sal) FROM scott.emp GROUP BY deptno,job;
--Número de empleados que tiene cada departamento.
SELECT deptno, COUNT(*) FROM scott.emp GROUP BY deptno;
--Salarios máximos y mínimos de cada departamento.
SELECT deptno, MAX(sal), MIN(sal) FROM scott.emp GROUP BY deptno;

--Nómina media de cada departamento. Es decir, contando las comisiones.
SELECT deptno, AVG(sal)+AVG(NVL(comm,0)) FROM scott.emp GROUP BY deptno;

--Menor y mayor comisión de cada uno de los departamentos.
SELECT deptno, MAX(comm),MIN(comm) FROM scott.emp WHERE 0<comm GROUP BY deptno;

--¿Cuántos empleados tiene a su cargo cada empleado?
SELECT mgr, COUNT(deptno) FROM scott.emp WHERE mgr LIKE '%' GROUP BY mgr;

--Cantidad de empleados en los departamentos cuyo nombre contiene una M.
SELECT deptno, COUNT(ename) FROM scott.emp WHERE ename LIKE 'M%' GROUP BY deptno;

--Trabajos diferentes que hay en cada departamento.
SELECT deptno, COUNT(DISTINCT(job)) FROM scott.emp GROUP BY deptno;

--Muestra la media de los salarios y el número de departamento para cada departamento. Pero solo de los empleados que son 'PRESIDENT' o 'MANAGER'.
SELECT AVG(sal), deptno FROM scott.emp WHERE job LIKE 'PRESIDENT' OR job LIKE 'MANAGER' GROUP BY deptno;

--Para cada uno de los trabajos, indicar en cuantos años diferentes ha entrado a trabajar algún empleado.
SELECT TO_CHAR(hiredate,'YEAR'),COUNT(ename) FROM scott.emp GROUP BY job,TO_CHAR(hiredate,'YEAR');

--Para cada uno de los departamentos, indicar cuántos no cobran comisión.
SELECT deptno, COUNT(*) FROM scott.emp WHERE comm IS NULL GROUP BY deptno;

--Para cada departamento, cuántos empleados han entrado a trabajar en un mes par y ganan menos de 3000$.
SELECT deptno, hiredate, sal FROM scott.emp WHERE MOD(EXTRACT(MONTH FROM hiredate),2)=0 AND sal<3000 ORDER BY deptno, sal;

--Para cada uno de lo trabajos que tengan al menos una A, mostrar el numero de empleados que hay por departamento.
SELECT deptno,job, COUNT(*) FROM scott.emp WHERE job LIKE '%A%' GROUP BY deptno,job;

--¿Qué departamentos tienen una media salarial de mayor 2000$?
SELECT deptno, AVG(sal) FROM scott.emp GROUP BY deptno HAVING 2000<AVG(sal);

--Cantidad de empleados en los departamentos 10 y 20 cuyo nombre contiene una M.
SELECT deptno, COUNT(*) FROM scott.emp WHERE (deptno=10 OR deptno=20) AND ename LIKE '%M%' GROUP BY deptno;

--Mostrar el trabajo, máximo salario, mínimo salario de los empleados que han entrado a trabajar en 1981 organizados por trabajo. Solo de aquellos cuya su media salarial sea menor de 2000$.
SELECT job, MAX(sal), MIN(sal) FROM scott.emp WHERE EXTRACT(YEAR FROM hiredate)=1981 GROUP BY job HAVING 2000<AVG(sal);

--De los empleados que entraron a trabajar en 1981, mostrar los trabajos que tengan el salario máximo menor de 1700$.
SELECT job, MAX(sal) FROM scott.emp WHERE EXTRACT(YEAR FROM hiredate)=1981 GROUP BY job HAVING MAX(sal)<1700;

--Para los departamento 20 y 30, mostrar los trabajos que cumplen que el salario menor esta entre 700 y 1200.
SELECT job, MIN(sal) FROM scott.emp WHERE (deptno=30 OR deptno=20) GROUP BY job HAVING MIN(sal)<700 AND MIN(sal)<1200;

--Mostrar la media salarial de por trabajo y departamento, pero solo teniendo en cuenta aquellos empleados que ganen mas de 1200$. Muestra la información para aquellos empleos y departamentos con dos empleados al menos.

SELECT AVG(sal) FROM scott.emp WHERE 1200<sal GROUP BY job, deptno;
--TODO acabar

--De los empleados que entraron en un año impar, mostrar los trabajos que tienen mas de un empleado.
--Mostrar la cantidad de empleados que fueron contratados por año.
--Indicar el sueldo medio por mes de contratación, pero solo de aquellos meses en los que se contratara al menos 2 empleados.
--Realizar un informe de totales y subtotales (es decir, con ROLL UP) con departamento y trabajo, mostrando el número de empleados, mínimo salario y máximo salario.
--Modifica el ejercicio anterior para que, en lugar de aparecer las celdas vacías en los subtotales ("-"), aparezca la cadena "-- Todos --".
--Cada nombre de empleado tiene una longitud diferente. Mostrar, para cada longitud de nombre de los empleados, el salario que es el máximo de entre ellos. En el formato: "De los empleados con un nombre de 5 letras, el salario máximo es 1750$".