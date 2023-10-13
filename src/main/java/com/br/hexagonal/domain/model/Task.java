package com.br.hexagonal.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private UUID id;
    private String title;
    private String description;
    private LocalDateTime timeOpen;
    private LocalDateTime deadline;
    private Boolean status;
    private Developer developer;

}
