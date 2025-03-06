class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int totalSum = n * n * (n * n + 1) / 2;
        int actualSum = 0;
        HashSet<Integer> seen = new HashSet<>();
        int repeated = -1;

        for (int[] row : grid) {
            for (int num : row) {
                if (seen.contains(num)) {
                    repeated = num;
                } else {
                    seen.add(num);
                }
                actualSum += num;
            }
        }

        int missing = totalSum - (actualSum - repeated);
        return new int[]{repeated, missing};
    }
}