package com.Assessment.StudentPerformanceTracker.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Marks {
    int studentId;
    int courseId;
    String marks;
}
