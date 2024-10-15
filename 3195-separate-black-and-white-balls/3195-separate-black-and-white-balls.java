class Solution {
    public long minimumSteps(String s) {
         Stack<Integer> stack = new Stack<>();
        long steps = 0;

        // Push positions of black balls onto the stack
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                stack.push(i);
            }
        }

        // Calculate the steps needed to group black balls
        int targetPosition = s.length() - 1;
        while (!stack.isEmpty()) {
            steps += targetPosition - stack.pop();
            targetPosition--;
        }

        return steps;
    }
}