<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Meus Dados</title>

	<link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	<link href="resources/css/sb-admin.css" rel="stylesheet">
</head>
<body>

	<div id="wrapper">
		<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<li class="nav-item active">
				<a class="nav-link" href="index.jsp">
					<i class="fas fa-fw fa-tachometer-alt"></i>
					<span>Comprar Passagem</span>
				</a>
			</li>
		
			<li class="nav-item">
				<a class="nav-link" href="minhasPassagens.jsp">
					<i class="fas fa-fw fa-chart-area"></i>
					<span>Minhas Passagens</span>
				</a>
			</li>
		
			<li class="nav-item">
				<a class="nav-link" href="meusDados.jsp">
					<i class="fas fa-fw fa-table"></i>
					<span>Meus Dados</span>
				</a>
			</li>
		
			<li class="nav-item">
				<a class="nav-link" href="alterarSenha.jsp">
					<i class="fas fa-fw fa-table"></i>
					<span>Alterar Senha</span>
				</a>
			</li>
		</ul>

		<div id="content-wrapper">

			<div class="container-fluid">
				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i>
						Meus Dados
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table id="meusDados" class="table table-bordered" cellspacing="0" style="width:98%">
								<thead>
									<tr>
										<th>CPF</th>
										<th>NOME</th>
										<th>TELEFONE</th>
										<th>ESTADO</th>
										<th>CIDADE</th>
										<th>ENDEREÇO</th>
										<th>RG</th>
										<th>EMAIL</th>
										<th></th>
									</tr>
								</thead>
								<c:forEach items="${dadosCliente}" var="cliente">
									<tr>
										<td>  	
											<c:out value="${cliente.cpf}"></c:out>
										</td>
										<td>
											<c:out value="${cliente.nome}"></c:out>
										</td>
										<td>
											<c:out value="${cliente.telefone}"></c:out>
										</td>
										<td>
											<c:out value="${cliente.estado}"></c:out>
										</td>
										<td>
											<c:out value="${cliente.cidade}"></c:out>
										</td>
										<td>
											<c:out value="${cliente.endereco}"></c:out>
										</td>
										<td>
											<c:out value="${cliente.rg}"></c:out>
										</td>
										<td>
											<c:out value="${cliente.email}"></c:out>
										</td>
										<td>
											
										</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>

			<footer class="sticky-footer">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright © Your Website 2018</span>
					</div>
				</div>
			</footer>

		</div>
		<!-- /.content-wrapper -->

	</div>

	<!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
		<i class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Sair do sistema</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Desesa realmente sair?</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                    <a class="btn btn-primary" href="Login.do?deslogar=true">Sair</a>
                </div>
            </div>
        </div>
	</div>
	
	<!-- Bootstrap core JavaScript-->
    <script src="resources/vendor/jquery/jquery.min.js"></script>
    <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Page level plugin JavaScript-->
    <script src="resources/vendor/datatables/jquery.dataTables.js"></script>
    <script src="resources/vendor/datatables/dataTables.bootstrap4.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="resources/js/sb-admin.min.js"></script>

    <!-- Demo scripts for this page-->
    <!-- <script src="resources/js/demo/datatables-demo.js"></script> -->

    <script src="resources/js/meusDados.js"></script>

	<script type="text/javascript">
	$(document).ready(function() {
	// 	console.log("entra")
		carregatabela();
	// 	$('#meusDados').DataTable( {
	// 		"processing": true,
	// 		"serverSide": true,
	// 		"ajax": "MeusDados.do"
	});
	// });

	function carregatabela(){
            
		$.ajax({
			method: "post",
			url: "MeusDados.do"
		})
		.done(function(response){
			console.log(response);
		});
    }
	</script>
</body>
</html>