class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());

                int result = 0;
                switch(token){
                    case "+": 
                            result = b + a; 
                            break;
                    case "-": 
                            result = b - a; 
                            break;
                    case "*": 
                            result = b * a;
                            break;
                    case "/": 
                            result = b / a;
                            break;
                }

                stack.push(Integer.toString(result));
            } else{
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
