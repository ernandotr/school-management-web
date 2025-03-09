package dev.ernandorezende.servlets;

import dev.ernandorezende.model.Course;
import dev.ernandorezende.service.CourseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/create-course")
public class CreateCourseServlet extends HttpServlet {

    private final CourseService courseService = new CourseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/pages/create-course.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String workload = req.getParameter("workload");
        String level = req.getParameter("level");
        var course = new Course(code, name, workload, level);
        courseService.addCourse(course);
        req.setAttribute("courses", courseService.courseList().stream().toList());

        req.getRequestDispatcher("WEB-INF/pages/course.jsp").forward(req, resp);
    }
}
