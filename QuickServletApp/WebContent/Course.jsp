<html>
<head>
<title>Select Course</title>
</head>
<link rel = "stylesheet" type = "text/css" href = "myStyle.css" />
<font color="white">
<h1>
	<font size="14">CSUS Attendance</font></h1>
	<font size="4">Welcome Professor</font>
    <fieldset>
    	<p>
    	<form action="QuickServlet" method="post">   	
<!--   	<form action="${pageContext.request.contextPath}/RandKey.jsp" method="post">   -->  
    		<label>Course Selection:</label>
    		<select id = "myList" name="courses">
    			<option value = "CSC20"> CSC 20</option>
    			<option value = "CSC130"> CSC 130</option>
    			<option value = "CSC131"> CSC 131</option>
    			<option value = "CSC133"> CSC 133</option>
    			<option value = "CSC135"> CSC 135</option>
    		</select>
    	</p>
    	<input type="hidden" value="CourseSelect" name="FormName"/>
    	<input type="submit" value="Generate Key">
    	</form>
    </fieldset>
    </font>
</body>
</html>