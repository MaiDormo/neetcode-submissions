class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s: tokens) {
            char c = s.charAt(0);
            if (isNum(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                // if (stack.size() < 2) return false;
                // System.out.println(stack.peek());
                int b = stack.pop();
                int a = stack.pop();
                int res = 0;
                switch (c) {
                    case '+' -> res = a + b;
                    case '-' -> res = a - b;
                    case '/' -> res = a / b;
                    case '*' -> res = a * b;
                }
                stack.push(res);
                // System.out.println(stack.peek());
            }
        }
        return stack.pop();
    }

    public boolean isNum(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') return true;
        }
        return false;
    }
}
