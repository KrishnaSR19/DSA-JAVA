class Solution {
    public void pattern18(int n) {
      for(int i =1;i<=n;i++){
        for(char ch =(char) ('A'+n-i);ch<(char)('A'+n) ;ch++){
          System.out.print(ch + " ");  
        }
        System.out.println();
        
      }
      

    }
}