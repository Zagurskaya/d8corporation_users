package com.gmail.zagurskaya.service.aspect;

import java.time.LocalDateTime;

import com.gmail.zagurskaya.service.model.UserDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.gmail.zagurskaya.service.UserService.add(..))")
    public void callAtTraderServicePublic() {
    }

    @Before("callAtTraderServicePublic()")
    public void beforeCallAtMethod1(JoinPoint jp) {
        UserDTO userDTO = (UserDTO) jp.getArgs()[0];
        logger.info("create user with login = " + userDTO.getUsername() + ", full_name = " + userDTO.getFullName()
                + ", age = " + userDTO.getAge() + ", reg_date  = " + LocalDateTime.now());
    }
}