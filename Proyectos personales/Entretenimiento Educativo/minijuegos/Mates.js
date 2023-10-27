let puntuacion = 0; //la puntuacion asignada desde la cookie (coge la version de mates en la que estes)
let dificultad; //dificultad elegida asignada desde la cookie
let bugueado; //si ya has desbloqueado el menu bug (cookies)

let partidaActiva=false; //si la partida ha empezado
let tamañoMaximo; //tamaño maximo de la barra de tiempo

let numeroTeclado=0;//numeros introducidos por teclado
let numeroTecladoDecimal=0;
let editarDecimal=false;//si estas editando el decimal

let solucion1;//el numero 1 y 2
let solucion2;
let solucionSuma;//si la pregunta es una suma o una resta
let aciertos; //el numero de aciertos del intento
let PuntuacionGanada; //la puntuacion que se suma a la cookie

function onLoadMates(){
    //asignar cookies
    dificultad = getCookie("dificultad")
    tamañoMaximo = document.getElementById("barraTiempo").width
    bugueado = getCookie("MatematicasIBug")

    switch (dificultad){ //SOLO mostrar la dificultad en la que estas
        
        case "1":
            document.getElementById("mostrarDificultad").innerHTML = "Dificultad: Facil"
        break;
        case "2":
            document.getElementById("mostrarDificultad").innerHTML = "Dificultad: Normal"
        break;
        case "3": 
        document.getElementById("mostrarDificultad").innerHTML = "Dificultad: Dificil"
        break;
    }
    switch (dificultad){
        //Matematicas I
        case "3": 
            if(bugueado==1){ //mostrar el menu bug si ya se ha desbloqueado
                menuBug()
            }
        case "1":
        case "2":
            document.getElementById("mostrarNombre").innerHTML = ("Matematicas I")
            puntuacion = parseInt(getCookie("puntuacionMatematicasI"))
            document.getElementById("mostrarPuntos").innerHTML = "Puntos: "+puntuacion
        break;
    }
}

