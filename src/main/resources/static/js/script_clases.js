async function cargarClases() {
    try {
        
        const responseClases = await fetch('http://localhost:8080/listar');
        if (!responseClases.ok) {
            throw new Error(`Error al cargar las clases: ${responseClases.statusText}`);
        }
        const clases = await responseClases.json();

      
        const reservas = await cargarReservas(); 

        
        renderizarTablaClases(clases, reservas);
    } catch (error) {
        console.error(error);
    }
}

async function cargarReservas() {
    try {
        const response = await fetch('http://localhost:8080/reservas/listar');
        if (!response.ok) {
            throw new Error(`Error al cargar las reservas: ${response.statusText}`);
        }
        return await response.json();
    } catch (error) {
        console.error(error);
        return [];
    }
}

function renderizarTablaClases(clases, reservas) {
    const tablaClases = document.getElementById('tabla-clases');
    const thead = tablaClases.querySelector('thead');
    const tbody = tablaClases.querySelector('tbody');

    
    thead.innerHTML = '';
    tbody.innerHTML = '';

    const horas = ['08:00', '09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00', '16:00', '17:00', '18:00', '19:00', '20:00'];
    const diasSemana = ['lunes', 'martes', 'miércoles', 'jueves', 'viernes'];

    
    const encabezados = document.createElement('tr');
    encabezados.appendChild(crearCelda('th', 'Hora'));
    diasSemana.forEach(dia => {
        encabezados.appendChild(crearCelda('th', dia));
    });
    thead.appendChild(encabezados);

    
    horas.forEach(hora => {
        const fila = document.createElement('tr');
        fila.appendChild(crearCelda('td', hora));
        diasSemana.forEach(dia => {
            const clase = clases.find(c => c.dia === dia && c.hora === hora);
            const celda = crearCelda('td', clase ? clase.tipoClase.nombre : '');
            if (clase) {
                const estaReservada = reservas.some(reserva => reserva.clase.idClases === clase.idClases);
                
                if (estaReservada) {
                    celda.classList.add('reservado');
                    celda.textContent += ' (Reservada)'; 
                } else {
                    celda.addEventListener('click', () => reservar(clase.idClases, celda));
                }
            }
            fila.appendChild(celda);
        });
        tbody.appendChild(fila);
    });
}

function crearCelda(tipo, contenido) {
    const celda = document.createElement(tipo);
    celda.textContent = contenido;
    return celda;
}

async function reservar(idClases, celda) {
    if (celda.classList.contains('reservado')) {
        alert('Esta clase ya está reservada.');
        return;
    }
    try {
        const response = await fetch(`http://localhost:8080/reservas/crear?claseId=${idClases}`, {
            method: 'POST',
            credentials: 'same-origin',
            headers: {
                'Content-Type': 'application/json'
            },
        });

        const mensajeError = await response.text(); 

        if (response.ok) {
            celda.classList.add('reservado');
            alert(`Clase reservada exitosamente.`);
        } else {
            celda.classList.add('error');
            alert(`Error al reservar la clase: ${mensajeError}`);
        }
    } catch (error) {
        celda.classList.add('error');
        alert('Error al reservar la clase: ' + error);
    }
}

window.onload = async () => {
    await cargarClases();
};









