#!/bin/bash

# Crea un script que entre las 19h y las 5h, de las buenas noches, entre las 6 y las 11h, los buenos días, y entre las 12 y las 18h, las buenas tardes.


echo "¿Cuál es tu sistema operativo favorito?"
echo "1. Windows 7"
echo "2. Windows 8"
echo "3. Windows 10"
echo "4. Ubuntu"
echo "5. Fedora"
echo "6. Otros"
echo "#? "

read opcion

case $opcion in
    1) echo "Has seleccionado Windows 7";;
    2) echo "Has seleccionado Windows 8";;
    3) echo "Has seleccionado Windows 10";;
    4) echo "Has seleccionado Ubuntu";;
    5) echo "Has seleccionado Fedora";;
    6) echo "Has seleccionado Otros";;
    *) echo "No has seleccionado nada";;
esac