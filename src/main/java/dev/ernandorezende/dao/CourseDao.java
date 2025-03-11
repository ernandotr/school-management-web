package dev.ernandorezende.dao;

import dev.ernandorezende.infra.DbConnection;
import dev.ernandorezende.model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CourseDao {

    private static final Logger logger = Logger.getLogger("CourseDao");

    public void save(Course course) {
        Connection connection = null;
        try {
            connection = DbConnection.getConnection();
            String sql = "INSERT INTO courses (code, name, workload, level) VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, course.code());
            ps.setString(2, course.name());
            ps.setInt(3,course.workload());
            ps.setString(4, course.level());
            ps.execute();
            connection.commit();
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

    public List<Course> FindAll() {
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
