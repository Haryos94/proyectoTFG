document.addEventListener("DOMContentLoaded", function() {
    fetch("/cliente/datos") 
        .then(response => response.json())
        .then(cliente => {
            const clienteInfo = document.getElementById("cliente-info");
            clienteInfo.innerHTML = `
                <div><strong>Nombre:</strong> ${cliente.nombre}</div>
                <div><strong>Apellidos:</strong> ${cliente.apellidos}</div>
                <div><strong>Email:</strong> ${cliente.email}</div>
                <div><strong>Fecha de Nacimiento:</strong> ${cliente.fecha_nacimiento}</div>
                
            `;
        })
        .catch(error => console.error('Error:', error));
});


