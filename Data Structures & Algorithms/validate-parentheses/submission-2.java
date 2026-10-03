class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case '(','[','{' -> stack.push(c);
                case ')',']','}' -> {
                    if (stack.isEmpty()) return false;
                    else if (c == ')' && '(' != stack.peek()) return false;
                    else if (c == ']' && '[' != stack.peek()) return false;
                    else if (c == '}' && '{' != stack.peek()) return false;
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
