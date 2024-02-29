package com.selfprojects.ToDoApp.controller;

import com.selfprojects.ToDoApp.model.ProgressData;
import com.selfprojects.ToDoApp.model.ToDoRequest;
import com.selfprojects.ToDoApp.model.ToDoResponse;
import com.selfprojects.ToDoApp.service.ToDoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/todo")
@Log4j2
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @PostMapping("/createHistory")
    public ResponseEntity<Long> createHistory(@RequestBody ToDoRequest toDoRequest) {
        long historyId = toDoService.createHistory(toDoRequest);
        log.info("History Id: {}", historyId);
        return new ResponseEntity<>(historyId, HttpStatus.OK);
    }

    @GetMapping("/{historyId}")
    public ResponseEntity<ToDoResponse> getHistoryDetails(@PathVariable long historyId) {
        ToDoResponse toDoResponse = toDoService.getHistoryDetails(historyId);
        return new ResponseEntity<>(toDoResponse, HttpStatus.OK);
    }

    @GetMapping("/progress")
    public ResponseEntity<ProgressData> getProgressData() {
        ProgressData progressData = toDoService.getProgressData();
        return new ResponseEntity<>(progressData, HttpStatus.OK);
    }
}
