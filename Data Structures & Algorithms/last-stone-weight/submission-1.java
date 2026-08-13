class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone: stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1){
            int largest = maxHeap.poll();
            int sLargest = maxHeap.poll();

            if(largest > sLargest){
                maxHeap.offer(largest - sLargest);
            }
        }

        return maxHeap.size() > 0 ? maxHeap.poll() : 0;
    }
}
