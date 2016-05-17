package com.patterns.visitor;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/15/2016
 * Time: 11:45 AM
 */
public class FruitPartitionVisitor implements FruitVisitor {

    @Override
    public void visit(Apple apple) {
        System.out.println("This is an apple");
    }

    @Override
    public void visit(Orange orange) {
        System.out.println("This is an orange");
    }
}
