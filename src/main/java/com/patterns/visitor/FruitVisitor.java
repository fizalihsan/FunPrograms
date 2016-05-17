package com.patterns.visitor;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/15/2016
 * Time: 11:42 AM
 */
public interface FruitVisitor {
    void visit(Apple apple);
    void visit(Orange orange);
}
