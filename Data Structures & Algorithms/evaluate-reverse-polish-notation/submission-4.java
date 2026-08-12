class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int res = 0;
        for(String s: tokens){
            if("+-/*".contains(s)){
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());

                switch(s){
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                }
                stack.push(Integer.toString(res));
            } else{
                stack.push(s);
            }
        } 

        return Integer.parseInt(stack.pop());
    }
}
