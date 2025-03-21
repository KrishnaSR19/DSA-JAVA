class Solution {
    public int LCM(int n1, int n2) {
        int i = 1;
        int maxNum = Math.max(n1,n2);
        do{
            int multiple = i * maxNum;
            if(multiple % n1 == 0 && multiple % n2==0)
                        return multiple;
            i = i + 1;            
            
        }while(true);

    }
}