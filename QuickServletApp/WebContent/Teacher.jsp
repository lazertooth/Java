<html>
<head>
<title>Teacher Sign In</title>
</head>
<link rel = "stylesheet" type = "text/css" href = "myStyle.css" />
<font color="white">
<h1>
	<font size="14">CSUS Attendance</font></h1>
	<font size="4">Please Sign In</font>
    <fieldset>
    <p>
    	<form action="QuickServlet" method="post">
        	User Name: <input type="text" size="10" name="userTeacher"/>
        	Password:  <input type="text" size="10" name="passTeacher"/>
 

        </p>
			<input type="hidden" value="TeacherLogin" name="FormName"/>
        	<input type="submit" value="Submit">
    	</form>
    </fieldset>
	</font>
</body>
</html>