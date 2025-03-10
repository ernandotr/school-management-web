package dev.ernandorezende.service;

import dev.ernandorezende.infra.DbConnection;
import dev.ernandorezende.model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Logger;

public class CourseService {
    private static final Logger logger = Logger.getLogger("CourseService");


    public void addCourse(Course course)  {
        Connection connection = null;
        try {
            connection = DbConnection.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            logger.severe(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                if(connection != null)
                    connection.close();
            } catch (SQLException e) {
                logger.severe(e.getMessage());
            }

        }
    }

    public List<Course> courseList() {
        Connection connection = null;
        List<Course> courses = new ArrayList<>();
        try {
            connection = DbConnection.getConnection();
            String query = "SELECT * FROM courses";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                int workload = rs.getInt("workload");
                String level = rs.getString("level");
                Course course = new Course(code, name, workload, level);
                courses.add(course);
            }

        } catch (ClassNotFoundException | SQLException e) {
            logger.severe(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                if(connection != null)
                    connection.close();
            } catch (SQLException e) {
                logger.severe(e.getMessage());
            }

        }
        return courses;
    }
}
