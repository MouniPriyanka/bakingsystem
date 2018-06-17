<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Homepage</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/landing-page.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

</head>

<body>
    <!-- Header -->
    
    <div class="intro-header" id="Top">
        <div class="container">
			<div class="row">
                <div class="col-lg-12">
						<img class="center-block" width="250px" src="banklogo.png"/><br>
						<h1 class="text-center"><span style="color:black;"><strong>INFINITY BANK</strong></span></h1>
                        <hr class="intro-divider">
                        <ul class="list-inline intro-social-buttons">
                            <li>
                                 <a href="#Register" class="btn btn-default btn-lg"><i class="glyphicon glyphicon-star-empty"></i><span class="network-name"> New Customer</span></a>
                            </li>
                            <li>
                                
								<a href="#Login" class="btn btn-default btn-lg"><i class="fa fa-unlock"></i> <span class="network-name"> Login</span></a>
                            </li>
                            <li>
                               <a href="#Reset Password" class="btn btn-default btn-lg"><i class="glyphicon glyphicon-cog"></i> <span class="network-name"> Reset password</span></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

        </div>

    <!-- /.intro-header -->

    <!-- Page Content -->

	<div class="content-section-a" id="Register">
        <div class="container">
            <div class="row">
                <div class="col-lg-11 col-sm-6">
                    <hr class="section-heading-spacer">
					<br><br><br><br><br><br><br>
                    <div class="clearfix"></div>
					<br>
					 <div class="row">
						<div class="col-md-6 col-md-offset-7">
							<div class="panel panel-default">
								<div class="panel-heading"> <strong class="">Registration</strong></div>
									<div class="panel-body">
										<form class="form-horizontal" role="form" method="post" action="RegisterCustomerServlet">
											<div class="form-group">
												<label class="col-sm-3 control-label">  </label>
												<div class="col-sm-10">
													<input type="text" class="form-control" id="customer_id" name="customer_id" placeholder="Customer Id"  title="Please enter valid customer id" class="form-control input-md" required>
												</div>
											</div>
											<div class="form-group"> 
												<label for="inputPassword3" class="col-sm-3 control-label"> </label> 
												<div class="col-sm-10"> 
													<input type="password" class="form-control" id="createPassword" name="createPassword" placeholder="New Password" required> 
												</div> 
											</div> 
											<div class="form-group"> 
												<label for="inputPassword3" class="col-sm-3 control-label"> </label> 
												<div class="col-sm-10"> 
													<input type="password" class="form-control" id="Reenter" name="Reenter" placeholder="Re-enter New Password" required> 
												</div> 
											</div> 
											<br>
											<div class="form-group last">
												<div class="col-sm-offset-1 col-sm-10">
													<button type="submit" class="btn btn-success btn-sm" onclick="return Validate()">Register</button>
													<span style="padding-left: 5px;"></span>
													<button type="reset" class="btn btn-default btn-sm">Reset</button>
													<a href="knowCustomerId.jsp" class ="pull-right"> Know your Customer Id ? </a>
												</div>
											</div>
										</form>
									</div>
							</div>
							<button class="glyphicon glyphicon-circle-arrow-up btn btn-default btn-lg" onclick="topFunction()" id="myBtn" title="Go to top" ></button>
						</div>
					</div>
					<br><br><br><br><br><br><br>
				</div>
            </div>
        </div>
	</div>
	
    <div class="content-section-a" id="Login">
		<div class="container">
            <div class="row">
                <div class="col-lg-11 col-sm-6">
                    <hr class="section-heading-spacer">
					<br><br><br><br><br><br>
                    <div class="clearfix"></div>
						<div class="row">
							<div class="col-md-6 col-md-offset-7">
								<div class="panel panel-default">
									<div class="panel-heading"> <strong class="">Login</strong></div>
										<div class="panel-body">
											<form class="form-horizontal" role="form" method="post" action="CustomerLoginServlet">
											<div class="form-group">
												<label for="customer_id" class="col-sm-3 control-label"></label>
												<div class="col-sm-10">
													<input type="text" class="form-control" id="customer_id" name="customer_id" placeholder="Customer Id" title="Please enter valid customer id" class="form-control input-md" required>
												</div>
											</div>
											<div class="form-group">
												<label for="inputPassword3" class="col-sm-3 control-label"></label>
												<div class="col-sm-10">
													<input type="password" class="form-control" id="inputPassword3" name="inputPassword3" placeholder="Password" required>
												</div>
											</div>
											<br>
											<div class="form-group last">
												<div class="col-sm-offset-1 col-sm-10">
													<button type="submit" class="btn btn-success">Sign in</button>
													<span style="padding-left: 5px;"></span>
													<button type="reset" class="btn btn-default">Reset</button>
													<span class ="pull-right">New Customer? <a href="#Register" style="color: light-blue;"> register here</a></span>
												</div>
											</div>
										</form>
									</div>
								</div>
								<button class="glyphicon glyphicon-circle-arrow-up btn btn-default btn-lg" onclick="topFunction()" id="myBtn" title="Go to top" ></button>
							</div>
						</div>
						<br><br><br><br><br><br><br>
                </div>                 
            </div>
        </div>

    </div>



    <div class="content-section-a" id="Reset Password">
		<div class="container">
            <div class="row">
                <div class="col-lg-11 col-sm-6">
                    <hr class="section-heading-spacer">
					<br><br><br><br><br><br>
                    <div class="clearfix"></div>
						<div class="row">
							<div class="col-md-6 col-md-offset-7">
								<div class="panel panel-default">
									<div class="panel-heading"> <strong class="">Reset password</strong></div>
										<div class="panel-body">
											<form class="form-horizontal" role="form" method="post" action="ChangePasswordServlet">
											<div class="form-group">
												<label for="inputEmail3" class="col-sm-3 control-label">  </label>
												<div class="col-sm-12">
													<input type="text" class="form-control" id="customer_id" name="customer_id"placeholder="Customer Id"  title="Please enter valid customer id" class="form-control input-md" required="">
												</div>
											</div>
											<div class="form-group"> 
												 <label for="inputPassword3" class="col-sm-3 control-label"> </label> 
												 <div class="col-sm-12"> 
													 <input type="password" class="form-control" id="oldPassword" name="oldPassword" placeholder="Old Password" required=""> 
												 </div> 
											 </div> 
											 <div class="form-group"> 
												 <label for="inputPassword3" class="col-sm-3 control-label"> </label> 
												 <div class="col-sm-12"> 
													 <input type="password" class="form-control" id="newPassword" name="newPassword"placeholder="New Password" required=""> 
												 </div> 
											 </div> 
											 <div class="form-group"> 
												 <label for="inputPassword3" class="col-sm-3 control-label"> </label> 
												 <div class="col-sm-12"> 
													 <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Re-enter New Password" required=""> 
												 </div> 
											 </div> 
											 <div class="form-group last">
												<div class="col-sm-offset-1 col-sm-10">
													<button type="submit" class="btn btn-success btn-sm" onclick="return Rstpwd()">Change</button>
													<span style="padding-left: 5px;"></span>
													<button type="reset" class="btn btn-default btn-sm">Reset</button>
													<a href="forgotPassword.jsp" class ="pull-right"> Forgot Password ?</a>
												</div>
											</div>
										</form>
									</div>
								</div>
								<button class="glyphicon glyphicon-circle-arrow-up btn btn-default btn-lg" onclick="topFunction()" id="myBtn" title="Go to top" ></button>
							</div>
						</div>
						<br><br><br><br>
                   </div>               
            </div>
        </div>
    </div>
	
    <!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 ">
                    <p class="copyright text-center text-muted small"> &copy; Infinity Bank & Co. 2017. All Rights Reserved</p>
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
    function Validate() {
        var password = document.getElementById("createPassword").value;
        var confirmPassword = document.getElementById("Reenter").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
</script>
<script type="text/javascript">
    function Rstpwd() {
        var password = document.getElementById("newPassword").value;
        var confirmPassword = document.getElementById("confirmPassword").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
</script>
<script>
// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.getElementById("myBtn").style.display = "block";
    } else {
        document.getElementById("myBtn").style.display = "none";
    }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}
</script>

</body>

</html>
