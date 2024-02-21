#!/bin/bash

if [ "$USER" == "root" ]; then
    echo "El usuario actual es root."
else
    echo "El usuario actual es $USER"
fi