package leetcode.Week1.Valid_parentheses;

import java.util.Stack;
class JI_Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else if(s.charAt(i) == ')' ){
                if(stack.isEmpty() || stack.peek() != '(')
                    return false;
                stack.pop();
            }
            else if(s.charAt(i) == '}'){
                if(stack.isEmpty() || stack.peek() != '{')
                    return false;
                stack.pop();
            }
            else if(s.charAt(i) == ']'){
                if(stack.isEmpty() || stack.peek() != '[')
                    return false;
                stack.pop();
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
