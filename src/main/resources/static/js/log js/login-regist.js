$(document).ready(function () {

    $("#login").click(function () {
        $("#container").toggleClass("log-in");
    });

    $("#loginButton").click(function () {
        $("#container").toggleClass("active");
    });

    $("#sign-up").click(function () {
        $("#container").toggleClass("log-in");
    });

    $("#sign-upButton").click(function () {
        $("#container").toggleClass("active");
    });

});