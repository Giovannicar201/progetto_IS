let contenitoreGriglia = document.getElementById("griglia");
let flagTile = 0;
let selectorGriglia = new Array();
let x;
let y;

/** creaGriglia():
 *
 * la seguente funzione javascript viene utilizzata per la creazione della griglia
 * generando vari div che vanno a creare poi l'effettiva griglia attraverso l'utiizzo del
 * css. Ad ogni div viene assegnato un id, che equivale alle coordinate nella griglia, e un
 * action listener che a seconda del valore di flagtile può eseguire diverse operazioni.
**/

function creaGriglia(){

    contenitoreGriglia.innerHTML = "";

    let righe = document.getElementById("righe").value;
    let colonne = document.getElementById("colonne").value;

    x = parseInt(righe)
    y = parseInt(colonne);

    let griglia = new Array();
    let riga = new Array();

    for(let j = 0; j < righe; j++){

        riga[j] = "";

    }

    for(let i = 0; i < colonne; i++){

        griglia[i] = riga;

    }

    griglia.forEach((elemento, index) => {

        elemento.forEach((elemento, index1) => {

            let cella = document.createElement("div");
            cella.id = index + "," + index1;
            cella.className = "square";
            cella.onclick = function test() {

                if(cella.childElementCount == 0 && flagTile == 0){

                    let img = document.createElement("img");
                    img.className = "cella";
                    img.src = "/images/tile.png";
                    cella.append(img);

                }

                if(cella.childElementCount == 1 && flagTile == 1){

                    cella.innerHTML = "";

                }


                if(flagTile == 2){

                    if (selectorGriglia.length < 2) {

                        selectorGriglia[selectorGriglia.length] = cella.id;

                        if (selectorGriglia.length == 2) {

                            let primaCoordinata = selectorGriglia[0].split(",");
                            let secondaCoordinata = selectorGriglia[1].split(",");
                            selectorGriglia = [];

                            let x1 = parseInt(primaCoordinata[0]); //x1 = 6
                            let x2 = parseInt(secondaCoordinata[0]); //x2 = 7
                            let y1 = parseInt(primaCoordinata[1]);
                            let y2 = parseInt(secondaCoordinata[1]);

                            while (x1 <= x2)
                            {
                                y1 = parseInt(primaCoordinata[1]);

                                while(y1 < y2)
                                {
                                    selectorGriglia[selectorGriglia.length] = x1 + "," + y1;
                                    y1++;
                                }

                                selectorGriglia[selectorGriglia.length] = x1 + "," + y1;
                                x1++;

                            }

                            for(let i = 0; i < selectorGriglia.length; i++) {

                                document.getElementById(selectorGriglia[i]).style.border = "solid 2px red";

                            }

                        }

                    }else{

                        for(let i = 0; i < selectorGriglia.length; i++) {

                            let cella = document.getElementById(selectorGriglia[i]);

                            cella.removeAttribute("style");

                        }

                        selectorGriglia = [];

                    }

                }

            };

            contenitoreGriglia.append(cella);

        });

    });

    let style = document.createElement("style");
    style.appendChild(document.createTextNode(
        ".griglia{ " +
        "    display: grid;" +
        "    grid-template-columns: repeat(" + colonne +", 64px);" +
        "    padding: 0px;" +
        "    width: fit-content;" +
        "    block-size: fit-content;" +
        "}"));

    document.head.append(style);

}

/**
 * disegnaTile():
 *
 * la seguente funzione ha associato il codice 0 e viene utilizzata per dissegnare un tile in un
 * (x, y) quadratino della griglia.
 **/

function disegnaTile(){

    if(flagTile == 2) {

        for(let i = 0; i < selectorGriglia.length; i++) {

            let cella = document.getElementById(selectorGriglia[i]);

            if (cella.childElementCount == 0){

                let img = document.createElement("img");
                img.className = "cella";
                img.src = "/images/tile.png";
                cella.append(img);

            }

            cella.removeAttribute("style");

        }

    }

    flagTile = 0;

}

/**
 * cancellaTile():
 *
 * la seguente funzione ha codice 1, cancella l'inner html di un div sulla quale si clicca e funziona
 * come gomma della mappa.
 *
 **/

function cancellaTile(){

    if (flagTile == 2) {

        for(let i = 0; i < selectorGriglia.length; i++) {

            let cella = document.getElementById(selectorGriglia[i]);
            cella.removeAttribute("style");
            cella.innerHTML = "";

        }

    }

    flagTile = 1;

}

/**
 *
 * updateButton():
 *
 *la seguente funzione viene utilizzata per capire quanto grande la griglia dev'essere generata.
 **/

function updateButton(){

    let colonne = document.getElementById("colonne");
    let righe = document.getElementById("righe");

    colonne.value = righe.value;

}

/**
 *
 * selettoreTile():
 *
 *la seguente funzione ha codice 2, inizializza la selezione.
 **/

function selettoreTile() {

    selectorGriglia = [];
    flagTile = 2;

}

function getimg() {

    combine();

}

async function download(url) {

    const a = document.createElement("a");

    a.href = url.toDataURL();
    a.download = "grid.png";

    document.body.appendChild(a);

    a.click();

    document.body.removeChild(a);

}

function combine(){

    html2canvas(document.querySelector("#griglia")).then(canvas => {

        document.getElementById("result").append(canvas);

        download(canvas);

        document.getElementById("result").removeChild(canvas);

    });

}