package br.com.events.events.model;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_subscription")

public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="subscription_number")
    private Integer subscriptionNumber;

    private Event event;

    private User subscriber;

    private User indication;

    public Integer getSubscriptionNumber() {
        return subscriptionNumber;
    }

    public void setSubscriptionNumber(Integer subscriptionNumber) {
        this.subscriptionNumber = subscriptionNumber;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(User subscriber) {
        this.subscriber = subscriber;
    }

    public User getIndication() {
        return indication;
    }

    public void setIndication(User indication) {
        this.indication = indication;
    }
}
