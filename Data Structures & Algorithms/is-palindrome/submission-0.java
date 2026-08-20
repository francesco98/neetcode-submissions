class Solution {
    public boolean isPalindrome(String s) {
        String value = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        for(int i = 0; i < value.length()/2; i++) {
            if(value.charAt(i) != value.charAt(value.length()-i-1)) {
                return false;
            }
        }

        return true;
    }
}
