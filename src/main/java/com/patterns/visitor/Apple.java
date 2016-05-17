package com.patterns.visitor;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/15/2016
 * Time: 11:38 AM
 */
public class Apple implements Fruit {

    @Override
    public void accept(FruitVisitor visitor) {
        visitor.visit(this);
    }
}
