<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title> Risks Overview </title>

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
              <h2>Manager Admin</h2>
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
                <li><a href="#"><i class="fa fa-home"></i> Home </a>
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
      <div class="right_col" role="main" style="min-height: 640px;">
        
        <div class="">

          <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
              <!--unassigned risks-->
              <div class="x_panel">
                <div class="row x_title">
                  <div class="col-md-6">
                    <h3>Unassigned Risks Overview</h3>
                  </div>
                  <div class="col-md-offset-4 col-md-2" style="padding-top: 1%;">
                  	<a id="add-user" href="#" data-toggle="modal" data-target="#add-developer">
                        <i class="fa fa-plus"></i> Add New Risk
                    </a>
                  </div>
                </div>
                <div class="x_content">
                  <table id="new-datatable" class="table table-hover table-striped table-bordered">
                    <thead>
                      <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Creator Name</th>
                        <th>Possibility</th>
                        <th>Influence Level</th>
                      </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="riskOfNewCreated">
                        <tr style="cursor: pointer;">
                        <td><s:property value="id"/></td>
                        <td><a href="manager_assign.html"><s:property value="title"/></a></td>
                        <td><s:property value="submitterId"/></td>
                        <td><s:property value="entries.get(0).possibility"/></td>
                        <td><s:property value="entries.get(0).influence"/></td>
                        </tr>
                        </s:iterator>
                       
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
            <div class="col-md-12 col-sm-12 col-xs-12">
              <!--processing risks-->
              <div class="x_panel">
                <div class="row x_title">
                  <div class="col-md-6">
                    <h3>Processing Risks Overview</h3>
                  </div>
                </div>
                <div class="x_content">
                  <table id="processing-datatable" class="table table-hover table-striped table-bordered">
                    <thead>
                      <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Creator Name</th>
                        <th>Possibility</th>
                        <th>Influence Level</th>
                      </tr>
                    </thead>
                    <tbody>
                    	<s:iterator value="riskOfProcessing">
                        <tr style="cursor: pointer;">
                        <td><s:property value="id"/></td>
                        <td><a href="manager_see_processing.html"><s:property value="title"/></a></td>
                        <td><s:property value="submitterId"/></td>
                        <td><s:property value="entries.get(0).possibility"/></td>
                        <td><s:property value="entries.get(0).influence"/></td>
                        </tr>
                        </s:iterator>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>

            <div class="col-md-12 col-sm-12 col-xs-12">
              <!--processing risks-->
              <div class="x_panel">
                <div class="row x_title">
                  <div class="col-md-6">
                    <h3>Closed Risks Overview</h3>
                  </div>
                </div>
                <div class="x_content">
                  <table id="closed-datatable" class="table table-hover table-striped table-bordered">
                    <thead>
                      <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Creator Name</th>
                        <th>Possibility</th>
                        <th>Influence Level</th>
                      </tr>
                    </thead>
                    <tbody>
                    
                    	<s:iterator value="riskOfclosed">
                        <tr style="cursor: pointer;">
                        <td><s:property value="id"/></td>
                        <td><a href="manager_see_closed.html"><s:property value="title"/></a></td>
                        <td><s:property value="submitterId"/></td>
                        <td><s:property value="entries.get(0).possibility"/></td>
                        <td><s:property value="entries.get(0).influence"/></td>
                        </tr>
                        </s:iterator>
               
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
		<div class="modal fade" id="add-developer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title">New Risk</h4>
		            </div>
		            <div class="modal-body">
	        			<form class="form-horizontal form-label-left" action="/DevOpsProject/Manager/createRisk">
		        			        <div class="form-group">
		                      <label class="control-label col-md-2 col-sm-2 col-xs-12">Title</label>
		                      <div class="col-md-9 col-sm-9 col-xs-12">
		                        <input type="text" class="form-control" placeholder="Title" name="title">
		                      </div>
		                      </div>
                          <div class="form-group">
                            <label class="control-label col-md-2 col-sm-2 col-xs-12">Context
                            </label>
                            <div class="col-md-9 col-sm-9 col-xs-12">
                              <textarea class="form-control" rows="3" placeholder='Risk context...' name="context"></textarea>
                            </div>
                          </div>
		                      <div class="form-group">
		                      <label class="control-label col-md-2 col-sm-2 col-xs-12">Possibility</label>
		                        <div class="col-md-9 col-sm-9 col-xs-12">
                              <div class="row radio">
                                <div class="col-md-3">
                                  <label>
                                  <input type="radio" class="flat" checked name="possibility" value="0"> Low
                                  </label>
                                </div>
                                <div class="col-md-3">
                                  <label>
                                  <input type="radio" class="flat" checked name="possibility" value="1"> Middle
                                  </label>
                                </div>
                                <div class="col-md-3">
                                  <label>
                                  <input type="radio" class="flat" checked name="possibility" value="2"> High
                                  </label>
                                </div>
                              </div>
		                      	</div>
		                      </div>
                          <div class="form-group">
                            <label class="control-label col-md-2 col-sm-2 col-xs-12">Influence Level</label>
                            <div class="col-md-9 col-sm-9 col-xs-12">
                                <select class="form-control" name="influenceLevel">
                                  <option value="0">0</option>
                                  <option value="1">1</option>
                                  <option value="2">2</option>
                                </select>
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="control-label col-md-2 col-sm-2 col-xs-12">Trigger / Threshold</label>
                            <div class="col-md-9 col-sm-9 col-xs-12">
                              <textarea class="form-control" rows="3" placeholder='Trigger...' name="threshold"></textarea>
                            </div>
                          </div>
							  <div class="ln_solid"></div>
							  <div class="col-md-offset-10">
		                      <button type="submit" class="btn btn-success">Submit</button>
		                      </div>
	        			</form>
		            </div>
		            
		        </div>
		    </div>
		</div>

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