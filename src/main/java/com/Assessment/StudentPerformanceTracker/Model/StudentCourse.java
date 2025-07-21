package com.Assessment.StudentPerformanceTracker.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentCourse {

    Integer studentId;
    String firstName;
    String lastName;
    Integer courseId;
    Double grade;
}
