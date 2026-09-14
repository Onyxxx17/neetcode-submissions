class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int first = nums[i];
            
            int l = i+1;
            int r = nums.length - 1;

            while(l < r){
                int second = nums[l];
                int third = nums[r];

                int sum = first + second + third;

                if(sum > 0){
                    r--;
                } else if(sum < 0){
                    l++;
                } else{
                    res.add(Arrays.asList(first,second,third));
                    l++;
                    r--;
                    while( l < r && nums[l] == nums[l-1]){
                        l++;
                    }
                }
            }

        }

        return res;
    }
}
