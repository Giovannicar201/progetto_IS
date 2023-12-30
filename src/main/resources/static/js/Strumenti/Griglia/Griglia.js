let divMappa = document.getElementById("tileset");
let x;
let y;

function tileset() {

    for (let i = 0; i < 2; i++) {

        let img = document.createElement("img");

        img.className = "cellaTile";
        img.src = "/images/tileset/tile" + i +".png";

        img.onclick = function test() {

            document.getElementById("tileScelto").children[0].src = img.src;

        };

        divMappa.append(img);

    }

}

function crea(){

    let div = document.getElementById("info");

    document.getElementsByClassName("break")[0].style.height = "100%";
    div.innerHTML = "";

    if (document.getElementById("crea").classList.contains("pressed") === false) {

        if(div.children.length === 0) {

            for (let child of document.getElementById("strumenti").children) {

                child.classList.remove("pressed");

            }

            $(div).append('<div class = "titleBar" id="titleBar">'+
                '            <img class="iconTitle" src="https://i.postimg.cc/d1jQtQT7/Tavola-disegno-1-3.png" id="title">' +
                '            <label for="title">Gestore Mappa</label>'+
                '</div>'+
                ' <div class="breakDivAction">'+
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Creazione' +
                '   </div>' +
                    '<div class="actionDiv">'+
                    '                  <label for="larghezza">Larghezza:</label>' +
                    '                  <input type="number" id="larghezza" class="inputForm">' +
                    '              </div>' +
                    '<div class="actionDiv">' +
                    '                  <label for="altezza">Altezza:</label>' +
                    '                  <input type="number" id="altezza" class="inputForm">' +
                    '              </div>' +
                    '<div class="actionDiv">' +
                    '                  <button class="bottone" onclick="creaGriglia()">Crea Mappa</button>' +
                    '              </div>' +
                '</div>' +
                '<div class="breakDivAction">'+
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Esportazione' +
                '   </div>' +
                '<div class="actionDiv">'+
                '                  <label for="formato">Formato:</label>' +
                '                  <div style="display: flex; margin-top: 8px;">' +
                '                       <button onclick="downloadButton(\'png\')" class="bottone download png" style="width: 114px; background-color: #1A1A1A;">PNG</button>' +
                '                       <button onclick="downloadButton(\'jpg\')" class="bottone download jpg" style="width: 114px; margin-left: 5px; margin-right: 5px; background-color: #1A1A1A;">JPG</button>' +
                '                       <button onclick="downloadButton(\'json\')" class="bottone download json" style="width: 114px; background-color: #1A1A1A;">JSON</button>' +
                '                  </div>' +
                '              </div>' +
                '<div class="actionDiv">' +
                '                  <button class="bottone" onclick="downloadSelection()">Salva Mappa</button>' +
                '              </div>' +
                '</div>' +
                '<div class="breakDivAction">' +
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Statistiche' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label for= "LargezzaMappa">Larghezza Mappa - </label>' +
                '       <div id="LarghezzaMappa"></div>' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label for= "AltezzaMappa">Altezza Mappa - </label>' +
                '       <div id="AltezzaMappa"></div>' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label for= "copertura">Entità Piazzate - </label>' +
                '       <div id="copertura"></div>' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label for= "coperturaPercentuale">Entità Piazzate Percentuale - </label>' +
                '       <div id="coperturaPercentuale"></div>' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label for= "celleVuote">Celle vuote - </label>' +
                '       <div id="celleVuote"></div>' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label for= "celleVuotePercentuale">Celle vuote percentuale - </label>' +
                '       <div id="celleVuotePercentuale"></div>' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label for= "coperturaEventi">Eventi - </label>' +
                '       <div id="coperturaEventi"></div>' +
                '   </div>' +
                '</div>' +
                '<div class="breakDivAction">' +
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Cursore' +
                '   </div>' +
                '   <div class="actionDiv" style="display: flex;">' +
                '       <label for= "ascissa">Coordinata X -  </label>' +
                '       <div id="ascissa"></div>' +
                '   </div>' +
                '   <div class="actionDiv" style="display: flex;">' +
                '       <label for="ordinata">Coordinata Y -  </label>' +
                '       <div id="ordinata"></div>' +
                '   </div>' +
                '</div>');

                document.getElementsByClassName("break")[0].style.height = "150%";

        }

        document.getElementById("crea").classList.add("pressed");

    } else {

        document.getElementById("crea").classList.remove("pressed");

    }
}

