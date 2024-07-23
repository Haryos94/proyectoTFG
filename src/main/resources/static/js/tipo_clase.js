// Función para cargar los tipos de clase
function cargarTiposClase() {
  fetch('http://localhost:8080/tipo-clase/listar')
      .then(response => {
          if (response.ok) {
              return response.json();
          } else {
              throw new Error('Error al cargar los tipos de clase');
          }
      })
      .then(data => {
          const tablaTiposClase = document.getElementById('tabla-tipos-clase');
          const tbody = tablaTiposClase.querySelector('tbody');
          tbody.innerHTML = '';

          data.forEach(tipoClase => {
              const tr = document.createElement('tr');
              tr.innerHTML = `
                  
                  <td>${tipoClase.nombre}</td>
                  <td>${tipoClase.descripcion}</td>
                  <td>${tipoClase.profesoresModel.nombre}</td>
              `;
              tbody.appendChild(tr);
          });
      })
      .catch(error => console.error(error));
}


window.onload = cargarTiposClase;


  