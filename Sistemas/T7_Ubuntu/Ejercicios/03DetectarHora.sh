#!/bin/bash

# Crea un script que entre las 19h y las 5h, de las buenas noches, entre las 6 y las 11h, los buenos días, y entre las 12 y las 18h, las buenas tardes.


hora_actual=$(date +%H) # cambiar formato a 24h

# Determinar el saludo según la hora del día
if [ $hora_actual -ge 19 -o $hora_actual -lt 5 ]; then
    echo "¡Buenas noches!"
elif [ $hora_actual -ge 6 -a $hora_actual -lt 12 ]; then
    echo "¡Buenos días!"
else
    echo "¡Buenas tardes!"
fi