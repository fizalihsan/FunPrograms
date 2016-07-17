package com.algos.numbers;

import java.util.HashMap;
import java.util.Map;

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

        toBase = 62;
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

        for (String i : new String[]{"A", "Z", "AA", "AZ", "ZZ"}) {
            System.out.println("Excel column " + i + " is index = " + excelColumnNameToIndex(i));
        }
        System.out.println("------------------------");
    }

    private static final Map<Integer, String> MAP = new HashMap<>();
    static {
        MAP.put(16, "0123456789ABCDEF");
        MAP.put(62, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
    }

    public static String fromDecimal(int num, int base){
        if(num==0){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        String map = MAP.get(base);

        while(num!=0){
            final int remainder = num % base;
            String value = map==null?""+remainder:""+map.charAt(Math.abs(remainder));
            result.append(value);
            num/=base;
        }

        return result.reverse().toString();
    }

    public static int toDecimal(String num, int base){
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

    public static int excelColumnNameToIndex(String columnName) {
        int index = 0;
        char[] name = columnName.toUpperCase().toCharArray();

        for(int i = 0; i < name.length; i++) {
            index *= 26;
            index += name[i] - 'A' + 1;
        }

        return index;
    }
}
