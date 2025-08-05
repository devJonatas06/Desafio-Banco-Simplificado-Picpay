package com.picpaysimplificado.picpaysimplificado.service;

import com.picpaysimplificado.picpaysimplificado.Dto.TransactionDto;
import com.picpaysimplificado.picpaysimplificado.domain.Entity.user.User;
import com.picpaysimplificado.picpaysimplificado.domain.Entity.user.transaction.Transaction;
import com.picpaysimplificado.picpaysimplificado.repository.TransactionsRepository;
import com.picpaysimplificado.picpaysimplificado.repository.UserRepository;
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
    private RestTemplate restTemplate;

    public Transaction createTransaction(TransactionDto transactionDto) throws Exception {
        User sender = this.userService.findUserByid(transactionDto.senderId());
        User receiver = this.userService.findUserByid(transactionDto.receiverId());

        userService.validadetTransaction(sender, transactionDto.value());

        boolean isAuthorized = this.authorizeTransaction(sender, transactionDto.value());
        if (!isAuthorized) {
            throw new Exception("Transacao nao autorizada");

        }
        Transaction newtransaction = new Transaction();
        newtransaction.setAmount(transactionDto.value());
        newtransaction.setSender(sender);
        newtransaction.setReceiver(receiver);
        newtransaction.setTimestamp(LocalDateTime.now());

        sender.setBalancer(sender.getBalancer().subtract(transactionDto.value()));
        receiver.setBalancer(receiver.getBalancer().add(transactionDto.value()));

        this.transactionsRepository.save(newtransaction);
        this.userService.saveuser(sender);
        this.userService.saveuser(receiver);

    }

    public boolean authorizeTransaction(User sender, BigDecimal value) {
        ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);
        if (authorizationResponse.getStatusCode() == HttpStatus.OK) {
            String message = (String) authorizationResponse.getBody().get("message");
            return "Autorizado".equalsIgnoreCase(message);

        } else return false;
    }
}
