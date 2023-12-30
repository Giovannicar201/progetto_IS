function creaEventi(){

    let div = document.getElementById("info");

    document.getElementsByClassName("break")[0].style.height = "100%";
    div.innerHTML = "";

    if (document.getElementById("creaEventi").classList.contains("pressed") === false) {

        if(div.children.length === 0) {

            for (let child of document.getElementById("strumenti").children) {

                child.classList.remove("pressed");

            }

            document.getElementsByClassName("break")[0].style.height = "150%";

        }

        $(div).append('<div class = "titleBar" id="titleBar">'+
            '            <img class="iconTitle" src="https://i.postimg.cc/PxkLPt7x/event.png" id="title">' +
            '            <label for="title">Gestore eventi</label>'+
            '</div>'+
            ' <div class="breakDivAction">'+
            '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
            '       Creazione' +
            '   </div>' +
            '<div class="actionDiv">'+
            '                  <label for="nome">Nome Evento:</label>' +
            '                  <input type="text" id="evento" class="inputForm">' +
            '              </div>' +
            '<div class="actionDiv">' +
            '                  <label>Posizione:</label>' +
            '                  <input type="number" id="riga" class="inputForm" style="grid-row: 2; grid-column: 1; width: 170px;">' +
            '                  <input type="number" id="colonna" class="inputForm" style="grid-row: 2; grid-column: 2; width: 170px;">' +
            '              </div>' +
            '<div id="istruzioni">' +
            '</div>' +
            '<div class="actionDiv">' +
            '                  <button class="bottone" onclick="addEvento('+  '\'Dialogo\'' + ')">Aggiungi istruzione "Dialogo"</button>' +
            '              </div>' +
            '<div class="actionDiv">' +
            '                  <button class="bottone" onclick="addEvento('+  '\'Inizia\'' + ')">Aggiungi istruzione "Inizia Ciclo"</button>' +
            '              </div>' +
            '<div class="actionDiv">' +
            '                  <button class="bottone" onclick="addEvento('+  '\'Fine\'' + ')">Aggiungi istruzione "Fine Ciclo"</button>' +
            '              </div>' +
            '<div class="actionDiv">' +
            '                  <button class="bottone" onclick="addEvento('+  '\'Mostra\'' + ')">Aggiungi istruzione "Mostra Dialogo"</button>' +
            '              </div>' +
            '<div class="actionDiv">' +
            '                  <button class="bottone" onclick="">Crea Evento</button>' +
            '              </div>' +
            '</div>' +
            '<div class="breakDivAction">'+
            '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
            '       Anteprima' +
            '   </div>' +
            '<div class="actionDiv">'+
            '                  <label>Nome evento:</label>' +
            '                   <input type="text" class="inputForm">' +
            '</div>' +
            '<div class="actionDiv">' +
            '                   <button class="bottone" onclick="">Anteprima Evento</button>' +
            '              </div>' +
            '</div>' +
            '<div class="breakDivAction">' +
            '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
            '       Eliminazione' +
            '   </div>' +
            '   <div class="actionDiv">'+
            '                  <label>Nome evento:</label>' +
            '                   <input type="text" class="inputForm">' +
            '    </div>' +
            '       <div class="actionDiv">' +
            '                   <button class="bottone" onclick="">Elimina Evento</button>' +
            '              </div>'+
            '</div>' +
            '<div class="breakDivAction">' +
            '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
            '       Eventi' +
            '   </div>' +
            '</div>');

        document.getElementById("creaEventi").classList.add("pressed");

    } else {

        document.getElementById("creaEventi").classList.remove("pressed");

    }

}

function addEvento(flag){

    switch (flag){

        case "Dialogo": $("#istruzioni").append('' +
            '<div class="actionDiv">'+
            '                  <label>Istruzione Mostra Dialogo (Testo)</label>' +
            '                   <input type="text" class="inputForm istruzione">' +
            '</div>'); break;

            case "Inizia": $("#istruzioni").append('' +
            '<div class="actionDiv">'+
            '                  <label>Istruzione Inizia Ciclo (Ripetizioni)</label>' +
            '                   <input type="text" class="inputForm istruzione">' +
            '</div>'); break;

            case "Fine": $("#istruzioni").append('' +
            '<div class="actionDiv">'+
            '                  <label>Istruzione "Fine Ciclo"</label>' +
            '                   <input hidden type="text" class="inputForm istruzione">' +
            '</div>'); break;

            case "Mostra": $("#istruzioni").append('' +
            '<div class="actionDiv">'+
                '                  <label>Istruzione Mostra Testo (Testo)</label>' +
                '                   <input type="text" class="inputForm istruzione">' +
            '</div>'); break;

    }

}