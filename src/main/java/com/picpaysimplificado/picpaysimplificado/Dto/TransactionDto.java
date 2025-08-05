package com.picpaysimplificado.picpaysimplificado.Dto;

import java.math.BigDecimal;

public record TransactionDto(BigDecimal value, Long senderId, Long receiverId) {
}
