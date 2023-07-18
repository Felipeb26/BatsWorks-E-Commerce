package com.batsworks.e_comerce.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@ToString(exclude = {"category"})
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "book")
@Table(name = "book")
public class Book extends AbstractyEntity<Book> {

    @Column(unique = true)
    private String title;
    private String author;
    private String description;
    private String isbn;
    private byte[] image;
    private float price;
    private Date publishDate;
    private LocalDateTime lastUpdate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;
}
