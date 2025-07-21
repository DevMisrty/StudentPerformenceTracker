package com.Assessment.StudentPerformanceTracker.Controller;

import com.Assessment.StudentPerformanceTracker.Model.Marks;
import com.Assessment.StudentPerformanceTracker.Model.Student;
import com.Assessment.StudentPerformanceTracker.Service.CourseService;
import com.Assessment.StudentPerformanceTracker.Service.MarksService;
import com.Assessment.StudentPerformanceTracker.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/registerStudent")
    public String addStudent(){
        System.out.println("Calling Add student");
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String addStudentDetails(@RequestParam int studentId ,
                                    @RequestParam String firstName,
                                    @RequestParam String lastName){
        Student s = new Student(studentId,firstName,lastName);
        StudentService.addNewStudent(s);
        return "home";
    }


    @RequestMapping("/deleteStudent")
    public String deleteStudent(){
        System.out.println("Inside delete Student");
        return "deleteStudent";
    }
    @RequestMapping("/deleteStudentUsingId")
    public String deleteStudentID(@RequestParam("search") String search){

        StudentService.deleteStudent(Integer.parseInt(search));
        return "home";
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(){
        System.out.println("Inside update Student");
        return "updateStudent";
    }

    @RequestMapping("/updateStudentDetails")
    public String updateStudentDetails(@RequestParam int studentId,
                                       @RequestParam String firstName,
                                       @RequestParam String lastName){
        StudentService.updateStudent(new Student(studentId,firstName,lastName));
        return "home";
    }

    @RequestMapping("/enrollCourse")
    public String enrollCourse(){
        System.out.println("Inside enroll Course ");
        return "enrollCourse" ;
    }

    @RequestMapping("/enrollStudentCourse")
    public String enrollStudent(@RequestParam String studentId,
                                @RequestParam String courseId){
        CourseService.enrollStudent(Integer.parseInt(studentId),Integer.parseInt(courseId));
        return "home";

    }

    @RequestMapping("/assignMarks")
    public String assignMarks(){
        return "assignMarks";
    }
    @RequestMapping("/assignMarkToStudent")
    public String assignMarksToStudent(
            @RequestParam String studentId,
            @RequestParam int courseId,
            @RequestParam int obtainedMarks
    ){
        MarksService.insertData(new Marks(Integer.parseInt(studentId),courseId,obtainedMarks));
        return "home";
    }

}
