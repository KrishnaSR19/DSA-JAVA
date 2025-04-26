
/*
 * Q.Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays. The elements in the union must be in ascending order.
The union of two arrays is an array where all values are distinct and are present in either the first array, the second array, or both.
 */

/*
 * Brute Force
 * Time Complexity: O( (M+N)log(M+N) ), at max set can store M+N elements {when there are no common elements and elements in nums1 , nums2 are distntict}. So Inserting M+N th element takes log(M+N) time. Upon approximation across inserting all elements in worst, it would take O((M+N)log(M+N) time.
Space Complexity: O(M+N), considering space of Union Array.
 */

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


/*
 * Union Of two arrays
 * Time Complexity: O(M+N), because both the arrays must be traversed once.
Space Complexity: O(M+N)
The auxiliary space used is O(1) as no extra space is used. However, considering the space for returning the output, the overall space complexity will be O(M+N).
 */

 public int[] unionArray(int[] nums1, int[] nums2) {
    List<Integer> UnionList = new ArrayList<>();
    int i = 0, j = 0;
    int n = nums1.length;
    int m = nums2.length;

    while (i < n && j < m) {
         // Case 1 and 2
        if (nums1[i] <= nums2[j]) {
            if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums1[i]) {
                UnionList.add(nums1[i]);
            }
            i++;
        } 
        // Case 3
        else {
            if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums2[j]) {
                UnionList.add(nums2[j]);
            }
            j++;
        }
    }

    // Add remaining elements of nums1, if any
    while (i < n) {
        if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums1[i]) {
            UnionList.add(nums1[i]);
        }
        i++;
    }

    // Add remaining elements of nums2, if any
    while (j < m) {
        if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums2[j]) {
            UnionList.add(nums2[j]);
        }
        j++;
    }

    // Convert List<Integer> to int[]
    int[] Union = new int[UnionList.size()];
    for (int k = 0; k < UnionList.size(); k++) {
        Union[k] = UnionList.get(k);
    }

    return Union;
}
