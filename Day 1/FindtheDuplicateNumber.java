import java.util.*;

public class FindtheDuplicateNumber {

    //Brute Force
    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    public static int findDuplicate1(int[] nums) {
        int n = nums.length;
        for(int i =0;i < n;i++){
            for(int j = i+1;j < n;j++){
                if(nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }
        return 0;
    }
    

    //Better
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static int findDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0;i < n;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return 0;
    }

    //Optimal
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int findDuplicate3(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate1(nums));
        System.out.println(findDuplicate2(nums));
        System.out.println(findDuplicate3(nums));
    }
}