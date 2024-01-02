function getimg(formato) {

    combine(formato);

}

async function download(url, formato) {

    const a = document.createElement("a");

    a.href = url.toDataURL();
    a.download = "grid." + formato;

    document.body.appendChild(a);

    a.click();

    document.body.removeChild(a);

}

function combine(formato){

    html2canvas(document.querySelector("#griglia")).then(canvas => {

        document.getElementById("result").append(canvas);

        download(canvas, formato);

        document.getElementById("result").removeChild(canvas);

    });

}

function creaLaCartella(){

    let xhr = new XMLHttpRequest();

    xhr.open('POST', '/gestoreCartelle/creaCartella', true);

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4 && xhr.status === 200) {

            alert("Cartella creata con successo!");
            showCartelle();

        }

        if (xhr.readyState === 4 && xhr.status === 500) {



        }

    };

    xhr.send(document.getElementById("nome").value);
    xhr.close;

}

function showCartelle(){

    let xhr = new XMLHttpRequest();

    xhr.open('GET', '/gestoreCartelle/visualizzaListaCartelle', true);

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4) {

            if (xhr.status === 200){

                $("#show").empty();

                let x = JSON.parse(xhr.responseText);

                x.nomiCartelle.forEach(function (nome){

                    $("#show").append(

                        '<label>' + nome +'</label>');

                });

            }

            if (xhr.status === 500) {

                alert("errore");

            }

        }

    };

    xhr.send();
    xhr.close;

}

function getCartellaContent(){

    let xhr = new XMLHttpRequest();

    xhr.open('GET', '/griglia/trovaCartelle', true);

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4) {

            if (xhr.status === 200){



            }

            if (xhr.status === 500) {



            }

        }

    };

    xhr.send();
    xhr.close;

}

/*
*
* FUNZIONI ASINCRONE EVENTO
*
* */

function creaEvento() {

    let xhr = new XMLHttpRequest();

    let eventoJSON = {
        "nome": document.getElementById("evento").value,
        "riga": document.getElementById("riga").value,
        "colonna": document.getElementById("colonna").value,
        "istruzioni" : getIstruzioni()
    };

    xhr.open('POST', '/eventi/creaEvento', true);

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4 && xhr.status === 200) {

            alert("evento creato con successo");

        }

    };

    xhr.onerror = function() {

        console.log('Si è verificato un errore durante la richiesta.');

    };

    console.log(eventoJSON);
    xhr.send(JSON.stringify(eventoJSON));
    xhr.close;
    
}

function getIstruzioni(){

    let istruzioniDiv = document.getElementsByClassName("istruzione");
    let istruzioni = [];

    for (let istruzioniDivElement of istruzioniDiv) {

        let objIstruzione = gestisciIstruzione(istruzioniDivElement);

        istruzioni.push({"istruzione" : objIstruzione});

    }

    return istruzioni;

}

function gestisciIstruzione(istruzioneElement){

    let obj = {};

    if(istruzioneElement.classList.contains("dialogo")){

        obj.nome = "dialogo";
        obj.valore = istruzioneElement.value;

    } else if(istruzioneElement.classList.contains("inizio")){

        obj.nome = "inizio";
        obj.valore = istruzioneElement.value;

    }else if(istruzioneElement.classList.contains("fine")){

        obj.nome = "fine";
        obj.valore = istruzioneElement.value;

    }else if(istruzioneElement.classList.contains("testo")){

        obj.nome = "testo";
        obj.valore = istruzioneElement.value;

    }

    return obj;

}

/**
*
* FUNZIONI ASINCRONE ENTITÀ
*
* */

function creaEntità() {

    let xhr = new XMLHttpRequest();

    let entità = getEntità();

    xhr.open('POST', '/entità/creaEntità', true);

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4 && xhr.status === 200) {

            alert("entità creato con successo");

        }

        if (xhr.readyState === 4 && xhr.status === 500) {

            erroreCreaEntità();

        }

    };

    xhr.send(entità);
    xhr.close;

    saveImages();

}

function getEntità(){

    let entitàText = {};

    entitàText.nome =  document.getElementById("nome").value;
    entitàText.nomeEntità = document.getElementById("entità").value;
    entitàText.collisioni =  document.getElementsByClassName("selezionato")[0].value;
    entitàText.nomeCartella = document.getElementById("nomeCartella").value;

    return JSON.stringify(entitàText);

}

function saveImages() {

    let xhr = new XMLHttpRequest();
    let formDataImmagine = new FormData(document.getElementById("file"));

    xhr.open('POST', '/caricaImmagine', true);

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                alert("Immagine caricata con successo!");
            } else {
                alert("Errore durante il caricamento dell'immagine.");
            }
        }
    };

    xhr.send(formDataImmagine);
    xhr.close;
}

function login() {

    let xhr = new XMLHttpRequest();
    let email = document.getElementById("emailLogin").value;
    let password = document.getElementById("passwordLogin").value;

    let loginForm = {};

    loginForm.email = email;
    loginForm.password = password;

    xhr.open('POST', '/auth/login', true);

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4) {

            if (xhr.status === 200) {

                alert("login effettuato con successo!");

                window.location.reload();

            }

            if (xhr.status === 500) {

                let messaggio = JSON.parse(xhr.responseText);

                erroreLogin(messaggio.message);

            }

        }

    };

    xhr.send(JSON.stringify(loginForm));
    xhr.close;

}

function signup() {

    let xhr = new XMLHttpRequest();
    let email = document.getElementById("emailRegistrazione").value;
    let nome = document.getElementById("nomeRegistrazione").value;
    let password = document.getElementById("PasswordRegistrazione").value;
    let passwordRipetuta = document.getElementById("RipetiPasswordRegistrazione").value;

    let signupForm = {};

    signupForm.email = email;
    signupForm.nome = nome;
    signupForm.password = password;
    signupForm.passwordRipetuta = passwordRipetuta;

    xhr.open('POST', '/auth/signup', true);

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4) {

            if (xhr.status === 200) {

                alert("sign-up effettuato con successo!");

                window.location.reload();

            }

            if (xhr.status === 500) {

                let messaggio = JSON.parse(xhr.responseText);

                erroreSignup(messaggio.message);

            }

        }

    };

    xhr.send(JSON.stringify(signupForm));
    xhr.close;

}

function logout(){

    let xhr = new XMLHttpRequest();

    xhr.open('POST', '/auth/logout', true);

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4) {

            if (xhr.status === 200) {

               alert("logout effettuato con successo!");

                window.location.reload();

            }

        }

    };

    xhr.send();
    xhr.close;

}
