package com.picpaysimplificado.picpaysimplificado.domain.Entity.user;

import com.picpaysimplificado.picpaysimplificado.Dto.UserDto;
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

    private BigDecimal balance;


    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDto data){
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.balance = data.balance();
        this.userType = data.userType();
        this.password = data.password();
        this.cpf= data.cpf();
        this.email = data.email();
    }

}
