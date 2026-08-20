class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int i = 0; 
        int j = numbers.length-1;

        while (i < j) {
            int r = target - numbers[i];
            while(numbers[j] > r) {
                j--;
            }

            if(r == numbers[j]) {
                return new int[]{i+1,j+1};
            }

            i++;
        }

        return new int[]{0,0};
    }
}
