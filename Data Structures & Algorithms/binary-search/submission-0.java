class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int l, int r, int target){
        if( l > r ) return -1;
        int m = l + (r - l) / 2;

        if(nums[m] == target) return m;

        if(nums[m] > target){
            r = m - 1;
        } else{
            l = m + 1;
        }
        return binarySearch(nums,l,r,target);
    }
}
