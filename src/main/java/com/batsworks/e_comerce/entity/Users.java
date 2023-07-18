package com.batsworks.e_comerce.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Users {

    @Id
    private Integer id;
    private String email;
    private String fullName;
    private String password;

}
