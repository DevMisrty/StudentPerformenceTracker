package com.Assessment.StudentPerformanceTracker.Service;

import com.Assessment.StudentPerformanceTracker.Model.Course;
import com.Assessment.StudentPerformanceTracker.utility.CourseUtility;

public class CourseService {

    public static void addNewCourse(Course course) {
        CourseUtility.addCourse(course);
    }

    public static void updateCourse(Course c){
        CourseUtility.updateCourse(c);
    }

    public static void deleteCourse(int id){
        CourseUtility.deleteCourse(id);
    }

    public static void enrollStudent(int studentId, int courseId){
        CourseUtility.enrollStudent(studentId,courseId);
    }
}
