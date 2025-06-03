function cargarReservas() {
    fetch('http://localhost:8080/reservas/listar', {
        method: 'GET',
        credentials: 'same-origin'
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('Error al cargar las reservas');
        }
    })
    .then(data => {
        const tablaReservas = document.getElementById('tabla-reservas');
        const tbody = tablaReservas.querySelector('tbody');
        tbody.innerHTML = '';

        data.forEach(reserva => {
            const fechaReserva = new Date(reserva.fechaReserva);
            const fechaFormateada = fechaReserva.toLocaleDateString();

            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${fechaFormateada}</td>
                <td>${reserva.clase.tipoClase.nombre}</td>
                <td>${reserva.clase.hora}</td>
                <td><button onclick="borrarReserva(${reserva.id})">Borrar</button></td>
            `;
            tbody.appendChild(tr);
        });
    })
    .catch(error => console.error('Error:', error));
}

function borrarReserva(id) {
    fetch(`http://localhost:8080/reservas/borrar/${id}`, {
        method: 'DELETE',
        credentials: 'same-origin'
    })
    .then(response => {
        if (response.ok) {
            console.log(`Reserva ${id} eliminada exitosamente.`);
            cargarReservas();
        } else {
            throw new Error(`Error al borrar la reserva ${id}`);
        }
    })
    .catch(error => console.error('Error:', error));
}

window.onload = cargarReservas;