<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html >
<html>
<head>
<title>Account Details</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="css/plugins/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
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

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
<script src="PagingJS.js"></script>


</head>


<body style="background-color: white;">
<%
String s= request.getParameter("a");
pageContext.setAttribute("abc", s);
String newaccounturl="CreateNewAccount.jsp?a="+s;

%>
	<sql:setDataSource var="myDS" driver="oracle.jdbc.driver.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:XE" user="team4"
		password="team4" />

	<sql:query var="listUsers" dataSource="${myDS}">
        SELECT * FROM AccountData where st='active' and customer_id= '<c:out value="${abc}"/>'
    </sql:query>
	<div class="container">
		<div class="row">
			<a href="UserHome.jsp">	<img  class="pull" width="80px" src="banklogo.png" /> </a><span
				style="color: black; font-size: 30px; margin: 0px 20px;" class=""><strong>INFINITY
					BANK</strong></span>
			<hr>

			<a href="logout.jsp"
				class="btn btn-default btn-sm pull-right glyphicon glyphicon-log-out"
				role="button"> Logout</a> <a href=<%=newaccounturl%>
				class="btn btn-default btn-sm pull-right glyphicon glyphicon-star-empty"
				role="button" style="margin: 0px 5px"> New Account</a>
			<h3>
				<i class="fa fa-fw fa-dashboard"></i>User Dashboard<small
					style="margin: 0px 10px;">Account Details</small>
			</h3>
			<br>
		</div>
	</div>


	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<input class="center-block"
					style="width: 100%; border-radius: 10px; padding: 6px 10px; border: 1px solid black;"
					type="text" id="myInput" onkeyup="myFunction()"
					placeholder="Search using Account Number..." title="Type in a name"><br>
				<div class="table-responsive">
				
					<table class="table table-bordred table-striped table-hover">
						<thead>
							<tr class="header">
								<th></th>
								<th>Account Number</th>
								<th>customer ID</th>
								<th>Account Type</th>
								<th>Balance</th>
								<th>OverDraft</th>
								<th></th>
							</tr>
						</thead>
						<tbody id="myTable">

							<c:forEach var="user" items="${listUsers.rows}">
								<tr>
									<td></td>
									<td><c:out value="${user.account_number}" /></td>
									<td><c:out value="${user.customer_id}" /></td>
									<td><c:out value="${user.account_type}" /></td>
									<td><c:out value="${user.balance}" /></td>
									<td><c:out value="${user.od}" /></td>

									<td align="center">
									  <form action="DeleteAccountServlet" method="post" >
										<p data-placement="top"
											data-toggle="tooltip" title="Edit">
											
										 
											<input class="btn btn-primary btn-sm"  type="submit" value="Close"  />
											<input type="hidden" value='<c:out value="${user.customer_id}" />' name="hf2" > 
											<input type="hidden" value='<c:out value="${user.account_number}"/>' name="account_number" >
											
										</p>
									  </form>
										
									</td>
									<td align="center"></td>
									
								</tr>

							</c:forEach>


						</tbody>
					</table>
				

				</div>
				<div class="col-md-12 text-right">
					<ul class="pagination pagination-sm pager" id="myPager"></ul>
				</div>
			</div>
		</div>
	</div>









</body>


</html>