package com.algos.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 7/10/2016
 * Time: 9:28 PM
 */
public class StackUsingQueues<T> {
    private final Queue<T> queue1 = new LinkedList<>();
    private final Queue<T> queue2 = new LinkedList<>();

    public static void main(String[] args) {
        StackUsingQueues<Integer> stack = new StackUsingQueues<>();

        List<Integer> list = new ArrayList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        list.add(stack.pop());
        stack.push(4);
        list.add(stack.pop());
        list.add(stack.pop());
        stack.push(5);
        list.add(stack.pop());
        list.add(stack.pop());

        System.out.println(list.toString()); //"[3, 4, 2, 5, 1]"
//        Assert.assertEquals("[3, 4, 2, 5, 1]", list.toString());
    }

    private void push(T item){
        if(!queue2.isEmpty()){
            queue2.add(item);
        } else {
            queue1.add(item);
        }
    }

    private T pop(){
        if(queue1.isEmpty() && queue2.isEmpty()){
            return null;
        }

        Queue<T> emptyQueue = queue1.isEmpty()?queue1:queue2;
        Queue<T> nonEmptyQueue = queue1.isEmpty()?queue2:queue1;

        T lastItem = null;

        while(nonEmptyQueue.size() > 1){
            emptyQueue.add(nonEmptyQueue.poll());
        }

        return nonEmptyQueue.poll();
    }
}
