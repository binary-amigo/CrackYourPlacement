/**
 * SubarraySumsDivisibleByk
 */
public class SubarraySumsDivisibleByk {
    
    //Brute Force
    //Time Complexity: O(n^2) (TLE)
    //Space Complexity: O(1)
    public static int subarraysDivByK(int[] nums, int k) {
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
    public static void main(String[] args) {
        int ans = subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5);
        System.out.println(ans);
    }
}