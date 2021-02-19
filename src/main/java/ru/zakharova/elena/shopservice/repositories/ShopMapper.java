package ru.zakharova.elena.shopservice.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.zakharova.elena.shopservice.model.Shop;

@Component
public class ShopMapper {


    private SessionFactory factory;
    private ShopDAO dao;
    @Autowired
    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }
    @Autowired
    public void setDao(ShopDAO dao) {
        this.dao = dao;
    }

    public Shop addShop(Shop shop) {
        dao.addShop(shop);
        Session session = this.factory.getCurrentSession();
        session.save(shop);
        return shop;
    }

    public Shop getShop(Long id) {
        Shop shop = dao.getShop(id);
        if (shop == null){
            Session session = this.factory.getCurrentSession();
            session.beginTransaction();
            shop = session.find(Shop.class, id);
            session.getTransaction().commit();
        }
        System.out.println(shop);
        return shop;

    }

    public Shop updateShop(Shop shop) {
        Session session = this.factory.getCurrentSession();
        session.update(shop);
        dao.updateShop(shop);
        return shop;
    }
}
