class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = Arrays.deepToString(board).replaceAll("[\\[\\], ]", "");
        if (start.equals(target)) return 0;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                int zeroIndex = current.indexOf('0');
                int x = zeroIndex / 3, y = zeroIndex % 3;

                for (int[] dir : directions) {
                    int newX = x + dir[0], newY = y + dir[1];
                    if (newX >= 0 && newX < 2 && newY >= 0 && newY < 3) {
                        char[] chars = current.toCharArray();
                        // Swap 0 with the adjacent number
                        char temp = chars[zeroIndex];
                        chars[zeroIndex] = chars[newX * 3 + newY];
                        chars[newX * 3 + newY] = temp;
                        String next = new String(chars);
                        if (next.equals(target)) return moves + 1;
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}