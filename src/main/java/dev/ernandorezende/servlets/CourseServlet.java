package dev.ernandorezende.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/courses")
public class CourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Servlet CourseServlet</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h1>Servlet CourseServlet</h1>");
//        out.println("</body>");
//        out.println("</html>");
        req.getRequestDispatcher("WEB-INF/pages/course.html").forward(req, resp);
    }
}
