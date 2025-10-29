package com.sparta.demo1.domain.user.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public record Email(
    String email
) {

    public static Email of(String value) {
        return new Email(value);
    }
}