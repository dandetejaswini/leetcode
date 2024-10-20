class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
         Set<String> obs = new HashSet<>();
        for (int[] o : obstacles) obs.add(o[0] + "," + o[1]);
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int x = 0, y = 0, d = 0, maxDist = 0;
        
        for (int cmd : commands) {
            if (cmd == -2) d = (d + 3) % 4; // Turn left
            else if (cmd == -1) d = (d + 1) % 4; // Turn right
            else {
                for (int k = 0; k < cmd; k++) {
                    if (!obs.contains((x + dirs[d][0]) + "," + (y + dirs[d][1]))) {
                        x += dirs[d][0];
                        y += dirs[d][1];
                        maxDist = Math.max(maxDist, x * x + y * y);
                    } else break;
                }
            }
        }
        return maxDist;
    }
}