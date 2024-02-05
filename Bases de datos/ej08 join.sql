--1. Mostrar el nombre de los empleados y el nombre del departamento al que pertenecen.
SELECT e.ename,d.dname FROM scott.emp e JOIN scott.dept d ON e.deptno = d.deptno;

--2. Obtén el nombre de los empleados junto a sus jefes, tanto si tienen como si no.
SELECT e.ename AS empleado ,d.ename AS manager FROM scott.emp e LEFT JOIN scott.emp d ON e.mgr = d.empno;

--3. Mostrar el nombre y salario de todos los empleados que trabajan en Chicago.
SELECT e.ename,e.sal FROM scott.emp e JOIN scott.dept d ON e.deptno = d.deptno WHERE d.loc LIKE 'CHICAGO';

--4. Obtén el nombre de los empleados y la ciudad donde trabajan, siempre y cuando el nombre de la ciudad tenga una "A".
SELECT e.ename,d.loc FROM scott.emp e JOIN scott.dept d ON e.deptno = d.deptno WHERE d.loc LIKE '%A%';

--5. Sacar cuántos empleados trabajan en cada ciudad, ordenados por cantidad.
SELECT COUNT(e.ename),d.loc FROM scott.emp e RIGHT JOIN scott.dept d ON e.deptno = d.deptno GROUP BY d.loc;

--6. Mostrar nombre, trabajo y nombre de departamento en que trabajan los empleados que ganan un salario entre 1500$ y 2000$.
SELECT e.ename,e.job,d.dname FROM scott.emp e JOIN scott.dept d ON e.deptno = d.deptno WHERE 1500<=e.sal AND e.sal<=2000;

--7. Obtener los departamentos y cuántos oficinistas trabajan en ellos.
SELECT d.dname,COUNT(e.ename) FROM scott.emp e JOIN scott.dept d ON e.deptno = d.deptno WHERE e.job LIKE 'CLERK' GROUP BY d.dname;

--8. Mostrar en qué ciudades trabajan más de tres empleados.
SELECT d.dname,COUNT(e.ename) FROM scott.emp e RIGHT JOIN scott.dept d ON e.deptno = d.deptno GROUP BY d.dname HAVING 3<COUNT(e.ename);

--9. Sacar, para cada nombre de departamento, cuántos managers y analistas hay (de manera diferenciada).
SELECT d.dname,e.job,COUNT(e.ename) FROM scott.emp e JOIN scott.dept d ON e.deptno = d.deptno GROUP BY d.dname,e.job HAVING e.job LIKE 'MANAGER' OR e.job LIKE 'ANALYST';

--10. Mostrar los nombres (sin repetir) de los empleados que tienen personal a su cargo.
SELECT DISTINCT d.ename FROM scott.emp e JOIN scott.emp d ON e.mgr = d.empno;

--11. Obtener qué empleados ganan más que su jefe.
SELECT e.ename AS empleado ,d.ename AS manager FROM scott.emp e LEFT JOIN scott.emp d ON e.mgr = d.empno WHERE e.sal>d.sal;

--12. Mostrar los nombres (sin repetir) de los empleados que tienen personal a su cargo, junto al número de subordinados
SELECT d.ename AS manager ,COUNT(e.ename) AS empleados FROM scott.emp e JOIN scott.emp d ON e.mgr = d.empno GROUP BY d.ename;

--13. Sacar los nombres (sin repetir) de los empleados que NO tienen personal a su cargo.
SELECT d.ename FROM scott.emp e RIGHT JOIN scott.emp d ON e.mgr = d.empno WHERE e.ename IS NULL;

--14. Obtener el nombre de cada empleado junto al nombre de su jefe (y la frase "No tiene", en caso de que no tenga).
SELECT d.ename,NVL(e.ename, 'No tiene') FROM scott.emp e RIGHT JOIN scott.emp d ON e.mgr = d.empno;

--15. Mostrar el nombre del departamento y el número de empleados que tiene. Si no tiene empleados se debe mostrar cero.
--16. 13. Obtener la media salarial en base a las ciudades donde opera la compañía, siempre y cuando el salario del empleado que más gana en ellas no exceda los 3000$.
--17. Sacar los nombres de los departamentos con el numero de empleados que tienen comisión.
--18. Sacar el nombre de los managers que son supervisores de algún oficinista.
--19. Obtener qué empleados entraron a trabajar en el mismo mes que su jefe.
--20. Obtener el nombre de los empleados que cobrarían más que su jefe en caso de que se les subiera el sueldo un 10%, el nombre del jefe y la diferencia salarial que habría.



