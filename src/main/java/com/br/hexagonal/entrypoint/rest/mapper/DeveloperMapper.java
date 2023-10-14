package com.br.hexagonal.entrypoint.rest.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeveloperMapper {

    private final ModelMapper mapper;



}
