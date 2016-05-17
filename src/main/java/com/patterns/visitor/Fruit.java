package com.patterns.visitor;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/15/2016
 * Time: 11:38 AM
 */
public interface Fruit {
    void accept(FruitVisitor visitor);
}
