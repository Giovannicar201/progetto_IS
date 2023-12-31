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

    xhr.open('POST', '/griglia/creacartella', true);

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4 && xhr.status === 200) {

            console.log("ciao");

        }

    };

    xhr.onerror = function() {

        console.log('Si è verificato un errore durante la richiesta.');

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

/*
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

    };

    xhr.onerror = function() {

        console.log('Si è verificato un errore durante la richiesta.');

    };

    xhr.send(entità);
    xhr.close;

}

function getEntità(){

    let entitàText = {};

    entitàText.nome =  document.getElementById("nome").value;
    entitàText.nomeEntità = document.getElementById("entità").value;
    entitàText.collisioni =  document.getElementsByClassName("selezionato")[0].value;
    entitàText.nomeCartella = document.getElementById("nomeCartella").value;

    return JSON.stringify(entitàText);

}