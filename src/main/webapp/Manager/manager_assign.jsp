<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title> Risks </title>

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
              <h2>Manager ${user.name}</h2>
            </div>
          </div>
          <!-- /menu prile quick info -->
          <br />
          <div class="clearfix"></div>
          <!-- sidebar menu -->
          <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
              <div class="menu_section">
              <ul class="nav side-menu">
                <li><a href="manager.html"><i class="fa fa-home"></i> Home </a>
              </ul>
            </div>
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
                  <img src="../img/user_normal.png" alt="">${user.name}
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
      <div class="right_col " role="main" style="min-height: 720px;">
        
        <div class="">

          <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
              <!--unassigned risks-->
              <div class="x_panel">
                <div class="row x_title">
                  <div class="col-md-6">
                    <h3>Risks Title : ${currentRisk.title}</h3>
                    <span class="label label-success" style="color:white;"><i class="fa fa-warning"></i> Open</span>
                  </div>
                  
                </div>
                <div class="x_content">
                  <div class="row">
                    <div class="col-md-9">
                      <blockquote>
                      <p>${currentRisk.content}.</p>
                      </blockquote>
                      <div class="ln_solid"></div>
                      <div>
                        <form class="form-horizontal form-label-left">
                          <div class="form-group">
                            <h4><label class="control-label col-md-2 col-sm-2 col-xs-12">Possibility</label></h4>
                            <div class="col-md-9 col-sm-9 col-xs-12">
                              <h5>${currentRisk.entries.get(0).possibility}</h5>
                            </div>
                          </div>
                          <div class="form-group">
                            <h4><label class="control-label col-md-2 col-sm-2 col-xs-12">Influence Level</label></h4>
                            <div class="col-md-9 col-sm-9 col-xs-12">
                              <h5>${currentRisk.entries.get(0).influence}</h5>
                            </div>
                          </div>
                          <div class="form-group">
                            <h4><label class="control-label col-md-2 col-sm-2 col-xs-12">Threshold</label></h4>
                            <div class="col-md-9 col-sm-9 col-xs-12">
                              <h5>${currentRisk.entries.get(0).threshold.content}</h5>
                            </div>
                          </div>
                        </form>
                      </div>
                    </div>
                    <div class="col-md-3" style="text-align: center;">
                      <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#assignto"><i class="fa fa-share"></i> Assign To</a>
                      
                    </div>
                  </div>
                </div>
              </div>
            </div>
          <div class="clearfix"></div>
        </div>

      </div>
      <div class="modal fade" id="assignto" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
              <h4 class="modal-title">Assign To</h4>
            </div>
            <div class="modal-body">
              <form actiom="/DevOpsProject/Manager/createResponsible">
              <table class="table table-striped responsive-utilities jambo_table">
                <thead>
                  <tr class="headings">
                    <th>
                      <input type="checkbox" id="check-all" class="flat">
                    </th>
                    <th class="column-title">ID</th>
                    <th class="column-title">Name</th>
                  </tr>
                </thead>
                <tbody>
                	<s:iterator value="userlist">
                		<tr>
                    	<td class="a-center ">
                      		<input type="checkbox" class="flat" name="userIds[]" value=<s:property value="id"/>>
                    	</td>
                    		<td class=" "><s:property value="id"/></td>
                    		<td class=" "><s:property value="name"/></td>
                  		</tr>
                     </s:iterator>
                  
                 
                </tbody>
              </table>
              <div class="ln_solid"></div>
              <div class="col-md-offset-10">
              <button type="submit" class="btn btn-success">Assign</button>
              </div>
              </form>
            </div>
          </div>
        </div>
      </div>

      <!-- /page content -->

     
    </div>
  <!-- footer content -->
      <footer>
        <div class="pull-right">
          Software Risk Management
        </div>
        <div class="clearfix"></div>
      </footer>
      <!-- /footer content -->
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
        $('#new-datatable').DataTable();
        $('#processing-datatable').DataTable();
        $('#closed-datatable').DataTable();
      });
  </script>
  

  <!-- /datepicker -->
        <script src="../js/highcharts/highcharts.js"></script>
        <script src="../js/highcharts/modules/data.js"></script>
        <script src="../js/highcharts/modules/drilldown.js"></script>
</body>
</html>