package filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

public class FormatFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String format = request.getParameter("format");
        
        if (format != null && !format.isEmpty()) {
        	
            try {
                new java.text.SimpleDateFormat(format).setLenient(false);
            } catch (IllegalArgumentException e) {
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_BAD_REQUEST, "Định dạng thời gian không hợp lệ.");
                return;
            }
        }

        // Nếu định dạng hợp lệ, tiếp tục chuỗi xử lý
        chain.doFilter(request, response);
    }

    public void destroy() {}
}
