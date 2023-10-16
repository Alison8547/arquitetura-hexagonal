package com.br.hexagonal.config;

import com.br.hexagonal.adapters.outbound.CreateDeveloperAdapter;
import com.br.hexagonal.adapters.outbound.FindDeveloperAdapter;
import com.br.hexagonal.adapters.outbound.UpdateDeveloperAdapter;
import com.br.hexagonal.application.usecases.CreateDeveloperUserCaseImpl;
import com.br.hexagonal.application.usecases.FindDeveloperUserCaseImpl;
import com.br.hexagonal.application.usecases.UpdateDeveloperUserCaseImpl;
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
}
