 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Minhas Passagens</title>

    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
    <link href="resources/css/sb-admin.css" rel="stylesheet">  
</head>

<body id="page-top">
    <nav class="navbar navbar-expand navbar-dark bg-info static-top">

        <a class="navbar-brand mr-1" href="index.jsp">FlyingHigh</a>

        <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
            <i class="fas fa-bars"></i>
        </button>

        <!-- Navbar Search -->
        <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0"></form>

        <!-- Navbar -->
        <ul class="navbar-nav ml-auto ml-md-0">
            <li class="nav-item dropdown no-arrow">
                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-user-circle fa-fw"></i>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Sair</a>
                </div>
            </li>
        </ul>
    </nav>

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
                <form method="post" action="MinhasPassagens.do">
                    <div class="form-group row">
                        <div class="col-md-5">
                                <!-- <input type="submit" value="Carregar Passagens" class="btn btn-info form-control"> -->
                        </div>
                    </div>
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-table"></i>
                            Minhas Passagens
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered" id="dataTablePassagens" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Fileira</th>
                                            <th>Poltrona</th>
                                            <th>Forma de Pagamento</th>
                                            <th>Parcelas de Pagamento</th>
                                        </tr>
                                    </thead>
                                    <!-- <c:forEach items="${passagensCompradas}" var="psg">
                                        <tr>
                                            <td>                                        	
                                                <c:out value="${psg.id}"></c:out>
                                            </td>
                                            <td>
                                                <c:out value="${psg.fileiras}"></c:out>
                                            </td>
                                            <td>
                                                <c:out value="${psg.poltrona}"></c:out>
                                            </td>
                                            <td>
                                                <c:out value="${psg.formaPagamento}"></c:out>
                                            </td>
                                            <td>
                                                <c:out value="${psg.parcelasPagamento}"></c:out>
                                            </td>
                                        </tr>
                                    </c:forEach> -->
                                </table>
                            </div>
                        </div>
                    </div>
                </form>
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
    <!-- /#wrapper -->

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
   
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>	
    <script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="resources/js/sb-admin.min.js"></script>

    <!-- Demo scripts for this page-->
    <!-- <script src="resources/js/demo/datatables-demo.js"></script> -->

    <script src="resources/js/minhasPassagens.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {            
            $("#dataTablePassagens").DataTable({
                "processing": true,
                "serverSide": true,
                "searching": false,
                autoWidth: true,
                language: {
                    thousands: ".",
                    info: "Mostrando START a END ( Total de TOTAL registros )",
                    lengthMenu: '<span>Mostrar:</span> _MENU_',
                    zeroRecords:"Nenhum registro encontrado",
                    emptyTable: "Nenhum registro encontrado",
                    paginate: { 'primeiro': 'Primeiro', 'último': 'Último', 'próximo': '&rarr;', 'anterior': '&larr;' },
                    paginate: {
                        first: "Primeira",
                        previous: "Anterior",
                        next: "Próxima",
                        last: "Última"
                    },
                    aria: {
                        sortAscending: "Classificar na ordem crescente",
                        sortDescending: "Classificar na ordem decrescente"
                    },
                },
                "ajax": "MinhasPassagens.do"
            });
        });
    </script>
</body>
</html>