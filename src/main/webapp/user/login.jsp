<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet" />
		<link href='http://fonts.googleapis.com/css?family=Abel|Open+Sans:400,600' rel='stylesheet'>
		<style>
			html{
				background:url(${pageContext.request.contextPath}/img/bg1.jpg) no-repeat center fixed;
				-webkit-background-size: cover;
				-moz-background-size: cover;
				-o-background-size: cover;
				background-size: cover;
			}
			h1 {
				font-family : "Abel",Arial,sans-serif;
				font-weight: 400;
				font-size: 40px;
			}
			body{
				padding-top: 20px;
				font-size: 16px;
				font-family: "Open Sans",serif;
				background: transparent;
			}
			.panel {
				background-color: rgba(255,255,255,0.5);
			}
			.margin-base-vertical{
				margin: 40px 0;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-8 panel panel-default">
					<h1 class="margin-base-vertical">Software Risk Management</h1>
					<h4>
						Managed Risks, Better Product.
					</h4>
					 <form action="/DevOpsProject/User/verify" method="post" class="margin-base-vertical">
						<p class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></span>
							<input type="email" class="form-control input-lg" name="email" placeholder="username@risk.org" />
						</p>
						<p class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></span>
							<input type="password" class="form-control input-lg" name="password" placeholder="password" />
						</p>
						<p class="text-center">
							<button type="submit" class="btn btn-success btn-lg">Sign in</button>
							<a class="btn btn-primary btn-lg" href= "/DessertHouse/User/getRegister">Sign up</a>
						</p>
					</form> 
				</div>
			</div>
		</div>		
	</body>
</html>