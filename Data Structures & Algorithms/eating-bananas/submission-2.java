class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxK = Arrays.stream(piles).max().getAsInt();

        int l = 0;
        int r = maxK;

        while(l < r) {
            int k = l + (r - l) / 2;
            
            int time = 0;
            for(int i = 0; i < piles.length; i++) {
                time += Math.ceil(piles[i] / Double.valueOf(k));
            }

            if(time > h) {
                l = k+1;
            }
            else {
                r = k;
            }
        }

        return l;
    } 
}
