package ru.zakharova.elena.shopservice.repositories;

import org.springframework.stereotype.Component;
import ru.zakharova.elena.shopservice.model.Shop;

import java.util.HashMap;
import java.util.Map;

@Component
public class ShopDAO {
    private Map<Long, Shop> identityMap = new HashMap<>();

    public void addShop(Shop shop) {
        identityMap.put(shop.getId(), shop);
    }

    public Shop getShop(Long id) {
        return identityMap.get(id);
    }

    public void updateShop(Shop shop) {
        if (identityMap.containsKey(shop.getId())){
            identityMap.remove(shop);
        }
        addShop(shop);
    }

}
