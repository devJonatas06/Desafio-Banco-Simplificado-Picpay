package com.picpaysimplificado.picpaysimplificado.service;

import com.picpaysimplificado.picpaysimplificado.Dto.UserDto;
import com.picpaysimplificado.picpaysimplificado.domain.Entity.user.User;
import com.picpaysimplificado.picpaysimplificado.domain.Entity.user.UserType;
import com.picpaysimplificado.picpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuario do tipo lojista nao esta autorizado a realizar transacao");
        }
        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo insuficiente");

        }
    }

    public User findUserById(Long id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(() ->  new Exception("Usuario nao encontrado"));
    }
    public User findUserByEmail(String email) throws Exception {
        return this.userRepository.findUserByEmail(email).orElseThrow(() ->  new Exception("Usuario nao encontrado"));
    }
    public User findUserByCpf(String cpf) throws Exception {
        return this.userRepository.findUserByCpf(cpf).orElseThrow(() ->  new Exception("Usuario nao encontrado"));
    }

    public User craeteUser(UserDto data){
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }
    public List<User> getAllUsers(){
        return this.userRepository.findAll();

    }

    public void saveUser(User user){
        this.userRepository.save(user);
    }
}
