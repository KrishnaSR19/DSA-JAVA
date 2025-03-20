class Solution {
    public boolean isPerfect(int n) {
        int sum=0;
        if(n==1){
            return false;
        }
        for(int i =1;i<n;i++){
            if(n%i==0){
                sum=sum+i;
            } 
        }
        return(sum==n);

    }
}