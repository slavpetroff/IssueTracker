/**
 * Created by slavpetroff on 8/26/16.
 */
"use strict";
var i, j;

$(document).ready(function () {
    var dropdowns = document.getElementsByClassName("dropdown-content");

    for (i = 0; i < dropdowns.length; i++) {
        var openDropdown = dropdowns[i];
        var childNodes = openDropdown.childNodes.length;

        for (j = 1; j < childNodes; j += 2) {
            var currentType = openDropdown.childNodes[j];

            var currentTypeName = currentType.innerText;
            if (currentTypeName.toLowerCase() === "bug") {
                currentType.style.backgroundColor = "#FF8F70";
            } else if (currentTypeName.toLowerCase() === "feature") {
                currentType.style.backgroundColor = "#A7F975";
            } else if (currentTypeName.toLowerCase() === "type") {
                currentType.style.backgroundColor = "#A7F975";
            }
        }
    }
});

function dropdownToggle() {
    document.getElementById("myDropdown").classList.toggle("show");
}

function changeType(sender, issue) {

}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function (event) {
    if (!event.target.matches('.dropbtn')) {

        var dropdowns = document.getElementsByClassName("dropdown-content");
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
};