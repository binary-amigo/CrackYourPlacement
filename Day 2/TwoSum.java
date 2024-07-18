/**
 * TwoSum
 */
import java.util.*;
public class TwoSum {

    //Brute Force
    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    public static int[] twoSum1(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;
        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                if(nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    //Optimal
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[2];
        int n = nums.length;
        for(int i = 0;i < n;i++){
            int rem = target - nums[i];
            if(map.containsKey(rem)){
                ans[0] = map.get(rem);
                ans[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target = 9;
        int ans[] = twoSum2(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}