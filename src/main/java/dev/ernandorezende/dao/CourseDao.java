package dev.ernandorezende.dao;

import dev.ernandorezende.infra.DbConnection;
import dev.ernandorezende.model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
