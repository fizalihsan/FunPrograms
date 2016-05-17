package com.patterns.visitor;

import java.util.Arrays;
import java.util.List;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/15/2016
 * Time: 11:47 AM
 */
public class Main {
    public static void main(String[] args) {
        List<Fruit> fruits = Arrays.asList(new Apple(), new Orange(), new Orange(), new Apple());

        final FruitVisitor partitionVisitor = new FruitPartitionVisitor();
        final FruitVisitor priceVisitor = new FruitPriceVisitor();
        for (Fruit fruit : fruits) {
            fruit.accept(partitionVisitor);
            fruit.accept(priceVisitor);
        }
    }
}
