class Solution {
    public int maxProfit(int[] prices) {
        int min = 101;
        int max = -1;
        int res = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            }

            if (prices[i] > max) {
                max = prices[i];
                res = Math.max(res, max-min);
            }
        }

        return res;
    }
}
