class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
         int n = customers.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (grumpy[i] == 0 ? customers[i] : 0);
        }

        int maxAdditionalSatisfied = 0;

        for (int i = 0; i <= n - minutes; i++) {
            int additionalSatisfied = 0;
            for (int j = i; j < i + minutes; j++) {
                if (grumpy[j] == 1) {
                    additionalSatisfied += customers[j];
                }
            }
            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, additionalSatisfied);
        }

        return prefixSum[n] + maxAdditionalSatisfied;
    }
}