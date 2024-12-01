function progresoCheck() {
    var camposRequired = document.querySelectorAll(".incompleto");
    camposRequired.forEach(input => {
        input.addEventListener("focusout", () => {
            if (input.classList.contains("incompleto") && (input.checkValidity())) {
                console.log("");
                moveBar(1);
                input.classList.remove("incompleto");
                input.classList.add("valido");
            }
            else if (input.value == " " || input.value == null) {
                input.classList.add("incompleto");
                input.classList.remove("valido");
            }
            if (input.classList.contains("valido") && (input.checkValidity()) == false) {
                moveBar(-1);
                input.classList.add("incompleto");
                input.classList.remove("valido");
                alert('invalid input');
            }
        }
        )
    })
}

function moveBar(a) {
    var i = a;
    var progresoBar = document.getElementById("progresoBar");
    var progreso = document.getElementById("progreso");

    var cssObj = window.getComputedStyle(progresoBar, null);
    let totalWidth = parseFloat(cssObj.getPropertyValue("width"));

    var cssObj = window.getComputedStyle(progreso, null);
    let progresoActual = parseInt(cssObj.getPropertyValue("width"));

    var camposRequired = document.querySelectorAll(".incompleto");
    var numberOfCampos = camposRequired.length;

    var increaseTotal = Math.round(parseFloat(totalWidth) / numberOfCampos);

    var id = setInterval(frame, 10);
    function frame() {
        if (progresoActual >= totalWidth || increaseTotal <= 0) {
            clearInterval(id);
            i = 0;
        } else {
            progresoActual += i;
            increaseTotal--;
            progreso.style.width = `${progresoActual}px`;
        }
    }
}

function getYear() {
    const yearSpan = document.querySelector("#crYear");
    const year = document.querySelector("#dispon");
    console.log("getYear is working");
    let date = new Date();
    let currentYear = date.getFullYear();
    currentYear = currentYear.toString();
    yearSpan.innerHTML = currentYear + `&nbsp&copy;`;
    year.value = date;
}

function dosNombres() {
    var lastName = document.getElementById("apellido1");
    var lastName2 = document.getElementById("apellido2");
    var firstName = document.getElementById("nombre1");
    var secondName = document.getElementById("nombre2");
    var prefName = document.getElementById("nombrePref");

    lastName.addEventListener("keydown", (event) => {
        if (event.key == " ") {
            lastName2.removeAttribute("hidden");
            lastName2.focus();
        }
    })
    firstName.addEventListener("keydown", (event) => {
        if (event.key == " ") {
            secondName.removeAttribute("hidden");
            secondName.focus();
        }
    })
    firstName.addEventListener("keyup", () => {
        prefName.value = firstName.value;
    })
}

function listenInputs() {
    const camposRequired = document.querySelectorAll('input');

    camposRequired.forEach(input => {
        if (input.getAttribute('type') == "email") {
            input.addEventListener("change", () => {
                console.log(" ~~~ input type =   email  ~~~ " + input.value);
            })
        }
        if (input.getAttribute('type') == "date" && input.id == "dateGrad") {
            let date = new Date();
            let dateToday = date.getTime();
            input.style.borderColor = "orange";
            console.log(" ~~~ Date() -> dateToday = date.getTime() = " + dateToday);
            input.addEventListener("change", () => {
                console.log("       ~~~ input.value = " + input.value);
                let inputDate = Date.parse(input.value);
                console.log(" ~~~ inputDate = " + inputDate);
                if (inputDate < dateToday) {
                    input.setCustomValidity("");
                    input.style.borderColor = "green";
                    console.log("       ~~~~~~ SUCCESS - input validity report = " + input.checkValidity());
                }
                else {

                    input.setCustomValidity("La fecha no puede ser en el futuro");
                    input.style.borderColor = "red";
                    console.log("       ~~~~~~ FAIL - input validity report = " + input.checkValidity());
                }
            })
        }
        if (input.getAttribute('type') == "text") {
            input.addEventListener("change", () => {
                console.log(" ~~~ input type =   text ~~~ " + input.value);
            })
        }
        if (input.getAttribute('type') == "tel") {
            input.addEventListener("change", () => {
                console.log(" ~~~ input type =   text ~~~ " + input.value);
            })
        }
    })
}

document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("nuevoUserNo").checked = true;
    document.getElementById("dateGrad").value = "";
    getYear();
    dosNombres();
    listenInputs();
    progresoCheck();
});
