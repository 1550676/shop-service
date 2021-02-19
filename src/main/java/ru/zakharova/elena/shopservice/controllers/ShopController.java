package ru.zakharova.elena.shopservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zakharova.elena.shopservice.model.Shop;
import ru.zakharova.elena.shopservice.model.ShopDTO;
import ru.zakharova.elena.shopservice.services.ShopService;

@RestController
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @GetMapping(value = "/dto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getShopDTO(@PathVariable Long id) {
        ShopDTO dto = shopService.getShopDTO(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getShop(@PathVariable Long id) {
        Shop shop = shopService.getShop(id);
        return new ResponseEntity<>(shop, HttpStatus.OK);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Shop addShop(@RequestBody Shop shop) {
        if (shop.getId() != null) {
            shop.setId(null);
        }
        return shopService.addShop(shop);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateShop(@RequestBody  Shop shop) {
        return new ResponseEntity<>(shopService.updateShop(shop), HttpStatus.OK);
    }
}
