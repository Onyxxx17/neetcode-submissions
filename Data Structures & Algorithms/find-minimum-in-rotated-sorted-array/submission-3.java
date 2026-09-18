class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int m = l + (r - l)/ 2;
            if(nums[m] > nums[r]){
                l = m + 1;
            } else{
                r = m - 1;
            }
            min = Math.min(min,nums[m]);
        }

        return min;
    }
}
