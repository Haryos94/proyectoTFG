// Definir la función de registro
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
            return response.json(); // Convertir la respuesta a JSON
        } else {
            throw new Error("Error al registrar cliente.");
        }
    })
    .then(data => {
        alert(data.message); // Mostrar el mensaje de éxito en el registro
        window.location.href = "index.html";
    })
    .catch(error => {
        alert(error.message); // Mostrar el mensaje de error en caso de fallo en el registro
    });
}

// Esperar a que el documento esté listo
$(document).ready(function() {
    // Agregar evento de envío para el formulario de registro
    $("#registroForm").submit(function(event) {
        event.preventDefault(); // Evitar el envío del formulario
        
        // Obtener valores de los campos del formulario
        const nombre = $("#nombre").val();
        const apellidos = $("#apellidos").val();
        const email = $("#email").val();
        const fecha_nacimiento = $("#fecha_nacimiento").val();
        const usernameRegistro = $("#usernameRegistro").val();
        const passwordRegistro = $("#passwordRegistro").val();

        // Construir objeto con los datos del formulario
        const formData = {
            nombre: nombre,
            apellidos: apellidos,
            email: email,
            fecha_nacimiento: fecha_nacimiento,
            username: usernameRegistro,
            password: passwordRegistro
        };

        // Convertir objeto a JSON
        const jsonData = JSON.stringify(formData);

        // Llamar a la función para enviar los datos de registro
        registro(jsonData);
    });
});
