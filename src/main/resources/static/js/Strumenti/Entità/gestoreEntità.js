function creaGestore(){

    let div = document.getElementById("info");

    document.getElementsByClassName("break")[0].style.height = "100%";
    div.innerHTML = "";

    if (document.getElementById("creaGestore").classList.contains("pressed") === false) {

        if(div.children.length === 0) {

            for (let child of document.getElementById("strumenti").children) {

                child.classList.remove("pressed");

            }

            document.getElementsByClassName("break")[0].style.height = "150%";

        }

        document.getElementById("creaGestore").classList.add("pressed");

        $(div).append('<div class = "titleBar" id="titleBar">'+
            '            <img class="iconTitle" src="https://i.postimg.cc/PxkLPt7x/event.png" id="title">' +
            '            <label for="title">Gestore entità</label>'+
            '</div>'+
            ' <div class="breakDivAction">'+
            '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
            '       Creazione' +
            '   </div>' +
            '<div class="actionDiv">'+
            '                  <label for="nome">Nome immagine:</label>' +
            '                  <input type="text" id="nomeImmagine" class="inputForm">' +
            '              </div>'+
            '<div class="actionDiv">'+
            '                  <label>Nome entità:</label>' +
            '                  <input type="text" id="nome" class="inputForm">' +
            '              </div>' +
            '<div class="actionDiv">' +
            '                  <label>Collisioni:</label>' +
            '                   <button onclick="selectButton(\'si\')" value = "si" class="bottone collisioni" style="width: 170px; background-color: #1A1A1A; grid-column: 1;">SI</button>' +
            '                   <button onclick="selectButton(\'no\')" value = "no" class="bottone collisioni" style="width: 170px; background-color: #1A1A1A; grid-column: 2;">NO</button>' +
            '              </div>' +
            '<div class="actionDiv">'+
            '                  <label>Nome cartella:</label>' +
            '                  <input type="text" id="nomeCartella" class="inputForm">' +
            '              </div>' +
            '<div id="proprietà">' +
            '</div>' +
            '<div class="actionDiv">' +
            '                  <button class="bottone" onclick="creaProprietà()">Aggiungi Proprietà</button>' +
            '              </div>' +
            '<div class="actionDiv">' +
            '                  <button class="bottone" onclick="creaEntità()">Crea Entità</button>' +
            '              </div>' +
            '<div id="creazione">' +
            '</div>' +
            '</div>' +
            '<div class="breakDivAction">' +
            '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
            '       Modifica </div>' +
            '<div class="actionDiv">'+
            '                  <label>Nome entità:</label>' +
            '                  <input type="text" class="inputForm" id="nomeIns">' +
            '              </div>' +
            '<div class="actionDiv">' +
            '                  <label>Collisioni:</label>' +
            '                   <button onclick="" class="bottone" style="width: 170px; background-color: #1A1A1A; grid-column: 1;">SI</button>' +
            '                   <button onclick="" class="bottone" style="width: 170px; background-color: #1A1A1A; grid-column: 2;">NO</button>' +
            '              </div>' +
            '<div class="actionDiv">' +
            '                  <button class="bottone" onclick="">Modifica Entità</button>' +
            '              </div>' +
            '</div>' +
            '<div class="breakDivAction">' +
            '<div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
            '       Eliminazione </div>' +
            '<div class="actionDiv">'+
            '                  <label>Nome entità:</label>' +
            '                  <input type="text" class="inputForm">' +
            '              </div>' +
            '<div class="actionDiv">' +
            '                  <button class="bottone" onclick="">Elimina Entità</button>' +
            '              </div>' +
            '</div>' +
            '<div class="breakDivAction">' +
            '<div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
            '       Entità </div>' +
            '               <div class="actionDiv" id="show1">' +
            '           </div>' +
            '       </div>' +
            '           ' +
            '</div>');


            document.getElementById("creaGestore").classList.add("pressed");
            showEntita();
    } else {

        document.getElementById("creaGestore").classList.remove("pressed");

    }

}

