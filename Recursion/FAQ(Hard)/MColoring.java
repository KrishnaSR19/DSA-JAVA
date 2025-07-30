/*
 * Q.Given an integer M and an undirected graph with N vertices and E edges. The goal is to determine whether the graph can be coloured with a maximum of M colors so that no two of its adjacent vertices have the same colour applied to them.
In this context, colouring a graph refers to giving each vertex a different colour. If the colouring of vertices is possible then return true, otherwise return false.
 */


/*
 * Time Complexity : O(M^N) where m is the number of colors and n is the number of nodes, since each node can be colored in m ways and there are n nodes to color.
Space Complexity : O(N) for the colors array and O(n) for the adjacency list, resulting in O(N) total space complexity.
 */

class Solution {

    // Function to check if it's safe to color the node with a given color
    private boolean isSafe(int col, int node, int[] colors, List<List<Integer>> adj) {
        // Check adjacent nodes
        for (int neighbor : adj.get(node)) {
            // If an adjacent node has the same color
            if (colors[neighbor] == col) return false;
        }
        return true; // Safe to color
    }

    // Recursive function to solve graph coloring problem
    private boolean solve(int node, int m, int n, int[] colors, List<List<Integer>> adj) {
        // If all nodes are colored
        if (n == node) return true;
        // Try all colors from 1 to m
        for (int i = 1; i <= m; i++) {
            // Check if it is safe to color the node with color i
            if (isSafe(i, node, colors, adj)) {
                colors[node] = i; // Assign color i to node
                // Recursively try to color the next node
                if (solve(node + 1, m, n, colors, adj)) return true;
                colors[node] = 0; // Reset color if it doesn't lead to a solution
            }
        }
        return false; // No color can be assigned
    }

    // Function to check if the graph can be colored with m colors
    public boolean graphColoring(int[][] edges, int m, int n) {
        // Create adjacency list representation of the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // Build the graph from edges
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] colors = new int[n]; // Initialize all colors to 0 (uncolored)
        // Start solving from the first node
        return solve(0, m, n, colors, adj);
    }
}
