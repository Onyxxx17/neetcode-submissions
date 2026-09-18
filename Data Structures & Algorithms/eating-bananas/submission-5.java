class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int res = Integer.MAX_VALUE;
        int max = 0;
        for(int pile: piles){
            max = Math.max(pile,max);
        }

        int l = 1;
        int r = max;

        while(l <= r){
            int m = l + (r - l) / 2;

            int hours = 0;
            for(int pile: piles){
                hours = hours + (int) Math.ceil(pile / (double)m);   
            }
            if(hours <= h){
                r = m - 1;
                res = Math.min(m,res);
            } else{
                l = m + 1;
            }
        }

        return res;
    }
}
