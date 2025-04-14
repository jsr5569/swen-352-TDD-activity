package edu.rit.swen352.tdd;

import java.util.ArrayList;
import java.util.List;

public class ShoeAccount {

    List<Shoe> shoes;

    public ShoeAccount() {
        this.shoes = new ArrayList<>();
    }

    public void addShoe(Shoe shoe) {
        shoes.add(shoe);
    }

    public void removeShoe(Shoe shoe) {
        shoes.remove(shoe);
    }

    public void reduceShoePrice(Shoe shoe, double price) {
        return;
    }
}
