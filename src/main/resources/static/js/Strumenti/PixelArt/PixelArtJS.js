let div = document.getElementById("color");
const colors = ["#FF0000", "#FFFF00", "#00FF00", "#0000FF", "#663300", "#00FFFF", "#606060", "#000000", "#FFFFFF"];
let x;
let y;

function createColor(){

    for(let i = 0; i < colors.length; i++){

        let color = document.createElement("div");
        color.classList.add("squarePixelArt");

        color.style.backgroundColor = colors[i];

        color.onclick = function test() {

            document.getElementById("colorScelto").style.backgroundColor = colors[i];

        };

        div.append(color);

    }

    let style = " .colori{ " +
        "    display: grid;" +
        "    grid-template-columns: repeat(" + 3 +", 32px);" +
        "    padding: 0px;" +
        "    width: fit-content;" +
        "    block-size: fit-content;" +
        "}";

    document.head.append(style);
    div.classList.add("colori");

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