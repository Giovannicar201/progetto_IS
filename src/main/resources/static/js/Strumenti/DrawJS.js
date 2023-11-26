let flagTile = 0;
let selectorGriglia = new Array();

function initDrawingTools(cella, flag) {

    cella.onclick = function test() {

        if(flagTile == 0){

            if(flag === 1) {

                cella.children[0].src = "/images/tile1.png";

            } else{

                cella.style.backgroundColor = document.getElementById("colorScelto").style.backgroundColor;

            }

        }

        if(flagTile == 1 && cella.className === "square"){

            cella.innerHTML = "";

            let img = document.createElement("img");
            img.className = "cella";
            cella.append(img);

        } else if(flagTile == 1 && cella.className === "squarePixelArt") {

            cella.style.backgroundColor = "#FFFFFF";

        }

        if(flagTile == 2){

            if (selectorGriglia.length < 2) {

                selectorGriglia[selectorGriglia.length] = cella.id;

                if (selectorGriglia.length == 2) {

                    let primaCoordinata = selectorGriglia[0].split(",");
                    let secondaCoordinata = selectorGriglia[1].split(",");
                    selectorGriglia = [];

                    document.getElementById("selectedPointOne").innerHTML = primaCoordinata;
                    document.getElementById("selectedPointTwo").innerHTML = secondaCoordinata;

                    let x1 = parseInt(primaCoordinata[0]);
                    let x2 = parseInt(secondaCoordinata[0]);
                    let y1 = parseInt(primaCoordinata[1]);
                    let y2 = parseInt(secondaCoordinata[1]);

                    while (x1 <= x2) {

                        y1 = parseInt(primaCoordinata[1]);

                        while(y1 < y2) {
                            selectorGriglia[selectorGriglia.length] = x1 + "," + y1;
                            y1++;
                        }

                        selectorGriglia[selectorGriglia.length] = x1 + "," + y1;
                        x1++;

                    }

                    for(let i = 0; i < selectorGriglia.length; i++) {

                        document.getElementById(selectorGriglia[i]).style.border = "solid 1px #516f96";

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

            if(cella.className === "square") {

                cella.children[0].src = "/images/tile1.png";
                cella.removeAttribute("style");

            } else {

                cella.removeAttribute("style");
                cella.style.backgroundColor = document.getElementById("colorScelto").style.backgroundColor;

            }

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

            if(cella.className === "square") {

                cella.removeAttribute("style");
                cella.innerHTML = "";

                let img = document.createElement("img");
                img.className = "cella";
                cella.append(img);

            } else {

                cella.removeAttribute("style");
                cella.style.backgroundColor = "#FFFFFF";

            }

        }

    }

    flagTile = 1;

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