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

async function cargarUsuariosReservados(claseId) {
    try {
        const response = await fetch(`http://localhost:8080/reservas/usuarios?claseId=${claseId}`);
        if (!response.ok) {
            throw new Error(`Error al cargar los usuarios reservados: ${response.statusText}`);
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
                    celda.addEventListener('click', () => mostrarPopupReserva(clase));//reservar(clase.idClases, celda));
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

async function reservar(idClases, popup) {
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
            
            cerrarPopup(popup); // Cerrar el popup después de la reserva
        } else {
            alert(`Error al reservar la clase: ${mensajeError}`);
        }
    } catch (error) {
        alert('Error al realizar la reserva: ' + error);
    }
}


window.onload = async () => {
    await cargarClases();
};


//Funcion de mostrar popup
async function mostrarPopupReserva(clase) {
    // Rellenar el contenido del popup con la información de la clase
    const claseDetalles = document.getElementById('claseDetalles');
    claseDetalles.innerHTML = `Clase: ${clase.tipoClase.nombre}<br>Monitor: ${clase.tipoClase.profesoresModel.nombre}<br>Horario: ${clase.hora} - ${clase.dia}`;

    // Cargar los usuarios que han reservado la clase
    const usuariosReservados = await cargarUsuariosReservados(clase.idClases);
    const usuariosList = document.getElementById('usuariosReservadosList');
    usuariosList.innerHTML = ''; // Limpiar la lista de usuarios

    if (usuariosReservados.length > 0) {
        usuariosReservados.forEach(usuario => {
            const li = document.createElement('li');
            li.textContent = `${usuario.username}`;
            usuariosList.appendChild(li);
        });
    } else {
        const li = document.createElement('li');
        li.textContent = 'No hay usuarios reservados.';
        usuariosList.appendChild(li);
    }
    
    // Mostrar el popup
    const popup = document.getElementById('popupReserva');
    popup.style.display = 'flex';

    // Guardar la clase seleccionada para reservarla luego
    const confirmarReservaBtn = document.getElementById('confirmarReservaBtn');
    confirmarReservaBtn.onclick = () => reservar(clase.idClases, popup);
    
    // Cerrar el popup si el usuario hace clic en "Cancelar"
    const cancelarReservaBtn = document.getElementById('cancelarReservaBtn');
    cancelarReservaBtn.onclick = () => cerrarPopup(popup);
    
    // Cerrar el popup si el usuario hace clic en la "X"
    const closePopupBtn = document.getElementById('closePopupBtn');
    closePopupBtn.onclick = () => cerrarPopup(popup);
}

function cerrarPopup(popup) {
    popup.style.display = 'none'; // Ocultar el popup
}