function creaCartella(){

    let div = document.getElementById("info");

    document.getElementsByClassName("break")[0].style.height = "100%";
    div.innerHTML = "";

    if (document.getElementById("cartelle").classList.contains("pressed") === false) {

        for (let child of document.getElementById("strumenti").children) {

            child.classList.remove("pressed");

        }

        if(div.children.length === 0) {

            $(div).append('<div class = "titleBar" id="titleBar">'+
                '            <img class="iconTitle" src="https://i.postimg.cc/BnB9xWyG/Tavola-disegno-1-4.png" id="title">' +
                '            <label for="title">Gestore Cartelle</label>'+
                '</div>'+
                ' <div class="breakDivAction">'+
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Creazione' +
                '   </div>' +
                '<div class="actionDiv">' +
                '                  <label for="nome">Nome:</label>' +
                '                  <input type="text" id="nome" class="inputForm">' +
                '              </div>'+
                '<div class="actionDiv">' +
                '                  <button class="bottone" onclick="creaCartellaJs()">Crea Cartella</button>' +
                '              </div>' +
                '</div>' +
                '<div class="breakDivAction">'+
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Cartelle Entità' +
                '   </div>' +
                '</div>');

            document.getElementsByClassName("break")[0].style.height = "150%";

        }

        document.getElementById("cartelle").classList.add("pressed");

    } else {

        document.getElementById("cartelle").classList.remove("pressed");

    }

}

function creaMatita(){

    let div = document.getElementById("info");

    document.getElementsByClassName("break")[0].style.height = "100%";
    div.innerHTML = "";

    if (document.getElementById("draw").classList.contains("pressed") === false) {

        for (let child of document.getElementById("strumenti").children) {

            child.classList.remove("pressed");

        }

        if(div.children.length === 0) {

            $(div).append('<div class = "titleBar" id="titleBar">'+
                '            <img class="iconTitle" src="https://i.postimg.cc/BQPjnVVL/Tavola-disegno-1-5.png" id="title">' +
                '            <label for="title">Strumento matita</label>'+
                '</div>'+
                ' <div class="breakDivAction">'+
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Entità selezionata' +
                '   </div>' +
                '<div class="actionDiv">'+
                '                  <label for="nome">Nome cartella:</label>' +
                '                  <input type="text" id="nome" class="inputForm" disabled>' +
                '              </div>'+
                '<div class="actionDiv">' +
                '                  <button class="bottone">Visualizza entità</button>' +
                '</div>' +
                '</div>' +
                '<div class="breakDivAction">'+
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Riempimento' +
                '   </div>' +
                '<div class="actionDiv">' +
                '                  <button onclick="matita()" class="bottone matita">Riempi Area</button>' +
                '</div>' +
                '</div>' +
                '<div class="breakDivAction">' +
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Cursore' +
                '   </div>' +
                '   <div class="actionDiv" style="display: flex;">' +
                '       <label for= "ascissa">Coordinata X -  </label>' +
                '       <div id="ascissa"></div>' +
                '   </div>' +
                '   <div class="actionDiv" style="display: flex;">' +
                '       <label for="ordinata">Coordinata Y -  </label>' +
                '       <div id="ordinata"></div>' +
                '   </div>' +
                '</div>');

            document.getElementsByClassName("break")[0].style.height = "150%";

        }

        document.getElementById("draw").classList.add("pressed");
        disegnaTile();

    } else {

        document.getElementById("draw").classList.remove("pressed");

    }

}

