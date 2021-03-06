<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
    <%
	ResultSet rs = null;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Generate Statements</title>

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
				<a href="#"  class="navbar-brand">Generate Statements</a>
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
                        <a href="#"><i class="fa fa-fw fa-file"></i> generate Statements</a>
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
					 <div class="col-lg-12">
                        <ol class="breadcrumb">
                            <li class="active">
                                <h3 style="color:black"><i class="fa fa-dashboard"></i> Account Statements</h3>
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="container">
									<div class="row main">
										<div class="main-login main-center">
											<form id="myform" name="myform" action="./generatestatementserv" method="post" >
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
				rs = statement.executeQuery(q);
%>

											<div class="col-xs-11">
												<div class="form-group">
													<label class="cols-sm-2 control-label">From Account</label>
													
													<div class="cols-sm-10">
														<div class="input-group">
																<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
																<select id="fromaccount" name="fromaccount" class="form-control">
																 <%
		   while (rs.next()) {
			%>
		   <option><%=rs.getString("account_number")%></option>
		   <% 
		   }
		   %>
		   <% 
}catch (Exception e) {
	out.println("wrong entry" + e);
} finally {
}
   %>
																</select>
														</div>
													</div>
												</div>
												
												<div class="form-group">
													<label class="cols-sm-2 control-label"></label>
													<div class="cols-sm-10">
														<div class="input-group">
																	<br><br>
																	<input type="radio" name="transway"  value="dateway" onclick='findselected1()'/>
																		<label class="cols-sm-2 control-label" style="padding: 7px;"> From : </label> 
																	<input type='date' name='fromdate'  id='fromdate' disabled>
																		<label class="cols-sm-2 control-label" style="padding: 10px;"> To : </label> 
																	<input type='date' name='todate' id='todate' disabled >
																	<br><br><br>
																	<input type="radio" name="transway"  value="lastway" onclick='findselected2()'/>
																		<label class="cols-sm-2 control-label" style="padding: 7px;">view</label> 
																	  <select name="lasttrans" id="lasttrans" disabled >
																		<option  value="10" >Last 10 transactions</option>
																		<option  value="20" >Last 20 transactions</option>
																	</select>
																	<br><br>													
														</div>
													</div>
												</div>
												<div>
													<input type='submit' name='viewstatements' class="btn btn-primary btn-lg btn-block login-button" value="View Statement">
												</div>
											</div>
										</form>
										</div>
									</div>
								</div>
							<div class="text-right">
								<br></br>
								<a href="generatestatement.html">View previous transaction details <i class="fa fa-arrow-circle-right"></i></a>
							</div>
								
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
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
<script>
function findselected1(){
	
	 document.getElementById("fromdate").disabled = false;
	 document.getElementById("todate").disabled = false;
	 document.getElementById("lasttrans").disabled = true;
	}
function findselected2(){

	 document.getElementById("fromdate").disabled = true;
	 document.getElementById("todate").disabled = true;
	 document.getElementById("lasttrans").disabled = false;
	
	}
	
	    
</script>



</body></html>