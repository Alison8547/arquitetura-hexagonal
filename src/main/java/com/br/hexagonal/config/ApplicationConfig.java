package com.br.hexagonal.config;

import com.br.hexagonal.adapters.outbound.*;
import com.br.hexagonal.application.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CreateDeveloperUserCaseImpl createDeveloperUserCase(CreateDeveloperAdapter createDeveloperAdapter) {
        return new CreateDeveloperUserCaseImpl(createDeveloperAdapter);
    }

    @Bean
    public FindDeveloperUserCaseImpl findDeveloperUserCase(FindDeveloperAdapter findDeveloperAdapter) {
        return new FindDeveloperUserCaseImpl(findDeveloperAdapter);
    }

    @Bean
    public UpdateDeveloperUserCaseImpl updateDeveloperUserCase(UpdateDeveloperAdapter updateDeveloperAdapter) {
        return new UpdateDeveloperUserCaseImpl(updateDeveloperAdapter);
    }

    @Bean
    public CreateTaskUserCasImpl createTaskUserCase(CreateTaskAdapter createTaskAdapter) {
        return new CreateTaskUserCasImpl(createTaskAdapter);
    }

    @Bean
    public TaskFinishedUserCaseImpl taskFinishedUserCase(TaskFinishedAdapter taskFinishedAdapter) {
        return new TaskFinishedUserCaseImpl(taskFinishedAdapter);
    }

    @Bean
    public ListFinishTasksUserCaseImpl listFinishTasksUserCase(ListFinishTasksAdapter listFinishTasksAdapter) {
        return new ListFinishTasksUserCaseImpl(listFinishTasksAdapter);
    }
}
