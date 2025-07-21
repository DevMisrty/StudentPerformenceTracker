package com.Assessment.StudentPerformanceTracker.utility;

import com.Assessment.StudentPerformanceTracker.Model.AvgMarksCourse;
import com.Assessment.StudentPerformanceTracker.Model.Marks;
import com.Assessment.StudentPerformanceTracker.Model.Student;
import com.Assessment.StudentPerformanceTracker.Model.StudentDetails;
import org.yaml.snakeyaml.error.Mark;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarksUtility {

    static String url ="jdbc:mysql://localhost:3306/studentmanagement";

    public static void insertMarks(Marks m ){
        try{
            Connection con = DriverManager.getConnection(url,"root","root");
            String query = "update student_course set grade = ? where s_id = ? and c_id =? ";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,m.getMarks());
            pst.setInt(2,m.getStudentId());
            pst.setInt(3,m.getCourseId());
            pst.execute();
            con.close();
        }catch(SQLException e){
            System.out.println("Inside insertMarks" + e.getMessage());
        }
    }

    public static List<Marks> getAboveAverageStudents(){
        List<Marks> list = new ArrayList<>();
        try{
            Connection con  = DriverManager.getConnection(url,"root","root");
            String query = "select * from student_course where \n" +
                    "grade > ( select avg(grade) from student_course );" ;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Marks m = new Marks();
                m.setStudentId(rs.getInt("s_id"));
                m.setCourseId(rs.getInt("c_id"));
                m.setMarks(rs.getInt("grade"));
                list.add(m);

                System.out.println(m);
            }

        }catch(SQLException e){
            System.out.println("Inside getAboveAverageStudents " + e.getMessage());
        }
        return list;
    }

    public static List<AvgMarksCourse> getAverageMarkPerSubject(){
        List<AvgMarksCourse> list = new ArrayList<>();
        try{
            Connection con  = DriverManager.getConnection(url,"root","root");
            String query = "select c_id, avg(grade) from student_course group by c_id;" ;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                AvgMarksCourse m = new AvgMarksCourse();
                m.setCourseId(rs.getInt("c_id"));
                m.setGrades(rs.getDouble("avg(grade)"));
                list.add(m);
            }

        }catch(SQLException e){
            System.out.println("Inside getAverageMarks " + e.getMessage());
        }
        return list;
    }

    public static List<AvgMarksCourse> getAvgEnrollment(){
        List<AvgMarksCourse> list = new ArrayList<>();
        try{
            Connection con  = DriverManager.getConnection(url,"root","root");
            String query = "select c_id , count(s_id) from student_course group by c_id;" ;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                AvgMarksCourse m = new AvgMarksCourse();
                m.setCourseId(rs.getInt("c_id"));
                m.setGrades(rs.getDouble("count(s_id)"));
                list.add(m);
            }

        }catch(SQLException e){
            System.out.println("Inside getAverageMarks " + e.getMessage());
        }
        return list;
    }

    public static List<StudentDetails> getStudentDetails(){
        List<StudentDetails> list = new ArrayList<>();
        try{
            Connection con  = DriverManager.getConnection(url,"root","root");
            String query = "select student.first_name , student.last_name , course.course_name, student_course.grade from student_course\n" +
                    "join course on course.id = student_course.c_id\n" +
                    "join student on student.id = student_course.s_id;" ;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                StudentDetails m = new StudentDetails();
                m.setFirstName(rs.getString("first_name"));
                m.setLastName(rs.getString("last_name"));
                m.setCourseName(rs.getString("course_name"));
                m.setGrade(rs.getDouble("grade"));
                list.add(m);
            }

        }catch(SQLException e){
            System.out.println("Inside getAverageMarks " + e.getMessage());
        }
        return list;
    }
}
