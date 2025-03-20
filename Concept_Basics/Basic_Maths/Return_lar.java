class Solution {
    public int largestDigit(int n) {
        int ld=0;
        while(n!=0){
            int d = n%10;
            if(d>ld){
                ld=d;
            }
            n=n/10;
        }
        return ld;

    }
}