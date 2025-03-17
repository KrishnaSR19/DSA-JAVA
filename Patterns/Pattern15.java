class Solution {
    public void pattern15(int n) {
        for(int i  = 0 ; i<n;i++){
            for(char ch = 'A' ; ch<'A'+(n-i); ch++){
                System.out.print(ch);
            }
            System.out.println();

        }
        
    }
}