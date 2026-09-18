class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int m = r + (l- r) / 2;
            System.out.println(m);
            if(nums[m] == target){
                return m;
            } 

            //Right Half is sorted
            if(nums[m] <= nums[r]){
                if(target > nums[m] && target <= nums[r]){
                    l = m + 1;
                } else{
                    r = m - 1;
                }
            } else{
                if(target < nums[m]  && target >= nums[l]){
                    r = m - 1;
                } else{
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
