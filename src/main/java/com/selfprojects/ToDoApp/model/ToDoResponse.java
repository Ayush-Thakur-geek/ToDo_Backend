package com.selfprojects.ToDoApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ToDoResponse {
    private long id;
    private Instant date;
    private long goalsCompleted;
    private long goalsCreated;
    private long totalGoalsCompleted;
    private long totalGoalsCreated;
}
