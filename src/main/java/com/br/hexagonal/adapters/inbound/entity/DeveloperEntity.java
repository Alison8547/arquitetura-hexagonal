package com.br.hexagonal.adapters.inbound.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "developer")
public class DeveloperEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name_developer")
    private String nameDeveloper;

    @Column(name = "email")
    private String email;

    @Column(name = "position_level")
    private String positionLevel;

    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL)
    private List<TaskEntity> taskList = new ArrayList<>();
}

