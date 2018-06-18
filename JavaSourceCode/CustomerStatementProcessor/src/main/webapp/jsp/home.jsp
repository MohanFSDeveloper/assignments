<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Statement Processor</title>
<script src="vendor/angular/angular.min.js" type="text/javascript"></script>
<script src="vendor/angular/angular-animate.min.js"
	type="text/javascript"></script>
<script src="vendor/angular/uigrid/ui-grid.min.js"
	type="text/javascript"></script>
<script src="vendor/jQuery/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="vendor/bootstrap/js/bootstrap.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="vendor/angular/uigrid/ui-grid.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<script src="assets/csp-main.js"></script>
<script src="assets/services/csp-services.js"></script>
<script src="assets/components/home.js"></script>
</head>
<body ng-app="csp" ng-controller="homecontroller">
	<div class="container">
		<h2 style="text-align: center;">Assignment - Customer Statement
			Processor</h2>
		<div class="row">
			<div class="col-md-5"></div>
			<div class="col-md-2">
				<button ng-click="processCustStatement()">Procees Statement</button>
			</div>
			<div class="col-md-5"></div>
		</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-5" style="font-size: 14px;">Note: Please set
				input file location in application.properties file</div>
			<div class="col-md-3"></div>
		</div>

		<div ng-if="showGrid" style="height: 377px; margin-top: 10px;"
			ui-grid="validationGrid" ui-grid-pagination class="grid"></div>

	</div>

</body>
</html>