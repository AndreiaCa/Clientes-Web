  function validarLogin() {
        
        var codigo = document.getElementById("codigo").value;
        

        if (codigo === "" ) {
            alert("Por favor, preencha todos os campos.");
            return;
        }

         console.log("Validação bem-sucedida!");
        document.getElementById("loginForm").submit();
    }
