class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length()+1;
        int n = text2.length()+1;

        //Dp table
        int cache[][] = new int[m][n];

        //Base cases (for empty string comparison everything is zero)
        for(int i = 0; i < m; i++){
            cache[i][0] = 0;
        }

        for(int i = 0; i < n; i++){
            cache[0][i] = 0;
        }

        //Main logic using formula
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    cache[i][j] = 1 + cache[i-1][j-1];
                } else{
                    cache[i][j] = Math.max(cache[i-1][j],cache[i][j-1]);
                }
                // System.out.println(i + ", " + j + " = " + cache[i][j]);
            }
        }
        return cache[m-1][n-1];
    }
}
