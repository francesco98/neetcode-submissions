class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProducts = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                leftProducts[i] = 1;
            }
            else {
                leftProducts[i] = nums[i-1] * leftProducts[i-1];
            }
        }

        int[] rightProducts = new int[nums.length];
        for(int i = nums.length-1; i >= 0; i--) {
            if(i == nums.length-1) {
                rightProducts[i] = 1;
            }
            else {
                rightProducts[i] = nums[i+1] * rightProducts[i+1];
            }

        }

        int[] products = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            products[i] = leftProducts[i] * rightProducts[i];
        }
        
        return products;
    }
}  
