package com.batsworks.e_comerce.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
@Table(name = "users")
public class Users extends AbstractyEntity<Users> {

    private String name;
    @Column(unique = true)
    private String email;
    private String secret;

}
