--Muestra los empleados que cobran más que el empleado que tiene el ID 163.
SELECT * FROM hr.employees WHERE salary > (SELECT salary FROM hr.employees WHERE employee_id = 163);


--Obtén el nombre, salario y fecha de contratación de los empleados que trabajan en el mismo departamento que el empleado que tiene el ID 169.
SELECT first_name,salary,hire_date FROM hr.employees WHERE department_id = (SELECT department_id FROM hr.employees WHERE employee_id = 169);


--Mostrar los empleados cuyo sueldo está por encima de la media salarial de la empresa.
SELECT * FROM hr.employees WHERE salary > (SELECT AVG(salary) FROM hr.employees);


--Saca todos los datos de los empleados que tienen por manager a "Payam".
SELECT * FROM hr.employees WHERE manager_id = (SELECT employee_id FROM hr.employees WHERE first_name LIKE 'Payam%');


--Mostrar los nombres completos y fechas de contratación de los empleados que están en el mismo departamento que clara, excluyendo a Clara.
SELECT FIRST_NAME||' '||LAST_NAME, HIRE_DATE FROM hr.employees WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID FROM hr.employees WHERE first_name LIKE 'Clara%') AND first_name NOT LIKE 'Clara%';


--Indica la información de los empleados que tienen un salario comprendido entre el mínimo salario de la empresa y 2500$.
SELECT * FROM hr.employees WHERE (SELECT MIN(salary) FROM hr.employees) < salary AND salary < 2500;


--Obtener el nombre, salario e ID de departamento de aquellos empleados cuyo salario coincide con alguno de los mínimos salarios de cada departamento.
SELECT FIRST_NAME,SALARY,DEPARTMENT_ID FROM hr.employees WHERE SALARY = ANY (SELECT MIN(salary) FROM hr.employees GROUP BY DEPARTMENT_ID);


--Muestra el ID y nombre completo de todos los empleados que trabajan en departamentos donde hay personas con nombres que contienen una "T".
SELECT employee_id, FIRST_NAME||' '||LAST_NAME, DEPARTMENT_ID FROM hr.employees WHERE DEPARTMENT_ID = ANY (SELECT DEPARTMENT_ID FROM hr.employees WHERE LOWER(first_name) LIKE '%t%');


--Indica el nombre, apellido y salario de todos los empleados que ganan más que la media de la empresa y que trabajan en un departamento donde hay hay personas que tienen una "J" en su apellido.
SELECT FIRST_NAME, LAST_NAME, salary FROM hr.employees WHERE (SELECT AVG(salary) FROM hr.employees)<salary AND DEPARTMENT_ID = ANY (SELECT DEPARTMENT_ID FROM hr.employees WHERE LOWER(last_name) LIKE '%j%');

--Muestra nombre completo de todos los empleados que trabajan el departamento que tiene por nombre "Marketing". 
SELECT FIRST_NAME||' '||LAST_NAME FROM hr.employees WHERE DEPARTMENT_ID = ANY (SELECT DEPARTMENT_ID FROM hr.DEPARTMENTS WHERE DEPARTMENT_name LIKE 'Marketing');

--Saca los datos de los trabajadores que tienen un sueldo menor que lo que gana cualquiera de los programadores (tienen por ID de trabajo el código "IT_PROG").
SELECT * FROM hr.employees WHERE salary < ANY (SELECT AVG(salary) FROM hr.employees WHERE JOB_ID LIKE 'IT_PROG');

--Saca los datos de los trabajadores que tienen un sueldo menor que lo que gana cualquiera de los programadores (tienen por ID de trabajo el código "IT_PROG"). Excluye a los programadores.
SELECT * FROM hr.employees WHERE salary < ANY (SELECT AVG(salary) FROM hr.employees WHERE JOB_ID LIKE 'IT_PROG') AND JOB_ID NOT LIKE 'IT_PROG';

--Muestra los datos de los empleados que tienen un sueldo superior a cualquiera de las medias salariales de cada departamento.
SELECT * FROM hr.employees WHERE salary > ANY (SELECT AVG(salary) FROM hr.employees GROUP BY DEPARTMENT_ID);

--Obtener toda la información de los empleados que trabajan en un departamento donde el manager no tiene un ID comprendido entre 100 y 200.
SELECT * FROM hr.employees WHERE DEPARTMENT_ID = ANY (SELECT DEPARTMENT_ID FROM hr.DEPARTMENTS WHERE manager_id BETWEEN 100 AND 200);

--Sacar los nombres de los departamentos que tienen empleados trabajando en ellos.
SELECT * FROM hr.DEPARTMENTS WHERE DEPARTMENT_ID = ANY (SELECT DEPARTMENT_ID FROM hr.employees);

--16. Indica qué empleados ganan menos que todos los empleados del departamento de Sales.
SELECT * FROM hr.employees WHERE salary < ANY (SELECT AVG(salary) FROM hr.employees WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID FROM hr.departments WHERE DEPARTMENT_NAME LIKE 'Sales'));

--17. Muestra el nombre completo, email (terminado en @compuserv.com) y fecha de entrada en la empresa de todos los empleados que entraron en la empresa después de David Lee (nombre apellido).
SELECT first_name||' '||last_name, email||'@compuserv.com',hire_date FROM hr.employees WHERE hire_date > (SELECT hire_date FROM hr.employees WHERE first_name LIKE 'David' AND last_name LIKE 'Lee');

--18. Saca la información de los empleados que son manager de algún otro empleado, ordenador por nombre.
SELECT * FROM hr.employees WHERE employee_id = ANY (SELECT MANAGER_ID FROM hr.employees);

--19. Obtén una query que muestre el nombre completo de los managers que supervisan a más de 3 empleados.
SELECT * FROM hr.employees WHERE employee_id = ANY (SELECT MANAGER_ID FROM hr.employees GROUP BY MANAGER_ID HAVING 3 < COUNT(MANAGER_ID) );

--20. Muestra el ID de cada departamento junto al dinero que destina a salarios, pero solo en aquellos donde haya al menos un empleado.
SELECT department_id, SUM(salary) FROM hr.employees GROUP BY department_id HAVING 1 < COUNT(employee_id);
SELECT department_id, SUM(salary) FROM hr.employees GROUP BY department_id HAVING department_id = ANY (SELECT department_id FROM hr.employees GROUP BY department_id HAVING 1 < COUNT(employee_id) );

--21. Obtén todos los empleados que trabajan en el departamento que Marketing.

--22. Lista todos los empleados que trabajan en la ciudad de Toronto.

--23. Obtén el sueldo más bajo de los empleados que trabajan en San Francisco. 

--24. Muestra la ciudad en la que trabaja el empleado con ID 134.

--25. Saca los empleados que entraron a trabajar después que cualquiera de los empleados del departamento de Marketing.

--26. Muestra toda la información de aquel empleado que es el segundo que más gana de la empresa.

