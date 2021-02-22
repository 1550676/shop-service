package ru.zakharova.elena.shopservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zakharova.elena.shopservice.model.Shop;
import ru.zakharova.elena.shopservice.model.ShopDTO;
import ru.zakharova.elena.shopservice.repositories.ShopRepository;
import ru.zakharova.elena.shopservice.services.utils.ShopDTOBuilder;

@Service
@RequiredArgsConstructor
public class ShopServiceImp implements ShopService {


    private final ShopRepository repository;
    private ShopDTOBuilder builder;


    @Override
    public Shop addShop(Shop shop) {
        return repository.addShop(shop);
    }

    @Override
    public Shop getShop(Long id) {
        return repository.getShop(id);
    }

    @Override
    public Shop updateShop(Shop shop) {
        return repository.updateShop(shop);
    }

    @Override
    public ShopDTO getShopDTO(Long id) {
        Shop shop = getShop(id);
        builder = new ShopDTOBuilder();
        builder.buildName(shop.getName());
        builder.buildEmail(shop.getEmail());
        builder.buildInn(shop.getInn());
        builder.buildDomainName(shop.getDomainName());
        builder.buildType(shop.getType());
        return builder.getShopDTO();
    }
}
