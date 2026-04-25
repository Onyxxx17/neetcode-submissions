class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int upperBound = 0;

        //Get maxValue (upperBound)
        for(int i = 0; i < piles.length; i++){
            if(piles[i] > upperBound){
                upperBound = piles[i];
            }
        }

        int l = 1;
        int r = upperBound;
        int res = 0;
        while(l <= r){
            //Get total hours per array, m = banana per hour
            int m = l + (r - l) / 2;
            int hours = 0;
            for(int i = 0; i < piles.length; i++){
                hours+= Math.ceil((double)piles[i] / m);
            }

            if(hours > h){
                l = m + 1;
            } else{
                res = m;
                r = m - 1;
            }
        }

        return res;
    }
}
