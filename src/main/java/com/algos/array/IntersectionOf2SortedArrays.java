package com.algos.array;

import java.util.LinkedList;
import java.util.List;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 7/13/2016
 * Time: 9:18 PM
 */
public class IntersectionOf2SortedArrays {
    public static void main(String[] args) {
        int[] a = new int[]{4,5,6};
        int[] b = new int[]{1,2,3};

        System.out.println(intersection(a, b));
    }

    private static List<Integer> intersection(int[] a, int[] b){
        List<Integer> list = new LinkedList<>();

        if(a.length==0 || b.length==0 || b[0]>a[a.length-1]){
            return list;
        }

        int i = 0, j = 0;

        while(i<a.length && j<b.length){
            if(a[i] == b[j]){
                list.add(a[i]);
                i++;
                j++;
            } else if(a[i]<b[j]){
                i++;
            } else {
                j++;
            }
        }

        return list;
    }
}
