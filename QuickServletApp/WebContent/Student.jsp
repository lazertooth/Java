<html>
<head>
    <title>Student Attendance</title>
</head>
<body background="C:\Users\p-chandra\Documents\Workspace\QuickServletApp\WebContent\temp.jpg">
	<font color="white">
	<h1>CSUS Attendance</h1>
	<p>Please enter your Student ID# and the Attendance Key</p>

   <!-- <a href="/QuickServlet">Click here to send GET request</a>-->
    <br/><br/>
     
    <form action="QuickServlet" method="post">
        ID#: <input type="text" size="10" name="Student ID"/>
        &nbsp;&nbsp;
        KEY <input type="text" size="10" name="Key"/>
        &nbsp;&nbsp;
        <input type="submit" value="Submit" />
    </form>
    </font>
</body>
</html>