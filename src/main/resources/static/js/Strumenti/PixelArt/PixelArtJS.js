let div = document.getElementById("color");
let x;
let y;

function createColor(){

    const colors = ["#FF0000", "#FFFF00", "#00FF00", "#0000FF", "#663300", "#00FFFF", "#606060", "#000000", "#FFFFFF"];

    for(let i = 0; i < colors.length; i++){

        let color = document.createElement("div");
        color.classList.add("squarePixelArt");

        color.style.backgroundColor = colors[i];

        color.onclick = function test() {

            document.getElementById("colorScelto").style.backgroundColor = colors[i];

        };

        div.append(color);

    }

}

createColor();

function creaPixelArt(righe, colonne){

    let contenitorePixelArt = document.getElementById("griglia");

    contenitorePixelArt.innerHTML = "";

    disegnaPixelArt(contenitorePixelArt, righe, colonne);

}

function disegnaPixelArt(div, righe, colonne) {

    x = parseInt(righe)
    y = parseInt(colonne);
    let px = "32px";

    for(let i = 0; i < x; i++){

        let j = 0

        for(; j < y; j++){

            let cella = document.createElement("div");

            cella.id = i + "," + j;

            cella.className = "squarePixelArt";

            initDrawingTools(cella,2);

            div.append(cella);

        }

    }

    if (document.head.children.length > 2) {

        document.head.children[2].remove();

    }

    let style = document.createElement("style");
    style.appendChild(document.createTextNode(
        ".griglia{ " +
        "    display: grid;" +
        "    grid-template-columns: repeat(" + colonne +","  + px +");" +
        "    padding: 0px;" +
        "    width: fit-content;" +
        "    block-size: fit-content;" +
        "}"));

    document.head.append(style);

}

function generaPaletteCasuale(colore){

    let palette = document.getElementById("randomHex");
    palette.innerHTML = "";

    creaDiv(colore, palette);

    for(let i = 0; i < 6; i++){

        let randomHex = Math.floor(Math.random() * 0xffffff).toString(16);
        randomHex = '#' + randomHex;

        creaDiv(randomHex, palette);

    }

}

function creaDiv(hex, palette){

    let color = document.createElement("div");
    color.classList.add("squarePixelArt");
    color.style.backgroundColor = hex;

    color.onclick = function test() {

        document.getElementById("colorScelto").style.backgroundColor = color.style.backgroundColor;

    };

    palette.append(color);

}

function generatorePalette() {

    let colore = document.getElementById("colore").value;
    let hex;

    fetch('/JSON/colours.json')
        .then((response) => response.json())
        .then(json => {

            let key = Object.keys(json);

            if (key.some(f)) {

                hex = json[colore];
                generaPaletteCasuale(hex);

            } else {

                alert("colore non valido");

            }

        });

}

function f(key){

    let colore = document.getElementById("colore").value;

    return key === colore;

}