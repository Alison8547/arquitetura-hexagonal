package com.br.hexagonal.adapters.outbound.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "task")
public class TaskEntity implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "time_open")
    private LocalDateTime timeOpen;

    @Column(name = "deadline")
    private LocalDateTime deadline;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "id_developer", nullable = false, updatable = false)
    private UUID idDeveloper;

    @ManyToOne
    @JoinColumn(name = "id_developer")
    private DeveloperEntity developer;

}
