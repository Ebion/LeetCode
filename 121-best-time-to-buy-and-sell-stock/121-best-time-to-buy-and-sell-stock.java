class Solution {
    public int maxProfit(int[] prices) {
        int max_diff = 0;
        int len_p = prices.length;
        
        int curr = 99999;
        
        for (int i = 0; i < len_p; i++) {
            if (i == len_p - 1) {
                break;
            }
            if (prices[i] >= curr) {
                //if the price at prices[i] is more than the previous price, then theres no way it will be better to buy now, so skip
                continue;
            } else {
                //if not just find the maximum profit u can gain from selling after day of buying
                curr = prices[i];
                for (int j = i + 1; j < len_p; j++) {
                    int next = prices[j];
                    int diff = next - curr;
                    if (diff > max_diff) {
                        max_diff = diff;
                    }
                }
            }
        }
        return max_diff;
    }
}