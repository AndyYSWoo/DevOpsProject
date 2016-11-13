<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	  <!-- Meta, title, CSS, favicons, etc. -->
	  <meta charset="utf-8">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	
	  <title> Active Users Overview </title>
	
	  <!-- Bootstrap core CSS -->
	
	  <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	  <link href='http://fonts.googleapis.com/css?family=Abel|Open+Sans:400,600' rel='stylesheet'>
	  <link href="${pageContext.request.contextPath}/font/admin//css/font-awesome.min.css" rel="stylesheet">
	  <link href="${pageContext.request.contextPath}/css/admin/animate.min.css" rel="stylesheet">
	
	  <link href="${pageContext.request.contextPath}/css/admin/select/select2.min.css" rel="stylesheet">
	  <!-- Custom styling plus plugins -->
	  <link href="${pageContext.request.contextPath}/css/admin/custom.css" rel="stylesheet">
	  <link href="${pageContext.request.contextPath}/css/admin/icheck/flat/green.css" rel="stylesheet">
	
	  <script src="${pageContext.request.contextPath}/js/jquery_min.js"></script>
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
              <img src="${pageContext.request.contextPath}/img/user_normal.png" alt="..." class="img-circle profile_img">
            </div>
            <div class="profile_info">
              <span>Welcome,</span>
              <h2>Admin</h2>
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
                    <li><a href="#">Overview</a>
                    </li>
                    <li><a href="user_reactive.html">Reactive User</a>
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
                  <img src="${pageContext.request.contextPath}/img/user_normal.png" alt="">Admin
                  <span class=" fa fa-angle-down"></span>
                </a>
                <ul class="dropdown-menu dropdown-usermenu pull-right">
                  <li><a href="/DevOpsProject/User/logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
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
                    <h3>Active Users Overview</h3>
                  </div>
                  <div class="col-md-offset-4 col-md-2" style="padding-top: 1%;">
                  	<a id="add-user" href="#" data-toggle="modal" data-target="#add-developer">
                        <i class="fa fa-plus"></i> Add User
                    </a>
                  </div>
                </div>
                <div class="x_content">
                  <table id="user-datatable" class="table table-striped table-bordered">
                    <thead>
                      <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>E-mail</th>
                        <th>Role</th>
                        <th></th>
                      </tr>
                    </thead>
                    <tbody>
                      <s:iterator value="users">
                      	<tr>
	                      	<td>
	                      		<s:property value="id"/>
	                      	</td>
	                    	<td>
	                      		<s:property value="name"/>
	                      	</td>
	                      	<td>
	                      		<s:property value="email"/>
	                      	</td>
	                      	<td>
	                      		<s:if test="%{role==0}">Manager</s:if>
	                      		<s:else>Developer</s:else>
	                      	</td>
	                      	<td style="text-align: center;">
	                      	<form id="disable<s:property value="id"/>" action="/DevOpsProject/Admin/disable" method="post">
	                      		<input type="hidden" name="userIdToDisable" id="userIdToDisable" value="<s:property value="id"/>"/>
	                      	</form>
	                      	<a href="#" onclick="document.getElementById('disable<s:property value="id"/>').submit();return false">Disable</a>
	                      	</td>
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
		                <h4 class="modal-title">Add User</h4>
		            </div>
		            <div class="modal-body">
	        			<form action="/DevOpsProject/Admin/addUser" method="post" class="form-horizontal form-label-left">
		        			  <div class="form-group">
		                      <label class="control-label col-md-2 col-sm-2 col-xs-12">Name</label>
		                      <div class="col-md-9 col-sm-9 col-xs-12">
		                        <input type="text" class="form-control" placeholder="Name" name="nameToAdd">
		                      </div>
		                      </div>
		                      <div class="form-group">
		                      <label class="control-label col-md-2 col-sm-2 col-xs-12">E-mail</label>
		                      <div class="col-md-9 col-sm-9 col-xs-12">
		                        <input type="email" class="form-control" placeholder="E-mail" name="emailToAdd">
		                      </div>
		                      </div>
		                      <div class="form-group">
		                      <label class="control-label col-md-2 col-sm-2 col-xs-12">Password</label>
		                      <div class="col-md-9 col-sm-9 col-xs-12">
		                        <input type="password" class="form-control" placeholder="******" name="passwordToAdd">
		                      </div>
		                      </div>
		                      <div class="form-group">
		                      <label class="control-label col-md-2 col-sm-2 col-xs-12">Role</label>
		                        <div class="col-md-9 col-sm-9 col-xs-12">
			                        <div class="radio">
			                          <label>
			                            <input type="radio" class="flat" checked name="roleToAdd" value="1"> Developer
			                          </label>
			                        </div>
			                        <div class="radio">
			                          <label>
			                            <input type="radio" class="flat" name="roleToAdd" value="0"> Project Manager
			                          </label>
			                        </div>
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


  <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>

  <!-- bootstrap progress js -->
  <!-- icheck -->
  <script src="${pageContext.request.contextPath}/js/admin/icheck/icheck.min.js"></script>

  <script src="${pageContext.request.contextPath}/js/admin/custom.js"></script>

  <!-- pace -->
  <script src="${pageContext.request.contextPath}/js/admin/pace/pace.min.js"></script>

  <!-- Datatables-->
  <script src="${pageContext.request.contextPath}/js/admin/datatables/jquery.dataTables.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/admin/datatables/dataTables.bootstrap.js"></script>
  <script src="${pageContext.request.contextPath}/js/admin/datatables/dataTables.buttons.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/admin/datatables/dataTables.fixedHeader.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/admin/datatables/dataTables.scroller.min.js"></script>

  <script type="text/javascript">
      $(document).ready(function() {
        var table = $('#user-datatable').DataTable();
      });
  </script>

  <!-- /datepicker -->
        <script src="${pageContext.request.contextPath}/js/highcharts/highcharts.js"></script>
        <script src="${pageContext.request.contextPath}/js/highcharts/modules/data.js"></script>
        <script src="${pageContext.request.contextPath}/js/highcharts/modules/drilldown.js"></script>
</body>
</html>