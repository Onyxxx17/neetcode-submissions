class Solution {
    public int coinChange(int[] coins, int amount) {
        int cache[] = new int[amount+1];

        cache[0] = 0;
        for(int i = 1; i < cache.length; i++){
            cache[i] = amount + 1;
        }

        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){
                    cache[i] = Math.min(cache[i], 1 + cache[ i - coins[j]]);
                }
            }
        }
        return cache[amount] == amount + 1 ? -1 : cache[amount];
    }
}