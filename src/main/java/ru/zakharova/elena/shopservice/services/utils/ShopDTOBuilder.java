package ru.zakharova.elena.shopservice.services.utils;

import ru.zakharova.elena.shopservice.model.ShopDTO;

public class ShopDTOBuilder {

    private ShopDTO shopDTO = new ShopDTO();
    private ShopDTOMemento memento;


    public void buildName (String name){
        shopDTO.setName(name);
    }

    public void buildEmail (String email){
        shopDTO.setEmail(email);
    }

    public void buildInn (String inn){
        shopDTO.setInn(inn);
    }

    public void buildDomainName (String domainName){
        shopDTO.setDomainName(domainName);
    }

    public void buildType (String type){
        shopDTO.setType(type);
    }

    public ShopDTO getShopDTO() {
        return shopDTO;
    }
}
