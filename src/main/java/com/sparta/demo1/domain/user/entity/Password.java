package com.sparta.demo1.domain.user.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public record Password(
    String passwordHash
) {

    public static Password of(String value) {
        return new Password(value);
    }
}