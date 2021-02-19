package ru.zakharova.elena.shopservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zakharova.elena.shopservice.services.utils.ShopDTOMemento;

@Data
@NoArgsConstructor
public class ShopDTO {

    private String name;
    private String email;
    private String inn;
    private String domainName;
    private String type;

    public ShopDTOMemento saveState()
    {
        return new ShopDTOMemento(name, email, inn, domainName, type);
    }

    // восстановление состояния
    public void restoreState(ShopDTOMemento memento)
    {
        this.name=memento.getName();
        this.email = memento.getEmail();
        this.inn = memento.getInn();
        this.domainName = memento.getDomainName();
        this.type = memento.getType();
    }
}
