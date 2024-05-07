document.addEventListener("DOMContentLoaded", function() {
    fetch("/cliente/datos") // Cambia la URL según la ruta de tu controlador para obtener la información del cliente
        .then(response => response.json())
        .then(cliente => {
            const clienteInfo = document.getElementById("cliente-info");
            clienteInfo.innerHTML = `
                <p><strong>Nombre:</strong> ${cliente.nombre}</p>
                <p><strong>Apellidos:</strong> ${cliente.apellidos}</p>
                <p><strong>Email:</strong> ${cliente.email}</p>
                <p><strong>Fecha de Nacimiento:</strong> ${cliente.fecha_nacimiento}</p>
                <!-- Puedes agregar más campos según tu modelo de datos -->
            `;
        })
        .catch(error => console.error('Error:', error));
});

