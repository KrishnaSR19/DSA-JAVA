public class UnionOfArrays {
    import java.util.*;


    public int[] unionArray(int[] nums1, int[] nums2) {
        Set<Integer> set = new TreeSet<>();

        // Insert all elements of nums1 into the set
        for (int num : nums1) {
            set.add(num);
        }

        // Insert all elements of nums2 into the set
        for (int num : nums2) {
            set.add(num);
        }

        // Convert the set to an integer array to get the union
        int[] union = new int[set.size()];
        int index = 0;
        for (int num : set) {
            union[index++] = num;
        }

        return union;
    }


}
