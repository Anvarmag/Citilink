package tech.itpark.citilink.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Iphone extends Product {
    private String color;
    private int memory;


    public Iphone(long id, String name, int price, boolean removed) {
        super(id, name, price, removed);
    }
}
