class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> indices = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            indices.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            int needed = target - nums[i];
            if(indices.containsKey(needed) && indices.get(needed)!=i){
                return new int[]{i,indices.get(needed)};
            }
        }

        return new int[]{0,0};
    }
}
