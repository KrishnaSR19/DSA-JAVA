class Solution {
    public void pattern17(int n) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n - i; j++) {
          System.out.print(" ");
        }
        char ch = 'A';
        int numberOfCharacters = 2 * i - 1;
        for (int j = 1; j <= numberOfCharacters; j++) {
          System.out.print(ch);
          if (j < i) {
            ch++;
          } else {
            ch--;
          }
        }
        for (int j = 1; j <= n - i; j++) {
          System.out.print(" ");
        }
        System.out.println();
      }
    }
  }
  