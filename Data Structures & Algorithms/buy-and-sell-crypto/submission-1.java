class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int max = 0;
        while(r != prices.length){
            int buy = prices[l];
            int sell = prices[r];
            int profit = sell - buy;
            if(sell < buy){
                l++;
                if(l == r) r++;
            } else{
                r++;
            }
            if(profit > max){
                max = profit;
            }
        }

        return max;

    }
}
