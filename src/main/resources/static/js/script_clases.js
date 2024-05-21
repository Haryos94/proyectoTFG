function cargarClases() {
    fetch('http://localhost:8080/listar')
        .then(response => response.json())
        .then(data => {
            // Crear la tabla HTML
            const tablaClases = document.getElementById('tabla-clases');
            tablaClases.innerHTML = ''; // Limpiar la tabla

            // Definir las horas y los días de la semana
            const horas = ['08:00', '09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00', '16:00', '17:00', '18:00', '19:00', '20:00'];
            const diasSemana = ['lunes', 'martes', 'miércoles', 'jueves', 'viernes'];

            // Crear la primera fila con los días de la semana como encabezados de columna
            const encabezados = document.createElement('tr');
            encabezados.innerHTML = '<th></th>'; // Celda vacía para la esquina superior izquierda
            diasSemana.forEach(dia => {
                encabezados.innerHTML += `<th>${dia}</th>`;
            });
            tablaClases.appendChild(encabezados);

            // Iterar sobre las horas
            horas.forEach(hora => {
                const fila = document.createElement('tr');
                fila.innerHTML = `<td>${hora}</td>`; // Agregar la hora como primera columna
                
                // Iterar sobre los días de la semana
                diasSemana.forEach(dia => {
                    // Buscar la clase correspondiente a la hora y día actual
                    const clase = data.find(clase => clase.dia === dia && clase.hora === hora);
                    // Si hay una clase para esta hora y día, agregarla a la celda
                    if (clase) {
                        fila.innerHTML += `<td onclick="reservar(${clase.idClases})">${clase.tipoClase.nombre}</td>`;
                    } else {
                        fila.innerHTML += '<td></td>'; // Si no hay clase, dejar la celda vacía
                    }
                });
                
                // Agregar la fila a la tabla
                tablaClases.appendChild(fila);
            });
        })
        .catch(error => console.error('Error al cargar las clases:', error));
}

// Función para reservar una clase
function reservar(idClases) {
    fetch(`http://localhost:8080/reservas/crear?claseId=${idClases}`, {
        method: 'POST',
        credentials: 'same-origin',
        headers: {
            'Content-Type': 'application/json'
        },
    })
    .then(response => {
        if (response.ok) {
            console.log(`Clase ${idClases} reservada exitosamente.`);
            // Aquí puedes actualizar la interfaz de usuario si es necesario
        } else {
            console.error(`Error al reservar la clase ${idClases}: ${response.statusText}`);
        }
    })
    .catch(error => console.error('Error al reservar la clase:', error));
}

// Llamar a la función para cargar las clases cuando la página se cargue
window.onload = cargarClases;





