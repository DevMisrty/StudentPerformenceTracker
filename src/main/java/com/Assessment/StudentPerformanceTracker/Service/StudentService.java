package com.Assessment.StudentPerformanceTracker.Service;

import com.Assessment.StudentPerformanceTracker.Model.Student;
import com.Assessment.StudentPerformanceTracker.utility.StudentUtility;

public class StudentService {

    public static void addNewStudent(Student s){
        StudentUtility.addStudent(s);
    }

    public static void deleteStudent(int id){
        StudentUtility.deleteStudent(id);
    }

    public static void updateStudent(Student s){
        StudentUtility.updateStudent(s);
    }

}