function creaStrumentoGomma(){

    let div = document.getElementById("info");

    document.getElementsByClassName("break")[0].style.height = "100%";
    div.innerHTML = "";

    if (document.getElementById("rubber").classList.contains("pressed") === false) {

        for (let child of document.getElementById("strumenti").children) {

            child.classList.remove("pressed");

        }

        if(div.children.length === 0) {

            $(div).append('<div class = "titleBar" id="titleBar">'+
                '            <img class="iconTitle" src="https://i.postimg.cc/d0NsYxf3/Tavola-disegno-1-6.png" id="title">' +
                '            <label for="title">Strumento gomma</label>'+
                '</div>'+
                '<div class="breakDivAction">'+
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Cancellazione' +
                '   </div>' +
                '<div class="actionDiv">' +
                '                  <button onclick="elimina()" class="bottone elimina">Cancella Area</button>' +
                '</div>' +
                '</div>' +
                '<div class="breakDivAction">' +
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Cursore' +
                '   </div>' +
                '   <div class="actionDiv" style="display: flex;">' +
                '       <label for= "ascissa">Coordinata X -  </label>' +
                '       <div id="ascissa"></div>' +
                '   </div>' +
                '   <div class="actionDiv" style="display: flex;">' +
                '       <label for="ordinata">Coordinata Y -  </label>' +
                '       <div id="ordinata"></div>' +
                '   </div>' +
                '</div>');

            document.getElementsByClassName("break")[0].style.height = "150%";

        }

        cancellaTile();
        document.getElementById("rubber").classList.add("pressed");

    } else {

        document.getElementById("rubber").classList.remove("pressed");

    }

}

function creaStrumentoRettangolare(){

    let div = document.getElementById("info");

    document.getElementsByClassName("break")[0].style.height = "100%";
    div.innerHTML = "";

    if (document.getElementById("rettangolare").classList.contains("pressed") === false) {

        for (let child of document.getElementById("strumenti").children) {

            child.classList.remove("pressed");

        }

        if(div.children.length === 0) {

            $(div).append('<div class = "titleBar" id="titleBar">'+
                '            <img class="iconTitle" src="https://i.postimg.cc/sggnzvSj/Tavola-disegno-1-7.png" id="title">' +
                '            <label for="title">Strumento selezione rettangolare</label>'+
                '</div>' +
                '<div class="breakDivAction">' +
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Cursore' +
                '   </div>' +
                '   <div class="actionDiv" style="display: flex;">' +
                '       <label for= "ascissa">Coordinata X -  </label>' +
                '       <div id="ascissa"></div>' +
                '   </div>' +
                '   <div class="actionDiv" style="display: flex;">' +
                '       <label for="ordinata">Coordinata Y -  </label>' +
                '       <div id="ordinata"></div>' +
                '   </div>' +
                '</div>' +
                '<div class="breakDivAction">' +
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Punti di selezione' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label for= "selectedPointOne">Primo punto - </label>' +
                '       <div id="selectedPointOne"></div>' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label for="selectedPointTwo">Secondo punto - </label>' +
                '       <div id="selectedPointTwo"></div>' +
                '   <div class="actionDiv">' +
                '       <button onclick="selezione()" class="bottone selezione">Selezione area</button>' +
                '   </div>' +
                '   </div>' +
                '</div>');

            document.getElementsByClassName("break")[0].style.height = "150%";

        }

        document.getElementById("rettangolare").classList.add("pressed");

    } else {

        document.getElementById("rettangolare").classList.remove("pressed");

    }

}

function creaStrumentoScattering(){

    let div = document.getElementById("info");

    document.getElementsByClassName("break")[0].style.height = "100%";
    div.innerHTML = "";

    if (document.getElementById("scattering").classList.contains("pressed") === false) {

        for (let child of document.getElementById("strumenti").children) {

            child.classList.remove("pressed");

        }

        if(div.children.length === 0) {

            $(div).append('<div class = "titleBar" id="titleBar">'+
                '            <img class="iconTitle" src="https://i.postimg.cc/RZV34bmt/Tavola-disegno-1-8.png" id="title">' +
                '            <label for="title">Strumento di scattering</label>'+
                '</div>' +
                '<div class="breakDivAction">' +
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Parametri' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label for= "cartella">Nome cartella</label>' +
                '       <input type="text" id= "cartella" class="inputForm" disabled>' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '                  <button class="bottone">Visualizza entità</button>' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label for="entità">Entità</label>' +
                '       <div class="inputForm" id= "entità"></div>' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label for="percentuale">Percentuale riempimento</label>' +
                '       <input type= "text" id= "percentuale" class="inputForm">' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label for="firstPriorità">Priorità entità 1 (%)</label>' +
                '       <input type= "text" id= "firstPriorità" class="inputForm">' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label for="secondPriorità">Priorità entità 2 (%)</label>' +
                '       <input type= "text" id= "secondPriorità" class="inputForm">' +
                '   </div><div class="actionDiv">' +
                '       <label for="secondPriorità">Priorità entità 2 (%)</label>' +
                '       <input type= "text" id= "secondPriorità" class="inputForm">' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label for="thirdPriorità">Priorità entità 3 (%)</label>' +
                '       <input type= "text" id= "thirdPriorità" class="inputForm">' +
                '   </div>' +
                '</div>');

            document.getElementsByClassName("break")[0].style.height = "150%";

        }

        document.getElementById("scattering").classList.add("pressed");

    } else {

        document.getElementById("scattering").classList.remove("pressed");

    }

}

