function cargarReservas() {
    fetch('http://localhost:8080/reservas/listar', {
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
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${reserva.fechaReserva}</td>
                <td>${reserva.clase.tipoClase.nombre}</td>
                <td>${reserva.clase.hora}</td>
                <td><button onclick="borrarReserva(${reserva.id})">Borrar</button></td>
            `;
            tbody.appendChild(tr);
        });
    })
    .catch(error => console.error(error));
}

function borrarReserva(id) {
    fetch(`http://localhost:8080/reservas/borrar/${id}`, {
        method: 'DELETE',
        credentials: 'same-origin'
    })
    .then(response => {
        if (response.ok) {
            console.log(`Reserva ${id} eliminada exitosamente.`);
            cargarReservas(); // Actualizar la lista de reservas
        } else {
            throw new Error(`Error al borrar la reserva ${id}`);
        }
    })
    .catch(error => console.error(error));
}

window.onload = cargarReservas;