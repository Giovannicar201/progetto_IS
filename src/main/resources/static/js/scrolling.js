const observer = new IntersectionObserver((entries) => {

    entries.forEach((entry) =>{

        if (entry.isIntersecting) {

            entry.target.classList.add("show");
            entry.target.classList.remove("notShow");

        } else {

            entry.target.classList.add("notShow");
            entry.target.classList.remove("show");

        }

    });

});

const observerDemo = new IntersectionObserver((entries) => {

    entries.forEach((entry) =>{

        if (entry.isIntersecting) {

            entry.target.innerHTML = "";

        }

    });

});

const mostra = document.getElementsByClassName("notShow");
const reset = document.getElementsByClassName("demo");

for (let mostraElement of mostra) {
    observer.observe(mostraElement);

}
for (let demoElement of reset) {

    observerDemo.observe(demoElement);

}

function demo(){

    let scrivere = document.getElementsByClassName("demotesto")[0];

    scrivere.innerHTML = "";

    scrivere.innerHTML = "Nome evento: Demo";
    scrivere.append(document.createElement("br"));
    scrivere.append(document.createElement("br"));
    scrivere.innerHTML += document.getElementById("istruzione1").value;

}

const observerMappa = new IntersectionObserver((entries) => {

    entries.forEach((entry) =>{

        if (entry.isIntersecting) {

            let mappa = document.getElementById("mappa");

            mappa.innerHTML = "";

            let righe = parseInt(document.getElementById("altezza").value);
            let colonne = parseInt(document.getElementById("largezza").value);

            disegna(mappa, righe, colonne);

        }

    });

});

const cancella = document.getElementsByClassName("mappa");

for (let mappa of cancella){

    observerMappa.observe(mappa);

}

const observerDemoColora= new IntersectionObserver((entries) => {

    entries.forEach((entry) =>{

        if (entry.isIntersecting) {

            entry.target.innerHTML = "";

            disegnaDiv(entry.target, 5, 5);

        }

    });

});

const tile = document.getElementsByClassName("pixelArt");

for(let element of tile){

    observerDemoColora.observe(element);

}
