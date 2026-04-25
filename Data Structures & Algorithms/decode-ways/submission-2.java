class Solution {
    public int numDecodings(String s) {

        if(s.charAt(0)=='0') return 0;
        int dp[] = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < s.length() + 1; i++){
            if(s.charAt(i-1)=='0'){
                if(s.charAt(i-2) != '2' && s.charAt(i-2) != '1'){
                    return 0;
                } else{
                    dp[i] = dp[i-2];
                }

            } else{
                int sub = Integer.parseInt(s.substring(i-2,i));
                dp[i] += dp[i-1];
                if(sub >= 10 && sub <= 26){
                    dp[i] += dp[i-2];
                }
            }
        }

        return dp[s.length()];
    }
}
