<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home</title>
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">
    <link href="resources/css/sb-admin.css" rel="stylesheet">
</head>
<body id="page-top">
    <nav class="navbar navbar-expand navbar-dark bg-info static-top">
        <a class="navbar-brand mr-1" href="index.jsp">FlyingHigh</a>
  
        <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
            <i class="fas fa-bars"></i>
        </button>
        <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0"></form>
  
        <!-- Navbar --> 
        <ul class="navbar-nav ml-auto ml-md-0">
            <li class="nav-item dropdown no-arrow">
                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-user-circle fa-fw"></i>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                    <div class="dropdown-divider"></div>
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
                <form action="ComprarPassagem.do" method="post">
                    <div class="form-group row">
                        <div class="col-md-3">
                            <label for="">Data de Partida</label>
                            <input type="text" required="required" name="dataPartida" id="dataPartida" class="datepicker form-control">
                        </div>
                        <div class="col-md-3">
                            <label for="">Data de Retorno</label>
                            <input type="text" required="required" name="dataRetorno" id="dataRetorno" class="datepicker form-control">
                        </div>
                    </div>
                    
                    <div class="form-group row">
                        <div class="col-md-3">
                            <label for="">Origem</label>
                            <select class="form-control" name="selectOrigem" id="selectOrigem">
                                <option value="0">Selecione</option>
                            </select>
                        </div>
                        <div class="col-md-3">
                            <label for="">Destino</label>
                            <select class="form-control" name="selectDestino" id="selectDestino">
                            <option value="0">Selecione</option>
                            </select>
                        </div>
                    </div>
                    
                    <div class="form-group row">
                        <div class="col-md-3">
                            <button type="submit" id="buscarVoo" class="btn btn-primary btn-lg btn-block">Buscar Passagens</button>
                        </div>
                    </div>
                </form>
                <br>
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fas fa-table"></i>
                        Data Table Example
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTableComprarPassagem" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Número</th>
                                        <th>Fileiras</th>
                                        <th>Poltronas p/ Fileiras</th>
                                        <th>Preço</th>
                                        <th>Origem</th>
                                        <th>Destino</th>
                                        <th>Data de Partida</th>
                                        <th>Hora Partida</th>
                                        <th>Data de Chegada</th>
                                        <th>Hora de chegada</th>
                                    </tr>
                                </thead>
                                <tbody >
                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                </div>        
            </div>
            <!-- /.container-fluid -->
        
            <!-- Sticky Footer -->
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
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Sair do sistema</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Deseja Realmente Sair?</div>
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
    <script src="resources/vendor/jquery/moment.min.js"></script>
    <!-- <script src="resources/vendor/jquery/fullcalendar.min.js"></script> -->
  	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="resources/js/sb-admin.min.js"></script>
    <script type="text/javascript" src="resources/js/index.js" charset="utf-8"></script>

</body>
</html>