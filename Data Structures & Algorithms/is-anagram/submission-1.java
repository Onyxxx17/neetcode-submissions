class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            map1.merge(s.charAt(i), 1, Integer::sum);
            map2.merge(t.charAt(i), 1, Integer::sum);
        }

        return map1.equals(map2);
    }
}
