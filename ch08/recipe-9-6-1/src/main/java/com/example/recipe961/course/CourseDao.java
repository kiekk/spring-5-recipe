package com.example.recipe961.course;

import java.util.List;

public interface CourseDao {

    Course store(Course course);

    void delete(Long courseId);

    Course findById(Long courseId);

    List<Course> findAll();
}
