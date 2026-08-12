class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int pile: piles){
            max = Math.max(pile,max);
        }

        int low = 1;
        int high = max;

        while(low <= high){
            int mid = (low + high) / 2;
            System.out.println(mid);
            //Check the max hours
            int hours = 0;
            for(int pile: piles){
                hours = hours + (int)Math.ceil(pile / (double)mid);
            }
            System.out.println(hours);
            if(hours <= h){
              high = mid - 1;
              max = Math.min(max,mid);
            } else{
                low = mid + 1;
            }
        }

        return max;
    }
}
