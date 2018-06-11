package net.codejava.servlet;
 
import java.io.IOException;
import java.util.Random;
import java.io.PrintWriter;
import SheetPackageTest.SheetsQuickstart;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

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

       // PrintWriter writer = response.getWriter();
       // SheetsQuickstart.getStudentData();
        
        //writer.println("<html>Hello, I am a Java servlet!</html>");
        //writer.flush();
    }
 
    /**
     * handles HTTP POST request
     * @throws ServletException 
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, NullPointerException {
    	// each servlet only has one doPost method, so we should send different values for the submit button and
    	// serve a different response depending on which form was submitted.
    	
    	// gets the hidden field formname value from each page and tosses it in a switchboard
    	String formName=request.getParameter("FormName");
    	
    	switch(formName) {
    		case "StudentEntry":
    			// student form posted
    			System.out.println("studentform");
    	    	// get stuff from student  	
    	        String paramID = request.getParameter("Student ID");
    	        int SID = Integer.parseInt(paramID);
    	        String paramKey = request.getParameter("Key");
    	        String Key = paramKey;
    	        String keyMain = SheetsQuickstart.getKey();
    	        //redirect after receiving post.

    	        // student JSP response page :     can possibly redirect to new pages    
    	        if (Key.equals(keyMain)) {
    	        	PrintWriter writer = response.getWriter();
    	            writer.println("<html>Thank You! Correct Key for sure</html>");
    	            writer.flush();
    	        }else {
    	        	PrintWriter writer = response.getWriter();
    	            writer.println("<html>Invalid Key</html>");
    	            writer.flush();   
    	        }   	        
    			break;
    			// end student section
    			
    		case "TeacherLogin":
    			//teacher login page
    			System.out.println("teacherlogin");
    	        // get stuff from teacher        
    	        String userTeacher = request.getParameter("userTeacher");
    	        String username= userTeacher;
    	        String passTeacher = request.getParameter("passTeacher");
    	        String password=passTeacher;
    	        System.out.println(password);
    	        
    	        // redirect to course selector upon success
    	        RequestDispatcher rd = request.getRequestDispatcher("Course.jsp");
    	        rd.forward(request, response);   	        
    	        break;
    	        // end teacher login sector

  
    		case "CourseSelect":
    			//teacher login page
    			System.out.println("courseSelected");
    	        // get stuff from teacher        
    	        String course = request.getParameter("courses");

    	        System.out.println(course);
    	        
    	        // redirect to course selector upon success
    	        RequestDispatcher cs = request.getRequestDispatcher("RandKey.jsp");
    	        cs.forward(request, response);   	        
    	        break;
    	        // end teacher login sector
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