package dev.ernandorezende.service;

import dev.ernandorezende.model.Course;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CourseService {
    private Map<String, Course> courseMap = new HashMap<>();

    public void addCourse(Course course) {
        courseMap.put(course.code(), course);
    }

    public Collection<Course> courseList() {
        return courseMap.values();
    }
}
