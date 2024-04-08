-- ################ USAR ESQUEMA SOUTH WIND #####################
--1 Escribe un bloque PL/SQL que tenga una variable con tu nombre, una con tu primer apellido y una con tu fecha de nacimiento. Debe mostrar una frase del tipo "Soy Ana Sanz, nací el 2004-05-01  y tengo 20 años".
DECLARE
    v_name CONSTANT VARCHAR2(16) := 'Daniel';
    v_surname CONSTANT VARCHAR2(16) := 'Vals';
    v_birth_date CONSTANT DATE := DATE '2005-12-15';
BEGIN
    DBMS_OUTPUT.PUT_LINE('Nombre: ' || v_name);
    DBMS_OUTPUT.PUT_LINE('Apellido: ' || v_surname);
    DBMS_OUTPUT.PUT_LINE('Fecha de nacimiento: ' || v_birth_date);
END;



--2 Modifica el programa anterior para que, aparte de mostrar la información, se inserte una fila en la tabla de clientes ("Customers") con tu información.
DECLARE
    v_name CONSTANT VARCHAR2(16) := 'Daniel';
    v_surname CONSTANT VARCHAR2(16) := 'Vals';
    v_birth_date CONSTANT DATE := DATE '2005-12-15';
BEGIN
	INSERT INTO customers(name) VALUES (v_name ||' '||v_surname);
END;



--3 Crea un bloque que busque el producto 224 y guarde en dos variables diferentes el nombre y el precio del producto. Mostrar al usuario la información.
DECLARE
    const_buscado CONSTANT PRODUCTS.PRODUCT_NAME%TYPE := 224;
    v_product_name  PRODUCTS.PRODUCT_NAME%TYPE;
    v_product_price PRODUCTS.LIST_PRICE%TYPE;
BEGIN
    SELECT PRODUCT_NAME, LIST_PRICE INTO v_product_name, v_product_price FROM PRODUCTS WHERE PRODUCT_ID = const_buscado;

END;






--4 Haz lo mismo con el cliente que tiene el ID 254. Muestra su nombre y límite de crédito, pero esta vez define las variables con %TYPE.

--5 Cambia el ejercicio anterior y, en vez de usar 2 variables, usa solo una que utilice %ROWTYPE.

--6 Haz un bloque PL que reciba el nombre de un cliente e imprima el número de pedidos que tiene (tabla "Orders"). Como en PL/SQL no podemos pasar parámetros, el nombre del cliente estará en una constante.

