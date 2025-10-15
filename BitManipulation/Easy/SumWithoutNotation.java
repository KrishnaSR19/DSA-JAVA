class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int xor = a ^ b;         // sum without carry
            int carry = (a & b) << 1; // carry bits shifted left
            a = xor;                  // new sum
            b = carry;                // new carry
        }
        return a;
    }
}
