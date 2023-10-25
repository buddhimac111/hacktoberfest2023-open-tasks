function myFunction() {
    var x = document.getElementById("nav-top");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
}