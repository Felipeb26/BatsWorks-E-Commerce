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
@Entity(name = "book_order")
@Table(name = "book_order")
public class BookOrder extends AbstractyEntity<BookOrder> {

    private LocalDateTime orderDate;
    private String shippingAdress;
    private String recipientName;
    private String recipientPhone;
    private String paymentMethod;
    private String status;
    private Float total;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
