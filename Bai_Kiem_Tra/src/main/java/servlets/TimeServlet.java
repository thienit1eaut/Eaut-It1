package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet {
	
	// Xử lý request form theo phương thức GET
	/**
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String format = request.getParameter("format");
        
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }

        try {
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            String formattedTime = sdf.format(now);
            
            request.setAttribute("formattedTime", formattedTime);
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Định dạng thời gian không hợp lệ.");
        }
    }
    */
	
	// Xử lý request form theo phương thức POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String format = request.getParameter("format");
        
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }

        try {
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            String formattedTime = sdf.format(now);
            
            request.setAttribute("formattedTime", formattedTime);
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Định dạng thời gian không hợp lệ.");
        }
    }
    
    
}