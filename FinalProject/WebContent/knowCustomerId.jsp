<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Know Customer Id</title>

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
        
			<div class="row">
                <div class="col-lg-12">
						<img class="center-block" width="250px" src="banklogo.png"/><br>
						<h1 class="text-center"><span style="color:black;"><strong>INFINITY BANK</strong></span></h1>
                        <hr class="intro-divider">
                    </div>
                </div>
            </div>

       

    <!-- /.intro-header -->

    <!-- Page Content -->

	<div class="content-section-a col-md-4 col-md-offset-5">
				<form class="form-inline" method="post" action="KnowCustomerIdServlet">
					<div class="form-group">
						<div class="col-sm-10">
							<input type="text" class="form-control" id="account_number" name="account_number" placeholder="Enter Account Number" class="form-control input-md" required>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-10">
							<input type="submit" class="btn btn-success btn-sm" value="submit">
						</div>
					</div>
				</form>
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

</body>

</html>
