import java.util.Arrays;

/**
 * MaxProductof3Numbers
 */
public class MaxProductof3Numbers {

    //Brute Force 
    //Time Complexity: O(n^3)
    //Space Complexity: O(1)
    public static int maximumProduct1(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(i == j) continue;
                for(int k = 0;k < n;k++){
                    if(i == k || j == k) continue;
                    int prod = nums[i] * nums[j] * nums[k];
                    ans = Math.max(prod,ans);
                }
            }
        }
        

        return ans;
    }

    //Optimal 
    //Time Complexity: O(nlogn)
    //Space Complexity: O(1)
    public static int maximumProduct2(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int m1 = nums[0] * nums[1] * nums[n-1];
        int m2 = nums[n-1] * nums[n-2] * nums[n-3];
        
        return Math.max(m1,m2);
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        System.out.println(maximumProduct1(nums));
        System.out.println(maximumProduct2(nums));
    }
}