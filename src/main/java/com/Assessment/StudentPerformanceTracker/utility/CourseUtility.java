package com.Assessment.StudentPerformanceTracker.utility;

import com.Assessment.StudentPerformanceTracker.Model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseUtility {

    static String url = "jdbc:mysql://localhost:3306/studentmanagement";

    public static void addCourse(Course c){
        try{
            Connection con = DriverManager.getConnection(url,"root","root");
            String query = " insert into course values (?,?);";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,c.getId());
            pst.setString(2, c.getCourseName());
            pst.execute();
            con.close();
        }catch(SQLException e){
            System.out.println("Inside course addCourse ");
        }
    }

    public static void updateCourse(Course c){
        try{
            Connection con = DriverManager.getConnection(url,"root","root");
            String query = "update course set course_name = ? where id = ? ";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,c.getCourseName());
            pst.setInt(2,c.getId());
            pst.execute();
            con.close();
        }catch(SQLException e ){
            System.out.println("Inside the updateCourse " + e.getMessage());
        }
    }

    public static void deleteCourse(int id){
        try{
            Connection con = DriverManager.getConnection(url,"root","root");
            String query ="delete from course where id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,id);
            pst.execute();
            con.close();

        }catch(SQLException e){
            System.out.println("Inside the deletCourse" + e.getMessage());
        }
    }

    public static void enrollStudent(int studentId, int courseId){
        try{
            Connection con = DriverManager.getConnection(url,"root","root");
            String query = "insert into student_course (s_id,c_id) values(?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,studentId);
            pst.setInt(2,courseId);
            pst.execute();
            con.close();
        }catch(SQLException e){
            System.out.println("Inside EnrollStudent " + e.getMessage());
        }
    }

    public static List<Course> getAllCourses(){
        List<Course> list = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(url,"root","root")){
            String query = "select * from course ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new Course(rs.getInt("id"),
                        rs.getString("course_name")));
            }
        }catch(SQLException e){
            System.out.println("Inside getAllCourse -> CourseUtility " + e.getMessage());
        }
        return list;
    }
}
