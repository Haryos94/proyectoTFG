
function registro(jsonData) {
    fetch("/home/registro", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: jsonData
    })
    .then(response => {
        if (response.ok) {
            return response.json(); 
        } else {
            throw new Error("Error al registrar cliente.");
        }
    })
    .then(data => {
        alert(data.message); 
        window.location.href = "index.html";
    })
    .catch(error => {
        alert(error.message); 
    });
}


$(document).ready(function() {
    
    $("#registroForm").submit(function(event) {
        event.preventDefault(); 
        
        
        const nombre = $("#nombre").val();
        const apellidos = $("#apellidos").val();
        const email = $("#email").val();
        const fecha_nacimiento = $("#fecha_nacimiento").val();
        const usernameRegistro = $("#usernameRegistro").val();
        const passwordRegistro = $("#passwordRegistro").val();

        const formData = {
            nombre: nombre,
            apellidos: apellidos,
            email: email,
            fecha_nacimiento: fecha_nacimiento,
            username: usernameRegistro,
            password: passwordRegistro
        };

        
        const jsonData = JSON.stringify(formData);

        
        registro(jsonData);
    });
});
