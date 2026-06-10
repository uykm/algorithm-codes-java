class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;
        int curPrice = -1;

        // 매수한 값보다 가장 비싸게 팔 수 있는 날을 찾으면  -> 매도
        // 다음날 가격이 떨어지면 -> 매수 X
        for (int i = 0; i < prices.length; ++i) {
            if (curPrice == -1) {
                curPrice = prices[i];
                continue;
            }
            
            if (curPrice > prices[i]) {
                curPrice = prices[i];
            } else if (curPrice < prices[i]) {
                maxProfit += prices[i] - curPrice;
                curPrice = prices[i];
            }

        }

        return maxProfit;
    }
}