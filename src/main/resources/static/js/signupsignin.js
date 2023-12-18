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
                '                    <form th:action="@{/login}" th:object="${infoUtente}" id="formLogin" method="post">' +
                '                        <div class="topActionDiv">' +
                '                            <label for="emailLogin">Email</label>' +
                '                            <input type="text" class="inputForm" id="emailLogin" th:field="*{email}" required>' +
                '                        </div>' +
                '                        <div class="actionDiv">' +
                '                            <label for="PasswordLogin">Password</label>' +
                '                            <input type="text" class="inputForm" id="PasswordLogin" th:field="*{Password}" required>' +
                '                        </div>' +
                '                        <div class="actionDiv">' +
                '                            <button class="bottone">Log-in</button>' +
                '                        </div>' +
                '                    </form>' +
                '                </div>' +
                '                <div class="breakDivAction" id="registrazioneDiv">' +
                '                    <label for="registrazione" style="margin-left: 8px; margin-top: 8px">Sign-up</label>' +
                '                    <form th:action="@{/registrazione}" th:object="${infoUtente}" id="registrazione" method="post">' +
                '                        <div class="topActionDiv">' +
                '                            <label for="emailRegistrazione">Email</label>' +
                '                            <input type="text" class="inputForm" id="emailRegistrazione" th:field="*{email}"' +
                '                                   required>' +
                '                        </div>' +
                '                        <div class="actionDiv">' +
                '                            <label for="nomeRegistrazione">Nome</label>' +
                '                            <input type="text" class="inputForm" id="nomeRegistrazione" th:field="*{nome}" required>' +
                '                        </div>' +
                '                        <div class="actionDiv">' +
                '                            <label for="PasswordRegistrazione">Password</label>' +
                '                            <input type="text" class="inputForm" id="PasswordRegistrazione" th:field="*{password}"' +
                '                                   required>' +
                '                        </div>' +
                '                        <div class="actionDiv">' +
                '                            <label for="RipetiPasswordRegistrazione">Ripeti Password</label>' +
                '                            <input type="text" class="inputForm" id="RipetiPasswordRegistrazione" required>' +
                '                        </div>' +
                '                        <div class="actionDiv">' +
                '                            <button class="bottone">Sign-up</button>' +
                '                        </div>' +
                '                    </form>' +
                '                </div>');

            document.getElementsByClassName("break")[0].style.height = "150%";

        }

        document.getElementById("auth").classList.add("pressed");

    } else {

        document.getElementById("auth").classList.remove("pressed");

    }

}