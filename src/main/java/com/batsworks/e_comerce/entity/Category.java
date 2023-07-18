package com.batsworks.e_comerce.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "category")
@Table(name = "category")
public class Category extends AbstractyEntity<Category> {
    private String name;
}
