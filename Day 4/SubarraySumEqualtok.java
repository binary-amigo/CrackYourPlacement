import java.util.HashMap;
import java.util.Map;

/**
 * SubarraySumEqualtok
 */
public class SubarraySumEqualtok {

    //Brute Force
    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for(int i = 0;i < n;i++){
            int sum = 0;
            for(int j = i;j < n;j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }


    //Optimal
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int i = 0;
        int sum = 0; 

        while(i < n){
            sum += nums[i];
            if(sum == k){
                count++;
            }
            if(map.containsKey(sum - k)) count += map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
            i++;
        }

        return count;
    }
    public static void main(String[] args) {
        int nums[] = {1,1,1};
        int k = 2;
        System.out.println(subarraySum1(nums,k));
        System.out.println(subarraySum2(nums,k));
    }
}