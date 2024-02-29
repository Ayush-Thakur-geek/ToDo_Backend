package com.selfprojects.ToDoApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgressData {
    private long totalGoalsCompleted;
    private long totalGoalsCreated;
}
