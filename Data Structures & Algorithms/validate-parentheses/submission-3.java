class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length() % 2 != 0) return false;

        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == ')' || c == '}' || c == ']'){
                if(c == ')' && !stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                } else if(c == '}' && !stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                } else if(c == ']' && !stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                } else{
                   return false;
                }
            } else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
