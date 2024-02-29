package com.selfprojects.ToDoApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ToDoRequest {
    private long goalsCompleted;
    private long goalsCreated;
    private long totalGoalsCompleted = 0;
    private long totalGoalsCreated = 0;
}
