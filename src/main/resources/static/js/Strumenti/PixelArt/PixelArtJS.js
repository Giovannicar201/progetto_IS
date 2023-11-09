let div = document.getElementById("color");
let x;
let y;

function createColor(){

    const colors = ["#FF0000", "#00FF00", "#0000FF", "#FFFF00", "#FF00FF","#00FFFF", "#000000", "#FFFFFF"];

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

function showPreview(){

    let preview = document.getElementById("tile");
    let shadow = document.getElementById("s-popup");

    let divTilePreview = document.getElementById("tileBody");
    let divGriglia = document.getElementById("griglia");
    let maxN = 9;

    preview.classList.add("active");
    shadow.classList.add("active");

    shadow.addEventListener("click", function (){

        if(shadow.classList.contains("active")){

            preview.classList.remove("active");
            shadow.classList.remove("active");

            divTilePreview.innerHTML = "";

        }

    })

    document.getElementById("close").addEventListener("click", function (){

        preview.classList.remove("active");
        shadow.classList.remove("active");

        divTilePreview.innerHTML = "";

    })

    for (let i = 0; i < maxN; i++){

        let div = document.createElement("div");

        div.innerHTML = divGriglia.innerHTML;
        div.classList.add("griglia");

        for (let child of div.children) {

            child.classList.remove("squarePixelArt");
            child.classList.add("popStyle");

        }

        divTilePreview.append(div);

    }

}