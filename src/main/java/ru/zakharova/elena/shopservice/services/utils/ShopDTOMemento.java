package ru.zakharova.elena.shopservice.services.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShopDTOMemento {
    private String name;
    private String email;
    private String inn;
    private String domainName;
    private String type;


}
