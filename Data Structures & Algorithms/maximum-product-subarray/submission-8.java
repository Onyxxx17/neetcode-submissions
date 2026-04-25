class Solution {
    public int maxProduct(int[] nums) {
        //Kadane' Algorithm
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max,nums[i]);
        }
        int curMin = 1; int curMax = 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                curMin = 1;
                curMax = 1;
                continue;
            }
            int temp = curMax;
            curMax = Math.max(Math.max(nums[i],nums[i] * curMin), nums[i] * curMax);
            curMin =  Math.min(Math.min(nums[i],nums[i] * curMin), nums[i] * temp);
            max = Math.max(Math.max(curMax,curMin), max);
        }

        return max;
    }
}
