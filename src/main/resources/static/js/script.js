function login(jsonData) {
    fetch("/home/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: jsonData
    })
    .then(response => {
        if (response.ok) {
            return response.json(); 
        } else {
            throw new Error("Credenciales inválidas.");
        }
    })
    .then(data => {
            
        if (data.redirectUrl) {
            
            window.location.href = data.redirectUrl;
        } else {
            
            alert(data.message);
        }
    })
    .catch(error => {
        alert(error.message); 
    });
}



$(document).ready(function() {
    
    $("#loginForm").submit(function(event) {
        event.preventDefault(); 
        
        
        const username = $("#username").val();
        const password = $("#password").val();

        
        const formData = {
            username: username,
            password: password
        };

        
        const jsonData = JSON.stringify(formData);

        
        login(jsonData);
    });

   
});






 
