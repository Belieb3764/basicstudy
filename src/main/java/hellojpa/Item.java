package hellojpa;

import jakarta.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED) //조인 전략
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//단일테이블전략
@DiscriminatorColumn
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
