package com.batsworks.e_comerce.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customer")
@Table(name = "customer")
public class Customer extends AbstractyEntity<Customer>{

    @Column(unique = true)
    private String email;
    @Column(name = "fullname")
    private String fullName;
    private String adress;
    private String city;
    private String country;
    private String phone;
    private String zipcode;
    private String secret;
    private LocalDateTime registerDate;

}
