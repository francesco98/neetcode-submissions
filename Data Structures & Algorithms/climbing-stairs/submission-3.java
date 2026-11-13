class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 0;

        for(int i = n-1; i >= 0; i--) {
            int tmp = a;
            a = a+b;
            b = tmp;
        }

        return a;
    }
}
