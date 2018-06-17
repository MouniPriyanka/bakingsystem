<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<script type="text/javascript">
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
	<body bgcolor="white">
        <%
        HttpSession session6=request.getSession(false);
        session6.invalidate();
        response.setHeader("Cache-Control","no-cache");   
        response.setHeader("Cache-Control","no-store");  
        response.setDateHeader("Expires", 0);  //as "stale"
        response.setHeader("Pragma","no-cache");

        %>
        <h1><font color="blue">You are Sucessfully logged out...</font></h1>
        <a href="UserLogin.jsp">Go-Back To Login Page</a>
    </body>
</html>