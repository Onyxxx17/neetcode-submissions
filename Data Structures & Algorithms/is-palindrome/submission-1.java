class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' ' && (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i)))){
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        StringBuilder rev = new StringBuilder(sb).reverse();

        return sb.toString().equals(rev.toString());
    }
}
