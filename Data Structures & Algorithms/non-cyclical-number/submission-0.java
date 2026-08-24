class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();
        System.out.println(sumOfSquares(100));
        while(!visit.contains(n)){
            visit.add(n); 
            n = sumOfSquares(n);
            if(n == 1) return true;
        }

        return false;
    }

    private int sumOfSquares(int n){
        int sum  = 0;

        String s = Integer.toString(n);
        int totalDigits = s.length();
        String first = "1";
        while(totalDigits != 1){
            first+="0";
            totalDigits--;
        }

        int firstt = Integer.parseInt(first);
        
        while(n != 0){
            int digit = n / firstt;
            digit = digit * digit;
            sum+=digit;
            n = n % firstt;
            firstt/=10;
        }

        return sum;
    }
}
