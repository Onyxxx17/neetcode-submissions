class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean dp[] = new boolean[s.length()+1];

        dp[s.length()] = true;

        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = 0; j < wordDict.size(); j++){
                String word = wordDict.get(j);
                if(i + word.length() <= s.length() && s.substring(i, i+word.length()).equals(word)){
                    dp[i] = dp[i+word.length()];
                }
                if(dp[i]) break;
            }

        }
        return dp[0];
    }
}
