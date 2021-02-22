package ru.zakharova.elena.shopservice.controllers;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@Slf4j
@Aspect
@Configuration
public class LoggingRequestAspect {

    // logging user's authentication attempt
//    @After("execution(* ru.zakharova.elena.shopservice.controllers.ShopController.* (..))")
//    public void logAuthRequest(JoinPoint joinPoint) {
//
//        SystemUser systemUser = (SystemUser) joinPoint.getArgs()[0];
//        log.info("Request for user's authentication with email: " + systemUser.getEmail() +
//                " and password: " + systemUser.getPassword());
//    }


}
