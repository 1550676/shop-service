package ru.zakharova.elena.shopservice.services;

import ru.zakharova.elena.shopservice.model.Shop;
import ru.zakharova.elena.shopservice.model.ShopDTO;

public interface ShopService {
    Shop addShop(Shop shop);
    Shop getShop(Long id);
    Shop updateShop(Shop shop);
    ShopDTO getShopDTO(Long id);
}
