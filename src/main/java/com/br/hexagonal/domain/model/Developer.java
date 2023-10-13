package com.br.hexagonal.domain.model;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Developer {

    private UUID id;
    private String nameDeveloper;
    private String email;
    private String positionLevel;
    private List<Task> taskList;
}
