$(document).ready(function() {
    var cookies = document.cookie;
    var _csrfCookie = cookies.split("=")[1];
    var x = document.createElement("INPUT");
    x.setAttribute("type", "text");
    x.setAttribute("value", _csrfCookie);
    x.setAttribute("id", "_csrf");
    x.setAttribute("name", "_csrf");
    x.setAttribute("hidden", true);
    document.getElementById("hiddenDiv").appendChild(x);
});