<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/estilo.css">
    
</head>
<body> 

	 <div id="form-container">
        <div class="panel" id="form-box">
            <form action="Login.do" method="post">
            <input readonly="readonly" type="hidden" id="url" name="url" value="<%= request.getParameter("url") %>">
                <h1 class="text-center"><span class="glyphicon glyphicon-log-in"></span><b> Login</b></h1>
                <hr>
 
                <div class="form-group MarginTop">
                    <label class="sr-only" for="login">Usuário</label>
                    <div class="input-group">
                        <div class="input-group-addon">
                            <span class="glyphicon glyphicon-user"></span>
                        </div>
                        <input type="text" name="usuario" id="usuario" class="form-control" required placeholder="Seu login de usuário">
                    </div>
                </div>
 
                <div class="form-group MarginTop">
                    <label class="sr-only" for="senha">Senha</label>
                    <div class="input-group">
                        <div class="input-group-addon">
                            <span class="glyphicon glyphicon-lock"></span>
                        </div>
                        <input type="password" name="senha" class="form-control" required placeholder="Digite sua senha">
                    </div>
                </div><br>
 
                <div class="form-group">
                    <input type="submit" value="Entrar" class="btn btn-info form-control">
                </div>
 
                <div class="form-group">
                    Não é Cliente? <a href="cadastroCliente.jsp">Crie uma conta</a>.
                </div>
            </form>
        </div>
    </div>
    
    <script src="resources/vendor/jquery/jquery.min.js"></script>
	<script src="resources/vendor/jquery/jquery.mask.min.js"></script>
    <script src="resources/vendor/jquery/jquery.validate.min.js"></script>
    <script src="resources/vendor/jquery/jquery.mask.min.js"></script>
    <script type="text/javascript" src="resources/js/script.js" charset="utf-8"></script>
    <script type="text/javascript" src="resources/js/script.js" charset="utf-8"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            
            $("#usuario").mask('000.000.000-00', {reverse: true});            
        });
    </script>

</body>
</html>