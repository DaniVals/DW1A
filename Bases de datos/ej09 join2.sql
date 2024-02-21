--1 Para los empleados, obtener la cantidad de correos electrónicos diferentes que hay, pero solo aquellos que tengan una comisión asignada.
--2 Para cada departamento: mostrar su nombre, la cantidad de empleados que tiene y la cantidad total que destina a pagar los sueldos. 
--3 Mostrar la cantidad de empleados que todavía no están asignados a un departamento. Muestra también la suma de sus salarios.
--4 Para cada identificador de trabajo (job_id), mostrar la cantidad de empleados que lo desempeñan, el salario del empleado que más gana en el puesto y el salario del que menos. 
--5 Obtén qué nombres de los empleados están repetidos.
--6 Para cada nombre de trabajo (job_title), mostrar la cantidad de empleados que lo desempeñan, el salario del empleado que más gana en el puesto y el salario del que menos. Solo para aquellos trabajos que tengan más de 3 empleados.
--7 Mostrar el apellido del empleado y nombre completo de su puesto de trabajo para todos los empleados que están en el departamento 30 y 60.
--8 Mostrar la cantidad de empleados y el salario medio de los distintos tipos de oficinistas que hay (puedes ver los diferentes tipos de oficinistas que hay en job_id o job_title).
--9 Mostrar el número de sedes que la empresa tiene en cada país.
--10 Mostrar los países en los que la empresa no tiene departamentos.


--11 La tabla de historial de trabajos contiene información sobre los trabajos que han desempeñado los empleados anteriormente en otros puestos de la compañía, en caso de que hubiera alguno. Obtén, el nombre y apellido de los empleados que han tenido algún otro puesto anteriormente (sin repetirlos), ordenados por su apellido.
SELECT DISTINCT e.FIRST_NAME, e.last_name FROM hr.employees e JOIN hr.job_history h ON e.EMPLOYEE_ID = h.EMPLOYEE_ID ORDER BY e.last_name;

--12 Obtén la cantidad de trabajos que han desempeñado previamente todos los empleados de la compañía, indicando sus nombres y apellidos.
SELECT e.FIRST_NAME, e.last_name,COUNT(h.job_id) FROM hr.employees e LEFT JOIN hr.job_history h ON e.EMPLOYEE_ID = h.EMPLOYEE_ID GROUP BY e.FIRST_NAME,e.last_name;

--13 Mostrar aquellos empleos (por su denominación completa) cuya media salarial está entre los 3000$ y 5000$.
SELECT AVG(e.salary),job_title FROM hr.employees e LEFT JOIN hr.jobs j ON e.job_id = j.job_id GROUP BY j.job_title HAVING AVG(e.salary) BETWEEN 3000 AND 5000;

--14 Indicar, cuál es el sueldo anual medio de los empleados en función de su manager, siempre y cuando ganen más de 100.000$ al año.
--15 Averiguar el número de empleados que hay por código de departamento y código de puesto de trabajo. Hay que tener en cuenta que es posible que hay empleados que no estén asignados a un departamento.
--16 Mostrar toda la información de los 3 empleados que más ganan de entre los que tienen como manager a Nancy Greenberg.
--17 Ver el sueldo más alto que tienen los subordinados de cada manager.
--18 Mostrar aquellos empleados que fueron contratados antes que sus jefes, indica el número de meses de diferencia entre que se contrataron ambos.
--19 Mostrar el sueldo medio de los empleados en función del mes en que fueron contratados, para aquellos meses que empiezan por J.
--20 Contar el número de meses diferentes en los que se ha contratado al menos un empleado.
--21 Mostrar el nombre y apellido de los empleados que trabajan en Seattle.
--22 Sacar el salario medio y número de empleados que hay trabajando en cada ciudad.
--23 Obtener, para los departamentos que están en Reino Unido (su identificador de país es UK), el nombre del departamento y el nombre del manager (en formato Apellido, Nombre).
--24 Sacar el nombre, ciudad, país y región donde está cada departamento.
--25 Mostrar la dirección completa (calle, código postal y ciudad) de las sedes donde se haya contratado a algún empleado durante el año 2003.