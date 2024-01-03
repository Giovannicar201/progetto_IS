let colorDiv = document.getElementById("color");
let x1;
let y1;

function creaDivPaletteScelta(nomePaletteScelta){

    const coloriStandard = ["#FF0000", "#00FF00", "#0000FF", "#FFFF00", "#FF00FF","#00FFFF", "#000000", "#FFFFFF"];

    createColor(coloriStandard);

    fetch('/JSON/palette.json')
        .then(json =>  json.json())
        .then(json => {

            let array = json["colori"];

            for (let arrayKey in array) {

                let color = document.createElement("div");
                color.classList.add("squarePixelArt");

                color.style.backgroundColor = array[arrayKey];

                color.onclick = function test() {

                    document.getElementById("colorScelto").style.backgroundColor = array[arrayKey];

                };

                colorDiv .append(color);

            }

        });

}

function creaPixel(){

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
                '            <label for="title">Gestore Pixel Art</label>'+
                '</div>'+
                ' <div class="breakDivAction">'+
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Creazione' +
                '   </div>' +
                '   <div class="actionDiv">'+
                '        <button onclick="creaImmagineDiv()" class="bottone">Crea immagine vuota</button>' +
                '   </div>' +
                '</div>'+
                ' <div class="breakDivAction">'+
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Integrazione' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label for="nomeCartella">Nome cartella</label>' +
                '       <input type="text" id="nomeCartella" class="inputForm" style="margin-top: 2px">' +
                '   </div>' +
                '   <div class="actionDiv">'+
                '       <button onclick="" class="bottone" style="margin-top: 1px;">Integra immagine</button>' +
                '   </div>' +
                '   </div>' +
                '</div>');

            document.getElementsByClassName("break")[0].style.height = "150%";

        }

        document.getElementById("crea").classList.add("pressed");

    } else {

        document.getElementById("crea").classList.remove("pressed");

    }
}

function creaMatitaPA(){

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
                '       Palette selezionata' +
                '   </div>' +
                '<div class="actionDiv">'+
                '                  <label for="nome">Nome palette:</label>' +
                '                  <select id="selezione" class="inputForm"></select>' +
                '              </div>'+
                '<div class="actionDiv">' +
                '                  <button class="bottone" onclick="caricaPalette()">Visualizza palette</button>' +
                '</div>' +
                '' +
                '<div class="actionDiv">'+
                '                  <label>Colori</label>' +
                '                   <div class="entityDiv" id="coloriPalette">' +
                '                  </div>' +
                '              </div>'  +
                '</div>' +
                '<div class="breakDivAction">'+
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Riempimento' +
                '   </div>' +
                '<div class="actionDiv">' +
                '                  <button onclick="matita()" class="bottone matita">Riempi Area</button>' +
                '</div>' +
                '</div>');

            document.getElementsByClassName("break")[0].style.height = "150%";
            palette();

        }

        document.getElementById("draw").classList.add("pressed");
        disegnaTile();

    } else {

        document.getElementById("draw").classList.remove("pressed");

    }


}

function creaStrumentoGommaPA(){

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
                '</div>');

            document.getElementsByClassName("break")[0].style.height = "150%";

        }

        cancellaTile();
        document.getElementById("rubber").classList.add("pressed");

    } else {

        document.getElementById("rubber").classList.remove("pressed");

    }

}

