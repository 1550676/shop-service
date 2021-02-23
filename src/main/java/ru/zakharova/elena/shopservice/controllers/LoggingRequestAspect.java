package ru.zakharova.elena.shopservice.controllers;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import ru.zakharova.elena.shopservice.model.Shop;
import ru.zakharova.elena.shopservice.model.ShopDTO;

@Slf4j
@Aspect
@Configuration
public class LoggingRequestAspect {

    @After("execution(* ru.zakharova.elena.shopservice.controllers.ShopController.addShop (..))")
    public void logShopAddingRequest(JoinPoint joinPoint) {
        ShopDTO shopDTO = (ShopDTO) joinPoint.getArgs()[0];
        log.info("New shop with inn " + shopDTO.getInn() + " was added. ");
    }

    @After("execution(* ru.zakharova.elena.shopservice.controllers.ShopController.getShop (..))")
    public void logShopRequest(JoinPoint joinPoint) {
        Long id = (Long) joinPoint.getArgs()[0];
        log.info("The shop with id " + id + " was requested. ");
    }

    @After("execution(* ru.zakharova.elena.shopservice.controllers.ShopController.updateShop (..))")
    public void logShopUpdatingRequest(JoinPoint joinPoint) {
        Shop shop = (Shop) joinPoint.getArgs()[0];
        log.info("The shop with inn " + shop.getInn() + " was updated. ");
    }

    @After("execution(* ru.zakharova.elena.shopservice.controllers.ShopController.getShopDTO (..))")
    public void logShopDTORequest(JoinPoint joinPoint) {
        Long id = (Long) joinPoint.getArgs()[0];
        log.info("The shop with id " + id + " was requested. ");
    }

}
