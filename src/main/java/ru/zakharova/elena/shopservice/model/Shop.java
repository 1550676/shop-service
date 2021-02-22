package ru.zakharova.elena.shopservice.model;

import lombok.Data;


@Data
public class Shop {

    private Long id;

    private String name;

    private String email;

    private String inn;

    private String domainName;

    private String type;
}
