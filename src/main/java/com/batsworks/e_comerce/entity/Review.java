package com.batsworks.e_comerce.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "review")
@Table(name = "review")
public class Review extends AbstractyEntity<Review>{

    private Integer rating;
    private String headline;
    private String comment;
    private LocalDateTime reviewTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
