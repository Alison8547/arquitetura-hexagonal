package com.br.hexagonal.application.ports.in;

import com.br.hexagonal.application.domain.Task;

import java.util.List;

public interface ListFinishTasksUserCasePort {
    List<Task> listFinishTasks();
}
