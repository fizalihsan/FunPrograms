package com.algos.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/15/2016
 * Time: 10:48 PM
 */
public class BaseConversion {
    public static void main(String[] args) {
        int toBase = 16;
        for (int i : new int[]{Integer.MIN_VALUE, -2, -1, 0, 1, 2, Integer.MAX_VALUE}) {
            System.out.println("Decimal " + i + " to base " + toBase + " = " + fromDecimal(i, toBase));
        }
        System.out.println("------------------------");

        int fromBase = 2;
        for (String i : new String[]{"-10000000000000000000000000000000", "-10", "-1", "0", "1", "10", "1111111111111111111111111111111"}) {
            System.out.println("From base " + fromBase + ", value of " + i + " in decimal = " + toDecimal(i, fromBase));
        }
        System.out.println("------------------------");

        fromBase = 8;
        for (String i : new String[]{"-20000000000", "-2", "-1", "0", "1", "2", "17777777777"}) {
            System.out.println("From base " + fromBase + ", value of " + i + " in decimal = " + toDecimal(i, fromBase));
        }
        System.out.println("------------------------");

        fromBase = 16;
        for (String i : new String[]{"-80000000", "-2", "-1", "0", "1", "2", "7FFFFFFF"}) {
            System.out.println("From base " + fromBase + ", value of " + i + " in decimal = " + toDecimal(i, fromBase));
        }
        System.out.println("------------------------");
    }

    private static final Map<Integer, String> MAP = new HashMap<>();
    static {
        MAP.put(16, "0123456789ABCDEF");
    }

    private static String fromDecimal(int num, int base){
        if(num==0){
            return "0";
        }
        Stack<String> stack = new Stack<>();
        String map = MAP.get(base);

        while(num!=0){
            final int remainder = num % base;
            String value = map==null?""+remainder:""+map.charAt(Math.abs(remainder));
            stack.push(value);
            num/=base;
        }

        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()){
            builder.append(stack.pop());
        }

        return builder.toString();
    }

    private static int toDecimal(String num, int base){
        boolean isNegative = num.trim().startsWith("-");

        int decimal = 0;
        int n = isNegative?num.length()-1:num.length();
        String map = MAP.get(base);

        for (char c : num.toCharArray()) {
            if(c == '-'){
                continue;
            }

            decimal+= Math.pow(base, --n) * (map==null?Integer.parseInt(c+""):map.indexOf(c));
        }

        return isNegative?-1*decimal:decimal;
    }
}