function creaImmagini(){

    let div = document.getElementById("info");

    document.getElementsByClassName("break")[0].style.height = "100%";
    div.innerHTML = "";

    if (document.getElementById("creaImmagini").classList.contains("pressed") === false) {

        if(div.children.length === 0) {

            for (let child of document.getElementById("strumenti").children) {

                child.classList.remove("pressed");

            }

            document.getElementsByClassName("break")[0].style.height = "150%";

        }

        $(div).append('<div class = "titleBar" id="titleBar">'+
            '            <img class="iconTitle" src="https://i.postimg.cc/PxkLPt7x/event.png" id="title">' +
            '            <label for="title">Gestore entità</label>'+
            '</div>'+
            ' <div class="breakDivAction">'+
            '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
            '       Caricamento' +
            '   </div>' +
            '<div class="actionDiv">'+
            '                  <label>Caricamento:</label>' +
            '              </div>' +
            '<div class="actionDiv">' +
            '                   <form id="file" enctype="multipart/form-data">' +
            '                       <label for="fileInput" id="label" style="cursor: pointer; width: 352px; height: 24px; margin-bottom: 8px;" class="inputForm">Carica File</label>' +
            '                       <input name="file" id="fileInput" style="opacity: 0; position: absolute;" type="file" onchange="showFile()" accept="image/*" hidden="hidden"/>' +
            '                   </form>' +
            '              </div>' +
            '<div class="actionDiv" style="margin-top: 0px;">' +
            '                   <button class="bottone" onclick="saveImages()">Carica Immagine</button>' +
            '</div>' +
            '</div>' +
            '<div class="breakDivAction">' +
            '<div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
            '       Immagini </div>' +
            '   <div class="actionDiv">' +
            '       <div class="entityDiv" style="padding: 8px; border-radius: 2px; height: fit-content;" id="show">' +
            '           ' +
            '       </div>' +
            '       <div class="actionDiv">' +
            '           <label>Nome Immagine</label>' +
            '           <input type="text" class="inputForm" id="nomeImmagine" disabled/>' +
            '       </div>' +
            '   </div> ' +
            '</div>');

        document.getElementById("creaImmagini").classList.add("pressed");
        showImmagini();

    } else {

        document.getElementById("creaImmagini").classList.remove("pressed");

    }

}

function selectButton(scelta){

    for (let elementsByClassNameElement of document.getElementsByClassName("collisioni")) {

        if (elementsByClassNameElement.value === scelta){

            elementsByClassNameElement.style.backgroundColor = "#516f96";
            elementsByClassNameElement.classList.add("selezionato");

        } else{

            elementsByClassNameElement.style.backgroundColor = "#1A1A1A";
            elementsByClassNameElement.classList.remove("selezionato");

        }

    }

}

function creaProprietà(){

    if(document.getElementById("proprietà").children.length <= 6) {

        if(document.getElementById("proprietà").children.length === 0) {

            document.getElementsByClassName("break")[0].style.height = "250%";

        }

        $("#proprietà").append('' +
            '<div class="actionDiv">' +
            '                  <label>Nome Proprietà</label>' +
            '                   <input type="text" class="inputForm NomeProprietà">' +
            '</div>' +
            '<div class="actionDiv">' +
            '                  <label>Valore Proprietà</label>' +
            '                   <input type="text" class="inputForm ValoreProprietà">' +
            '</div>');


    } else {

        if ($("#creazione").children().length > 0){

            $("#creazione").empty();

        }

        $("#creazione").append(

            '<div class="actionDiv">'+
            "                  <label style='color:rgb(175,80,92);'>Non puoi aggiungere più di 4 proprietà!</label>" +
            '</div>'

        );

    }

}

function erroreCreaEntità(){

    if ($("#creazione").children().length > 0){

        $("#creazione").empty();

    }

    $("#creazione").append(

        '<div class="actionDiv">'+
        "                  <label style='color:rgb(175,80,92);'>Errore Nella Creazione Dell'entità</label>" +
        '</div>'

    );

}

function showFile(){

    let label = document.getElementById("label");

    if(!label.classList.contains("file")) {

        label.innerHTML = document.getElementById("fileInput").files[0].name;
        label.classList.add("file");

    } else{

        label.innerHTML = "Carica File";
        label.classList.remove("file");

    }
}
