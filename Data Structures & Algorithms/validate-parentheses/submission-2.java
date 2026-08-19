class Solution {
    public boolean isValid(String s) {
        Deque<Character> expected = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> expected.push(')');
                case '[' -> expected.push(']');
                case '{' -> expected.push('}');
                default  -> {
                    if (expected.isEmpty() || expected.pop() != c) return false;
                }
            }
        }
        return expected.isEmpty();
    }
}
