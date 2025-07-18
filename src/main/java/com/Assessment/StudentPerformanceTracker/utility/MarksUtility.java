package com.Assessment.StudentPerformanceTracker.utility;

import com.Assessment.StudentPerformanceTracker.Model.Marks;

import java.sql.*;

public class MarksUtility {

    static String url ="jdbc:mysql://localhost:3306/studentmanagement";

    public static void insertMarks(Marks m ){
        try{
            Connection con = DriverManager.getConnection(url,"root","root");
            String query = "update student_course set grade = ? where s_id = ? and c_id =? ";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,m.getMarks());
            pst.setInt(2,m.getStudentId());
            pst.setInt(3,m.getCourseId());
            pst.execute();
            con.close();
        }catch(SQLException e){
            System.out.println("Inside insertMarks" + e.getMessage());
        }
    }
}
