package com.ljubove.automationqa.filters;

import com.ljubove.automationqa.model.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CourseFilter {
    public Course filterByName(String name, List<Course> courses) {
        if (courses.isEmpty()) return null;
        return courses.stream().filter(c -> c.getCourseName().equals(name)).findFirst().orElse(null);
    }

    public Course filterByEarliestStart(List<Course> courses){
        if (courses.isEmpty()) return null;
        Course course = courses.stream().reduce((s1, s2) -> s1.getStartDate().before(s2.getStartDate()) ? s1 : s2).get();
        log.debug("Course = " + course.getCourseName());
        return course;

    }

    public Course filterByLastStart(List<Course> courses){
        if (courses.isEmpty()) return null;
        Course course = courses.stream().reduce((s1, s2) -> s1.getStartDate().after(s2.getStartDate()) ? s1 : s2).get();
        log.debug("Course = " + course.getCourseName());
        return course;

    }
}
