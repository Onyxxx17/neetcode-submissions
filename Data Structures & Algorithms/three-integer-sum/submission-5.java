class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){

            int num1 = nums[i];

            if(num1 > 0) break;
            if(i>0 && nums[i] == nums[i-1]) continue;
            int needed = 0 - num1;
            int l = i+1;
            int r = nums.length - 1;

            while(l < r){
                int num2 = nums[l];
                int num3 = nums[r];
                if(num2 + num3 == needed){
                    res.add(new ArrayList<>(List.of(num1, num2, num3)));
                    l++;
                    r--;
                     while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                } else if(num2 + num3 > needed){
                    r--;
                } else{
                    l++;
                }
            }
        }

        return res;
    }
}
