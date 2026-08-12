class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int maxF = 0;
        int l = 0;
        int r = 0;
        int res = 0;
        while(r < s.length()){

            //Add the right index char to hashmap
            if(!map.containsKey(s.charAt(r))){
                map.put(s.charAt(r), 1);
            } else{
                map.put(s.charAt(r), map.get(s.charAt(r)) + 1);
            }

            maxF = Math.max(maxF, map.get(s.charAt(r)));

            while((r - l + 1) - maxF > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, r - l +1);
            r++;    
        }

        return res;
    }
}
