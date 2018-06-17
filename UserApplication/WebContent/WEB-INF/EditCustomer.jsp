<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer Profile</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body style="background-color:white;">
			<div class="container">
			<div class="row">
				<img class="pull" width="80px" src="banklogo.png"/><span style="color:black; font-size:30px; margin: 0px 20px;" class=""><strong>INFINITY BANK</strong></span>
				<hr>
				<br>
			</div>
		</div>
			<form class="col-lg-7 col-sm-8" >
			<div class="form-group">
					<label class="cols-sm-2 control-label">Customer ID</label>
					<input class="form-control " type="text" placeholder="1234567" readonly>
				</div>
				<div class="form-group">
					<label class="cols-sm-2 control-label">Full Name</label>
					<input class="form-control " type="text" placeholder="Pravalika Gangidi">
				</div>
				<div class="form-group">
					<label class="cols-sm-2 control-label">Gender</label>
					<input class="form-control " type="text" placeholder="Male">
				</div>
				<div class="form-group">
					<label class="cols-sm-2 control-label">Date Of Birth</label>
					<input class="form-control " type="text" placeholder="DDMMYYYY">
				</div>
				<div class="form-group">
					<label class="cols-sm-2 control-label">Address</label>
					<textarea rows="2" class="form-control" placeholder="CB 106/107 Street # 11 Wah Cantt Islamabad Pakistan"></textarea>        
				</div>
				<div class="form-group">
					<label class="cols-sm-2 control-label">SSN Number</label>
					<input class="form-control " type="text" placeholder="SSN12345678">
				</div>
				<div class="form-group">
					<label class="cols-sm-2 control-label">Phone Number</label>
					<input class="form-control " type="text" placeholder="9999999999">
				</div>
				<div class="form-group">
					<label class="cols-sm-2 control-label">E-mail ID</label>
					<input class="form-control " type="text" placeholder="abcd@xyz.com">
				</div>
				<div>
				 <button type="button" class="btn btn-success btn-lg" style="width:20%;"><span class="glyphicon glyphicon-ok-sign"></span> Update</button> 
				 </div>
				 </form>
</body>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
<script src="PagingJS.js"></script>
</html>