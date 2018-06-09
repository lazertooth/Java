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
        SheetsQuickstart.updateSheet();
        //writer.println("<html>Hello, I am a Java servlet!</html>");
        //writer.flush();
    }
 
    /**
     * handles HTTP POST request
     * @throws ServletException 
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, NullPointerException {
    	
        String paramKey = request.getParameter("Student ID");
        int ID = Integer.parseInt(paramKey);
        String paramID = request.getParameter("Key");
        int Key = Integer.parseInt(paramID);
        
        String userTeacher = request.getParameter("userTeacher");
        String username= userTeacher;
        String passTeacher = request.getParameter("passTeacher");
        String password=passTeacher;
 
        int x = 4444; // manual key
        
        //long area = width * height;
        if (Key == x) {
        	PrintWriter writer = response.getWriter();
            writer.println("<html>Thank You</html>");
            writer.flush();
        }else {
        	PrintWriter writer = response.getWriter();
            writer.println("<html>Invalid Key</html>");
            writer.flush();
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