#!/bin/bash

# Crea un script que determine si existe un fichero y además si es ejecutable.

# archivo existe
if [ -f "$1" ]; then
    echo "El archivo $1 existe."

    # archivo es ejecutable
    if [ -x "$1" ]; then
        echo "El archivo $1 es ejecutable."
    else
        echo "El archivo $1 no es ejecutable."
    fi
else
    echo "El archivo $1 no existe."
fi