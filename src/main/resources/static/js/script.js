// Definir la función de inicio de sesión
function login(jsonData) {
    fetch("/home/login", {
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
            throw new Error("Credenciales inválidas.");
        }
    })
    .then(data => {
            // Verifica si la respuesta incluye una URL de redirección
        if (data.redirectUrl) {
            // Redirige al usuario a la página de menú
            window.location.href = data.redirectUrl;
        } else {
            // Muestra el mensaje de éxito en el inicio de sesión
            alert(data.message);
        }
    })
    .catch(error => {
        alert(error.message); // Mostrar el mensaje de error en caso de credenciales inválidas
    });
}


// Esperar a que el documento esté listo
$(document).ready(function() {
    // Agregar evento de envío para el formulario de inicio de sesión
    $("#loginForm").submit(function(event) {
        event.preventDefault(); // Evitar el envío del formulario
        
        // Obtener valores de los campos del formulario
        const username = $("#username").val();
        const password = $("#password").val();

        // Construir objeto con los datos del formulario
        const formData = {
            username: username,
            password: password
        };

        // Convertir objeto a JSON
        const jsonData = JSON.stringify(formData);

        // Llamar a la función para enviar los datos de inicio de sesión
        login(jsonData);
    });

   
});






 
