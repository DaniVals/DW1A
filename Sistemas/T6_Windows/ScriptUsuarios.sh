# Función para dar de alta usuarios
function CrearUsuario {
    param (
        [string]$nombreUsuario,
        [string]$contrasena
    )
    
    # Lógica para crear el usuario (aquí puedes agregar la lógica específica de tu entorno)
    Write-Host "Creando usuario: $nombreUsuario con contraseña: $contrasena"
}

# Bucle principal
do {
    # Solicitar nombre de usuario
    $nombreUsuario = Read-Host "Introduce el nombre de usuario"
    
    # Solicitar contraseña
    $contrasena = Read-Host "Introduce la contraseña" -AsSecureString
    $contrasenaTextoPlano = [System.Runtime.InteropServices.Marshal]::PtrToStringAuto([System.Runtime.InteropServices.Marshal]::SecureStringToBSTR($contrasena))
    
    # Llamar a la función para crear el usuario
    CrearUsuario -nombreUsuario $nombreUsuario -contrasena $contrasenaTextoPlano
    
    # Preguntar si se desea salir o continuar
    $continuar = Read-Host "¿Deseas continuar? (s para salir, cualquier otra tecla para continuar)"
} while ($continuar -ne 's')
