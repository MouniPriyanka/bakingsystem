<%@ page language="java" import="com.Model.GeneratestmtBean"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>view Statements</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="css/plugins/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

</head>

<body style="background-color: white;">

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="#" class="navbar-brand">view statements </a>
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


		<!-- /.navbar-collapse --> </nav>
		<!-- middle part -->
		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<img src="banklogo.png" width="100ox" class="center-block"
							style="padding: 10px 0px 0px 0px;"></img>
						<h1 class="text-center">INFINITY BANK</h1>
					</div>
					<div class="col-lg-12">
						<ol class="breadcrumb">
							<li class="active">
								<h3 style="color: black">
									<i class="fa fa-dashboard"></i> View Statements
								</h3>
							</li>
						</ol>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="fa fa-money fa-fw"></i> Generate Statements
						</h3>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th>TRANSACTION ID</th>
										<th>DATE</th>
										<th>TYPE</th>
										<th>NARRATION</th>
										<th>AMOUNT</th>
										<th>RECEPIENT ACCOUNT</th>
									</tr>
								</thead>
								<tbody id="myTable">
									<%
										List<GeneratestmtBean> customersList = (List<GeneratestmtBean>) session.getAttribute("Genstsession");
										for (GeneratestmtBean bean : customersList) {
									%>

									<tr>
										<td><%=bean.getcheckno()%></td>
										<td><%=bean.getdate()%></td>
										<td><%=bean.gettype()%></td>
										<td><%=bean.getnarration()%></td>
										<td><%=bean.getamount()%></td>
										<td><%=bean.getToaccount()%></td>
									</tr>

									<%
										}
									%>

								</tbody>
							</table>
						</div>
						<div class="col-md-12 text-right">
							<ul class="pagination pagination-sm pager" id="myPager"></ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer>
	<div class="container">
		<div class="row">
			<div class="col-lg-12 ">
				<p class="copyright text-center text-muted small">&copy;
					Infinity Bank & Co. 2017. All Rights Reserved</p>
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
	
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
<script src="js/paging.js"></script>



	<script>
		$("#profile_name")[0].innerHTML = ""
	</script>
</body>
</html>