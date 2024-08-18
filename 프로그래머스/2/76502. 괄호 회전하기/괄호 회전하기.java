import java.util.Stack;
class Solution {
    public int solution(String s) {
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (isValid(s)) {
                count++;
            }
            s = rotateLeft(s);
        }

        return count;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    
     private String rotateLeft(String s) {
        return s.substring(1) + s.charAt(0);
    }
}