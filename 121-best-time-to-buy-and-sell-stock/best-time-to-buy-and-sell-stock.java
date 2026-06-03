class Solution {
    public int maxProfit(int[] prices) {

        int minPrices = Integer.MAX_VALUE;
        int maxProfite = 0;

        for(int i=0; i<prices.length; i++) {

            int price = prices[i];

            if(price < minPrices) {

                minPrices = price;
            }
            else {
                maxProfite = Math.max(maxProfite, price - minPrices);
            }
        }
        return maxProfite;
    }
}