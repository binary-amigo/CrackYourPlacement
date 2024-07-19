import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ThreeSum
 */
public class ThreeSum {

    //Brute Force
    //Time Complexity: O(n^3)
    //Space Complexity: O(1)
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                for(int k = j+1;k < n;k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> curr = Arrays.asList(nums[i],nums[j],nums[k]);
                        Collections.sort(curr);
                        if(!ans.contains(curr))
                            ans.add(curr);
                    }
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));       
    }
}