package edu.rit.swen352.tdd;

import java.util.ArrayList;
import java.util.List;

public class ShoeAccount {

    public class Shoe {
        double size;
        float price;
        String condition;
    }
    List<Shoe> shoes;

    public ShoeAccount() {
        this.shoes = new ArrayList<>();
    }

}
