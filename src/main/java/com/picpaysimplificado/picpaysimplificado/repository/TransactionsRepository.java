package com.picpaysimplificado.picpaysimplificado.repository;

import com.picpaysimplificado.picpaysimplificado.domain.Entity.user.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transaction, Long> {


}
