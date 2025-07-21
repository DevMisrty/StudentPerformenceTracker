package com.Assessment.StudentPerformanceTracker.utility;

import com.Assessment.StudentPerformanceTracker.Model.Course;
import com.Assessment.StudentPerformanceTracker.Model.Marks;
import com.Assessment.StudentPerformanceTracker.Model.Student;
import com.Assessment.StudentPerformanceTracker.Model.StudentCourse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StreamUtility {

    static String url ="jdbc:mysql://localhost:3306/studentmanagement";
    static String user = "root";

    public static List<StudentCourse> getStudentCourse(){

        List<StudentCourse> list = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(url,user,user)){
            Statement st = con.createStatement();
            String query = """
                    select  student.id, student.first_name, student.last_name, student_course.c_id , student_course.grade
                    from student_course
                    join student
                    on student.id = student_course.s_id;
                    """ ;
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new StudentCourse(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("c_id"),
                        rs.getDouble("grade")
                ));
            }
        }catch(SQLException e){
            System.out.println("Inside getStudentCourse -> StreamUtility "+ e.getMessage());
        }
        return list;
    }
}
