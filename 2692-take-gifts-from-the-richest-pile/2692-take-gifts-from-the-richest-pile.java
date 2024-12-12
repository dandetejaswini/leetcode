class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            maxHeap.offer(gift);
        }
        
        for (int i = 0; i < k; i++) {
            int maxGift = maxHeap.poll();
            int remainingGifts = (int) Math.floor(Math.sqrt(maxGift));
            maxHeap.offer(remainingGifts);
        }
        
        long totalRemainingGifts = 0;
        while (!maxHeap.isEmpty()) {
            totalRemainingGifts += maxHeap.poll();
        }
        
        return totalRemainingGifts;
    }
}