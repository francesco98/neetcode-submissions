class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> BRACKETS = Map.of('}', '{', ']', '[', ')', '(');
        Stack<Character> openBrackets = new Stack<>();

        for(char c : s.toCharArray()) {
            if(BRACKETS.containsValue(c)) {
                openBrackets.push(c);
            }
            else if(openBrackets.isEmpty() || openBrackets.pop() != BRACKETS.get(c)) {
                return false;
            }
        }

        return openBrackets.isEmpty();
    }
}
