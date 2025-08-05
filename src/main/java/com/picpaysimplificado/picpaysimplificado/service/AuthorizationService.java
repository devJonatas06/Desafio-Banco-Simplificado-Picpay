package com.picpaysimplificado.picpaysimplificado.service;

import com.picpaysimplificado.picpaysimplificado.domain.Entity.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class AuthorizationService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${app.authorizationApi}")
    private String authApiUrl;

    public boolean authorizeTransaction(User sender, BigDecimal value){
        ResponseEntity<Map> response = restTemplate.getForEntity(this.authApiUrl, Map.class);

        if(response.getStatusCode() == HttpStatus.OK){
            Map<String, Object> responseBody = response.getBody();
            if (responseBody == null) return false;

            Map<String, Object> data = (Map<String, Object>) responseBody.get("data");
            if (data == null) return false;

            Boolean authorized = (Boolean) data.get("authorization");
            return Boolean.TRUE.equals(authorized);
        }

        return false;
    }

}

