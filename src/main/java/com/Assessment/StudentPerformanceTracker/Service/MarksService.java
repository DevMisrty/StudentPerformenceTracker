package com.Assessment.StudentPerformanceTracker.Service;

import com.Assessment.StudentPerformanceTracker.Model.Marks;
import com.Assessment.StudentPerformanceTracker.utility.MarksUtility;

public class MarksService {


    public static void insertData(Marks m){
        MarksUtility.insertMarks(m);
    }

    public static String getGrade(int marks){
        if(marks>=90 && marks<100)return "A";
        else if(marks >= 80 && marks <90)return "B";
        else if(marks >=70 && marks <80)return "C";
        else if(marks >= 60 && marks <70)return "D";
        else return "F";
    }
}
