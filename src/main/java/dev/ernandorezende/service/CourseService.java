package dev.ernandorezende.service;

import dev.ernandorezende.dao.CourseDao;
import dev.ernandorezende.model.Course;

import java.util.*;
import java.util.logging.Logger;

public class CourseService {
    private static final Logger logger = Logger.getLogger("CourseService");
    private final CourseDao dao = new CourseDao();

    public void addCourse(Course course)  {
       dao.save(course);
       logger.info("New course savd succesfull.");
    }

    public List<Course> courseList() {
        return dao.FindAll();
    }

}