function pulsarMates(botonPulsado){
    //acortar texto
    let textoTeclado = document.getElementById("MostrarInput");
    let textoAciertos = document.getElementById("mostrarAciertos");
    let sonidoA = document.getElementById("sonidoAcierto");
    let sonidoF = document.getElementById("sonidoFallo");

    if(partidaActiva){
        switch (botonPulsado){
            case "enviar":
                if(bugueado==0&&aciertos==5&&dificultad==3){
                    menuBug()
                    document.getElementById("sonidoFalloBug").play();
                }else{
                    if(solucionSuma){
                        if((numeroTeclado+numeroTecladoDecimal/10)==(solucion1+solucion2)){
                            sonidoA.load()
                            sonidoA.play()
                            aciertos +=1
                        }else{
                            sonidoF.load()
                            sonidoF.play()
                        }
                    }else{
                        if((numeroTeclado+numeroTecladoDecimal/10)==(solucion1-solucion2)){
                            sonidoA.load()
                            sonidoA.play()
                            aciertos +=1
                        }else{
                            sonidoF.load()
                            sonidoF.play()
                        }
                    }
                    numeroNuevo()
                    numeroTecladoDecimal=0;
                    editarDecimal=false;
                }
            break;
            case "signo":
                numeroTeclado = -1*numeroTeclado
                if(numeroTecladoDecimal==0){
                    textoTeclado.innerHTML = numeroTeclado
                }else{
                    textoTeclado.innerHTML = numeroTeclado+"."+numeroTecladoDecimal
                }
            break;
            case "bug":
                if(editarDecimal){
                    editarDecimal=false;
                }else{
                    editarDecimal=true;
                }
                textoTeclado.innerHTML = numeroTeclado+"."+numeroTecladoDecimal
            break;
            default://meter un numero
            if(editarDecimal){
                numeroTecladoDecimal=botonPulsado
                textoTeclado.innerHTML = numeroTeclado+"."+numeroTecladoDecimal
            }else{
                if(numeroTeclado>9){
                    numeroTeclado= numeroTeclado-(10*Math.floor(numeroTeclado/10))
                }
                numeroTeclado = (numeroTeclado*10)+botonPulsado
                textoTeclado.innerHTML = numeroTeclado
            }
                
            break;
        }
    }else{
        switch (dificultad){
            case "1":
                cuentaAtras(50)
            break;
            case "2":
                cuentaAtras(45)
            break;
            case "3":
                cuentaAtras(45)
            break;
        }
        numeroNuevo()
        aciertos = 0;
    }
    textoAciertos.innerHTML = "Aciertos: "+aciertos
}
function numeroNuevo(){
    let textoSolucion = document.getElementById("MostrarSolucion");
    let textoTeclado = document.getElementById("MostrarInput");
    numeroTeclado = 0
    textoTeclado.innerHTML = numeroTeclado

    switch (dificultad){
        case "1":
            solucion1 = Math.floor(Math.random() * 6)
            solucion2 = Math.floor(Math.random() * 6)
            if(0.2<Math.random()){
                solucionSuma = true;
            }else{
                solucionSuma = false;
            }
        break;
        case "2":
            solucion1 = Math.floor(Math.random() * 10)
            solucion2 = Math.floor(Math.random() * 10)
            if(0.5<Math.random()){
                solucionSuma = true;
            }else{
                solucionSuma = false;
            }
        break;
        case "3":
            if(0.6<Math.random()&&aciertos>5||aciertos==5){
                solucion1 = Math.floor(Math.random() * 10)/10
            }else{
                solucion1 = Math.floor(Math.random() * 10)
            }
            if(0.6<Math.random()&&aciertos>5){
                solucion2 = Math.floor(Math.random() * 10)/10
            }else{
                solucion2 = Math.floor(Math.random() * 10)
            }
            
            if(0.5<Math.random()){
                solucionSuma = true;
            }else{
                solucionSuma = false;
            }
        break;
    }
    if(solucionSuma){
        textoSolucion.innerHTML = (solucion1+" + "+solucion2)
    }else{
        textoSolucion.innerHTML = (solucion1+" - "+solucion2)
    }
    
}
async function cuentaAtras(tiempoMaximo){ //tiempo maximo en segundos
    document.getElementById("barraTiempo").width = tamañoMaximo
    partidaActiva = true
    for (i=1000; i>0; i--){
        document.getElementById("barraTiempo").width = (i/1000)*tamañoMaximo
        await sleep(tiempoMaximo)
        if(i==1){
            document.getElementById("MostrarSolucion").innerHTML = "SE ACABO EL TIEMPO"
            await sleep(1000)
            switch (dificultad){
                case "1":
                    PuntuacionGanada = aciertos*0.5
                break;
                case "2":
                    PuntuacionGanada = aciertos*0.8
                break;
                case "3":
                    PuntuacionGanada = aciertos
                break;
            }
            console.log(PuntuacionGanada)
            PuntuacionGanada = Math.floor(PuntuacionGanada)
            puntuacion += PuntuacionGanada
            setCookie("puntuacionMatematicasI", puntuacion, 30)
            document.getElementById("mostrarPuntos").innerHTML = "Puntos: "+puntuacion
            document.getElementById("MostrarSolucion").innerHTML = "Ha ganado "+PuntuacionGanada+" puntos"
            setCookie("jugadoMatematicasI", 1, 30)
            partidaActiva = false
        }
    }    
}
function menuBug(){ //cambiar los botones para añadir el decimal
    let botones6 = document.getElementById("6");
    let botones7 = document.getElementById("7");
    let botones8 = document.getElementById("8");
    let botones9 = document.getElementById("9");
    let botones0 = document.getElementById("0");
    let botonBug = document.getElementById("botonbug");

    botones6.style.width = "12%"
    botones7.style.width = "12%"
    botones8.style.width = "12%"
    botones9.style.width = "12%"
    botones0.style.width = "12%"
    botonBug.style.width = "9.5%"
    botonBug.style.display = ""

    bugueado = setCookie("MatematicasIBug", 1, 30)
}
var sleep = function(ms){
    return new Promise(resolve => setTimeout(resolve, ms));
}
function volverMain(){
    window.location.href="../index.html"
}
function setCookie(cname,cvalue,exdays) { //crear y establecer cookies
    const d = new Date();
    d.setTime(d.getTime() + (exdays*365*24*60*60*1000));
    let expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}
function getCookie(cname) { //leer cookies
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for(let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}