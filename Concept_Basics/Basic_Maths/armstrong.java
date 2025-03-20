class Solution {
    public int countDigit(int n) {
        int count = 0;
        if (n == 0) {
            return 1;
        }
        while (n != 0) {
            n = n / 10;
            count++;
        }
        return count;
    }

    public boolean isArmstrong(int n) {
        int count = countDigit(n);  // No need for 'int' keyword here
        int num = n;
        int sum = 0;
        int d;

        while (n > 0) {
            d = n % 10;
            sum += (int) Math.pow(d, count);  // Cast result to int
            n = n / 10;
        }
        return (num == sum);
    }
}
