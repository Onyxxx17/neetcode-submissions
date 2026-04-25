class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while(l < r){
            int val1 = numbers[l];
            int val2 = numbers[r];
            int req = target - val1;
            if(req == val2){
                return new int[] {l+1,r+1};
            } else if(req < val2){
                r--;
            } else{
                l++;
            }
        }

        return new int[2];
    }
}
