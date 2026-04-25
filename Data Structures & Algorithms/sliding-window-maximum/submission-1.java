class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int windowSize = nums.length - k + 1;
        int[] res = new int[windowSize];
        Deque<Integer> deque = new LinkedList<>();
        int l = 0;
        int r = 0;

        while(r < nums.length){
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[r]){
                deque.removeLast();
            }
            deque.addLast(r);

            if(l > deque.getFirst()){
                deque.removeFirst();
            }

            if(r+1 >= k){
                res[l] = nums[deque.getFirst()];
                l++;
            }

            r++;
        }

        return res;
        
    }
}