function creaStrumentoRettangolarePA(){

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

function creaPreview(){

    let div = document.getElementById("info");

    document.getElementsByClassName("break")[0].style.height = "100%";
    div.innerHTML = "";

    if (document.getElementById("preview").classList.contains("pressed") === false) {

        for (let child of document.getElementById("strumenti").children) {

            child.classList.remove("pressed");

        }

        if(div.children.length === 0) {

            $(div).append('<div class = "titleBar" id="titleBar">'+
                '            <img class="iconTitle" src="https://i.postimg.cc/Gprst7tc/Tavola-disegno-1.png" id="title">' +
                '            <label for="title">Pattern</label>'+
                '</div>' +
                '<div class="breakDivAction">' +
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Parametri' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label>Numero ripetizioni</label>' +
                '       <input type="number" id="numero" class="inputForm" style="margin-top: 2px">' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <button onclick="callCombine()" class="bottone">Visualizza anteprima</button>' +
                '   </div>' +
                '   </div>');

            document.getElementsByClassName("break")[0].style.height = "150%";

        }

        document.getElementById("preview").classList.add("pressed");

    } else {

        document.getElementById("preview").classList.remove("pressed");

    }

}

function creaStrumentoGenerazioneCasuale(){

    let div = document.getElementById("info");

    document.getElementsByClassName("break")[0].style.height = "100%";
    div.innerHTML = "";

    if (document.getElementById("generatore").classList.contains("pressed") === false) {

        for (let child of document.getElementById("strumenti").children) {

            child.classList.remove("pressed");

        }

        if(div.children.length === 0) {

            $(div).append('<div class = "titleBar" id="titleBar">'+
                '            <img class="iconTitle" src="https://i.postimg.cc/vBtg5W1W/Tavola-disegno-1-1.png" id="title">' +
                '            <label for="title">Gestore Palette</label>'+
                '</div>' +
                '<div class="breakDivAction">' +
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Generazione' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label>Colori generati</label>' +
                '                   <div class="coloriDiv" id="coloriPalette">' +
                '                  </div>' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <button onclick="generaPaletteCasuale()" class="bottone">Genera palette</button>' +
                '   </div>' +
                '</div>' +
                '<div class="breakDivAction">' +
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Salvataggio' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <label>Nome</label>' +
                '       <input type="number" id="nome" class="inputForm" style="margin-top: 2px">' +
                '   </div>' +
                '   <div class="actionDiv">' +
                '       <button onclick="" class="bottone">Salva Palette</button>' +
                '   </div>' +
                '   </div>' +
                '<div class="breakDivAction">' +
                '   <div class="topActionDiv" style="margin: 12px 8px 8px 8px;">' +
                '       Palette' +
                '   </div>' +
                '   <div class="actionDiv"></div>' +
                '   </div>');

            document.getElementsByClassName("break")[0].style.height = "150%";

        }

        document.getElementById("generatore").classList.add("pressed");

    } else {

        document.getElementById("generatore").classList.remove("pressed");

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

function createColor(colors){

    for(let i = 0; i < colors.length; i++){

        let color = document.createElement("div");
        color.classList.add("squarePixelArt");

        color.style.backgroundColor = colors[i];

        color.onclick = function test() {

            document.getElementById("colorScelto").style.backgroundColor = colors[i];

        };

        colorDiv .append(color);

    }

    colorDiv .append(document.createElement("br"));

}

function creaImmagineDiv(){

    disegnaPixelArt(document.getElementById("griglia"));

}

function callCombine(){

    let flag = document.getElementById("numero").value;

    if (document.getElementById("griglia").children.length === 0){

        alert("assicurati prima di disegnare!")

    } else {

        switch (parseInt(flag)) {

            case 1:
                combinePixel(3);
                break;
            case 2:
                combinePixel(5);
                break;
            case 3:
                combinePixel(7);
                break;
            default:
                alert("inserisci un valore tra: 1 2 3");

        }

    }

}

function disegnaPixelArt(divTile) {

    x1 = parseInt("16")
    y1 = parseInt("16");
    let px = "32px";

    disegnaDiv(divTile, x1, y1);

    if (document.head.children.length > 2) {

        document.head.children[2].remove();

    }

    let style = document.createElement("style");
    style.appendChild(document.createTextNode(
        ".griglia{ " +
        "    display: grid;" +
        "    grid-template-columns: repeat(" + x1 +","  + px +");" +
        "    width: fit-content;" +
        "    top: 32px;" +
        "    margin-top: 7%;" +
        "    margin-left: 15%;" +
        "    block-size: fit-content;" +
        "}"));

    document.head.append(style);

}

function disegnaDiv(divTile, x, y){

    for(let i = 0; i < x; i++){

        let j = 0

        for(; j < y; j++){

            let cella = document.createElement("div");

            cella.id = i + "," + j;

            cella.className = "squarePixelArt";

            initDrawingTools(cella,2);

            divTile.append(cella);

        }

    }

}

function generaPaletteCasuale(){

    let palette = document.getElementById("coloriPalette");
    let children = palette.children;

    if(children.length != 0){

        for (let i = 0; i < children.length; i++) {

            if(children[i].classList != undefined) {

                if (children[i].classList.contains("unlocked")) {

                    let randomHex = Math.floor(Math.random() * 0xffffff).toString(16);
                    randomHex = '#' + randomHex;

                    children[i].style.backgroundColor = randomHex;

                }

            }

        }

    } else {

        for (let i = 0; i < 8; i++) {

            let randomHex = Math.floor(Math.random() * 0xffffff).toString(16);
            randomHex = '#' + randomHex;

            creaDiv(randomHex, palette);

        }

    }

}

function creaDiv(hex, palette){

    let color = document.createElement('div');
    color.classList.add("squareColor");
    color.classList.add("unlocked");
    color.style.backgroundColor = hex;

    let lock = document.createElement("button");
    let img = document.createElement("img");
    img.src = "https://i.postimg.cc/vZkCkKm8/lock-2.png";
    lock.classList.add("blocca");
    lock.style.backgroundColor = "transparent";
    lock.style.border = "none";
    lock.style.padding = "20%";
    lock.append(img)

    lock.addEventListener("click", function lockPalette(){

        if(lock.classList.contains("blocca")){

            color.classList.add("locked");
            color.classList.remove("unlocked");

            lock.classList.add("bloccato");
            lock.children[0].src = "https://i.postimg.cc/HkVfSmdP/lock-1.png";
            lock.classList.remove("blocca");

        } else if(lock.classList.contains("bloccato")){

            color.classList.add("unlocked");
            color.classList.remove("locked");

            lock.classList.add("blocca");
            lock.children[0].src = "https://i.postimg.cc/vZkCkKm8/lock-2.png";
            lock.classList.remove("bloccato");

        }

    });

    color.append(lock);
    palette.appendChild(color);

}

function combinePixel(repeat){

    document.getElementById("result").innerHTML = "";
    document.getElementById("griglia").style.visibility = "visible";

    let stile = document.createElement("style");

    stile.appendChild(document.createTextNode(".griglia div{" +
        "" +
        "border: none;" +
        "" +
        "}"));

    document.head.appendChild(stile);

    document.getElementById("result").innerHTML = "";

    for(let i = 0; i < repeat * repeat; i++){

        html2canvas(document.querySelector("#griglia")).then(canvas => {

            canvas.style.width = "64px";
            canvas.style.height = "64px";

                if(i === ((repeat * repeat)-1)/2){

                    document.getElementById("result").append(canvas);

                } else {

                    canvas.style.filter = "brightness(50%)";
                    document.getElementById("result").append(canvas);

                }

        });

    }

    document.getElementById("griglia").style.visibility = "hidden";
    document.getElementById("result").style.display = "grid";
    document.getElementById("result").style.gridTemplateColumns = "repeat(" + repeat +", 64px)";
    document.getElementById("result").style.margin = "18.5% 26%";
    document.getElementById("result").style.position = "absolute";

    document.getElementById("result").addEventListener("click", function test(){

        document.getElementById("result").innerHTML = "";
        document.getElementById("griglia").style.visibility = "visible";

    });

    document.head.removeChild(stile);

}

function palette(){

    let scelta = document.getElementById("selezione");

    fetch('/JSON/palette.json')
        .then((response) => response.json())
        .then(json => {

            let value = document.createElement("option");
            value.value = json.name;
            value.innerHTML = json.name;

            scelta.append(value);

        });

}

function caricaPalette(){

    fetch('/JSON/palette.json')
        .then((response) => response.json())
        .then(json => {

            let colori = json["colori"];

            document.getElementById("coloriPalette").innerHTML = "";

            for (let key in colori){

                let div = document.createElement("div");
                div.classList.add("squareColor");
                div.style.backgroundColor = colori[key];

                div.onclick = function test(){

                    for (let elementsByClassNameElement of document.getElementsByClassName("squareColor")) {

                        elementsByClassNameElement.classList.remove("selected");

                    }

                    div.classList.add("selected");

                };

                document.getElementById("coloriPalette").append(div);

            }

        });

}