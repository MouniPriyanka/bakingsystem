<%@ page language="java" import="com.Model.Beneficiary" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    -<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Beneficiary</title>
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
<form method="post" action="DeleteBeneficiary" >
	
	<div id="wrapper">
		
        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
				<p class="imgpadding"><img style="padding: 10px 10px 0px 10px;" alt="ggg" src="wells-fargo-logo.jpg" width="235px" height="40px" ></p>
            </div>
			
			
			
			<!-- Top Menu Items -->
				<ul class="nav navbar-right top-nav">
				
				<li>
					<a href="AccountController"><i class="fa fa-fw fa-user"></i><span id="profile_name"> </span></a>	
				</li>
				<li>
					<a href="logOut.jsp" ><i class="fa fa-fw fa-power-off"></i> Log Out</a>	
				</li>
			</ul>
				<div class="collapse navbar-collapse navbar-ex1-collapse" >
                <ul class="nav navbar-nav side-nav">
                   <li class="active">
                       <a href="Dashboard.jsp"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                    </li>
					<li>
                        <a href="Generatestmtjsp.jsp"><i class="fa fa-fw fa-file"></i> generate Statements</a>
                    </li>
					<li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo1"><i class="fa fa-fw fa-arrows-v"></i> Transfer Funds <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo1" class="collapse">
                            <li>
                                <a href="fundtransferjsp.jsp">To Self</a>
                            </li>
                            <li>
                                <a href="fundsTransfer.jsp">To Others</a>
                            </li>
                        </ul>
                    </li>
					<li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo2"><i class="fa fa-fw fa-wrench"></i> Manage Beneficiary<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo2" class="collapse">
                            <li>
                                <a href="addBeneficiary.jsp">Add Beneficiary</a>
                            </li>
                           <li>
                            <a href="Select">Delete Beneficiary</a>
                               
                            </li>
							<li>
                                <a href="successful.jsp">See all Beneficiary</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
			
		<!-- /.navbar-collapse -->
       </nav>
	   
	   <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Manage Beneficiary <small>Delete Beneficiary</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> Delete Beneficiary
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
                        <div class="alert alert-info alert-dismissable">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <i class="fa fa-info-circle"></i> some warning message!
                        </div>
                    </div>
                </div>
                <!-- /.row -->
               
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-money fa-fw"></i> Beneficiary List</h3>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                            <tr>
												<th></th>
												<th>Beneficiary Name</th>
                                                <th>Account Number</th>
                                                <th>Nick Name</th>
                                                <th>Branch Code</th>
                                                <th>Bank Name</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            
<% List<Beneficiary> customersList =(List<Beneficiary>) session.getAttribute("beneficiaryList"); 

for(Beneficiary beneficiary : customersList) {
	%>
			
			<!--  <tr><th colspan="8">Bookflick Registered Users</th></tr>-->
		
		
	<tr><td><input type = "checkbox" name="user" value=<%=beneficiary.getNickName()%>><td><%=beneficiary.getBeneficiaryName() %></td><td><%=beneficiary.getAccountNumber() %></td><td><%=beneficiary.getNickName() %></td><td><%=beneficiary.getBranchCode()%></td><td><%=beneficiary.getBankName()%></td></tr>
	
	
	
<% }

%>							
			
			
	 




                                        </tbody>
                                    </table>
									<div>
										<input type="Submit" id="button" class="btn btn-primary btn-lg btn-block login-button">
									</div>
                                </div>
								
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="js/plugins/morris/raphael.min.js"></script>
    <script src="js/plugins/morris/morris.min.js"></script>
    <script src="js/plugins/morris/morris-data.js"></script>
<script>
$("#profile_name")[0].innerHTML = ""
</script>

</form>


</body>
</html>