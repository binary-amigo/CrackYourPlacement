/**
 * BesttimetobuyandsellstockII
 */
public class BesttimetobuyandsellstockII {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        for(int i = 1;i < n;i++){
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        int ans = maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(ans);
    }
}