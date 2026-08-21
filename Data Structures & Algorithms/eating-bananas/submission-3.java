class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();;

        while(l < r) {
            int k = l + (r - l) / 2;
            
            long time = 0;
            for(int p : piles) {
                time += (p+k-1)/k;
                if (time > h) break;
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
