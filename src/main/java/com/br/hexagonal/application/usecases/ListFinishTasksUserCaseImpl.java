package com.br.hexagonal.application.usecases;

import com.br.hexagonal.application.domain.Task;
import com.br.hexagonal.application.ports.in.ListFinishTasksUserCasePort;
import com.br.hexagonal.application.ports.out.ListFinishTasksPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListFinishTasksUserCaseImpl implements ListFinishTasksUserCasePort {

    private final ListFinishTasksPort listFinishTasksPort;

    @Override
    public List<Task> listFinishTasks() {
        return listFinishTasksPort.listFinishTasks();
    }
}
