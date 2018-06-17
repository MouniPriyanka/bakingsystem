<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
 window.history.forward();
    function noBack() { window.history.forward(); }
    
    if (document.layers) {
        //Capture the MouseDown event.
        document.captureEvents(Event.MOUSEDOWN);
     
        //Disable the OnMouseDown event handler.
        document.onmousedown = function () {
            return false;
        };
    }
    else {
        //Disable the OnMouseUp event handler.
        document.onmouseup = function (e) {
            if (e != null && e.type == "mouseup") {
                //Check the Mouse Button which is clicked.
                if (e.which == 2 || e.which == 3) {
                    //If the Button is middle or right then disable.
                    return false;
                }
            }
        };
    }
     
    //Disable the Context Menu event.
    document.oncontextmenu = function () {
        return false;
    };
    </script>
</head>
<body>
  <%      // response.sendRedirect("Homepage.jsp");
        // request.getRequestDispatcher("/Homepage.jsp").forward(request,response);
            session.invalidate();
          
        %>
        <h1><font color="Red">You are Sucessfully logged out...</font></h1>
        <a href="HomePage.jsp">Go-Back To Home Page</a>
       
</body>

</html>