function creaStrumentoGenerativa(){

    let div = document.getElementById("info");

    document.getElementsByClassName("break")[0].style.height = "100%";
    div.innerHTML = "";

    if (document.getElementById("generative").classList.contains("pressed") === false) {

        for (let child of document.getElementById("strumenti").children) {

            child.classList.remove("pressed");

        }

        if(div.children.length === 0) {

            $(div).append('<div class = "titleBar" id="titleBar">'+
                '            <img class="iconTitle" src="https://i.postimg.cc/KzPFKBhT/Tavola-disegno-1-9.png" id="title">' +
                '            <label for="title">Strumento di scattering</label>'+
                '</div>' +
                '<div class="breakDivAction">' +
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Generazione' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <button class = "bottone">Genera</button>' +
                '   </div>');

            document.getElementsByClassName("break")[0].style.height = "150%";

        }

        document.getElementById("generative").classList.add("pressed");

    } else {

        document.getElementById("generative").classList.remove("pressed");

    }

}

function creaCartellaJs(){

    creaLaCartella();

}

function downloadSelection(){

    switch (document.getElementsByClassName("selected")[0].innerHTML){

        case "PNG": getimg("png"); break;
        case "JPG": getimg("jpg"); break;
        case "JSON": break;
        default:

    }

}

function matita(){

    document.getElementsByClassName("matita")[0].style.backgroundColor = "#516f96";

    disegnaTileSelezione();

}

function elimina(){

    document.getElementsByClassName("elimina")[0].style.backgroundColor = "#516f96";

    cancellaTileSelezione()

}

function selezione(){

    document.getElementsByClassName("selezione")[0].style.backgroundColor = "#516f96";

    selettoreTile();

}

function downloadButton(selezione){

    for (let elementsByClassNameElement of document.getElementsByClassName("bottone")) {

        if (elementsByClassNameElement.classList.contains("download")) {

            elementsByClassNameElement.style.backgroundColor = "#1A1A1A";
            elementsByClassNameElement.classList.remove("selected");

        }

        if(elementsByClassNameElement.classList.contains(selezione)){

            elementsByClassNameElement.style.backgroundColor = "#516f96";
            elementsByClassNameElement.classList.add("selected");

        }

    }

}

function creaGriglia(){

    let contenitoreGriglia = document.getElementById("griglia");

    contenitoreGriglia.innerHTML = "";

    let righe = parseInt(document.getElementById("altezza").value);
    let colonne = parseInt(document.getElementById("larghezza").value);

    if(document.getElementsByClassName("break")[0] !== undefined){

        document.getElementsByClassName("break")[0].style.height = "150%";

    }

    disegna(contenitoreGriglia, righe, colonne);

}

function disegna(div, righe, colonne) {

    x = parseInt(righe)
    y = parseInt(colonne);
    let px = "32px";

    for(let i = 0; i < x; i++){

        let j = 0

        for(; j < y; j++){

            let cella = document.createElement("div");

            let img = document.createElement("img");
            img.className = "cella";

            cella.id = i + "," + j;
            cella.className = "square";

            cella.append(img);

            cella.onmouseover = function test() {

                document.getElementById("ascissa").innerHTML = cella.id.split(",")[1];
                document.getElementById("ordinata").innerHTML = cella.id.split(",")[0];

            };

            initDrawingTools(cella, 1);

            div.append(cella);

        }

    }

    if (document.head.children.length > 3) {

        document.head.children[3].remove();

    }

    let style = document.createElement("style");

    style.appendChild(document.createTextNode(
        ".griglia{ " +
        "    display: grid;" +
        "    grid-template-columns: repeat(" + colonne +","  + px +");" +
        "    width: fit-content;" +
        "    top: 32px;" +
        "    margin-top: 7%;" +
        "    margin-left: 15%;" +
        "    block-size: fit-content;" +
        "}"));

    document.head.append(style);

}
