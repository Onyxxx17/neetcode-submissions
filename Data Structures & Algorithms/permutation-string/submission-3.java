class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        int[] s1count = new int[26];
        int[] s2count = new int[26];
        int needed = 0;

        for(int i = 0; i < s1.length(); i++){
            s1count[s1.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(s1count[i] != s2count[i]){
                needed++;
            }
        }
        System.out.println(needed);

        for(int i = 0; i < s1.length(); i++){
            s2count[s2.charAt(i) - 'a']++;
            
            if(s1count[s2.charAt(i) - 'a'] == s2count[s2.charAt(i) - 'a']){
                needed--;
            } else if(s2count[s2.charAt(i) - 'a'] - 1 == s1count[s2.charAt(i) - 'a']){
                needed++;
            }
        }
       

        if(needed == 0) return true;

        int l = 0;
        int r = s1.length();

        while(r < s2.length()){
            if(needed == 0) return true;
            s2count[s2.charAt(r) - 'a']++;
            
            if(s1count[s2.charAt(r) - 'a'] == s2count[s2.charAt(r) - 'a']){
                needed--;
            } else if(s2count[s2.charAt(r) - 'a'] - 1 == s1count[s2.charAt(r) - 'a']){
                needed++;
            }

            s2count[s2.charAt(l) - 'a']--;
            if(s1count[s2.charAt(l) - 'a'] - 1 == s2count[s2.charAt(l) - 'a']){
                needed++;
            } else if(s1count[s2.charAt(l) - 'a'] == s2count[s2.charAt(l) - 'a']){
                needed--;
            }

            l++;
            r++;
        }


        return needed == 0;

    }
}
