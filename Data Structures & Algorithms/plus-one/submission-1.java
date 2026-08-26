class Solution {
    public int[] plusOne(int[] digits) {
        long total = 0;
        long factor = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            long num = digits[i] * factor;
            total += num;
            factor *= 10;
        }

        total+=1;
        
        String s = Long.toString(total);
        int[] res = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            res[i] = Character.getNumericValue(s.charAt(i));
        }

        return res;
    }
}
