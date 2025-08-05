package com.picpaysimplificado.picpaysimplificado.domain.Entity.user;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private  String lastName;

    @Column(unique = true)
    private  String cpf;

    @Column(unique = true)
    private String email;

    private  String password;

    private BigDecimal balancer;

    @Enumerated(EnumType.STRING)
    private UserType userType;


}
