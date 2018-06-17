<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true" errorPage="error.jsp"%>
<%@ page import="java.sql.*"%>
<%
	ResultSet resultset = null;
%>
<%
	ResultSet resultset1 = null;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Transfer Funds</title>

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
			<a href="#" class="navbar-brand"> Transfer Funds</a>
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
                                <a href="#">To Self</a>
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
						<img src="banklogo.png" width="100px" class="center-block"
							style="padding: 10px 0px 0px 0px;"></img>
						<h1 class="text-center">INFINITY BANK</h1>
					</div>
					<div class="col-lg-12">
						<ol class="breadcrumb">
							<li class="active">
								<h3 style="color: black">
									<i class="fa fa-dashboard"></i> Transfer to Self Account
								</h3>
							</li>
						</ol>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="alert alert-info alert-dismissable">
							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">&times;</button>
							<i class="fa fa-info-circle"></i> Minimum balance of 5000$ in all
							accounts is obligatory!
						</div>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="fa fa-money fa-fw"></i> Transfer Details
						</h3>
					</div>
					<form name="myform" action="./fundtransferserv" method="post" onSubmit="return validation(this)">
						<%
							try {
								Class.forName("oracle.jdbc.driver.OracleDriver");
								Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.7:1521:XE", "team4",
										"team4");

								Statement statement = connection.createStatement();

								String cid = (session.getAttribute("customerid")).toString();
                                 System.out.println(cid);
                                 String q="select account_number from accountdata where customer_id='"+cid+"'";
                                 System.out.println(q);
								resultset = statement.executeQuery(q);
						%>
						<div class="panel-body">
							<div class="container">
								<div class="row main">
									<div class="main-login main-center">
									
											<div class="col-xs-11">
												<div class="form-group">
													<label class="cols-sm-2 control-label">Transfer
														From</label>
													<div class="cols-sm-10">
														<div class="input-group">
															<span class="input-group-addon"><i
																class="fa fa-bank" aria-hidden="true"></i></span> <select
																id="fromaccount" name="fromaccount" class="form-control">
																<%
																	while (resultset.next()) {
																%>
																<option><%=resultset.getString("account_number")%></option>
																<%
																	}
																%>
															</select><br>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="cols-sm-2 control-label">Transfer To</label>
													<div class="cols-sm-10">
														<div class="input-group">
															<span class="input-group-addon"><i
																class="fa fa-bank" aria-hidden="true"></i></span> <select
																id="toaccount" name="toaccount" class="form-control">
																<%
											
																	resultset1 = statement.executeQuery("select account_number from accountdata where customer_id='"+cid+"'");
																	
																		while (resultset1.next()) {
																%>
																<option><%=resultset1.getString("account_number")%></option>
																<%
																	}
																%>
															</select><br>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="cols-sm-2 control-label">Amount</label>
													<div class="cols-sm-10">
														<div class="input-group">
															<span class="input-group-addon"><i
																class="fa fa-money" aria-hidden="true"></i></span> <input
																type="number" class="form-control " name="amount"
																id="amount" placeholder="Amount" required>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="cols-sm-2 control-label">Bank Name</label>
													<div class="cols-sm-10">
														<div class="input-group">
															<span class="input-group-addon"><i
																class="fa fa-bank" aria-hidden="true"></i></span> <input
																class="form-control" type="text"
																placeholder="INFINITY BANK" readonly>
														</div>
													</div>
												</div>
												<div>
													<input type="submit" value="Transfer"
														class="btn btn-primary btn-lg btn-block login-button" ></input>
												</div>
											</div>
											</div>
											</div>
											</div>
											</div>
											
										</form>
									</div>
								</div>
							</div>
						</div>
						<%
							//**Should I input the codes here?**
							} catch (Exception e) {
								out.println("wrong entry" + e);
							} finally {

							}
						%>
					
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
			<script>
				$("#profile_name")[0].innerHTML = ""
			</script>

			<script type="text/javascript">
				$(".form_datetime").datetimepicker({
					format : "dd MM yyyy",
					autoclose : true,
					todayBtn : true,
					pickerPosition : "bottom-left"
				});
				</script>
				<script type="text/javascript">
				function validation(){
					 System.out.println("hi");
				 var x = document.forms["myform"]["fromaccount"].value;
				 var x = document.forms["myform"]["toaccount"].value;
				 System.out.println(x);
				 System.out.println(y);
				    if (x.match(y)) {
				        alert("username cannot be empty..!!");
				        return false;
				    }
				}
			</script>
</body>
</html>