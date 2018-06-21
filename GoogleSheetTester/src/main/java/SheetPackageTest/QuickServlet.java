package net.codejava.servlet;
 
import java.io.IOException;
import java.util.Random;
import java.io.PrintWriter;
import SheetPackageTest.SheetsQuickstart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    


public class QuickServlet extends HttpServlet {
    /**
     * this life-cycle method is invoked when this servlet is first accessed
     * by the client
     */

    public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
    }
 
    /**
     * handles HTTP GET request
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        PrintWriter writer = response.getWriter();
                
    	/*** Pass Current Date to google sheet  ***/
     	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
    	LocalDateTime now = LocalDateTime.now();  
    	SheetsQuickstart.inputDate(dtf.format(now));
    	
    }
 
    /**
     * handles HTTP POST request
     * @throws ServletException 
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException, NullPointerException {
    	
    	int col  = SheetsQuickstart.getCol()-1;   	
    	String formName=request.getParameter("FormName");
    	RequestDispatcher rd;
    	
    	switch(formName) {
    		case "StudentEntry":
    			/****************** Matches the ID and Key in Google SHeet**************/
    	    	PrintWriter writer = response.getWriter();
    	        String paramID = request.getParameter("Student ID");
    	        String paramKey = request.getParameter("Key");
    	        String paramComment = request.getParameter("Comment"); 
    	        if (SheetsQuickstart.checkID(paramID) && SheetsQuickstart.checkKey(col,paramKey)) {
    	        	if(paramComment.equals("") || paramComment == null)
    	            	SheetsQuickstart.inputComment(col,"Yes",paramID);
    	            else
    	            	SheetsQuickstart.inputComment(col, paramComment,paramID);       	
    	        	writer.println("<html>Attendance Logged</html>");
    	        	writer.flush();
    	        }else {
    	        	writer.println("<html>Invalid Credentials</html>");
    	    		writer.flush();
    	    		}
    	        break;
    			
    		case "TeacherLogin":    
    	        String userTeacher = request.getParameter("userTeacher");
    	        String passTeacher = request.getParameter("passTeacher");
    	        System.out.println("Welcome Professor: " + userTeacher);    
    	        rd = request.getRequestDispatcher("Course.jsp");
    	        rd.forward(request, response);   	        
    	        break;

  
    		case "CourseSelect":     
    			String x = request.getParameter("myList");    
    			System.out.println("You selected course: " + x);
    	        rd = request.getRequestDispatcher("RandKey.jsp");
    	        rd.forward(request, response);     	    	
    	    	break;
    	    
    	    	
    		case "RandKey":     
    			System.out.println("Hello World");
    			/****** Store Random Key into GoogleSheet *******/
    			Random rand = new Random();
    	    	int randomKey = rand.nextInt(10000-1000) + 1000;
    	    	String randKey = Integer.toString(randomKey);
    	    	SheetsQuickstart.inputKey(col,randKey);
    	    	
    	    	//request.setAttribute("message", randomKey);
    	    	//RequestDispatcher view=getServletContext().getRequestDispatcher("RandKey.jsp");   	        
    	        
    	        break;
    	}
    }
 
    
    
    /**
     * this life-cycle method is invoked when the application or the server
     * is shutting down
     */
    public void destroy() {
        System.out.println("Servlet is being destroyed");
    }
}