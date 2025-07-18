package com.Assessment.StudentPerformanceTracker.Controller;

import com.Assessment.StudentPerformanceTracker.Model.Course;
import com.Assessment.StudentPerformanceTracker.Service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {

    @RequestMapping("/addCourse")
    public String addCourse(){
        return "addCourse";
    }

    @RequestMapping("/registerNewCourse")
    public String registerNewCourse(@RequestParam String courseId,
                                    @RequestParam String courseName){
        CourseService.addNewCourse(new Course(Integer.parseInt(courseId),courseName));
        return "home";
    }

    @RequestMapping("/updateCourse")
    public String updateCourse(){
        return "updateCourse";
    }

    @RequestMapping("/updateCourseDetails")
    public String updateCourseDetails(@RequestParam String courseId,
                                      @RequestParam String courseName){
        CourseService.updateCourse(new Course(Integer.parseInt(courseId),courseName));
        return "home";
    }

    @RequestMapping("/deleteCourseById")
    public String deleteCourseID(@RequestParam String courseId){
        CourseService.deleteCourse(Integer.parseInt(courseId));
        return "home";
    }

    @RequestMapping("/deleteCourse")
    public String deleteCourse(){
        return "deleteCourse";
    }
}
