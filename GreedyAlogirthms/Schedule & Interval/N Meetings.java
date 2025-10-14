/*
 Given one meeting room and N meetings represented by two arrays, start and end, where start[i] represents the start time of the ith meeting and end[i] represents the end time of the ith meeting, determine the maximum number of meetings that can be accommodated in the meeting room if only one meeting can be held at a time.
 */

/*
 * Time Complexity: O(N+N logN) where 𝑁 is the size of the start and end arrays. The O(N) term accounts for filling the meetings array with start and end times. The O(NlogN) term arises from sorting the meetings based on their end times. After sorting, the function iterates through the sorted meetings in O(N) time to count the maximum number of non-overlapping meetings.
Space Complexity: O(N) since we used an additional data structure for storing the start time and end time.
 */

class Solution {
    // Comparator function to sort meetings based on end times
    static class MeetingComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            // Sort by end time in ascending order
            return Integer.compare(a[1], b[1]);
        }
    }

    // Function to find the maximum number of meetings that can be held
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        // List to store meetings
        List<int[]> meetings = new ArrayList<>();

        // Fill the meetings list with start and end times
        for (int i = 0; i < n; i++) {
            meetings.add(new int[] { start[i], end[i] });
        }

        // Sort the meetings based on the custom comparator
        Collections.sort(meetings, new MeetingComparator());

        // The end time of last selected meeting
        int limit = meetings.get(0)[1];
        // Initialize count
        int count = 1;

        /*
         * Iterate through the meetings
         * to select the maximum number
         * of non-overlapping meetings
         */
        for (int i = 1; i < n; i++) {
            /*
             * If the current meeting starts
             * after the last selected meeting ends
             */
            if (meetings.get(i)[0] > limit) {
                /*
                 * Update the limit to the end
                 * time of the current meeting
                 */
                limit = meetings.get(i)[1];
                // Increment count
                count++;
            }
        }

        // Return count
        return count;
    }
}
