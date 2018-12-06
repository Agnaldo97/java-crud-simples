<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>	
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Cadastrar Cliente</title>

	<link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	<link href="resources/css/sb-admin.css" rel="stylesheet">

</head>
<body style="background-color: #6C7A89">
	
	<div class="container" style="width: 150%">
		<div class="card mx-auto mt-5">
			<div class="card-header">
				Registar Conta
			</div>

			<div class="card-body">
				<form class="form">
					<div class="form-group">
						<div class="form-label-group">
							<input type="text" id="nome" name="nome" class="form-control" placeholder="First name" autofocus="autofocus">
							<label for="nome">Nome completo</label>
						</div>
					</div>

					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<div class="form-label-group">
									<input type="text" id="cpf" name="cpf" class="form-control" placeholder="Last name">
									<label for="cpf">CPF</label>
								</div>
							</div>

							<div class="col-md-6">
								<div class="form-label-group">
									<input type="text" id="rg" name="rg" class="form-control" placeholder="Registro Geral">
									<label for="rg">RG</label>
								</div>
							</div>
						</div>
					</div>

					<div class="form-group">
						<div class="form-row">
							<div class="col-md-4">
								<div class="form-label-group">
									<input type="text" id="endereco" name="endereco" class="form-control" placeholder="Endereço">
									<label for="endereco">Endereço</label>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-label-group">
									<input type="text" id="cidade" name="cidade" class="form-control" placeholder="Cidade">
									<label for="cidade">Cidade</label>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-label-group">
									<input type="text" id="estado" name="estado" class="form-control" placeholder="Estado">
									<label for="estado">Estado</label>
								</div>
							</div>
						</div>
					</div>

					<div class="form-group">
						<div class="form-row">
							<div class="col-md-4">
								<div class="form-label-group">
									<input type="text" id="telefone" name="telefone" class="form-control" placeholder="Telefone">
									<label for="telefone">Telefone</label>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-label-group">
									<input type="text" id="senha" name="senha" class="form-control" placeholder="Senha">
									<label for="senha">Senha</label>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-label-group">
									<input type="text" id="email" name="email" class="form-control" placeholder="E-mail">
									<label for="email">E-mail</label>
								</div>
							</div>
						</div>
					</div>

					<button type="button" id="btnCadastrar" class="btn btn-primary btn-lg btn-block"> Registrar Conta</button>

				</form>
				<div class="text-center">
					<a class="d-block small mt-3" href="login.jsp">Retornar para a pagina de Login</a>
				</div>
			</div>
		</div>
	</div>

	<!-- <script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script> -->

	<script src="resources/vendor/jquery/jquery.min.js"></script>
	<script src="resources/vendor/jquery/jquery.mask.min.js"></script>
	<script src="resources/vendor/jquery/jquery.validate.min.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript" src="resources/js/validate.js" charset="utf-8"></script> 
	<script type="text/javascript" src="resources/js/script.js" charset="utf-8"></script>

	<script type="text/javascript">

	$(document).ready(function () {

		$("#btnCadastrar").on("click", function(){
			validaCampos() ? cadastraCliente() : false
		});
	});
	
	function validaCampos() {

		if (
			$("#nome").val() 	 == '' ||
			$("#cpf").val() 	 == '' ||
			$("#rg").val() 		 == '' ||
			$("#endereco").val() == '' ||
			$("#cidade").val() 	 == '' ||
			$("#estado").val() 	 == '' ||
			$("#telefone").val() == '' ||
			$("#senha").val() 	 == '' ||
			$("#email").val() 	 == ''
			){
				
				swal({
					  title: "Atenção!",
					  text: "Todos os campos são de preenchimento obrigatório!",
					  icon: "error",
					})
					
				return false
			}

		return true
		
	}

	function cadastraCliente(){

		var data = {
						nome: 	  $("#nome").val(),
						cpf:  	  $("#cpf").val(),
						rg:   	  $("#rg").val(),
						endereco: $("#endereco").val(),
						cidade:   $("#cidade").val(),
						estado:   $("#estado").val(),
						telefone: $("#telefone").val(),
						senha:    $("#senha").val(),
						email:    $("#email").val()
					}
		
		$.ajax({
			method: "post",
			url: "CadastrarCliente.do",
			data: data
		})
		.always(function (response) {
			
			mensagem(parseInt(response));			
		})
	}

	function mensagem(valor){

		if (valor == 200) {
			
			return swal("Cadastro realizado com SUCESSO!", "", "success");

		} else {
			
			return swal("Falha ao realizar o cadastro!", "", "error");
		}
	}
	</script>
</body>
</html>