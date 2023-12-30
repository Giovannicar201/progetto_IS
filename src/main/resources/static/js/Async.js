function getimg(formato) {

    combine(formato);

}

async function download(url, formato) {

    const a = document.createElement("a");

    a.href = url.toDataURL();
    a.download = "grid." + formato;

    document.body.appendChild(a);

    a.click();

    document.body.removeChild(a);

}

function combine(formato){

    html2canvas(document.querySelector("#griglia")).then(canvas => {

        document.getElementById("result").append(canvas);

        download(canvas, formato);

        document.getElementById("result").removeChild(canvas);

    });

}

function creaLaCartella(){

    let xhr = new XMLHttpRequest();

    xhr.open('POST', '/griglia/creacartella', true);

    xhr.onreadystatechange = function() {

        if (xhr.readyState === 4 && xhr.status === 200) {

            console.log("ciao");

        }

    };

    xhr.onerror = function() {

        console.log('Si è verificato un errore durante la richiesta.');

    };

    xhr.send();
    xhr.close;

}