package com.picpaysimplificado.picpaysimplificado.domain.Entity.user.transaction;

import com.picpaysimplificado.picpaysimplificado.domain.Entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name="transactions")
@Table(name="transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "sender_Id")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "receiver_Id")
    private User sender;

    private LocalDateTime timestamp;
}
