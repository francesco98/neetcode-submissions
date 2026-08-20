class Solution {
    public boolean isPalindrome(String s) {
        String value = s.toLowerCase();

        int left = 0;
        int right = value.length() - 1;

        while(left < right) {
            while (left < right && !Character.isLetterOrDigit(value.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(value.charAt(right))) right--;

            if(value.charAt(left) != value.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}