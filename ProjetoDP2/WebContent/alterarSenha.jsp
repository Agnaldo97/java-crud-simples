<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Alterar Senha</title> 

    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="resources/css/sb-admin.css" rel="stylesheet">
</head>
<body style="background-color: #6C7A89">
    <div class="container"> 
        <div class="card card-login mx-auto mt-5"> 
            <div class="card-header">Alterar Senha</div> 
            <div class="card-body">
                <form method="POST" action="AlterarSenha.do">
                    <div class="form-group"> 
                        <div class="form-label-group">
                            <input type="text" id="usuario" name="usuario" class="form-control" placeholder="CPF" required="required" autofocus="autofocus">
                            <label for="usuario">CPF</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-label-group">
                            <input type="text" id="senha" name="senha" class="form-control" placeholder="Senha" required="required">
                            <label for="senha">Senha</label>
                        </div>
                    </div>
                    <button type="submit" id="altSenha" name="altSenha" class="btn btn-primary btn-lg btn-block">Alterar Senha</button>
                </form>
                <div class="text-center">
                    <a class="d-block small mt-3" href="cadastroCliente.jsp">Registrar Conta</a>
                    <a class="d-block small" href="login.jsp">Login</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Core plugin JavaScript--> 
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>	
    <script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
    <script src="resources/vendor/jquery/jquery.min.js"></script>
	<script src="resources/vendor/jquery/jquery.mask.min.js"></script>
	<script src="resources/vendor/jquery/jquery.validate.min.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="resources/js/sb-admin.min.js"></script>
    <script src="resources/js/alterarSenha.js"></script>
</body>
</html>