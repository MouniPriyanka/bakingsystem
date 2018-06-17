<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Register New customer </title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="css/plugins/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
	
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    $(document).ready(function() {
        $.active = false;
        $('body').bind('click keypress', function() { $.active = true; });
        checkActivity(30000, 30000, 0); // timeout = 3 minutes, interval = 1 minute.
    });

    function checkActivity(timeout, interval, elapsed) {
        if ($.active) {
            elapsed = 0;
            $.active = false;
            $.get('heartbeat');
        }
        if (elapsed < timeout) {
            elapsed += interval;
            setTimeout(function() {
                checkActivity(timeout, interval, elapsed);
            }, interval);
        } else {
            window.location = 'UserLogin.jsp'; // Redirect to "session expired" page.
        }
    }
</script>
</head>


<body style="background-color: white;">
   
	<div class="container">
		<div class="row">
			<a href="UserHome.jsp">	<img  class="pull" width="80px" src="banklogo.png" /> </a><span
				style="color: black; font-size: 30px; margin: 0px 20px;" class=""><strong>INFINITY BANK</strong></span>
			<hr>

			<a href="UserLogin.jsp"
				class="btn btn-default btn-sm pull-right glyphicon glyphicon-log-out"
				role="button"> Logout</a> 
			<h3>
				<i class="fa fa-fw fa-dashboard"></i>Register New Customer <small
					style="margin: 0px 10px;"></small>
			</h3>
			<br>
		</div>
	</div>
<form action="RegisterServlet" method="post">

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<br>
				<div class="table-responsive">
				
					<table class="table table-bordred table-striped table-hover">
						<thead>
						<caption> Customer Profile </caption>
						</thead>

						<tbody id="myTable">
						
								<tr>
									<td>Name</td>	<td><input type="text" placeholder="Enter your Name here.." name="Name" required /></td>										
								</tr>
								<tr>
									<td>Gender</td>	<td><input type="text" placeholder="Female/Male/other" name="Gender" required/></td>									
								</tr>
								<tr>
									<td>DOB</td>	<td><input type="text"  placeholder="dd-MMM-yyyy" name="DOB" required/></td>									
								</tr>
								<tr>
									<td>Residence</td><td><input type="text" placeholder=""  name="Residence" required/></td>										
								</tr>
								<tr>
									<td>SSN</td><td><input type="text"  placeholder="" name="SSN" required/></td>										
								</tr>
								<tr>
									<td>Phone</td><td><input type="number" placeholder=""  name="Phone" required /></td>										
								</tr>
								<tr>
									<td>Email</td><td><input type="email" placeholder="abc@xyz.com"  name="Email" required/></td>										
								</tr>
		 
		
		 


						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
		<div class="container">
		<div class="row">
			<div class="col-md-12">
				<br>
				<div class="table-responsive">
				
					<table class="table table-bordred table-striped table-hover">
						<thead>
						<caption> Account Details </caption>
						</thead>

						<tbody id="myTable">
								<tr>
									<td>Account Type</td>	<td><input type="text" placeholder="( savings/current)"  name="AccountType" /></td>									
								</tr>
								<tr>
									<td>Branch Code</td>	<td><input type="text" placeholder="( hyd1/hyd2/hyd3)"  name="BranchCode" /> </td>									
								</tr>
								<tr>
									<td>Over draft</td>	<td><input type="text" placeholder=" ( yes/no )"  name="OverDraft" /> </td>									
								</tr>
								<tr>
									<td>Balance</td>	<td><input type="number" placeholder=""  name="Balance" /> </td>									
								</tr>
								<tr> 
			<td colspan="2" align="center"> <input type="submit" class="btn btn-primary btn-sm"  value="Register"> </td>
		</tr>
						</tbody>
		 
		
					</table>
				</div>
			</div>
		</div>
	</div>
	</form>


<script>
	function myFunction() {
		var input, filter, table, tr, td, i;
		input = document.getElementById("myInput");
		filter = input.value.toUpperCase();
		table = document.getElementById("myTable");
		tr = table.getElementsByTagName("tr");
		for (i = 0; i < tr.length; i++) {
			td = tr[i].getElementsByTagName("td")[1];
			if (td) {
				if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
					tr[i].style.display = "";
				} else {
					tr[i].style.display = "none";
				}
			}
		}
	}
</script>


<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>




</body>


</html>