public class RemoveDulpli {
    import java.util.*;
        // Function to remove duplicates from the array
        public int removeDuplicates(int[] nums) {
            
            // TreeSet to store unique elements in sorted order
            Set<Integer> s = new TreeSet<>();
            
            // Add all elements from array to the set
            for (int val : nums) {
                s.add(val);
            }
            
            // Get the number of unique elements
            int k = s.size();
            
            int j = 0;
            // Copy unique elements from set to array
            for (int val : s) {
                nums[j++] = val;
            }
            
            // Return the number of unique elements
            return k;
        }
}
