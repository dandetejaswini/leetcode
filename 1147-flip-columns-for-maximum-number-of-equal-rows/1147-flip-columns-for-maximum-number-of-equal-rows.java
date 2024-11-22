class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> map = new HashMap<>();
                int maxRows = 0;

                        for (int[] row : matrix) {
                                    StringBuilder key = new StringBuilder();
                                                for (int j = 0; j < row.length; j++) {
                                                                key.append(row[j] ^ row[0]); // Flip based on the first element
                                                                            }
                                                                                        String keyStr = key.toString();
                                                                                                    map.put(keyStr, map.getOrDefault(keyStr, 0) + 1);
                                                                                                                maxRows = Math.max(maxRows, map.get(keyStr));
                                                                                                                        }

                                                                                                                                return maxRows;
    }
}