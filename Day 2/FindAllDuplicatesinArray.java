/**
 * FindAllDuplicatesinArray
 */
import java.util.*;
public class FindAllDuplicatesinArray {

    //Brute Force
    //Time Complexity: O(nlogn)
    //Space Complexity: O(1)
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 1;i < n;i++){
            if(nums[i] == nums[i-1]){
                ans.add(nums[i]);
            }
        }

        return ans;
    }

    //Better
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public List<Integer> findDuplicates2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for(int num : nums){
            if(set.contains(num)){
                ans.add(num);
                continue;
            }
            set.add(num);
        }

        return ans;
    }

    
    public static void main(String[] args) {
        List<Integer> ans = new FindAllDuplicatesinArray().findDuplicates1(new int[]{4,3,2,7,8,2,3,1});
        System.out.println(ans);
    }
}