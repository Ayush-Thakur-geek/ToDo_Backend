package com.selfprojects.ToDoApp.service;

import com.selfprojects.ToDoApp.entity.ToDo;
import com.selfprojects.ToDoApp.model.ProgressData;
import com.selfprojects.ToDoApp.model.ToDoRequest;
import com.selfprojects.ToDoApp.model.ToDoResponse;
import com.selfprojects.ToDoApp.repository.ToDoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class ToDoServiceImpl implements ToDoService{

    @Autowired
    private ToDoRepository toDoRepository;


    @Override
    public long createHistory(ToDoRequest toDoRequest) {
        log.info("Creating History Request: {}", toDoRequest);
        long latestId = 0;
        if (toDoRepository.findTopByOrderByIdDesc() != null) {
            latestId = toDoRepository.findTopByOrderByIdDesc().getId();
        }
        if (latestId == 0) {
            toDoRequest.setTotalGoalsCompleted(toDoRequest.getGoalsCompleted());
            toDoRequest.setTotalGoalsCreated(toDoRequest.getGoalsCreated());
        } else {
            ToDo latestToDo = toDoRepository.findById(latestId).get();
            toDoRequest.setTotalGoalsCreated(latestToDo.getTotalGoalsCreated() + toDoRequest.getGoalsCreated());
            toDoRequest.setTotalGoalsCompleted(latestToDo.getTotalGoalsCompleted() + toDoRequest.getGoalsCompleted());
        }
        ToDo toDo = ToDo.builder()
                .date(Instant.now())
                .goalsCompleted(toDoRequest.getGoalsCompleted())
                .goalsCreated(toDoRequest.getGoalsCreated())
                .totalGoalsCompleted(toDoRequest.getTotalGoalsCompleted())
                .totalGoalsCreated(toDoRequest.getTotalGoalsCreated())
                .build();
        toDo = toDoRepository.save(toDo);
        return toDo.getId();
    }

    @Override
    public ToDoResponse getHistoryDetails(long historyId) {
        return null;
    }

    @Override
    public ProgressData getProgressData() {
        return null;
    }
}
