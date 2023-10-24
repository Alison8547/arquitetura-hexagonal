package com.br.hexagonal.adapters.inbound.controller;

import com.br.hexagonal.adapters.inbound.dto.request.TaskRequest;
import com.br.hexagonal.adapters.inbound.dto.response.TaskDevResponse;
import com.br.hexagonal.adapters.inbound.dto.response.TaskResponse;
import com.br.hexagonal.adapters.inbound.mapper.TaskMapper;
import com.br.hexagonal.application.domain.Task;
import com.br.hexagonal.application.ports.in.CreateTaskUserCasePort;
import com.br.hexagonal.application.ports.in.TaskFinishedUserCasePort;
import com.br.hexagonal.application.ports.out.JoinDevTaskPort;
import com.br.hexagonal.application.ports.out.ListFinishTasksPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping
public class TaskController {

    private final CreateTaskUserCasePort createTaskUserCasePort;
    private final TaskFinishedUserCasePort taskFinishedUserCasePort;
    private final ListFinishTasksPort listFinishTasksPort;
    private final JoinDevTaskPort joinDevTaskPort;
    private final TaskMapper mapper;


    @Operation(summary = "Create task", description = "Save you task to the database")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Successfully created"),
                    @ApiResponse(responseCode = "400", description = "An exception was generated"),
                    @ApiResponse(responseCode = "403", description = "You do not have permission to access this resource"),
                    @ApiResponse(responseCode = "500", description = "An internal server exception was generated")
            }
    )
    @PostMapping("/create-task")
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody TaskRequest taskRequest) {
        Task task = mapper.toTask(taskRequest);
        return new ResponseEntity<>(mapper.toTaskResponse(createTaskUserCasePort.createTask(task)), HttpStatus.CREATED);
    }

    @Operation(summary = "Finished task", description = "Finished task in the database")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Finished successfully"),
                    @ApiResponse(responseCode = "400", description = "An exception was generated"),
                    @ApiResponse(responseCode = "403", description = "You do not have permission to access this resource"),
                    @ApiResponse(responseCode = "500", description = "An internal server exception was generated")
            }
    )
    @PutMapping("/finished-task/{id}")
    public ResponseEntity<TaskResponse> finishedTask(@PathVariable(name = "id") UUID id) {
        return new ResponseEntity<>(mapper.toTaskResponse(taskFinishedUserCasePort.finishedTask(id)), HttpStatus.OK);
    }

    @Operation(summary = "List of finished tasks", description = "Return completed tasks from the database")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "List successfully"),
                    @ApiResponse(responseCode = "400", description = "An exception was generated"),
                    @ApiResponse(responseCode = "403", description = "You do not have permission to access this resource"),
                    @ApiResponse(responseCode = "500", description = "An internal server exception was generated")
            }
    )
    @GetMapping("/list-finished")
    public ResponseEntity<List<TaskResponse>> listFinishTasks() {
        return new ResponseEntity<>(listFinishTasksPort.listFinishTasks().stream()
                .map(mapper::toTaskResponse).toList(), HttpStatus.OK);
    }

    @Operation(summary = "Join Dev Task", description = "Join Dev task in the database")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Join successfully"),
                    @ApiResponse(responseCode = "400", description = "An exception was generated"),
                    @ApiResponse(responseCode = "403", description = "You do not have permission to access this resource"),
                    @ApiResponse(responseCode = "500", description = "An internal server exception was generated")
            }
    )
    @PutMapping("/join-dev/{idDev}/{idTask}")
    public ResponseEntity<TaskDevResponse> joinDevTask(@PathVariable(name = "idDev") UUID idDev, @PathVariable(name = "idTask") UUID idTask) {
        return new ResponseEntity<>(mapper.toTaskDevResponse(joinDevTaskPort.joinDevTask(idDev, idTask)), HttpStatus.OK);
    }
}
