class Solution {
    public boolean isPowerOfFour(int n) {
        // n must be positive
        // n must be a power of 2 (only one bit set)
        // the 1-bit must be at an odd position (e.g., 1, 4, 16, 64, etc.)
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}