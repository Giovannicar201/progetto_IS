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