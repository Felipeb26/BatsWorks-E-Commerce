package com.batsworks.e_comerce.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "order_detail")
@Table(name = "order_detail")
public class OrderDetail extends AbstractyEntity<OrderDetail>{

    private Float subtotal;
    private Integer quantity;
    @OneToOne(fetch = FetchType.LAZY)
    private Book book;
    @OneToOne(fetch = FetchType.LAZY)
    private BookOrder order;

}
