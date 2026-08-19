class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        products[0] = 1;

        for(int i = 1; i < nums.length; i++) {
            products[i] = nums[i-1] * products[i-1];
        }

        int right = 1;
        for(int i = nums.length-2; i >= 0; i--) {
            right *= nums[i+1];
            products[i] *= right;
        }

        return products;
    }
}  
