class Solution {
    public int numTeams(int[] rating) {
         int count = 0;
        int n = rating.length;

        for (int j = 0; j < n; j++) {
            int leftLess = 0, leftGreater = 0, rightLess = 0, rightGreater = 0;

            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) leftLess++;
                else leftGreater++;
            }

            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j]) rightLess++;
                else rightGreater++;
            }

            count += leftLess * rightGreater; // (rating[i] < rating[j] < rating[k])
            count += leftGreater * rightLess; // (rating[i] > rating[j] > rating[k])
        }

        return count;
    }
}