import java.util.HashMap;
import java.util.Map;

/**
 * SubarraySumsDivisibleByk
 */
public class SubarraySumsDivisibleByk {
    
    //Brute Force
    //Time Complexity: O(n^2) (TLE)
    //Space Complexity: O(1)
    public static int subarraysDivByK1(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for(int i = 0;i < n;i++){
            int sum = 0;
            for(int j = i;j < n;j++){
                sum += nums[j];
                if(sum % k == 0){
                    count++;
                }
            }
        }
        return count;
    }

    //Optimal
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static int subarraysDivByK2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>(); //Sum, Frequency
        int count = 0;
        int i = 0;
        int sum = 0;
        while(i < nums.length){
            sum += nums[i];
            int rem = sum%k;
            if(rem == 0) count++;
            if(rem < 0){ //handling negative remainder
                rem += k;
            }
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
            i++;
        }
        

        return count; 
    }


    
    public static void main(String[] args) {
        int ans = subarraysDivByK2(new int[]{4,5,0,-2,-3,1}, 5);

        System.out.println(ans);
    }
}