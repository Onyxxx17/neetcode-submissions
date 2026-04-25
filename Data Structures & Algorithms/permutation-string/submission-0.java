class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for(int i = 0; i < s1.length(); i++){
            s1Count[s1.charAt(i) - 'a']++;
        }

        int need = 0;
        for(int i = 0; i < 26; i++){
            if(s1Count[i] != s2Count[i]){
                need++;
            }
        }


        //Initial check
        for(int i = 0; i < s1.length(); i++) {
            int idx = s2.charAt(i) - 'a';
            s2Count[idx]++;
            
            if(s2Count[idx] == s1Count[idx]){
                need--;
            } else if(s2Count[idx] - 1 == s1Count[idx]){ 
                need++;
            }
        }
        if(need == 0) return true;


        //Increment the window
        int l = 0;
        int r = s1.length();

        for(; r < s2.length(); r++){
            if(need == 0) return true;

            s2Count[s2.charAt(r) - 'a']++;
            if(s2Count[s2.charAt(r) - 'a'] == s1Count[s2.charAt(r) - 'a']){
                need--;
            } else if(s2Count[s2.charAt(r) - 'a'] - 1 == s1Count[s2.charAt(r) - 'a']){
                need++;
            }

            s2Count[s2.charAt(l) - 'a']--;
            if(s2Count[s2.charAt(l) - 'a'] == s1Count[s2.charAt(l) - 'a']){
                need--;
            } else if(s2Count[s2.charAt(l) - 'a'] + 1 == s1Count[s2.charAt(l) - 'a']){
                need++;
            }
            l++;
        }       

        return need == 0;
    }
}

