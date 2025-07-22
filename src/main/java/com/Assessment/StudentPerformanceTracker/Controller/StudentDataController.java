package com.Assessment.StudentPerformanceTracker.Controller;

import com.Assessment.StudentPerformanceTracker.Model.AvgMarksCourse;
import com.Assessment.StudentPerformanceTracker.Model.Marks;
import com.Assessment.StudentPerformanceTracker.Model.StudentDetails;
import com.Assessment.StudentPerformanceTracker.utility.MarksUtility;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentDataController {

    @RequestMapping("/getAboveAvgStudents")
    public List<Marks> getAboveAvgStudents(){
        return MarksUtility.getAboveAverageStudents();
    }

    //used for later purpose
    @RequestMapping("/getAverageMarksperCourse")
    public List<AvgMarksCourse> getAverageMarks(){
        return MarksUtility.getAverageMarkPerSubject();
    }

    @RequestMapping("/getEnrollment")
    public List<AvgMarksCourse> getAvgEnrollment(){
        return MarksUtility.getAvgEnrollment();
    }

    @RequestMapping("/getStudentDetails")
    public List<StudentDetails> getStudentDetails(){
        return MarksUtility.getStudentDetails();

    }


}
