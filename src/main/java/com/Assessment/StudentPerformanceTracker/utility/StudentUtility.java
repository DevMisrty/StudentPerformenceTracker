package com.Assessment.StudentPerformanceTracker.utility;

import com.Assessment.StudentPerformanceTracker.Model.Student;

import  java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Student> getAllStudentList(){
        List<Student> list = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(url,"root","root")){
            Statement st = con.createStatement();
            String query = "select * from student";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new Student(rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")));
            }

        }catch (SQLException e){
            System.out.println("Inside getALlStudentList-> StudentUtility " + e.getMessage());
        }
        return list;
    }
}
