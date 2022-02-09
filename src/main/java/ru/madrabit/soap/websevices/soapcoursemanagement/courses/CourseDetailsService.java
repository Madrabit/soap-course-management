package ru.madrabit.soap.websevices.soapcoursemanagement.courses;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CourseDetailsService {

    public enum Status {
        SUCCESS, FAILURE;
    }

    private static List<Course> courses = new ArrayList<>();

    static {
        courses.add(new Course(1, "Spring", "Desc 1"));
        courses.add(new Course(2, "SOAP", "Desc 2"));
        courses.add(new Course(3, "Rest", "Desc 3"));
        courses.add(new Course(4, "JPA", "Desc 4"));
        courses.add(new Course(5, "Hibernate", "Desc 5"));
    }

    public Course findById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public List<Course> findAll() {
        return courses;
    }

    public Status delete(int id) {
        Iterator<Course> iter = courses.iterator();
        while (iter.hasNext()) {
            final Course course = iter.next();
            if (course.getId() == id) {
                courses.remove(course);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
}
