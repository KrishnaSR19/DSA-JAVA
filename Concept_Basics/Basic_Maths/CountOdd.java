class Solution {
    public int countOddDigit(int n) {
        int count = 0;
        while(n!=0){
           int d=n%10;
            n=n/10;
            if(d%2!=0){
                count++;
            }
        }
        return count;

    }
}