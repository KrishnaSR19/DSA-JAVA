class Solution {
    public int factorial(int n) {
        if(n==0){
            return 1;
        }
        int fact = factorial(n-1)*n;
        return fact;

    }
}