/**
 *
 *  Questa parte contiene le funzioni associate a GMP
 *
 **/

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

function createMapFunction(altezza, larghezza, nome){

    let xhr = new XMLHttpRequest();

    xhr.open('POST', '/gestoreMappa/creaMappa', true);

    let map = {};

    map.nome = nome;

    console.log(altezza + " " + larghezza);

    map.altezza = altezza.toString();
    map.larghezza = larghezza.toString();

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4 && xhr.status === 200) {

            alert("Creazione avvenuta con successo!");

        }

        if (xhr.readyState === 4 && xhr.status === 302) {



        }

    };

    xhr.send(JSON.stringify(map));
    xhr.close;

}

function drawTheTile(nome, div){

    let xhr = new XMLHttpRequest();

    xhr.open('POST', '/matita/piazzaEntita', true);

    let entita = {};

    entita.nome = nome;
    entita.riga = div.id.split(",")[0].toString();
    entita.colonna = div.id.split(",")[1].toString();

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4 && xhr.status === 200) {



        }

    };

    xhr.send(JSON.stringify(entita));
    xhr.close;

}

function doTheMapSelection(coordinata1, coordinata2){

    let xhr = new XMLHttpRequest();

    xhr.open('POST', '/selezione/selezioneAreaMappa', true);

    let entita = {};

    entita.primaRiga = coordinata1[0].toString();
    entita.primaColonna = coordinata1[1].toString();
    entita.secondaRiga = coordinata2[0].toString();
    entita.secondaColonna = coordinata2[1].toString();

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4 && xhr.status === 200) {



        }

    };

    xhr.send(JSON.stringify(entita));
    xhr.close;

}

function getMapFromTheSession(){

    let xhr = new XMLHttpRequest();

    xhr.open('POST', '/gestoreMappa/recuperaMappa', true);

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4 && xhr.status === 200) {

            let map = JSON.parse(xhr.responseText);

            console.log(map);

            $("#griglia").empty();

            map.mappa.forEach(function (mapDiv){

                drawFromAsyncCall(mapDiv);

            });

            console.log(map.mappa[map.mappa.length - 1].colonna);

            createStyle(parseInt(map.mappa[map.mappa.length - 1].colonna) + 1, "32px");

        }

    };

    xhr.send();
    xhr.close;

}

/**
 *
 *  Questa parte contiene le funzioni associate a GMP e all'AI
 *
 **/

function generativeFillCalls(){

    let xhr = new XMLHttpRequest();

    xhr.open('POST', '/IA/genera', true);

    //TO-DO

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4 && xhr.status === 200) {

            getMapFromTheSession()

        }

    };

    xhr.send();
    xhr.close;

}

/**
 *
 *  Questa sezione contiene le funzioni inerenti al GMP.GCR
 *
 **/

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

    xhr.open('POST', '/matita/visualizzaListaEntitaInCartella', true);

    let richiesta = {};
    let nome = document.getElementById("nome");

    richiesta.nome = nome.value;

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4) {

            if (xhr.status === 200){

                $("#show").empty();

                let x = JSON.parse(xhr.responseText);

                x.blobImmagini.forEach(function (immagine) {

                    let id = Object.keys(immagine)[0];
                    let src = "data:image;base64," + immagine[id];

                    $("#show").append(
                        '<img id="' + id + '" src="' + src + '" style ="width: 64px; height: 64px;" class="imgEntity">');

                });

                $(".imgEntity").click(function (){

                    $(".imgEntity").removeClass("selected")

                    $(this).addClass("selected");

                    $(this).css("border", "solid 1px #516f96");

                });

            }

        }

    };

    xhr.send(JSON.stringify(richiesta));
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

    xhr.open('POST', '/gestoreEventi/creaEvento', true);

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

function showListEventi(){
    let xhr = new XMLHttpRequest();

    xhr.open('GET','/gestoreEventi/trovaEventi',true);

    xhr.onreadystatechange=function (){
        if(xhr.readyState === 4){
            if(xhr.status === 200){
                $("#show").empty();

                let x = JSON.parse(xhr.responseText);
                console.log(x);

                x.nomiEventi.forEach(function (evento){
                    $("#show").append(
                        '<label>' + nome +'</label>');
                });
            }
            if(xhr.status === 500){
                alert("errore");
            }
        }
    }
    xhr.send();
    xhr.close;
}

