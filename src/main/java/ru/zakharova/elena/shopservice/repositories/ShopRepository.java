package ru.zakharova.elena.shopservice.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.zakharova.elena.shopservice.model.Shop;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class ShopRepository {
    private final NamedParameterJdbcTemplate jdbc;
    private final ShopDAO dao;

    @Transactional
    public Shop addShop(Shop shop) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("name", animal.getName());
//        jdbc.update("insert into shops (name) values (:name)", paramSource, holder);
//        animal.setId(holder.getKey().longValue());

        return shop;
    }

    @Transactional
    public Shop getShop(Long id) {
        Shop shop = dao.getShop(id);
        if (shop == null) {
            Map<String, Object> params = new HashMap<>();
            params.put("id", id);
            return jdbc.queryForObject("select * from shops where id=:id", params, new ShopMapper());
        }
        System.out.println(shop);
        return shop;

    }

    @Transactional
    public Shop updateShop(Shop shop) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", shop.getId());
        jdbc.update("insert into shops (id) values (:id)", params);
        dao.updateShop(shop);
        return shop;
    }
}
