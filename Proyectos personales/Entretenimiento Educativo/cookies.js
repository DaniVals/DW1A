let username;
let activeDialogue;
let puntuacionMatematicasI;
let variableCero = 0;
let dificultad;

function skipNextDialogue(opcion){ //saltar el dialogo
    //acortar texto textbox
    let h1 = document.getElementById("h1MainBox");
    let h2 = document.getElementById("h2MainBox");
    let h3 = document.getElementById("h3MainBox");
    let h4 = document.getElementById("h4MainBox");
    let h5 = document.getElementById("h5MainBox");
    let h6 = document.getElementById("h6MainBox");
    
    let p1 = document.getElementById("p1MainBox");
    let p2 = document.getElementById("p2MainBox");
    let p3 = document.getElementById("p3MainBox");
    let p4 = document.getElementById("p4MainBox");
    let p5 = document.getElementById("p5MainBox");
    
    p5.style.color = "#000000";
    
    //acortar texto opciones y "escoderlos"
    let skipButton = document.getElementById("skipDialogue");
    let button1 = document.getElementById("opcion1");
    let button2 = document.getElementById("opcion2");
    let button3 = document.getElementById("opcion3");
    let button4 = document.getElementById("opcion4");
    let button5 = document.getElementById("opcion5");
    skipButton.innerHTML = "";
    button1.innerHTML = "";
    button2.innerHTML = "";
    button3.innerHTML = "";
    button4.innerHTML = "";
    button5.innerHTML = "";

    
    switch(activeDialogue){

        //introduccion, seleccionar nombre y desbloquear mates 1
        case "PrimeraVez01":
            //texto
            h1.innerHTML =  "Hola internauta"
            p1.innerHTML =  "Bienvenido a Entretenimiento Educativo, yo soy MarIA una inteligencia"+
                            " artifcial la cual te ayudara en tu travesia por el aprendizaje digital a traves de esta pagina web."
            p2.innerHTML =  "Pulsa Siguiente para continuar"
            //opciones
            skipButton.innerHTML = "Siguiente";
            activeDialogue = "PrimeraVez02"
        break; 
        case "PrimeraVez02":
            //texto
            h1.innerHTML =  "Hola internauta"
            p1.innerHTML =  "En esta pagina podras encontrar una gran cantidad de minijuegos, "+
                            "que generare de forma aleatoria dependiendo de la dificultad que elijas."
            p2.innerHTML =  "Asegurate de completar todas las dificultades para desbloquear nuevas dificultades y minijuegos."
            //opciones
            skipButton.innerHTML = "Siguiente";
            activeDialogue = "PrimeraVez03"
        break; 
        case "PrimeraVez03":
            //texto
            h1.innerHTML =  "Hola internauta"
            p1.innerHTML =  "Ahora vamos a elejir tu nombre de usuario, cuando pulses 'Elegir nombre', "+
                            "te saldra un panel en el que podras escribir, en este deberas escribir tu nombre de usuario."
            p2.innerHTML =  "Ten en cuenta que no podras modificar tu nombre de usuario una vez elejido, "+
                            "asi que presta atencion y elije con cuidado"
            //opciones
            skipButton.innerHTML = "Escribir nombre";
            activeDialogue = "PrimeraVez04"
        break;
        case "PrimeraVez04":
            //variables
            username =  prompt("ERROR: panel_no_valido")
            setCookie("username", username, 30)
            puntuacionMatematicasI = 0
            setCookie("puntuacionMatematicasI", puntuacionMatematicasI, 30)
            mostrarStats("puntuacionMatematicasI")
            
            //texto
            h1.innerHTML =  "Hola internauta"
            p1.innerHTML =  "Y con esto ya hemos terminado :D , que nombre tan bonito "+ username +
                            ", como puedes ver a tu izquierda, ahi se muestra tu nombre, ese es el panel de las estadisticas."
            p2.innerHTML =  "Este se ira rellenando segun las diferentes actividades que vayas desbloqueando, por ahora te dare acceso a "+
                            "las matematicas I, para empezar un minijuego, deberas seleccionarlo en la izquierda"
            //opciones
            activeDialogue = "Default"
        break;

        //minijuego Mates
        case "MatesI":
            if (opcion==null){
                //texto
                h1.innerHTML =  "Matematicas I"
                p1.innerHTML =  "Este minijuego consiste en sumar y restar, te saldra un panel en el que tendras que escribir "+
                                "la solucion correcta y luego pulsar el boton verde dentro del tiempo establecido."
                p2.innerHTML =  "Dependiendo de la dificultad elegida se establecera la dificultad de las preguntas "+
                                "y la cantidad de puntos ganados por respuesta correcta al acabarse el tiempo"
                //opciones
                button1.innerHTML = "Facil";
                button2.innerHTML = "Normal";
                button3.innerHTML = "Dificil";
            }else{
                
                //texto
                h1.innerHTML =  "Matematicas I"
                p1.innerHTML =  "Cargando modo facil..."
                p2.innerHTML =  ""
                if (opcion==1){
                    p5.style.color = "#0000ff";
                    p5.innerHTML =  "debil..."
                }
                //variables y codigo
                dificultad = opcion;
                setCookie("dificultad", dificultad, 30);
                window.location.href="minijuegos/Mates.html"
                //abrir pestaña distinta
                //window.open("minijuegosmatematicas/MatesI.html")
            }
        break;

        //caso por defecto, si no se ha hecho ningun progreso importante, para dar pistas o lore
        case "Default":
            h1.innerHTML =  "Hola de nuevo"
            if (puntuacionMatematicasI<=0) { 
                p1.innerHTML =  "Veo que todavia no has probado las Matematicas I "+ username + 
                                ", deberias ir a probarlas, seguro que son mas divertidas de lo que crees"
                p2.innerHTML =  "Para acceder a un minijuego, deberas hacer click sobre el en el panel izquierdo "
            }
            if (puntuacionMatematicasI>1) { 
                p1.innerHTML =  "¿Que te ha parecido Matematicas I "+ username+"?"
            }
        break;
    }
    setCookie("activeDialogue", activeDialogue, 30);
}

