let div = document.getElementById("color");
let x;
let y;

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

                div.append(color);

            }

        });

}

function createColor(colors){

    for(let i = 0; i < colors.length; i++){

        let color = document.createElement("div");
        color.classList.add("squarePixelArt");

        color.style.backgroundColor = colors[i];

        color.onclick = function test() {

            document.getElementById("colorScelto").style.backgroundColor = colors[i];

        };

        div.append(color);

    }

    div.append(document.createElement("br"));

}

function creaPixelArt(nomePaletteScelta){

    let preview = document.getElementById("menuTile");
    let shadow = document.getElementById("s-popup");

    close(preview, shadow);

    let contenitorePixelArt = document.getElementById("griglia");

    contenitorePixelArt.innerHTML = "";

    disegnaPixelArt(contenitorePixelArt);
    creaDivPaletteScelta();

}

function disegnaPixelArt(div) {

    x = parseInt("16")
    y = parseInt("16");
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
        "    grid-template-columns: repeat(" + x +","  + px +");" +
        "    padding: 0px;" +
        "    width: fit-content;" +
        "    block-size: fit-content;" +
        "}"));

    document.head.append(style);

}

function generaPaletteCasuale(){

    let palette = document.getElementById("randomHex");
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

        for (let i = 0; i < 6; i++) {

            let randomHex = Math.floor(Math.random() * 0xffffff).toString(16);
            randomHex = '#' + randomHex;

            creaDiv(randomHex, palette);

        }

    }

}

function creaDiv(hex, palette){

    let color = document.createElement('div');
    color.classList.add("squarePixelArt");
    color.classList.add("unlocked");
    color.style.backgroundColor = hex;

    color.onclick = function test() {

        document.getElementById("colorScelto").style.backgroundColor = color.style.backgroundColor;

    };

    let lock = document.createElement("button");
    lock.innerHTML = "blocca";

    lock.addEventListener("click", function lockPalette(){

        if(lock.innerHTML === "blocca"){

            color.classList.add("locked");
            color.classList.remove("unlocked");

            lock.innerHTML = "bloccato";

        } else if(lock.innerHTML === "bloccato"){

            color.classList.add("unlocked");
            color.classList.remove("locked");

            lock.innerHTML = "blocca";

        }

    });

    palette.appendChild(color);
    palette.appendChild(lock);

}

document.getElementById("TilePreview").addEventListener("change", function test(){

    let n = parseInt(document.getElementById("TilePreview").value);
    doPreview(n);

})

function showPreview(){

    let preview = document.getElementById("tile");
    let shadow = document.getElementById("s-popup");

    let divTilePreview = document.getElementById("tileBody");
    divTilePreview.innerHTML = "";

    activePop(preview, shadow, 0);

}

function doPreview(maxN){

    let divTilePreview = document.getElementById("tileBody");
    let divGriglia = document.getElementById("griglia");

    divTilePreview.innerHTML = "";

    for (let i = 0; i < maxN * maxN; i++){

        let div = document.createElement("div");

        div.innerHTML = divGriglia.innerHTML;
        div.classList.add("grigliaPreview");

        for (let child of div.children) {

            child.classList.remove("squarePixelArt");
            child.classList.add("popStyle");

        }

        divTilePreview.append(div);

    }

    if (document.head.children.length > 3) {

        document.head.children[3].remove();

    }

    let style = document.createElement("style");
    style.appendChild(document.createTextNode(
        ".grigliaPreview{ " +
        "    display: grid;" +
        "    grid-template-columns: repeat( 16, 2px);" +
        "    padding: 0px;" +
        "    width: 32px;" +
        "    height: 32px;" +
        "    block-size: fit-content;" +
        "}" +
        ".tilePreview{" +
        "    padding: 10px;" +
        "    display: grid;" +
        "    grid-template-columns: repeat("+ maxN +", 32px);" +
        "    width: fit-content;" +
        "    block-size: fit-content;" +
        "    margin: auto;" +
        "}"));

    document.head.append(style);

}

function creaPopUp(){

    let preview = document.getElementById("menuTile");
    let shadow = document.getElementById("s-popup");

    let paletteList = document.getElementById("sceltaPalette");
    palette(paletteList);

    activePop(preview, shadow, 1);

}

function activePop(preview, shadow, flag){

    preview.classList.add("active");
    shadow.classList.add("active");

    shadow.addEventListener("click", function (){

        close(preview, shadow);

    })

    document.getElementsByClassName("close")[flag].addEventListener("click", function (){

        close(preview, shadow);

    })

}

function close(preview, shadow) {

    preview.classList.remove("active");
    shadow.classList.remove("active");

}

function palette(scelta){

    fetch('/JSON/palette.json')
        .then((response) => response.json())
        .then(json => {

            let value = document.createElement("option");
            value.value = json.name;
            value.innerHTML = json.name;

            scelta.append(value);

        });

}