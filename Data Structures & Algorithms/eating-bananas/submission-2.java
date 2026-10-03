class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int l = 1;
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            r = Math.max(r,piles[i]);
        }

        int res = r;
        while (l <= r) {
            int k = (l + r) / 2;
            //simulate
            int t = 0;
            for (int i = 0; i < n; i++) {
                t += piles[i] / k;
                t += piles[i] % k != 0 ? 1 : 0;
                // System.out.println(k + " " + t);
            }

            // System.out.println(t);

            if (t <= h) {
                res = k;
                r = k - 1;
            } else if (t > h) {
                l = k + 1;
            } 
        }
        return res;
    }
}
