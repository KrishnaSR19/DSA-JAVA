class Solution {
    public String toHex(int num) {
        if (num == 0) return "0"; // edge case
        
        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        
        // Treat as unsigned 32-bit number
        long n = num & 0xFFFFFFFFL;
        
        while (n != 0) {
            int digit = (int)(n & 0xF); // get last 4 bits
            sb.append(hexChars[digit]);
            n >>= 4; // shift right 4 bits
        }
        
        return sb.reverse().toString(); // reverse to get correct order
    }
}
