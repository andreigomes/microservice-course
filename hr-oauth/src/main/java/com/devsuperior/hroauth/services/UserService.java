package com.devsuperior.hroauth.services;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.feignClients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserFeignClient userFeignClient;

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();

        if (user == null) {
            logger.error("Email não encontrado: " + email);
            throw new IllegalArgumentException("Email não encontrado");
        }
        logger.info("Email encontrado: " + email);
        return user;
    }
}
