document.addEventListener("DOMContentLoaded", function() {
    const editarPerfilForm = document.getElementById("editarPerfilForm");

    // Evento para enviar el formulario de edición de perfil
    editarPerfilForm.addEventListener("submit", function(event) {
        event.preventDefault(); // Previene el comportamiento por defecto del formulario

        // Obtiene los valores del formulario
        const nombre = document.getElementById("nombre").value;
        const apellidos = document.getElementById("apellidos").value;
        const email = document.getElementById("email").value;
        const fechaNacimiento = document.getElementById("fechaNacimiento").value;
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        // Objeto con los datos del perfil a actualizar
        const clienteActualizado = {
            nombre: nombre,
            apellidos: apellidos,
            email: email,
            fecha_nacimiento: fechaNacimiento,
            usuario: {
                username: username,
                password: password
            }
        };

        
        console.log(clienteActualizado)
        // Realiza una solicitud PUT para actualizar el perfil del cliente
        fetch(`/cliente/editar`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(clienteActualizado)
            
        })
        .then(response => {
            if (response.ok) {
                // Redirige a la página del perfil del cliente después de guardar los cambios
                window.location.href = "/cliente/datos";
            } else {
                console.error("Error al actualizar el perfil");
            }
        })
        .catch(error => console.error('Error:', error));
    });
});


