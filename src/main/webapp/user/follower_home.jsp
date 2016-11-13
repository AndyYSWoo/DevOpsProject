<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title> Follower Home </title>

  <!-- Bootstrap core CSS -->

  <link href="../css/bootstrap.min.css" rel="stylesheet">
  <link href='http://fonts.googleapis.com/css?family=Abel|Open+Sans:400,600' rel='stylesheet'>
  <link href="../font/admin//css/font-awesome.min.css" rel="stylesheet">
  <link href="../css/admin/animate.min.css" rel="stylesheet">

  <link href="../css/admin/select/select2.min.css" rel="stylesheet">
  <!-- Custom styling plus plugins -->
  <link href="../css/admin/custom.css" rel="stylesheet">
  <link href="../css/admin/icheck/flat/green.css" rel="stylesheet">

  <script src="../js/jquery_min.js"></script>
  <style type="text/css">
  	body{
  		font-family: "Open Sans",serif;
  	}
  	
  </style>
</head>
<body class="nav-md">
  <div class="container body">
    <div class="main_container">
      <div class="col-md-3 left_col">
        <div class="left_col scroll-view">
          <div class="navbar nav_title" style="color: white; ">
          <h3 class="site_title margin-base-vertical">Software Risk Management</h3>
          </div>
          <div class="clearfix"></div>
          <!-- menu prile quick info -->
          <div class="profile">
            <div class="profile_pic">
              <img src="../img/user_normal.png" alt="..." class="img-circle profile_img">
            </div>
            <div class="profile_info">
              <span>Welcome,</span>
              <h2>${user.name}</h2>
            </div>
          </div>
          <!-- /menu prile quick info -->
          <br />
          <div class="clearfix"></div>
          <!-- sidebar menu -->
          <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
              <ul class="nav side-menu">
                <li><a><i class="fa fa-home"></i> User <span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                    <li class="current-page"><a href="follower_home.html">Followed Risk</a>
                    </li>
                    <li><a href="follower_closed.html">Closed Risk</a>
                    </li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>

      <!-- top navigation -->
      <div class="top_nav">
        <div class="nav_menu">
          <nav class="" role="navigation">
            <div class="nav toggle">
              <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>
            <ul class="nav navbar-nav navbar-right">
              <li class="">
                <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                  <img src="../img/user_normal.png" alt="">Admin
                  <span class=" fa fa-angle-down"></span>
                </a>
                <ul class="dropdown-menu dropdown-usermenu pull-right">
                  <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                  </li>
                </ul>
              </li>
            </ul>
          </nav>
        </div>
      </div>
      <!-- /top navigation -->
      
      <!-- page content -->
      <div class="right_col" role="main" style="height: 700px;">
        
        <div class="">

          <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="x_panel">
                <div class="row x_title">
                  <div class="col-md-6">
                    <h3>Follwored Risk</h3>
                  </div>
                  
                </div>
                <div class="x_content">
                  <table id="user-datatable" class="table table-striped">
                    <thead>
                      <tr>
                        <th>Risk</th>
                        <th>Submitter</th>
						<th>Status</th>
						<th>Last Modify</th>
        
                        <th>Edit</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>2012 the world end</td>
                        <td>Tiger Nixon</td>
						<td><button type="button" class="btn btn-info btn-xs">state</button></td>
                        <td>2016-05-21</td>
                        <td><a class="btn btn-primary btn-xs" href="risk_detail.html">view</a>
							<a class="btn btn-danger btn-xs" href=#>close</a>
						</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
          
          <div class="clearfix"></div>
        </div>

      </div>
      <!--add developer form-->
		
      <!-- /page content -->
<!-- footer content -->
      <footer>
        <div class="pull-right">
          Software Risk Management
        </div>
        <div class="clearfix"></div>
      </footer>
      <!-- /footer content -->
     
    </div>

  </div>


  <script src="../js/bootstrap.js"></script>

  <!-- bootstrap progress js -->
  <!-- icheck -->
  <script src="../js/admin/icheck/icheck.min.js"></script>

  <script src="../js/admin/custom.js"></script>

  <!-- pace -->
  <script src="../js/admin/pace/pace.min.js"></script>

  <!-- Datatables-->
  <script src="../js/admin/datatables/jquery.dataTables.min.js"></script>
  <script src="../js/admin/datatables/dataTables.bootstrap.js"></script>
  <script src="../js/admin/datatables/dataTables.buttons.min.js"></script>
  <script src="../js/admin/datatables/dataTables.fixedHeader.min.js"></script>
  <script src="../js/admin/datatables/dataTables.scroller.min.js"></script>

  <script type="text/javascript">
      $(document).ready(function() {
        var table = $('#user-datatable').DataTable({
          //fixedHeader: true,
        });
      });
  </script>

  <!-- /datepicker -->
        <script src="../js/highcharts/highcharts.js"></script>
        <script src="../js/highcharts/modules/data.js"></script>
        <script src="../js/highcharts/modules/drilldown.js"></script>
</body>
</html>