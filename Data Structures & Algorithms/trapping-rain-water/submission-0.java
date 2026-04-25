class Solution {
    public int trap(int[] height) {
        int l = height.length;
        int[] res = new int[l];
        int max = 0;
        res[0] = 0;
        for(int i = 1; i < height.length; i++){
            res[i] = Math.max(res[i - 1], height[i - 1]);
        }

        int maxR = 0;
        for(int j = l - 1; j >= 1; j--){
            if(height[j] > maxR) maxR = height[j];
            res[j] = Math.min(res[j], maxR) - height [j];

            if(res[j] > 0){
                max+=res[j];
            }
        }
        
        return max;

    }
}
