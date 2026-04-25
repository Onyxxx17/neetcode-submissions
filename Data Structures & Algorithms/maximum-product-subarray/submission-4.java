class Solution {
    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length+1];
        if(nums.length == 1) return nums[0];
        dp[0] = 0;
        dp[1] = nums[1];
        dp[2] = Math.max(Math.max(nums[1], dp[0]), nums[1]*nums[0]);
        if(nums.length == 2) return dp[2];
        for(int i = 3; i < nums.length + 1; i++){
            dp[i] = Math.max(nums[i-1],dp[i-1]);
            int product = nums[i-1];
            for(int j = i - 1; j >=1; j--){
                product*=nums[j-1];
                dp[i] = Math.max(product, dp[i]);
            }
        }

        return dp[nums.length];
    }
}
