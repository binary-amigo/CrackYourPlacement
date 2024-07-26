import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ThreeSum
 */
public class ThreeSum {

    //Brute Force
    //Time Complexity: O(n^3)
    //Space Complexity: O(1)
    public static List<List<Integer>> threeSum1(int[] nums) {
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

    //Better
    //Time Complexity: O(n^2)
    //Space Complexity: O(N)
    public static List<List<Integer>> threeSum2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;

        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                int rem = 0 - (nums[i] + nums[j]);
                if(set.contains(rem)){
                    List<Integer> list = Arrays.asList(nums[i],nums[j],rem);
                    Collections.sort(list);
                    ans.add(list);
                }
                set.add(nums[j]);
            }
            set.clear();
        }
        return new ArrayList<>(ans);
    }

    //Optimal
    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0;i < n;i++){
            int j = i+1;
            int k = n-1;

            if(i != 0 && nums[i] == nums[i-1]) continue;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;
                } else if(sum > 0){
                    k--;
                } else{
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;

                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {-1,0,1,2,-1,-4};
        System.out.println(threeSum2(nums));       
    }
}