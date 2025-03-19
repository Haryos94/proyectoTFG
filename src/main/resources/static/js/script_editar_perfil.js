document.addEventListener("DOMContentLoaded", function() {
    const editarPerfilForm = document.getElementById("editarPerfilForm");

    fetch('/cliente/datos', {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    })
    .then(response => response.json())
    .then(cliente => {
        document.getElementById("nombre").value = cliente.nombre || '';
        document.getElementById("apellidos").value = cliente.apellidos || '';
        document.getElementById("email").value = cliente.email || '';
        document.getElementById("fechaNacimiento").value = cliente.fechaNacimiento || '';
        document.getElementById("username").value = cliente.usuario.username || '';
    })
    .catch(error => console.error('Error al cargar los datos del cliente:', error));

    
    editarPerfilForm.addEventListener("submit", function(event) {
        event.preventDefault(); 
        
        const nombre = document.getElementById("nombre").value;
        const apellidos = document.getElementById("apellidos").value;
        const email = document.getElementById("email").value;
        const fechaNacimiento = document.getElementById("fechaNacimiento").value;
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

       
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
       
        fetch(`/cliente/editar`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(clienteActualizado)
            
        })
        .then(response => {
            if (response.ok) {
                
                window.location.href = "/cliente.html";
            } else {
                console.error("Error al actualizar el perfil");
            }
        })
        .catch(error => console.error('Error:', error));
    });
});


