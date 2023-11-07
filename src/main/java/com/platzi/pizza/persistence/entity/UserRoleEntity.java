package com.platzi.pizza.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_role")
@IdClass(UserRoleId.class)
@NoArgsConstructor
public class UserRoleEntity {

    @Id
    @Column(nullable = false, length = 20)
    private String username;

    @Id
    @Column(nullable = false, length = 20)
    private String role;

    @Column(name = "granted_date", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime grantedDate;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    private UserEntity user;
}
