class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;

        int l = 0;
        int r = 0;
        int maxF = 0;
        while(r < s.length()){
            if(!map.containsKey(s.charAt(r))){
                map.put(s.charAt(r), 1);
            } else{
                map.put(s.charAt(r),map.get(s.charAt(r)) + 1);
            }

            maxF = Math.max(maxF, map.get(s.charAt(r)));
            if((r - l + 1) - maxF > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;

    }
}
