package com.Assessment.StudentPerformanceTracker.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDetails {

    String firstName;
    String lastName;
    String courseName;
    double grade;
}
