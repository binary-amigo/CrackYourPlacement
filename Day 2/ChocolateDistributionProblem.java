/**
 * ChocolateDistributionProblem
 */
import java.util.*;
public class ChocolateDistributionProblem {

    //Optimal
    //Time Complexity: O(nlogn)
    //Space Complexity: O(1)
    public static long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        int ans = Integer.MAX_VALUE;
        Collections.sort(a);
        for(int i = 0;i < n;i++){
            int si = i;
            int ei = m + i - 1;
            if(ei >= n) break;
            int diff = a.get(ei) - a.get(si);
            ans = Math.min(ans,diff);
        }
        return (long)(ans);
        // your code here
    }
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.addAll(Arrays.asList(3, 4, 1, 9, 56, 7, 9, 12));
        System.out.println(findMinDiff(a, 8, 5));


    }
}