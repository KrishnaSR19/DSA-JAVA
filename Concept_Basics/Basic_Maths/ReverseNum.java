class Solution {
    public int reverseNumber(int n) {
        int newNum = 0;
        while(n!=0){
            int d = n%10;
            newNum = (newNum*10)+d;
            n = n/10;

        }
        return newNum;

    }
}