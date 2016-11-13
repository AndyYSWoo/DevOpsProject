<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="cn.edu.nju.se.DevOpsProject.model.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Follower Home</title>

<!-- Bootstrap core CSS -->

<link href="../css/bootstrap.min.css" rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Abel|Open+Sans:400,600'
	rel='stylesheet'>
<link href="../font/admin//css/font-awesome.min.css" rel="stylesheet">
<link href="../css/admin/animate.min.css" rel="stylesheet">

<link href="../css/admin/select/select2.min.css" rel="stylesheet">
<!-- Custom styling plus plugins -->
<link href="../css/admin/custom.css" rel="stylesheet">
<link href="../css/admin/icheck/flat/green.css" rel="stylesheet">

<script src="../js/jquery_min.js"></script>
<style type="text/css">
body {
	font-family: "Open Sans", serif;
}
</style>
</head>
<%
	//RiskEntry lastEntry = (RiskEntry)request.getAttribute("lastEntry");
%>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="color: white;">
						<h3 class="site_title margin-base-vertical">Software Risk
							Management</h3>
					</div>
					<div class="clearfix"></div>
					<!-- menu prile quick info -->
					<div class="profile">
						<div class="profile_pic">
							<img src="../img/user_normal.png" alt="..."
								class="img-circle profile_img">
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
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<ul class="nav side-menu">
								<li><a><i class="fa fa-home"></i> User <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu" style="display: none">
										<li><a href="home">Followed Risk</a></li>
										<li><a href="closedRisk">Closed Risk</a></li>
									</ul></li>
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
						<li class=""><a href="javascript:;"
							class="user-profile dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false"> <img src="../img/user_normal.png"
								alt="">
							<s:property value="user.name" /> <span class=" fa fa-angle-down"></span>
						</a>
							<ul class="dropdown-menu dropdown-usermenu pull-right">
								<li><a href="../User/logout"><i
										class="fa fa-sign-out pull-right"></i> Log Out</a></li>
							</ul></li>
					</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main" style="min-height: 1000px">

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
										<li><span class="name"> Possibility </span> 
											<span id="possibility" class="value text-success"
											><s:if test="%{lastEntry.possibility==0}">Low</s:if
											><s:elseif test="%{lastEntry.possibility==1}">Medium</s:elseif
											><s:else>High</s:else></span>
										</li>
										<li><span class="name"> Influence </span> 
											<span id="influence" class="value text-success"
											><s:if test="%{lastEntry.influence==0}">Low</s:if
											><s:elseif test="%{lastEntry.influence==1}">Medium</s:elseif
											><s:else>High</s:else></span>
										</li>
										<li class="hidden-phone"><span class="name">
												status </span> 
											<span id="stata" class="value text-success"
											><s:if test="%{lastEntry.status==0}">Unassigned</s:if
											><s:elseif test="%{lastEntry.status==1}">Processing</s:elseif
											><s:else>Closed</s:else></span>
										</li>
									</ul>
									<div>
										<h3 id="title" class="heading">${risk.title}</h3>
										<p id="content">${risk.content}</p>
										<h4 id="threshold" class="heading">Threshold</h4>
										<p id="threshold">${lastEntry.threshold.content}</p>
										<h4 class="description">Description</h4>
										<p id="description">${lastEntry.description.content }</p>
									</div>


									<h4>Recent Activity</h4>
									
									<div class="col-md-offset-10 col-md-2" 
									style="padding-top: 1%;display:<s:if test='%{lastEntry.status==2}'>none</s:if>
										<s:else>block</s:else>"
										>									
										<a id="add-user" href="javascript:addEntry()" data-toggle="amodal"
											data-target="#aupdate-risk"> <i class="fa fa-plus"></i>
											Update Risk
										</a>
									</div>

									<!--update risk form-->

									<table class="table table-striped">
										<tr>
											<th width="160px">Date</th>
											<th>Possibility</th>
											<th>Influence</th>
											<th min-width="160px">Threshold</th>
											<th>Description</th>
											<th>Follower</th>
										</tr>
										<s:iterator value="entryList">
											<tr>
												<td><s:property value="createdTime" /></td>
												<td><s:if test="%{possibility==0}">low</s:if>
													<s:elseif test="%{possibility==1}">medium</s:elseif>
													<s:else>high</s:else></td>

												<td><s:if test="%{influence==0}">low</s:if>
													<s:elseif test="%{influence==1}">medium</s:elseif>
													<s:else>high</s:else></td>

												<td><s:property value="threshold.content" /></td>
												<td><s:property value="description.content" /></td>
												<td><s:property value="changer.name" /></td>
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
													<img src="../img/user_normal.png" alt="..."
														class="img-circle profile_img">
												</div>
												<div class="profile_info">
													<span>${submitter.name}</span>

												</div>
											</div>
											<div class="clearfix"></div>
											<h4>Follower</h4>
											<s:iterator value="followerList">
												<div class="profile">
													<div class="profile_pic">
														<img src="../img/user_normal.png" alt="..."
															class="img-circle profile_img">
													</div>
													<div class="profile_info">
														<span><s:property value="name" /></span>
													</div>
												</div>
											</s:iterator>

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

		</div>
		<!--add developer form-->

		<!-- /page content -->
		<!-- footer content -->
		<!-- /footer content -->

	</div>

	</div>

	<div class="modal fade" id="update-risk" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">Update risk status</h4>
				</div>
				<div class="modal-body">
					<form action="addEntry" method="post" class="form-horizontal form-label-left">
						<input style="display:none" name="status" value="<s:property value='lastEntry.status'/>">
						<input style="display:none" name="riskId" value="<s:property value='risk.id'/>">
						<div id="possibility" class="form-group">
							<label class="control-label col-md-2 col-sm-2 col-xs-12">Possibility</label>
							<div  class="col-md-9 col-sm-9 col-xs-12">
								<div class="radio">
									<label> <input type="radio" class="flat" checked
										name="possibility" value=0> Low
									</label>
								</div>
								<div class="radio">
									<label> <input type="radio" class="flat"
										name="possibility" value=1> Medium
									</label>
								</div>
								<div class="radio">
									<label> <input type="radio" class="flat"
										name="possibility" value=2> High
									</label>
								</div>
							</div>
						</div>
						<div id="influence" class="form-group">
							<label class="control-label col-md-2 col-sm-2 col-xs-12">Influence</label>
							<div class="col-md-9 col-sm-9 col-xs-12">
								<div class="radio">
									<label> <input type="radio" class="flat" checked
										name="influence" value=0> Low
									</label>
								</div>
								<div class="radio">
									<label> <input type="radio" class="flat"
										name="influence" value=1> Medium
									</label>
								</div>
								<div class="radio">
									<label> <input type="radio" class="flat"
										name="influence" value=2> High
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2 col-sm-2 col-xs-12">Threshold</label>
							<div class="col-md-9 col-sm-9 col-xs-12">
								<input id="threshold" type="text" class="form-control"
									value="Original Threshold" name="name">
								
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2 col-sm-2 col-xs-12">Description</label>
							<div class="col-md-9 col-sm-9 col-xs-12">
								<textarea id="description" type="email" class="form-control"
									value="Original Description" name="description">
                                              </textarea>
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
		function addEntry() {
			var	possibility = $(".x_panel #possibility").text();
			var influence = $(".x_panel #influence").text();
			var threshold = $(".x_panel #threshold").text();
			var description = $(".x_panel #description").text();
			var pos_value = 0;
			var des_value = 0;
			switch(possibility){
			case "Low":
				pos_value=0;
				break;
			case "Medium":
				pos_value=1;
				break;
			case "High":
				pos_value=2;
				break;
			}
			switch(influence){
			case "Low":
				des_value = 0;
				break;
			case "Medium":
				des_value = 1;
				break;
			case "High":
				des_value = 2;
				break;
			}
			var des_str = "#update-risk #influence input[value="+des_value+"]";
			var ops_str = "#update-risk #possibility input[value="+pos_value+"]";
			$(des_str).parent().click();
			$(ops_str).parent().click();
			$("#update-risk #threshold").val(threshold);
			$("#update-risk #description").text(description);
			$("#update-risk").modal("show");
		}
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