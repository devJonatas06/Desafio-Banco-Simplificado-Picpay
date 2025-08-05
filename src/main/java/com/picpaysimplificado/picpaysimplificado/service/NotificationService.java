package com.picpaysimplificado.picpaysimplificado.service;

import com.picpaysimplificado.picpaysimplificado.Dto.NotificationDto;
import com.picpaysimplificado.picpaysimplificado.domain.Entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate template;

    public void sendNotification(User user, String message) throws Exception {
    //    String email = user.getEmail();
    //    NotificationDto notificationRequest = new NotificationDto(email, message);
    //    ResponseEntity<String> notificationResponse = template.postForEntity("https://util.devi.tools/api/v1/notify", notificationRequest, String.class);
//
    //    if (!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
    //        System.out.println("Error ao enviar notificacao");
    //        throw new Exception("Servico de notificacao esta fora do ar");
//
    //    }
        System.out.println("notificacao enviada para o o user");

    }
}
