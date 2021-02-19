package ru.zakharova.elena.shopservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.zakharova.elena.shopservice.model.Shop;
import ru.zakharova.elena.shopservice.model.ShopDTO;

@Slf4j
@Component
@Primary
@RequiredArgsConstructor
public class ProxyService implements ShopService {
    private final ShopServiceImp shopService;

    @Override
    public Shop addShop(Shop shop) {
        Shop result = shopService.addShop(shop);
        log.info("New shop with inn " + shop.getInn() + " was added. ");
        return result;
    }

    @Override
    public Shop getShop(Long id) {
        log.info("The shop with id " + id + " was requested. ");
        return shopService.getShop(id);
    }

    @Override
    public Shop updateShop(Shop shop) {
        Shop result = shopService.updateShop(shop);
        log.info("The shop with inn " + shop.getInn() + " was added. ");
        return result;
    }

    @Override
    public ShopDTO getShopDTO(Long id) {
        log.info("The shop with id " + id + " was requested. ");
        return shopService.getShopDTO(id);

    }
}
