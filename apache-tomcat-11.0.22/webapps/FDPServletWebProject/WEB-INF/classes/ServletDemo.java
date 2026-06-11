import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/life")
public class ServletDemo extends HttpServlet {

    private int requestCount;

    @Override
    public void init() throws ServletException {
        requestCount = 0;
        System.out.println("Servlet has Initialized");
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        synchronized (this) {
            requestCount++;
        }

        System.out.println(
            "doGet(): Processing client request number : "
            + requestCount);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("<h2>Hello! This is doGet() Method Demo</h2>");
        out.println("<p>Welcome to Java Servlet Programming </p>");
        out.println("<h2>Hits count "+ requestCount +"</h2>");
        out.println("<a href='index.html'>Go Back</a>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    @Override
    public void destroy() {
        System.out.println("Servlet Destroyed");
    }
}