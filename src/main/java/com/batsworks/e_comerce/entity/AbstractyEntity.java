package com.batsworks.e_comerce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractyEntity<T> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Column(updatable = false)
    protected LocalDateTime dateInclusion;

    @PrePersist
    private void persistDate() {
        this.dateInclusion = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }

}
