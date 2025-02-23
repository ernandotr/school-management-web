package dev.ernandorezende.servlets;


import dev.ernandorezende.model.Course;
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
        req.getRequestDispatcher("WEB-INF/pages/course.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String workload = req.getParameter("workload");
        String level = req.getParameter("level");
        var course = new Course(code, name, workload, level);
        System.out.println("Course:"+ course );
        req.getRequestDispatcher("WEB-INF/pages/course.html").forward(req, resp);
    }
}
