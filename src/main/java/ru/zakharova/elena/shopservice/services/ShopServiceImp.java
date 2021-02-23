package ru.zakharova.elena.shopservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.zakharova.elena.shopservice.model.Shop;
import ru.zakharova.elena.shopservice.model.ShopDTO;
import ru.zakharova.elena.shopservice.repositories.ShopRepository;
import ru.zakharova.elena.shopservice.services.utils.ShopDTOMemento;

@Service
@Primary
@RequiredArgsConstructor
public class ShopServiceImp implements ShopService {

    private final ShopRepository repository;


    @Override
    public Shop addShop(ShopDTO shopDTO) {
        return repository.addShop(shopDTO);
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
        class ShopDTOBuilder {
            private ShopDTO shopDTO = new ShopDTO();
            private ShopDTOMemento memento;

            public void buildName(String name) {
                shopDTO.setName(name);
            }

            public void buildEmail(String email) {
                shopDTO.setEmail(email);
            }

            public void buildInn(String inn) {
                shopDTO.setInn(inn);
            }

            public void buildDomainName(String domainName) {
                shopDTO.setDomainName(domainName);
            }

            public void buildType(String type) {
                shopDTO.setType(type);
            }

            public ShopDTO getShopDTO() {
                return shopDTO;
            }
        }
        Shop shop = getShop(id);
        ShopDTOBuilder builder = new ShopDTOBuilder();
        builder.buildName(shop.getName());
        builder.buildEmail(shop.getEmail());
        builder.buildInn(shop.getInn());
        builder.buildDomainName(shop.getDomainName());
        builder.buildType(shop.getType());
        return builder.getShopDTO();
    }
}
