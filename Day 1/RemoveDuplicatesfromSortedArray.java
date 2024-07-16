/**
 * RemoveDuplicatesfromSortedArray
 */
import java.util.*;
public class RemoveDuplicatesfromSortedArray {


    //Brute Force
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static int removeDuplicates1(int[] nums) {
        int k = nums.length;
        int idx = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < k;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                nums[idx] = nums[i];
                idx++;
            }
        }

        return set.size();
    }

    //Optimal
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        for(int j = i+1;j<nums.length;j++){
            if(nums[j] != nums[i]){
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        int [] nums = {1,1,2};
        System.out.println(removeDuplicates1(nums));
        System.out.println(Arrays.toString(nums));
        System.out.println(removeDuplicates2(nums));
        System.out.println(Arrays.toString(nums));
    }
}