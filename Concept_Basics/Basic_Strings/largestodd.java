public class largestodd {
    public String largeOddNum(String s) {
        // your code goes here
        int j = -1;
        int n = s.length()-1;
        for (int i = n; i >=0; i--) {
          if ((s.charAt(i) - '0') % 2 == 1) {
            j = i;
            break;
          }
        }
        if (j == -1) return "";
    
    
        int i = 0;
        while (i <= n) {
          if (s.charAt(i) != '0') {
            break;
          }
          i++;
        }
    
        return s.substring(i, j + 1);
      }
    
}
