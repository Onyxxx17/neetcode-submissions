class Solution {
    public boolean isPalindrome(String s) {
        //Remove white spaces
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' ' && Character.isLetterOrDigit(s.charAt(i))){
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        int l = 0;
        int r = sb.length() - 1;


        while(l < r){
            if(sb.charAt(l) != sb.charAt(r)){
                return false;
            } else{
                l++;
                r--;
            }
        }
        return true;
    }
}
