let puntuacion;
let dificultad;
let partidaActiva=false;
let tamañoMaximo;
let numeroTeclado;
let solucion1;
let solucion2;
let solucionSuma;
let aciertos;
let bugueado;

function onLoadMates(){
    let textoNombre = document.getElementById("mostrarNombre");
    let textoPuntos = document.getElementById("mostrarPuntos");
    dificultad = getCookie("dificultad")
    tamañoMaximo = document.getElementById("barraTiempo").width
    bugueado = getCookie("MatematicasIBug")
    if(bugueado){

    }

    switch (dificultad){
        case "1":
        case "2":
        case "3":
            textoNombre.innerHTML = ("Matematicas I")
            puntuacion = getCookie("puntuacionMatematicasI")
            textoPuntos.innerHTML = "Puntos: "+puntuacion
        break;
    }
}

function empezarMatesI(botonPulsado){
    let textoTeclado = document.getElementById("MostrarInput");
    let textoAciertos = document.getElementById("mostrarAciertos");
    let sonidoA = document.getElementById("sonidoAcierto");
    let sonidoF = document.getElementById("sonidoFallo");
    menuBug()

    if(partidaActiva){
        switch (botonPulsado){
            case "enviar":
                if(solucionSuma){
                    if(numeroTeclado==(solucion1+solucion2)){
                        sonidoA.load();
                        sonidoA.play();
                        aciertos +=1;
                        numeroNuevo()
                    }else{
                        sonidoF.load();
                        sonidoF.play();
                        numeroNuevo()
                    }
                }else{
                    if(numeroTeclado==(solucion1-solucion2)){
                        sonidoA.load();
                        sonidoA.play();
                        aciertos +=1;
                        numeroNuevo()
                    }else{
                        sonidoF.load();
                        sonidoF.play();
                        numeroNuevo()
                    }
                }
            break;
            case "signo":
                console.log("orrar fxdd")
                if(numeroTeclado==0){
                    numeroTeclado=1
                }
                numeroTeclado = -1*numeroTeclado
                textoTeclado.innerHTML = numeroTeclado
            break;
            default:
                if(numeroTeclado>9){
                    numeroTeclado= numeroTeclado-(10*Math.floor(numeroTeclado/10))
                }
                numeroTeclado = (numeroTeclado*10)+botonPulsado
                textoTeclado.innerHTML = numeroTeclado
            break;
        }
    }else{
        switch (dificultad){
            case "1":
                cuentaAtras(50)
            break;
            case "2":
                cuentaAtras(40)
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
            if(0.7<Math.random()&&aciertos>5||aciertos==5){
                solucion1 = Math.floor(Math.random() * 10)/10
                solucion2 = Math.floor(Math.random() * 10)/10
            }else{
                solucion1 = Math.floor(Math.random() * 10)
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
    }
    partidaActiva = false

}
function menuBug(){
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

}
var sleep = function(ms){
    return new Promise(resolve => setTimeout(resolve, ms));
}
function sumarMates() {
    setCookie("puntuacionMatematicasI", (1+parseInt(getCookie("puntuacionMatematicasI"))), 30)
    console.log(getCookie("puntuacionMatematicasI"))
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