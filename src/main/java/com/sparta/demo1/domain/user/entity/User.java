package com.sparta.demo1.domain.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String username;

    @Embedded
    private Email email;

    @Column(nullable = false, length = 100)
    private String name;

    @Embedded
    private Password passwordHash;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public static User create(
        String username,
        String email,
        String name,
        String passwordHash
    ) {
        return new User(
            username,
            Email.of(email),
            name,
            Password.of(passwordHash)
        );
    }

    private User(
        String username,
        Email email,
        String name,
        Password passwordHash
    ) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.passwordHash = passwordHash;
        this.status = UserStatus.ACTIVE;
    }
}