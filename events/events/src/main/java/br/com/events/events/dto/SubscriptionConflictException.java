package br.com.events.events.dto;

public class SubscriptionConflictException extends RuntimeException {
    public SubscriptionConflictException(String msg) {
        super(msg);
    }
}
