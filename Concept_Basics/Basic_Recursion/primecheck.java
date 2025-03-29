public class primecheck {
   
        public boolean checkPrime(int num) {
            // 0 and 1 are not prime numbers
            if (num <= 1) {
                return false; 
            }
            // Call the helper function to check for primality
            return prime(num, 2); 
        }
    
        private boolean prime(int num, int x) {
            if (x > Math.sqrt(num)) {
                return true; 
            }
            // Found a divisor, so the number is not prime
            if (num % x == 0) {
                return false; 
            }
            // Recursive call with the next divisor
            return prime(num, x + 1); 
        }
    
}
