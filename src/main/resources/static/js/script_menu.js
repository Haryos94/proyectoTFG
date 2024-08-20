fetch('menu.html')
            .then(response => response.text())
            .then(data => {
                document.getElementById('menu-container').innerHTML = data;
            })
            .catch(error => console.error('Error al cargar el menú:', error));