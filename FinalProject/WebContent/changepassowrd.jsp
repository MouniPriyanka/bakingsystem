<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<script>
var check = function() {
	  if (document.getElementById('password').value ==
	    document.getElementById('confirm_password').value) {
	    document.getElementById('message').style.color = 'green';
	    document.getElementById('message').innerHTML = 'matching';
	  } else {
	    document.getElementById('message').style.color = 'red';
	    document.getElementById('message').innerHTML = 'not matching';
	  }
	}
  

</script>
</head>
<body>
<form action="ChangePasswordServlet" method="post">

		    Enter your Customer id:		
			<input type="text" value="" name="cid"/><br>		
		    Enter your old password:
		    <input type="password" id="oldpwd" name="oldpwd"><br>
			<label>password :
            <input name="password" id="password" type="password"  />
            </label><br>
            <label>confirm password:
            <input type="password" name="confirm_password" id="confirm_password"  onkeyup='check();' /> 
            <span id='message'></span>
            </label>
            <input type="submit" name="submit" value="Submit">
</form>
</body>
</html>