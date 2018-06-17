<%@page import="com.Model.Account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Dashboard</title>

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
				<a href="#"  class="navbar-brand">Dashboard</a>
			
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
                       <a href="#"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
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
						<img src="banklogo.png" width="100ox" class="center-block" style="padding:10px 0px 0px 0px ;"></img>
						<h1 class="text-center"> INFINITY BANK </h1>
					</div>
					 <!-- <div class="col-lg-12"> -->
                        <!-- <ol class="breadcrumb"> -->
                            <!-- <li class="active"> -->
                                <!-- <h3 style="color:black"><i class="fa fa-dashboard"></i> Delete Beneficiary</h3> -->
                            <!-- </li> -->
                        <!-- </ol> -->
                    <!-- </div> -->
                </div>
				<br> <br> 
                <!-- /.row -->
					<%
					List<Account> accountList = (List<Account>) session.getAttribute("accountList");

					for (Account account : accountList) {
				%>

				<%
					String s = account.getAccountType();
				%>

				<div class="row">
					<div class="col-lg-12 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-money fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><%=account.getBalance()%></div>
                                        <div><%=account.getAccountType()%> Account Balance</div>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
								<div class="pull-right" style="color: #2196F3;"> Account Number <%=account.getAccountNumber()%></div>
								<br>
							</div>
                        </div>
                    </div>
                    
                    
                </div>
				<%
					}
				%>

				
                <!-- /.row -->

              

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->
		<footer>
			<div class="container">
				<div class="row">
					<div class="col-lg-12 ">
						<p class="copyright text-center text-muted small"> &copy; Infinity Bank  & Co. 2017. All Rights Reserved</p>
					</div>
				</div>
			</div>
		</footer>
    </div>
    <!-- /#wrapper -->
	   

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
</body>
</html>