package com.selfprojects.ToDoApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Entity
@Table(name = "TODO_HISTORY")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "DATE")
    private Instant date;

    @Column(name = "GOALS_COMPLETED")
    private long goalsCompleted;

    @Column(name = "GOALS_CREATED")
    private long goalsCreated;

    @Column(name = "TOTAL_GOALS_COMPLETED")
    private long totalGoalsCompleted;

    @Column(name = "TOTAL_GOALS_CREATED")
    private long totalGoalsCreated;
}
