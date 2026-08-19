class Solution {
    public int evalRPN(String[] tokens) {
        final Deque<Integer> numbers = new ArrayDeque<>();

        for(String token : tokens) {
            if(token.length() == 1 && isOperator(token.charAt(0))) {
                int b = numbers.pop();
                int a = numbers.pop();

                numbers.push(compute(a, b, token.charAt(0)));
            }
            else {
                numbers.push(Integer.valueOf(token));
            }
        }

        return numbers.pop();
    }

    public boolean isOperator (char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public int compute(int a, int b, char op) {
        return switch(op) {
            case '+' -> a+b;
            case '-' -> a-b;
            case '*' -> a*b;
            case '/' -> a/b;
            default -> 0;
        };
    }
}
