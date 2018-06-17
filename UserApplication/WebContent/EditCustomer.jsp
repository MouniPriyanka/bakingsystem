<%@ page language="java" import="editCustomer.EditCustomerBean" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
	
    <title>Edit Customer Profile </title>

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
<% EditCustomerBean currentUser =( EditCustomerBean)session.getAttribute("currentSessionUser");%>
			<div class="container">
			<div class="row">
				<a href="UserHome.jsp">	<img  class="pull" width="80px" src="banklogo.png" /> </a><span style="color:black; font-size:30px; margin: 0px 20px;" class=""><strong>INFINITY BANK</strong></span>
				<hr>
				<br>
			</div>
		</div>
			<form class="col-lg-7 col-sm-8" method="post" action="UpdateCustomerServlet">
			<div class="form-group">
					<label class="cols-sm-2 control-label">Customer ID</label>
					<input class="form-control " name="customerid" value=<%=currentUser.getCustomerID()%> type="text"   readonly>
				</div>
				<div class="form-group">
					<label class="cols-sm-2 control-label">Full Name</label>
					<input class="form-control " name="name" type="text"  value=<%=currentUser.getName()%> >
				</div>
				<div class="form-group">
					<label class="cols-sm-2 control-label">Gender</label>
					<input class="form-control " name="gender" type="text" value=<%=currentUser.getGender()%> >
				</div>
				<div class="form-group">
					<label class="cols-sm-2 control-label">Date Of Birth</label>
					<input class="form-control " name="dob" type="text" value=<%=currentUser.getDOB().toString()%>>
					
				</div>
				<div class="form-group">
					<label class="cols-sm-2 control-label">Address</label>
					<textarea rows="2" class="form-control" name="residence" ><%=currentUser.getResidence()%></textarea>        
				</div>
				<div class="form-group">
					<label class="cols-sm-2 control-label">SSN Number</label>
					<input class="form-control " type="text" name="ssn" value=<%=currentUser.getSSN()%> >
				</div>
				<div class="form-group">
					<label class="cols-sm-2 control-label">Phone Number</label>
					<input class="form-control " type="text" name="phonenumber" value=<%=currentUser.getPhonenumber()%>  >
				</div>
				<div class="form-group">
					<label class="cols-sm-2 control-label">E-mail ID</label>
					<input class="form-control " type="text" name="email" value=<%=currentUser.getEmail()%> >
				</div>
				<div>
				<input type="submit" value="Update" class="btn btn-success btn-lg" style="width:20%;"/>
				<!--   <button type="button" class="btn btn-success btn-lg" style="width:20%;"><span class="glyphicon glyphicon-ok-sign"></span> Update</button>  -->
				 </div>
				</form>
</body>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
<script src="PagingJS.js"></script>
</html>			