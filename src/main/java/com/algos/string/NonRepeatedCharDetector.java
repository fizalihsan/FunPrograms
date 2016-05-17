package com.algos.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/13/2016
 * Time: 4:18 PM
 */
public class NonRepeatedCharDetector {
    public static void main(String[] args) {
        System.out.println(detect("teeter"));
        System.out.println(detect("total"));
    }

    /**
     * Efficiency = O(2n) which is O(n)
     * @param str
     * @return
     */
    private static Character detect(String str){
        Map<Character, Integer> map = new HashMap<>();

        //1st loop - O(n)
        for (char c : str.toCharArray()) {
            Integer count = map.get(c);
            if(count==null){
                count = 0;
            }
            map.put(c, ++count);
        }

        //2nd loop - O(n)
        for (char c : str.toCharArray()) {
            if(map.get(c)==1){
                return c;
            }
        }

        return null;
    }
}
