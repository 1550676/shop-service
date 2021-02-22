package ru.zakharova.elena.shopservice.repositories;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.zakharova.elena.shopservice.model.Shop;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ShopMapper implements RowMapper<Shop> {

    @Override
    public Shop mapRow(ResultSet resultSet, int i) throws SQLException {
        Shop shop = new Shop();
        shop.setId(resultSet.getLong("id"));
        shop.setName(resultSet.getString("name"));
        shop.setEmail(resultSet.getString("email"));
        shop.setInn(resultSet.getString("inn"));
        shop.setDomainName(resultSet.getString("domain_name"));
        shop.setType(resultSet.getString("type"));
        return shop;
    }
}
