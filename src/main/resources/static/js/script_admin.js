function listAllUsers() {
    fetch('/admin/listAll')
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al obtener la lista de usuarios');
            }
            return response.json();
        })
        .then(users => {
            const userList = document.getElementById('user-list');
            userList.innerHTML = '';
            users.forEach(user => {
                const userItem = document.createElement('div');
                userItem.innerHTML = `
                    <div>ID: ${user.id}</div>
                    <div>Nombre de usuario: ${user.username}</div>
                    <button onclick="showEditForm(${user.id}, '${user.username}')">Editar</button>
                    <button onclick="deleteUser(${user.id})">Eliminar</button>
                `;
                userList.appendChild(userItem);
            });
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function showEditForm(id, username) {
    
    document.getElementById('edit-form').style.display = 'block';
    
    
    document.getElementById('edit-user-form').setAttribute('data-user-id', id);
    document.getElementById('edit-username').value = username;
    document.getElementById('edit-password').value = ''; 
}


document.getElementById('edit-user-form').addEventListener('submit', function(event) {
    event.preventDefault();
    const userId = this.getAttribute('data-user-id');
    const updatedUserData = {
        username: document.getElementById('edit-username').value,
        password: document.getElementById('edit-password').value
    };
    updateUser(userId, updatedUserData);
});


function cancelEdit() {
    document.getElementById('edit-form').style.display = 'none';
}


function updateUser(id, updatedUserData) {
    fetch(`/admin/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedUserData)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al actualizar el usuario');
            }
            return response.json();
        })
        .then(updatedUser => {
            console.log('Usuario actualizado:', updatedUser);
            
            cancelEdit();
           
            listAllUsers();
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
listAllUsers();




function findUserById(id) {
    fetch(`/admin/${id}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al obtener el usuario');
            }
            return response.json();
        })
        .then(user => {
            
            console.log(user);
        })
        .catch(error => {
            console.error('Error:', error);
        });
}






function deleteUser(userId) {
    fetch(`/admin/${userId}`, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
            
            listAllUsers();
        } else {
            console.error('Error al eliminar el usuario');
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
}


