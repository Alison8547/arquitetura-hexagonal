package com.br.hexagonal.application.ports.out;

import com.br.hexagonal.application.domain.Task;

import java.util.List;

public interface ListFinishTasksPort {

    List<Task> listFinishTasks();
}
