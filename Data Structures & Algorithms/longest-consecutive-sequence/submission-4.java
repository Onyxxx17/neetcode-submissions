class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        int max = 0;

        for(int i = 0; i < nums.length; i++){
            int count = 1;
            if(!set.contains(nums[i] - 1)){
                int length= 1;
                while(set.contains(nums[i] + length)){
                    length++;
                    count++;
                }

                max = Math.max(max,count);
            }
        }

        return max;
    }
}
