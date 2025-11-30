/*
 * Problem Statement:
 * Write a Java program that prints the numbers from 1 to n. For multiples of
 * three, print "Fizz" instead of the number, for multiples of five, print
 * "Buzz", and for numbers which are multiples of both three and five, print
 * "FizzBuzz".
 */

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> str = new ArrayList<>();

        for(int i = 1 ; i<=n ; i++){
            String out = "";

            if(i%3==0)out+="Fizz";
            if(i%5==0) out+="Buzz";
            if(out.isEmpty()) out = String.valueOf(i);

            str.add(out);
        }

        return str;
    }
}