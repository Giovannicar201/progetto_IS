function creaLogin(){

    let div = document.getElementById("login");

    document.getElementsByClassName("break")[0].style.height = "100%";
    div.innerHTML = "";

    if (document.getElementById("auth").classList.contains("pressed") === false) {

        for (let child of document.getElementById("strumenti").children) {

            child.classList.remove("pressed");

        }

        if(div.children.length === 0) {

            $(div).append('                <div class="titleBar" id="titleBar">' +
                '                    <img src="https://i.postimg.cc/xdwxc1w6/user.png" class="iconTitle" id="user">' +
                '                        <label for="user">Sign-up & Log-in</label>' +
                '                </div>' +
                '                <div class="breakDivAction" id="login">' +
                '                    <label for="formLogin" style="margin-left: 8px; margin-top: 8px">Log-in</label>' +
                '                        <div class="topActionDiv">' +
                '                            <label for="emailLogin">Email</label>' +
                '                            <input type="text" id="emailLogin" name="email" class="inputForm" required>' +
                '                        </div>' +
                '                        <div class="actionDiv">' +
                '                            <label for="passwordLogin">Password</label>' +
                '                            <input type="password" id="passwordLogin" name="password" class="inputForm" required>' +
                '                        </div>' +
                '                        <div class="actionDiv">' +
                '                            <button class="bottone" onclick="login()">Log-in</button>' +
                '                        </div>' +
                '                   <div id = "errori"></div>' +
                '                </div>' +
                '                <div class="breakDivAction" id="registrazioneDiv">' +
                '                    <label for="registrazione" style="margin-left: 8px; margin-top: 8px">Sign-up</label>' +
                '                        <div class="topActionDiv">' +
                '                            <label for="emailRegistrazione">Email</label>' +
                '                            <input type="text" class="inputForm" id="emailRegistrazione" name="email"' +
                '                                   required>' +
                '                        </div>' +
                '                        <div class="actionDiv">' +
                '                            <label for="nomeRegistrazione">Nome</label>' +
                '                            <input type="text" class="inputForm" id="nomeRegistrazione" name="nome" required>' +
                '                        </div>' +
                '                        <div class="actionDiv">' +
                '                            <label for="PasswordRegistrazione">Password</label>' +
                '                            <input type="password" class="inputForm" id="PasswordRegistrazione" name="password"' +
                '                                   required>' +
                '                        </div>' +
                '                        <div class="actionDiv">' +
                '                            <label for="RipetiPasswordRegistrazione">Ripeti Password</label>' +
                '                            <input type="password" class="inputForm" id="RipetiPasswordRegistrazione" name="passwordRipetuta" required>' +
                '                        </div>' +
                '                        <div class="actionDiv">' +
                '                            <button class="bottone" onclick="signup()">Sign-up</button>' +
                '                        </div>' +
                '                   <div id = "errori"></div>' +
                '                </div>');

            document.getElementsByClassName("break")[0].style.height = "150%";

        }

        document.getElementById("auth").classList.add("pressed");

    } else {

        document.getElementById("auth").classList.remove("pressed");

    }

}

function erroreLogin(){

    if ($("#errori").children().length > 0){

        $("#errori").empty();

    }

    $("#errori").append(

        '<div class="actionDiv">'+
        "                  <label style='color:rgb(175,80,92);'>Errore durante il login! <br>" +
        "                                                       Controlla che email e/o password siano corretti!</label>" +
        '</div>'

    );

}
function erroreSignup(){

    if ($("#errori").children().length > 0){

        $("#errori").empty();

    }

    $("#errori").append(

        '<div class="actionDiv">'+
        "                  <label style='color:rgb(175,80,92);'>Errore durante la registrazione! <br>" +
        "                                                       Controlla che email e/o password siano corretti!</label>" +
        '</div>'

    );

}