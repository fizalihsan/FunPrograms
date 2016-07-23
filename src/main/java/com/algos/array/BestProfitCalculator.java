package com.algos.array;

/**
 * (Note: This question was asked in Bloomberg interview)
 *
 * Given an array of stock prices like the below calculate the list of dates to buy and sell so that max profit is achieved.
 * But buy and sell cannot be done on the same day.
 *
 * {100, 180, 250, 360, 110, 120, 260, 80, 50, 40}
 *
 * In this case,
 *  buy on $100 and sell on $360
 *  buy again on $110 and sell on $260
 *
 * User: Fizal
 * Date: 7/23/2016
 * Time: 1:37 PM
 */
public class BestProfitCalculator {
    public static void main(String[] args) {

        printBuySellDays(new int[]{100, 180, 250, 360, 110, 120, 260, 80, 50, 40});
        System.out.println("------------");
        printBuySellDays(new int[]{100, 180, 250, 360});
        System.out.println("------------");
        printBuySellDays(new int[]{100, 80, 50, 40});
        System.out.println("------------");
    }

    private static void printBuySellDays(int[] prices){

        int buyPrice = -1;
        int sellPrice = -1;

        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i] < prices[i+1]){
                if(buyPrice == -1) {
                    buyPrice = prices[i];
                }
            } else if(prices[i] > prices[i+1] && buyPrice!=-1) {
                sellPrice = prices[i];
                System.out.println("Buy @ " + buyPrice + " - Sell @ " + sellPrice);
                buyPrice = -1;
            }
        }

        if(sellPrice == -1 && buyPrice!=-1){
            sellPrice = prices[prices.length - 1];

            if(sellPrice > buyPrice) {
                System.out.println("Buy @ " + buyPrice + " - Sell @ " + prices[prices.length - 1]);
            } else {
                System.out.println("Don't sell what is bought @ " + buyPrice);
            }
        }
    }
}
