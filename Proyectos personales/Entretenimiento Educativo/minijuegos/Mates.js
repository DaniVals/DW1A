let puntuacion;
let dificultad;

function onLoadMates(){
}

function empezarMatesI(){
    dificultad = getCookie("dificultad")
    console.log(dificultad)
}


function sumarMates() {
    setCookie("puntuacionMatematicasI", (1+parseInt(getCookie("puntuacionMatematicasI"))), 30)
    console.log(getCookie("puntuacionMatematicasI"))
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