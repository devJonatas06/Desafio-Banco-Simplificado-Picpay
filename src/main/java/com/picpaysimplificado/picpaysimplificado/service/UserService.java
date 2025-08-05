package com.picpaysimplificado.picpaysimplificado.service;

import com.picpaysimplificado.picpaysimplificado.domain.Entity.user.User;
import com.picpaysimplificado.picpaysimplificado.domain.Entity.user.UserType;
import com.picpaysimplificado.picpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void validadetTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuario do tipo lojista nao esta autorizado a realizar transacao");
        }
        if (sender.getBalancer().compareTo(amount) < 0) {
            throw new Exception("Saldo insuficiente");

        }
    }

    public User findUserByid(Long id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(() ->  new Exception("Usuario nao encontrado"));
    }

    public void saveuser( User user){
        this.userRepository.save(user);
    }
}
