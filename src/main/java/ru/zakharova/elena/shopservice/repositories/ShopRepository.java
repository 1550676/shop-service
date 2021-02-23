package ru.zakharova.elena.shopservice.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.zakharova.elena.shopservice.model.Shop;
import ru.zakharova.elena.shopservice.model.ShopDTO;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class ShopRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbc;

    private final ShopDAO dao;

    @Transactional
    public Shop addShop(ShopDTO shopDTO) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue( "name", shopDTO.getName())
                .addValue( "email", shopDTO.getEmail())
                .addValue( "inn", shopDTO.getInn())
                .addValue( "domain_name", shopDTO.getDomainName())
                .addValue( "type", shopDTO.getType())   ;
        final KeyHolder holder = new GeneratedKeyHolder();
        this.namedParameterJdbc.update("insert into shops (name, email, inn, domain_name, type) values " +
                "(:name, :email, :inn, :domain_name, :type)", params, holder, new String[] {"id"} );
        Shop shop = getShop((Long) holder.getKey());
        dao.addShop(shop);
        return shop;
    }

    @Transactional
    public Shop getShop(Long id) {
        Shop shop = dao.getShop(id);
        if (shop == null) {
            Map<String, Object> params = new HashMap<>();
            params.put("id", id);
            return namedParameterJdbc.queryForObject("select * from shops where id=:id", params, new ShopMapper());
        }
        return shop;

    }

    @Transactional
    public Shop updateShop(Shop shop) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue( "id", shop.getId())
                .addValue( "name", shop.getName())
                .addValue( "email", shop.getEmail())
                .addValue( "inn", shop.getInn())
                .addValue( "domain_name", shop.getDomainName())
                .addValue( "type", shop.getType())               ;
        this.namedParameterJdbc.update("update shops set name=:name, email=:email, inn=:inn, " +
                "domain_name=:domain_name, type=:type where id=:id", params);
        dao.updateShop(shop);
        return shop;
    }
}
