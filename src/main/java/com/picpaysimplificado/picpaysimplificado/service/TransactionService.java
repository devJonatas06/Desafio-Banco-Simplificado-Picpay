package com.picpaysimplificado.picpaysimplificado.service;

import com.picpaysimplificado.picpaysimplificado.Dto.TransactionDto;
import com.picpaysimplificado.picpaysimplificado.domain.Entity.user.User;
import com.picpaysimplificado.picpaysimplificado.domain.Entity.user.transaction.Transaction;
import com.picpaysimplificado.picpaysimplificado.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private  AuthorizationService authorizationService;

    @Autowired
    private NotificationService notificationService;


    public Transaction createTransaction(TransactionDto transactionDto) throws Exception {
        User sender = this.userService.findUserById(transactionDto.senderId());
        User receiver = this.userService.findUserById(transactionDto.receiverId());

        userService.validateTransaction(sender, transactionDto.value());

        boolean isAuthorized = this.authorizationService.authorizeTransaction(sender, transactionDto.value());
        if (!isAuthorized) {
            throw new Exception("Transacao nao autorizada");

        }
        Transaction newtransaction = new Transaction();
        newtransaction.setAmount(transactionDto.value());
        newtransaction.setSender(sender);
        newtransaction.setReceiver(receiver);
        newtransaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transactionDto.value()));
        receiver.setBalance(receiver.getBalance().add(transactionDto.value()));

        this.transactionsRepository.save(newtransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);
        this.notificationService.sendNotification(sender, "Transacao realizada com sucesso");
        this.notificationService.sendNotification(receiver, "Transacao recebida com sucesso");
        return newtransaction;
    }
}