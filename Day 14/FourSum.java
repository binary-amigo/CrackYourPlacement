/**
 * FourSum
 */
import java.util.*;
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0;i <n;i++){
            if(i > 0 && i < n && nums[i] == nums[i-1])continue;
            for(int j = i+1;j < n;j++){
                if(j > i+1 && j < n && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while(k < l){
                    long sum = nums[i]; 
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(sum > target){
                        l--;
                    } else if(sum < target){
                        k++;
                    } else {
                        ans.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        l--;

                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }

        return ans;

    }
    public static void main(String[] args) {
        List<List<Integer>> ans = fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        for(List<Integer> list: ans){
            System.out.println(list);
        }
    }
}