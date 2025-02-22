package br.com.events.events.model;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_subscription")

public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="subscription_number")
    private Integer subscriptionNumber;

}
