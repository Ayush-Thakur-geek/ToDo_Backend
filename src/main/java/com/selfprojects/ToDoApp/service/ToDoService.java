package com.selfprojects.ToDoApp.service;

import com.selfprojects.ToDoApp.model.ProgressData;
import com.selfprojects.ToDoApp.model.ToDoRequest;
import com.selfprojects.ToDoApp.model.ToDoResponse;

public interface ToDoService {
    long createHistory(ToDoRequest toDoRequest);

    ToDoResponse getHistoryDetails(long historyId);

    ProgressData getProgressData();
}
