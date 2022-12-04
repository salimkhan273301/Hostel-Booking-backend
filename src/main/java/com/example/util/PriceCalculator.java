package com.example.util;

import java.util.List;

import com.example.model.Feature;
import com.example.model.Room;

public class PriceCalculator {
    public static double getPrice(Room room, List<Feature> features) {

        double price = room.getPrice();

        if (price < 0) {
            return -1;
        }

        for (Feature feature : features) {
            price += feature.getPrice();
        }

        return price;
    }
}
