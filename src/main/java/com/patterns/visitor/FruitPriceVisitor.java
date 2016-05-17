package com.patterns.visitor;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/15/2016
 * Time: 11:51 AM
 */
public class FruitPriceVisitor implements FruitVisitor {

    @Override
    public void visit(Apple apple) {
        System.out.println("Apple price is $5/kg");
    }

    @Override
    public void visit(Orange orange) {
        System.out.println("Apple price is $3/kg");
    }
}
