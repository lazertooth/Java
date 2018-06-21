<html>
<head>
    <title>Student Attendance</title>
</head>
<link rel = "stylesheet" type = "text/css" href = "myStyle.css" />

<!-- frontend form validation... 
can instead move to external js file and reference 
via link like the css file--> 

<script type="text/javascript">
function validateForm() {
	
	var ID = document.forms["StudentForm"]["Student ID"];  
    if (ID.value == "")                                 
    {
        window.alert("Please enter a value");
        ID.focus();
        return false;
    }
    
	var Key = document.forms["StudentForm"]["Key"];  
    if (Key.value == "")                                 
    {
        window.alert("Please enter a value");
        Key.focus();
        return false;
    }
    return true;
}
</script>
<body background="C:\Users\p-chandra\Documents\Workspace\QuickServletApp\WebContent\temp.jpg">
	<font color="white">
	<center>
		<h1>CSUS Attendance</h1>
		<p>Please enter your Student ID# and the Attendance Key</p>

   		<!-- <a href="/QuickServlet">Click here to send GET request</a>-->
    	<br/><br/>
    	<fieldset>
			<legend><font  color="white">Sign In </font></legend> 
			<br/><br/>
    	<form action="QuickServlet" method="post">
        	ID#: <input type="text" size="10" name="Student ID"/>
        	&nbsp;&nbsp;
        	KEY <input type="text" size="10" name="Key"/>
        	&nbsp;&nbsp;
        	<input type="hidden" value="StudentEntry" name="FormName"/>
			<br/><br/>
		</fieldset>
		<fieldset>
			<legend><font  color="white">Attendance Note </font></legend>
			<br/><br/> 
			<textarea name="Comment"  rows="5" cols="50" maxlength="140"></textarea>
			<br/><br/>
        	<input type="submit" value="Submit" />
		</fieldset>
    
    	</form>
    	</font>
    </center>
</body>
</html>