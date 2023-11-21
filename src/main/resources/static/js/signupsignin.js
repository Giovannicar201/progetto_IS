document.getElementById("userBar").addEventListener("click", function (){

    let div = document.getElementById("userBar");
    let login = document.getElementById("login");
    let signup = document.getElementById("registrazioneDiv");
    let title = document.getElementById("titleBar");

    if(div.classList.contains("pressed") === false){

        div.classList.add("pressed");
        div.src = "https://i.postimg.cc/Y06qJjHZ/userhover.png";

        login.style.display = "grid";
        signup.style.display = "grid";
        title.style.display = "flex";

    } else {

        div.classList.remove("pressed");
        div.src = "https://i.postimg.cc/xdwxc1w6/user.png";

        login.style.display = "none";
        signup.style.display = "none";
        title.style.display = "none";

    }

});