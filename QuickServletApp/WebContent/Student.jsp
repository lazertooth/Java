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
	<!-- these are test conditions so far testing so blank forms are not setn -->
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
<body>
	<font color="white">
	<h1>CSUS Attendance</h1>
	<p>Please enter your Student ID# and the Attendance Key</p>

   <!-- <a href="/QuickServlet">Click here to send GET request</a>-->
    <br/><br/>
     
    <form name="StudentForm" action="QuickServlet" method="post" onsubmit="return validateForm()">
        ID#: <input type="text" size="10" name="Student ID"/>
        &nbsp;&nbsp;
        KEY <input type="text" size="10" name="Key"/>
        &nbsp;&nbsp;
        <input type="hidden" value="StudentEntry" name="FormName"/>
        <input type="submit" value="Submit" />
    </form>
    </font>
</body>
</html>

