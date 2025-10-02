/*
 * Q.Each lemonade at a booth sells for $5. Consumers are lining up to place individual orders, following the billing order. Every consumer will purchase a single lemonade and may pay with a $5, $10, or $20 bill. Each customer must receive the appropriate change so that the net transaction is $5. Initially, there is no change available.
Determine if it is possible to provide the correct change to every customer. Return true if the correct change can be given to every customer, and false otherwise.
Given an integer array bills, where bills[i] is the bill the ith customer pays, return true if the correct change can be given to every customer, and false otherwise.
 */
class Solution {
    public boolean lemonadeChange(int[] bills) {
        // Counter for $5
        int five = 0;
        // Counter for $10
        int ten = 0;
        // Iterate through each customer's bill
        for (int bill : bills) {
            /*
             * If the customer's
             * bill is $5
             */
            if (bill == 5) {

                // Increment $5
                five++;
            }
            /*
             * If the customer's
             * bill is $10
             */
            else if (bill == 10) {

                /*
                 * Check if there are $5
                 * bills available to give change
                 */
                if (five > 0) {
                    // Use one $5
                    five--;
                    // Receive one $10
                    ten++;
                } else {
                    // If no $5 bill available, return false
                    return false;
                }
            }
            /*
             * If the customer's
             * bill is $20
             */
            else {
                /*
                 * Check if there are both
                 * $5 and $10 bills
                 * available to give change
                 */
                if (five > 0 && ten > 0) {
                    // Use one $5
                    five--;
                    // Use one $10
                    ten--;
                }
                /*
                 * If there are not enough $10 bills,
                 * check if there are at least
                 * three $5 bills available
                 */
                else if (five >= 3) {
                    // Use three $5 bills
                    five -= 3;
                }
                /*
                 * If unable to give
                 * change, return false
                 */
                else {
                    return false;
                }
            }
        }
        // Return true
        return true;
    }
}