function singleEvent(){
    let xhr = new XMLHttpRequest();
    let nomeEvento = document.getElementById("nomeEvento").value;

    xhr.open('POST', '/gestoreEventi/visualizzaAnteprima', true);

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4) {

            if (xhr.status === 200) {

                alert("nome preso con successo!")

            }

            if (xhr.status === 500) {

            }

        }

    };

    xhr.send();
    xhr.close;

}

/**
*
* FUNZIONI ASINCRONE ENTITÀ
*
* */

function creaEntità() {

    let xhr = new XMLHttpRequest();

    let entità = getEntità();

    xhr.open('POST', '/gestoreEntita/creaEntità', true);

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4 && xhr.status === 200) {

            alert("entità creato con successo");
            //saveImages();

        }

        if (xhr.readyState === 4 && xhr.status === 500) {

            erroreCreaEntità();

        }

    };

    xhr.send(entità);
    xhr.close;

}

function getEntità(){

    let entitàText = {};

    entitàText.nomeImmagine =  document.getElementById("nomeImmagine").value;
    entitàText.nome = document.getElementById("nome").value;
    entitàText.collisioni =  document.getElementsByClassName("selezionato")[0].value;
    entitàText.nomeCartella = document.getElementById("nomeCartella").value;

    let proprietà = [];

    let nomi = document.getElementsByClassName("NomeProprietà");
    let valori = document.getElementsByClassName("ValoreProprietà");

    for (let i = 0; i < nomi.length; i++){

        let elemento = {};

        elemento.nomeProprieta = nomi[i].value;
        elemento.valoreProprieta = valori[i].value;

        proprietà.push(elemento);

    }

    entitàText.proprieta = proprietà;

    return JSON.stringify(entitàText);

}

function showEntita(){
    let xhr= new XMLHttpRequest();

    xhr.open('POST', '/gestoreEntita/visualizzaListaEntità', true);

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4) {

            if (xhr.status === 200) {

                $("#show1").empty();

                let x = JSON.parse(xhr.responseText);
                console.log(x);

                x.blobImmagini.forEach(function (entita){

                    let nome = Object.keys(entita)[0];
                    let src = "data:image;base64," + entita[nome];

                    let entitaWrapper = document.createElement('div');
                    entitaWrapper.classList.add('imageContainer');

                    entitaWrapper.innerHTML = '<div class="overlay" onclick="submitForm(\'' + nome + '\')">' +
                        '<img id="' + nome + '" src="' + src + '" style="width: 64px; height: 64px;" class="imgEntity">' +
                        '</div>';

                    $("#show1").append(entitaWrapper);
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

function submitForm(nomeImmagine) {
    $('#nomeIns').val(nomeImmagine);
}

function saveImages() {

    let xhr = new XMLHttpRequest();
    let formDataImmagine = new FormData(document.getElementById("file"));

    xhr.open('POST', '/gestoreImmagini/caricaImmagine', true);

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                showImmagini();
            } else {

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

    xhr.open('POST', '/gestoreAccessi/login', true);

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4) {

            if (xhr.status === 200) {

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

    xhr.open('POST', '/gestoreAccessi/signup', true);

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4) {

            if (xhr.status === 200) {

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

    xhr.open('POST', '/gestoreAccessi/logout', true);

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4) {

            if (xhr.status === 200) {

                window.location.reload();

            }

        }

    };

    xhr.send();
    xhr.close;

}

function showImmagini(){

    let xhr = new XMLHttpRequest();

    xhr.open('GET', '/gestoreImmagini/visualizzaListaImmagini', true);

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4) {

            if (xhr.status === 200) {

                $("#show").empty();

                let x = JSON.parse(xhr.responseText);

                x.blobImmagini.forEach(function (immagine) {

                    let id = Object.keys(immagine)[0];
                    let src = "data:image;base64," + immagine[id];

                    $("#show").append(
                        '<img id="' + id + '" src="' + src + '" style ="width: 64px; height: 64px;" class="imgEntity">');

                });

                $(".imgEntity").click(function (){

                    $("#nomeImmagine").val($(this).attr("id"));

                    $(".imgEntity").css("border", "none");

                    $(this).css("border", "solid 1px #516f96");

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

function getImageName() {

}
