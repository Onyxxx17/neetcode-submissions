class Solution {
    public int trap(int[] height) {
        //First find the max height on the left side of the cell
        int max = 0;
        int res[] = new int[height.length];
        for(int i = 1;i < height.length; i++){
            res[i] = Math.max(res[i-1],height[i-1]);
            System.out.print(res[i]);
        }
        //Now compare with max right side and get the total water store in each cell
        int maxRight = 0;
        for(int i = height.length - 1;i>=0; i--){
            maxRight = Math.max(height[i],maxRight);
            int curr = Math.min(res[i],maxRight) - height[i];
        
            if(curr > 0) max += curr;
        }
        return max;
    }
}
