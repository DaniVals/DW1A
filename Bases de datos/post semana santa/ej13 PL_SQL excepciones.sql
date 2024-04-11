-- 1 Crea un script para introducir nuevas regiones. El programa tiene dos constantes: un VARCHAR2 para elegir el ID de la nueva región y otra para el nombre.
--   Controla, mediante dos excepciones del sistema (mira la tabla y elige cuáles), que el ID que ha elegido es un número (y no caracteres) y que no está duplicado.
DECLARE
    c_id REGIONS.REGION_ID%TYPE := 69;
    c_nombre REGIONS.REGION_NAME%TYPE := 'La grasa';
BEGIN
	INSERT INTO REGIONS (REGION_ID, REGION_NAME) VALUES (c_id, c_nombre);

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
    	DBMS_OUTPUT.PUT_LINE('Esa ya existe machote');

END;

-- 2 Haz un bloque PL/SQL que reciba el nombre y el apellido de un empleado. El programa informará de si ese empleado aparece como cliente de la empresa o no (tabla "Contacts").
--   Utiliza la excepción predefinida correspondiente para que, en caso de que no se encuentre al empleado, se informe de ello.
DECLARE
    c_nombre Contacts.FIRST_NAME%TYPE := 'Flor';
    c_apellido Contacts.LAST_NAME%TYPE := 'Stone';
	v_select Contacts%ROWTYPE;
BEGIN
    SELECT * INTO v_select FROM Contacts WHERE FIRST_NAME = c_nombre AND LAST_NAME = c_apellido;
    DBMS_OUTPUT.PUT_LINE('Id: '||v_select.CONTACT_ID);
    DBMS_OUTPUT.PUT_LINE('Nombre: '||v_select.FIRST_NAME);
    DBMS_OUTPUT.PUT_LINE('Apellido: '||v_select.LAST_NAME);
    DBMS_OUTPUT.PUT_LINE('Email: '||v_select.EMAIL);
    DBMS_OUTPUT.PUT_LINE('Telefono: '||v_select.PHONE);
    DBMS_OUTPUT.PUT_LINE('Id de cliente: '||v_select.CUSTOMER_ID);

EXCEPTION
    WHEN no_data_found THEN
    	DBMS_OUTPUT.PUT_LINE('No existe el empleado');

END;


-- 3 Modifica el bloque anterior para que:
--   Salte una excepción definida por ti mismo si el nombre o el apellido tienen menos de 2 caracteres o más de 15, informando de ello.
--   Se recoja cualquier otra excepción que pueda haber (mostrando su código).

DECLARE
    c_nombre Contacts.FIRST_NAME%TYPE := 'Flor';
    c_apellido Contacts.LAST_NAME%TYPE := 'Stone';
	v_select Contacts%ROWTYPE;

	nombre_no_valido EXCEPTION;

BEGIN
    
    IF LENGTH(c_nombre)<2 OR 15<LENGTH(c_nombre) THEN
		RAISE nombre_no_valido;
    END IF;

    SELECT * INTO v_select FROM Contacts WHERE FIRST_NAME = c_nombre AND LAST_NAME = c_apellido;
    DBMS_OUTPUT.PUT_LINE('Id: '||v_select.CONTACT_ID);
    DBMS_OUTPUT.PUT_LINE('Nombre: '||v_select.FIRST_NAME);
    DBMS_OUTPUT.PUT_LINE('Apellido: '||v_select.LAST_NAME);
    DBMS_OUTPUT.PUT_LINE('Email: '||v_select.EMAIL);
    DBMS_OUTPUT.PUT_LINE('Telefono: '||v_select.PHONE);
    DBMS_OUTPUT.PUT_LINE('Id de cliente: '||v_select.CUSTOMER_ID);

EXCEPTION
    WHEN no_data_found THEN
    	DBMS_OUTPUT.PUT_LINE('No existe el empleado');
    WHEN nombre_no_valido THEN
    	DBMS_OUTPUT.PUT_LINE('El nombre no tiene una longitud valida (entre 2 y 15 caracteres)');
    WHEN others THEN
    	DBMS_OUTPUT.PUT_LINE('Se encontro otra excepcion ' || SQLCODE);

END;