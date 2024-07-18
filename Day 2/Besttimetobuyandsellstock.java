/**
 * Besttimetobuyandsellstock
 */
public class Besttimetobuyandsellstock {

    public static int maxProfit(int[] prices) {
        int ans = 0;
        int cp = Integer.MAX_VALUE;
        for(int price : prices){
            cp = Math.min(cp,price);
            int profit = price - cp;
            ans = Math.max(profit,ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}