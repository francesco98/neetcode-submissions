class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();

        while(l < r) {
           int k = l + (r-l) / 2;
           long time = calculateTotalTime(piles, k);

           if(time > h) {
            l = k + 1;
           }
           else {
            r = k;
           }
        }

        return l;
    }

    public long calculateTotalTime(int[] piles, int k) {
        long time = 0;
        for(int i = 0; i < piles.length; i++) {
            time += (piles[i] + k - 1) / k;
        }

        return time;
    }
}
