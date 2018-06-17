<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<title>User Login</title>
</head>

<body  style="background-color:white;">
<br>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
			
			
				<form action="LoginServlet" method="post" class="form-horizontal" role="form" >
				<div class="get-in-touch">
					<img class="center-block" width="200px" src="banklogo.png"/><br>
					<h1 class="text-center"><span style="color:black;"><strong>INFINITY BANK</strong></span></h1>
					<br/><br/>
					<div class="form-group">
						<label class="col-sm-2 control-label">User name</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="txtUsernane" name="un" required="required" >
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="txtPassword" name="pw" placeholder="************" required="required">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<!--<a href="userdash.html" class="btn btn-danger center-block" role="button">Sign in</a> -->
							<input type="submit"  class="btn btn-danger center-block" value="Submit">
						</div>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>

</body>



</html>
