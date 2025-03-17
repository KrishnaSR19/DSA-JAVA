class Solution {
    public void pattern14(int n) {
        for(int  i = 1; i<=n ; i++){
           
            for(char ch = 'A' ; ch<'A'+ i; ch++){
                System.out.print(ch);
            }
            System.out.println();

        }

    }
}