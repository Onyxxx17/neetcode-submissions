class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i),0) + 1);
        }

        // MOVE L UNTIL IT REACHES SOMETHING FROM NEED
        int l = 0;
        while(l < s.length() && !need.containsKey(s.charAt(l))){
            l++;
        }

        int r = l;

        int needed = need.size();
        int match = 0;

        //Needed index
        int[] res = {-1,-1};
        int resLen = Integer.MAX_VALUE;
        //Window time
        while(r < s.length()){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c,0) + 1);

            if(need.containsKey(c) && need.get(c) == window.get(c)){
                match++;
            }

            while(needed == match){
                if(r - l + 1 < resLen){
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char c1 = s.charAt(l);
                window.put(c1, window.get(c1) - 1);
                
                if(need.get(c1) > window.get(c1)){
                    match--;
                }

                l++;
                while(l < r && !need.containsKey(s.charAt(l))){
                    l++;
                }
            }
            r++;
        }
        
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0],res[1]+1);
    }
}
