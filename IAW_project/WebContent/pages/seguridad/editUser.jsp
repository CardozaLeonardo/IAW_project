<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.Tbl_user,datos.Dt_usuario;" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Usuario</title>
<!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Font Awesome -->
  <link rel="stylesheet" href="../../plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

<%

  String idUser = "";
  idUser = request.getParameter("userID");
  idUser = idUser==null?"0":idUser;
  
  int user = 0;
  user = Integer.parseInt(idUser);
  
  Tbl_user tus = new Tbl_user();
  Dt_usuario dtus = new Dt_usuario();
  
  tus = dtus.obtenerUser(user);

%>

<!-- NAVBAR -->
  <jsp:include page="../../WEB-INF/layouts/topbar.jsp"></jsp:include>
  
  <!-- MENU -->
  <jsp:include page="../../WEB-INF/layouts/menu.jsp"></jsp:include>
  
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>General Form</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">General Form</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
          <div class="col-md-6">
            <!-- general form elements -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Quick Example</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form role="form" method="POST" action="../../SL_usuario">
                <input type="hidden" name="opc" id="opc" value="2">
                <input type="hidden" name="idUser" id="idUser" value="<%=tus.getId_user() %>">
                <div class="card-body">
                  <div class="form-group">
                    <label for="username">Nombre de usuario</label>
                    <input name="username" type="text" class="form-control" value="<%=tus.getUsername() %>" id="username" placeholder="Ingrese su nombre de usuario">
                  </div>
                  <div class="form-group">
                    <label for="name">Primer nombre:</label>
                    <input name="name1" name="name1" type="text" value="<%=tus.getNombre1() %>" class="form-control" id="name1" placeholder="Primer nombre">
                  </div>
                  <div class="form-group">
                    <label for="name2">Segundo nombre: </label>
                    <input type="text" name="name2" class="form-control" value="<%=tus.getNombre2() %>" id="name2" placeholder="Segundo nombre">
                  </div>
                  <div class="form-group">
                    <label for="apellido1">Primer apellido: </label>
                    <input type="text" name="apellido1" class="form-control" value="<%=tus.getApellido1() %>" id="apellido1" placeholder="Primer apellido">
                  </div>
                  <div class="form-group">
                    <label for="apellido2">Segundo apellido: </label>
                    <input type="text" class="form-control" id="apellido2" value="<%=tus.getApellido2() %>" name="apellido2" placeholder="Segundo apellido">
                  </div>
                  
                  <div class="form-group">
                    <label for="password">Contraseña: </label>
                    <input type="password" name="password" class="form-control" id="password" placeholder="">
                  </div>
                  
                  <div class="form-group">
                    <label for="email">Email: </label>
                    <input type="email" name="email" class="form-control" id="email" value="<%=tus.getEmail() %>" placeholder="Eje: lol@gmail.com">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputFile">File input</label>
                    <div class="input-group">
                      <div class="custom-file">
                        <input type="file" class="custom-file-input" id="exampleInputFile">
                        <label class="custom-file-label" for="exampleInputFile">Choose file</label>
                      </div>
                      <div class="input-group-append">
                        <span class="input-group-text" id="">Upload</span>
                      </div>
                    </div>
                  </div>
                  <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                  </div>
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Guardar</button>
                </div>
              </form>
            </div>
            <!-- /.card -->

            <!-- Form Element sizes -->
            
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="float-right d-none d-sm-block">
      <b>Version</b> 3.0.0-rc.1
    </div>
    <strong>Copyright &copy; 2014-2019 <a href="http://adminlte.io">AdminLTE.io</a>.</strong> All rights
    reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="../../plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>

</body>
</html>