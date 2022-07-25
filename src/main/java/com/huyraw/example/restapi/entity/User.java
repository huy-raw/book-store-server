package com.huyraw.example.restapi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.huyraw.example.restapi.util.UserRole;
import com.huyraw.example.restapi.util.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "Id", updatable = false)
    private String id;

    @Column(name = "Name", nullable = false)
    private String fullName;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Birthday", nullable = false)
    private LocalDate dob;

    @Column(nullable = false)
    private UserStatus status;


    @Column(nullable = false)
    private UserRole role;

    public User(final String fullName, final String password, final String email, final LocalDate dob, final UserStatus status, final UserRole role) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.status = status;
        this.role = role;
    }

}