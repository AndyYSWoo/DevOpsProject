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

  <title> Closed Risk </title>

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
              <ul class="nav side-menu">
                <li><a href="manager.html"><i class="fa fa-home"></i> Home </a>
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
                  <img src="../img/user_normal.png" alt="">${user.name}
                  <span class=" fa fa-angle-down"></span>
                </a>
                <ul class="dropdown-menu dropdown-usermenu pull-right">
                  <li><a href="../User/logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                  </li>
                </ul>
              </li>
            </ul>
          </nav>
        </div>
      </div>
      <!-- /top navigation -->
      
      <!-- page content -->
      <div class="right_col" role="main" style="min-height:640px">
        
        <div class="">
      <div class="page-title">
            <div class="title_left">
              <h3>Risk Detail</h3>
            </div>
      </div>
          <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="x_panel">
                  <div class="col-md-9">

                    <ul class="stats-overview">
                      <li>
                        <span class="name"> Possibility </span>

                        <span class="value text-success"> 
                        	<s:if test="%{currentRisk.entries.get(0).possibility==0}">low</s:if>
                        	<s:elseif test="%{currentRisk.entries.get(0).possibility==1}">medium</s:elseif>
                        	<s:else>high</s:else>
						</span>
                      </li>
                      <li>
                        <span class="name"> Influence </span>
                        <span class="value text-success"> 
							<s:if test="%{currentRisk.entries.get(0).influence==0}">low</s:if>
                        	<s:elseif test="%{currentRisk.entries.get(0).influence==1}">medium</s:elseif>
                        	<s:else>high</s:else>
						</span>
                      </li>
                      <li class="hidden-phone">
                        <span class="name"> status </span>
                        <span class="value text-success">
                        	<s:if test="%{currentRisk.entries.get(0).status==0}">Unassigned</s:if>
                        	<s:elseif test="%{currentRisk.entries.get(0).influence==1}">Processing</s:elseif>
                        	<s:else>closed</s:else>
						</span>
                      </li>
                    </ul>
          <div>
            <h3 class="heading">${currentRisk.title}</h3>
            <p>${currentRisk.content}</p>
            <h4 class="heading">Threshold</h4>
            <p>${currentRisk.entries.get(0).threshold.content}</p>
            <h4 class="description">Description</h4>
            <p>${currentRisk.entries.get(0).description.content}</p>
          </div>  
                    
          
                    <h4>Recent Activity</h4>
          <table class="table table-striped">
            <tr>
              <th style="width:20%;">Date</th>
              <th>Possibility</th>
              <th>Influence</th>
              <th style="width: 16%;">Threshold</th>
              <th>Description</th>
              <th>Follower</th>
            </tr>
            
            <s:iterator value="currentRisk.entries">
              <tr>
          		<td><s:property value="createdTime"/></td>
              	<td>
                        		<s:if test="%{entries.get(0).possibility==0}">low</s:if>
                        		<s:elseif test="%{entries.get(0).possibility==1}">medium</s:elseif>
                        		<s:else>high</s:else>
                </td>	
                
              	<td>
								<s:if test="%{entries.get(0).influence==0}">low</s:if>
                        		<s:elseif test="%{entries.get(0).influence==1}">medium</s:elseif>
                        		<s:else>high</s:else>
				</td>
				
              	<td><s:property value="threshold.content"/></td>
              	<td><s:property value="description.content"/></td>
              	<td><s:property value="changerId"/></td>
              </tr>
             </s:iterator>
             
          </table>
                      <!-- end of user messages -->
                      
                      <!-- end of user messages -->

                    </div>

         <div class="col-md-3 col-sm-3 col-xs-12">

                    <div class="panel">

                      <div class="x_title">
                        <h2 class="green">Group People</h2>
                        <div class="clearfix"></div>
                      </div>
            <div class="panel-body">
            <h4>Submitter</h4>
             <div class="profile">
              <div class="profile_pic">
                <img src="../img/user_normal.png" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>${user.name}</span>
                
              </div>
             </div>
             <div class="clearfix"></div>
             <h4>Follower</h4>
             <div class="profile">
              <div class="profile_pic">
                <img src="../img/user_normal.png" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>${follower.name}</span>
                
              </div>
             </div>
            </div>
                    </div>

                  </div>
                   
              </div>

                  <!-- start project-detail sidebar -->
                  <!-- end project-detail sidebar -->

        </div>
            </div>
          </div>
          
          <div class="clearfix"></div>
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