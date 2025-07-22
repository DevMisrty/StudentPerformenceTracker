package com.Assessment.StudentPerformanceTracker.Service;

import com.Assessment.StudentPerformanceTracker.Model.Course;
import com.Assessment.StudentPerformanceTracker.Model.Marks;
import com.Assessment.StudentPerformanceTracker.Model.Student;
import com.Assessment.StudentPerformanceTracker.Model.StudentCourse;
import com.Assessment.StudentPerformanceTracker.utility.CourseUtility;
import com.Assessment.StudentPerformanceTracker.utility.MarksUtility;
import com.Assessment.StudentPerformanceTracker.utility.StreamUtility;
import com.Assessment.StudentPerformanceTracker.utility.StudentUtility;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class StreamService {
    static List<Student> students ;
    static List<Marks> marks ;
    static List<Course> courses ;

    static Comparator<Marks> comparator = (Marks o1, Marks o2) -> {
            return o2.getMarks()-o1.getMarks();
        };

    static {
        students= StudentUtility.getAllStudentList();
        marks= MarksUtility.getAllData();
        courses = CourseUtility.getAllCourses();
    }

    public static Double getAverageGrade(){
        return marks.stream()
                .filter(students -> students.getMarks() != 0.0)
                .collect(Collectors.averagingDouble(Marks::getMarks));
    }

    public static List<StudentCourse> getAboveAverageStudentPerCourse(){
        List<StudentCourse> res = StreamUtility.getStudentCourse();
        Map<Integer, Double> map = MarksUtility.getAverageMarkPerSubjectMap();
        List<StudentCourse> list = res.stream()
                .filter(students -> students.getGrade() > map.get(students.getCourseId()))
                .toList();
        return list;
    }

    public static Map<Integer, List<Student>> getGradeStudentMap(){
        Map<Integer,Student> studentMap = new HashMap<>();
        students.forEach(student -> studentMap.put(student.getId(), student));
        Map<Integer,List<Student>> map = new HashMap<>();
        Collections.sort(marks, (Marks m1, Marks m2) -> m2.getMarks()- m1.getMarks());
        marks.forEach(mark -> {
            map.computeIfAbsent(mark.getMarks(), k -> new ArrayList<>())
                    .add(studentMap.get(mark.getStudentId()));
        });
        return map;
    }

    public static List<StudentCourse> getStudentCourse(){
        List<StudentCourse> res = StreamUtility.getStudentCourse();
        return res.stream()
                .filter(student -> student.getGrade() != 0.0 )
                .toList();
    }

    public static Map<Integer,List<Marks>>  getTopRankersPerCourse(){
        Map<Integer,List<Marks>> map = new HashMap<>();
        Map<Integer,List<Marks>> res = new HashMap<>();
        marks.stream()
                .forEach(students -> {
                    map.computeIfAbsent(students.getCourseId(),k->new ArrayList<Marks>());
                    map.get(students.getCourseId()).add(students);
                });
        map.forEach( (k,v)->{
            Collections.sort(v,comparator);
//            Collections.sort(v,(Marks o1, Marks o2) -> o2.getMarks()-o1.getMarks());
        });

        for(Integer key: map.keySet()){
            res.put(key,new ArrayList<Marks>());
            int n=3;
            for (Marks marks1 : map.get(key)) {
                if(n==0)break;
                res.get(key).add(marks1);
                n--;
            }
        }
        return res;
    }
}
