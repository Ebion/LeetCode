class Solution {
    public int maxProfit(int[] prices) {
        int arraylen = prices.length;
        int[][] profit = new int[arraylen][2];
        profit[0][0] = -prices[0];
        profit[0][1] = 0;
        for (int i = 1; i < arraylen; i++) {
            profit[i][0] = Math.max(profit[i - 1][0], -prices[i]); 
            
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 1][0] + prices[i]);
        }
        
        return Math.max(profit[arraylen - 1][0], profit[arraylen - 1][1]);
    }
}