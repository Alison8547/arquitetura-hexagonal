package com.br.hexagonal.adapters.inbound.controller;

import com.br.hexagonal.adapters.inbound.dto.request.TaskRequest;
import com.br.hexagonal.adapters.inbound.dto.response.TaskResponse;
import com.br.hexagonal.adapters.inbound.mapper.TaskMapper;
import com.br.hexagonal.application.domain.Task;
import com.br.hexagonal.application.ports.in.CreateTaskUserCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping
public class TaskController {

    private final CreateTaskUserCasePort createTaskUserCasePort;
    private final TaskMapper mapper;

    @PostMapping("/create-task")
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody TaskRequest taskRequest) {
        Task task = mapper.toTask(taskRequest);
        return new ResponseEntity<>(mapper.toTaskResponse(createTaskUserCasePort.createTask(task)), HttpStatus.CREATED);
    }
}
