#!/bin/bash

# Crea un script que muestre por pantalla si el usuario que lo está ejecutando es el root o es otro usuario.


if [ "$USER" == "root" ]; then
    echo "El usuario actual es root."
else
    echo "El usuario actual es $USER"
fi