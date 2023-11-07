let div = document.getElementById("tileset");
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

        div.append(img);

    }

}

tileset();

function crea(){

    document.getElementById("crea").hidden = "hidden";

    document.getElementById("menuMappa").visibility = "visible";
    document.getElementById("popup").classList.remove("popdown");
    document.getElementById("popup").classList.add("popup");

}

function creaGriglia(){

    document.getElementById("menuMappa").visibility = "hidden";
    document.getElementById("popup").classList.remove("popup");
    document.getElementById("popup").classList.add("popdown");

    document.getElementById("devtools").removeAttribute("hidden");

    let contenitoreGriglia = document.getElementById("griglia");

    contenitoreGriglia.innerHTML = "";

    let righe = parseInt(document.getElementById("righe").value);
    let colonne = parseInt(document.getElementById("colonne").value);

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

                document.getElementById("valore").value = cella.id;

            };

            initDrawingTools(cella, 1);

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
        "    padding: 50px;" +
        "    width: fit-content;" +
        "    block-size: fit-content;" +
        "}"));

    document.head.append(style);

}