let x;
let y;

function creaGriglia(righe, colonne){

    let contenitoreGriglia = document.getElementById("griglia");

    contenitoreGriglia.innerHTML = "";

    disegna(contenitoreGriglia, righe, colonne);


}

function disegna(div, righe, colonne) {

    x = parseInt(righe)
    y = parseInt(colonne);
    let px = "64px";

    for(let i = 0; i < x; i++){

        let j = 0

        for(; j < y; j++){

            let cella = document.createElement("div");

            cella.id = i + "," + j;
            cella.className = "square";

            initDrawingTools(cella, 1);

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