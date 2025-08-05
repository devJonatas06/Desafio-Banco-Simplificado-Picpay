package com.picpaysimplificado.picpaysimplificado.Dto;

import com.picpaysimplificado.picpaysimplificado.domain.Entity.user.UserType;

import java.math.BigDecimal;

public record UserDto(String firstName, String lastName, String cpf, String email, String password, BigDecimal balance, UserType userType) {
}
