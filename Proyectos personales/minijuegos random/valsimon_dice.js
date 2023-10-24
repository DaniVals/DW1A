//variables normales
let colorArray = [];
let contadorColor;
let juegoActivo;
let indexManual;
let bucleAcabado = true;
let record = 0;
    
//acortar texto
let colorBotonGrande = document.getElementById("reinicio").style;
let colorBotonRojo = document.getElementById("rojo").style;
let colorBotonAmarillo = document.getElementById("amarillo").style;
let colorBotonVerde = document.getElementById("verde").style;
let colorBotonAzul = document.getElementById("azul").style;
let textoPuntuacion = document.getElementById("puntuacion");
let textoRecord = document.getElementById("record");

//sistema espera
var sleep = function(ms){
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function pressButton(colorPulsado) {
    
    //empezar partida
    if(colorPulsado == 4 && bucleAcabado==true){
        //console.log("empezar partida")
        juegoActivo = true;
        colorArray = [];
        contadorColor = 0;
        colorArray[contadorColor] = Math.floor(Math.random() * 4);
        indexManual=0;
        //bucleAcabado=true;
        //if (record == null){
            console.log(record)
        //}
    }
                            
    //debug
    /*
    console.log("debug zone");
    console.log("el array:"+colorArray);
    console.log("el contador:"+contadorColor);
    console.log("el index manual:"+indexManual);
    console.log("el detector de bucle:"+bucleAcabado);
    console.log("");
    */
   //alert(document.documentElement.clientWidth+" x "+document.documentElement.clientHeight);
    
    if (juegoActivo==true){ //partida activa
        if(bucleAcabado==true){ //esto es para evitar sobrecarga de click
        bucleAcabado=false
            if (indexManual<contadorColor){ //momento pulsar
                if(colorPulsado==colorArray[indexManual]) { //color acertado
                    
                    //cambiar color
                    if(colorPulsado==0){
                        colorBotonRojo.backgroundColor = "rgb(0, 0, 0)";
                    }
                    if(colorPulsado==1){
                        colorBotonAmarillo.backgroundColor = "rgb(0, 0, 0)";
                    }
                    if(colorPulsado==2){
                        colorBotonVerde.backgroundColor = "rgb(0, 0, 0)";
                    }
                    if(colorPulsado==3){
                        colorBotonAzul.backgroundColor = "rgb(0, 0, 0)";
                    }
                    
                    //reiniciar color botones
                    await sleep(50);
                    colorBotonRojo.backgroundColor = "rgb(255, 0, 0)";
                    colorBotonAmarillo.backgroundColor = "rgb(255, 255, 0)";
                    colorBotonVerde.backgroundColor = "rgb(0, 255, 0)";
                    colorBotonAzul.backgroundColor = "rgb(0, 0, 255)";
                    await sleep(50);
                } else { //color fallado

                    //cambiar color botones
                    colorBotonGrande.backgroundColor = "rgb(100, 0, 0)";
                    colorBotonRojo.backgroundColor = "rgb(0, 0, 0)";
                    colorBotonAmarillo.backgroundColor = "rgb(0, 0, 0)";
                    colorBotonVerde.backgroundColor = "rgb(0, 0, 0)";
                    colorBotonAzul.backgroundColor = "rgb(0, 0, 0)";
                    //parar juego
                    juegoActivo=false;
                }
                indexManual++;
            }
            if(!(indexManual<contadorColor)&&juegoActivo==true){ //momento memorizar

                //poner colores en gris
                colorBotonRojo.backgroundColor = "rgb(50, 50, 50)";
                colorBotonAmarillo.backgroundColor = "rgb(50, 50, 50)";
                colorBotonVerde.backgroundColor = "rgb(50, 50, 50)";
                colorBotonAzul.backgroundColor = "rgb(50, 50, 50)";

                //añadir un color mas
                contadorColor++; 
                colorArray[contadorColor] = Math.floor(Math.random() * 4);
                indexManual=0;
                textoPuntuacion.innerHTML = contadorColor;
                if (record<contadorColor){
                    record = contadorColor;
                    textoRecord.innerHTML= record;
                    setCookie("record", record, 30)
                }

                //sucesion de color
                for (i=0; i<contadorColor; i++) {
                    switch(colorArray[i]){ 
                    case 0:
                        colorBotonGrande.backgroundColor = "rgb(255, 0, 0)";
                    break;
                    case 1:
                        colorBotonGrande.backgroundColor = "rgb(255, 255, 0)";
                    break;
                    case 2:
                        colorBotonGrande.backgroundColor = "rgb(0, 255, 0)";
                    break;
                    case 3:
                        colorBotonGrande.backgroundColor = "rgb(0, 0, 255)";
                    break;
                    }
                    await sleep(700);
                        colorBotonGrande.backgroundColor = "rgb(0, 0, 0)";
                    await sleep(100);
                }

                //reiniciar color botones
                colorBotonGrande.backgroundColor = "rgb(50, 50, 50)";
                colorBotonRojo.backgroundColor = "rgb(255, 0, 0)";
                colorBotonAmarillo.backgroundColor = "rgb(255, 255, 0)";
                colorBotonVerde.backgroundColor = "rgb(0, 255, 0)";
                colorBotonAzul.backgroundColor = "rgb(0, 0, 255)";
            }    
        bucleAcabado=true;
        }
    }
}
function loadMain(){
    let textoRecord = document.getElementById("record");
    record = getCookie("record")
    textoRecord.innerHTML= record;
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