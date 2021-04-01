package tech.itpark.citilink.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Laptop extends Product {
    private int diagonal;
    private int battery;
    private String cpu;


    public Laptop(long id, String name, int price, boolean removed) {
        super(id, name, price, removed);
    }
}
