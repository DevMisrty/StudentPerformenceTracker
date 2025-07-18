package com.Assessment.StudentPerformanceTracker.utility;

import com.Assessment.StudentPerformanceTracker.Model.Student;

import  java.sql.*;

public class StudentUtility {

    static String url =  "jdbc:mysql://localhost:3306/studentmanagement";

    public  static void addStudent(Student s){
        try{
            Connection con = DriverManager.getConnection(url,"root","root");
            String query = "insert into student values(?,?,?);" ;
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,s.getId());
            pst.setString(2,s.getFirstName());
            pst.setString(3,s.getLastName());
            pst.execute();
            con.close();

        }catch(SQLException e){
            System.out.println("Inside addStudent" + e.getMessage());
        }
    }

    public static void updateStudent(Student s){
        try{
            Connection con = DriverManager.getConnection(url,"root","root");
            String query = "update student set first_name = ? , last_name= ? where id =?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,s.getFirstName());
            pst.setString(2,s.getLastName());
            pst.setInt(3,s.getId());
            pst.execute();
            con.close();
        }catch(SQLException e){
            System.out.println("Inside updateStudent" + e.getMessage());
        }
    }

    public static void deleteStudent(int id){
        try{
            Connection con = DriverManager.getConnection(url,"root","root");
            String query = "delete from student where id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,id);
            pst.execute();
            con.close();
        }catch(SQLException e){
            System.out.println("inside deleteStudent" + e.getMessage());
        }
    }
}
