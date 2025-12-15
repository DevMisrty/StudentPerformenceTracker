package com.Assessment.StudentPerformanceTracker.Controller;

import com.Assessment.StudentPerformanceTracker.Model.Marks;
import com.Assessment.StudentPerformanceTracker.Model.Student;
import com.Assessment.StudentPerformanceTracker.Model.StudentCourse;
import com.Assessment.StudentPerformanceTracker.Service.StreamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/stream")
public class StreamController {

    @GetMapping("/getAboveAvgStudents")
    public List<StudentCourse> getAboveAvgStudents(){
       return  StreamService.getAboveAverageStudentPerCourse();
    }

    @GetMapping("/gradeStudent")
    public Map<Integer,List<Student>> gradeStudent(){
        return StreamService.getGradeStudentMap()   ;
    }

    @RequestMapping("/studentCourse")
    public List<StudentCourse> getStudentCourse(){
        return StreamService.getStudentCourse();
    }

    @RequestMapping("/avgOfGrade")
    public Double getAverageMarks(){
        return StreamService.getAverageGrade();
    }

    @RequestMapping("/getTopScorers")
    public Map<Integer,List<Marks>> getTopScorers(){
        return StreamService.getTopRankersPerCourse();
    }
}
