package com.br.hexagonal.config;

import com.br.hexagonal.adapters.outbound.CreateDeveloperAdapter;
import com.br.hexagonal.application.usecases.CreateDeveloperUserCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CreateDeveloperUserCaseImpl createDeveloperUserCase(CreateDeveloperAdapter createDeveloperAdapter) {
        return new CreateDeveloperUserCaseImpl(createDeveloperAdapter);
    }
}