function seleccionarMinijuego(juegoSelect){
    switch (juegoSelect) {
        case "MatematicasI":                      
                activeDialogue="MatesI"
        break;
        case "Default":                      
                activeDialogue="Default"
        break;
    }
    skipNextDialogue();
}

function onLoadMain(){
    //acortar texto
    let textoNombre = document.getElementById("mostrarNombre");

    //cojer cookies
    username = getCookie("username");
    activeDialogue = "Default";
    puntuacionMatematicasI = getCookie("puntuacionMatematicasI")
    
    console.log("cargar pagina");
    console.log(puntuacionMatematicasI)
    console.log(activeDialogue)

    //mostrar stats 
    mostrarStats()

    //texto al entrar
    if(username == "" || username == null){ //detecte si falta nombre de usuario (si es la primera vez que entra en la pagina) y carga el dialogo
        activeDialogue="PrimeraVez01";  //cargar el dialogo de la primera vez al entrar el la pagina
        puntuacionMatematicasI = -1;    //establecer variables iniciales
        setCookie("puntuacionMatematicasI", puntuacionMatematicasI, 30)
    }else{ 
        if (puntuacionMatematicasI<=0) { //detecta si se han completado suficientes ejercicios matematicos
            
        }else{
            activeDialogue="Default"
        }
    }
    skipNextDialogue();
}

function mostrarStats(stat){
    //acortar texto panel izquierdo
    let textoNombre = document.getElementById("mostrarNombre");
    let textoMatesI = document.getElementById("mostrarMatesI");

    username = getCookie("username");
    puntuacionMatematicasI = getCookie("puntuacionMatematicasI")

    if (username != null){
        textoNombre.innerHTML = ("Hola "+ username)
    }
    if (puntuacionMatematicasI <= 0){
        textoMatesI.innerHTML = ("Matematicas I: "+ puntuacionMatematicasI)
    }
}

function resetCookie(){ //reiniciar cookies de forma manual
    console.log("reseteando cookies")
    setCookie("username", null, 0)
    setCookie("puntuacionMatematicasI", -1, 30)
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