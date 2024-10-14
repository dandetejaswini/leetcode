class Solution {
    public long maxKelements(int[] nums, int k) {
         PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            maxHeap.offer(num);
        }
        
        long score = 0;
        for (int i = 0; i < k; i++) {
            int maxElement = maxHeap.poll();
            score += maxElement;
            maxHeap.offer((int) Math.ceil(maxElement / 3.0));
        }
        
        return score;
    }
}