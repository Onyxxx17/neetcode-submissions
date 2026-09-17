class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String token: tokens){
            if("+-*/".contains(token)){
                int num1 = st.pop();
                int num2 = st.pop();
                int res = 0;
                switch(token){
                    case "+":
                        res = num2 + num1;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num2 * num1;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                }
                st.push(res);
            } else{
                st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }
}
