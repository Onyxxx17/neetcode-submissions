class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        for(int i = 0; i < nums.length; i++){
            int count = 1;
            if(!set.contains(nums[i] - 1)){
                int length = 1;
                while(set.contains(nums[i] + length)){
                    count++;
                    length++;
                }

                if(count > max) max = count;
            }
        }
        return max;

    }
}
