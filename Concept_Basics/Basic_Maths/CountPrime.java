class Solution {
    public boolean isPrime(int n) {
    if(n==1){
        return false;
    }
    for(int i=2;i<n;i++){
        if(n%i==0){
            return false;
        }
    }
    return true;
}
public int primeUptoN(int n) {
    int count=0;
    for(int i=1;i<=n;i++){
        if(isPrime(i)){
            count = count+1;
        }
    }
    return count;

}
}