function cargarClases() {
    fetch('http://localhost:8080/listar')
        .then(response => response.json())
        .then(data => {
            
            const tablaClases = document.getElementById('tabla-clases');
            tablaClases.innerHTML = ''; 

            
            const horas = ['08:00', '09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00', '16:00', '17:00', '18:00', '19:00', '20:00'];
            const diasSemana = ['lunes', 'martes', 'miércoles', 'jueves', 'viernes'];

            
            const encabezados = document.createElement('tr');
            encabezados.innerHTML = '<th>Hora</th>'; 
            diasSemana.forEach(dia => {
                encabezados.innerHTML += `<th>${dia}</th>`;
            });
            tablaClases.appendChild(encabezados);

            
            horas.forEach(hora => {
                const fila = document.createElement('tr');
                fila.innerHTML = `<td>${hora}</td>`; 
                
                
                diasSemana.forEach(dia => {
                    
                    const clase = data.find(clase => clase.dia === dia && clase.hora === hora);
                    
                    if (clase) {
                        fila.innerHTML += `<td onclick="reservar(${clase.idClases})">${clase.tipoClase.nombre}</td>`;
                    } else {
                        fila.innerHTML += '<td></td>';
                    }
                });
                
                
                tablaClases.appendChild(fila);
            });
        })
        .catch(error => console.error('Error al cargar las clases:', error));
}


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
            
        } else {
            console.error(`Error al reservar la clase ${idClases}: ${response.statusText}`);
        }
    })
    .catch(error => console.error('Error al reservar la clase:', error));
}


window.onload = cargarClases;





