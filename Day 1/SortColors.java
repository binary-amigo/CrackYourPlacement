import java.util.*;
public class SortColors {

    //Better
    //Time Complexity: O(nlogn)
    //Space Complexity: O(1)
    public static void sortColors1(int [] nums){
        Arrays.sort(nums);
    }

    //Better
    //Time Complexity: O(nlogn)
    //Space Complexity: O(1)
    public static int partition(int[] arr, int si, int ei){
        int pivot = arr[ei];
        int i = si - 1;

        for(int j = si;j < ei;j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        int temp = arr[ei];
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }

    public static void quickSort(int[] arr, int si, int ei){
        if(si >= ei) return;

        int pIdx = partition(arr,si,ei);
        quickSort(arr,si,pIdx - 1);
        quickSort(arr,pIdx + 1, ei);
    }
    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length - 1);
    }

    public static void sortColors2(int [] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    //Optimal
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void sortColors3(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums,mid,low);
                low++;
                mid++;
            } else if(nums[mid] == 1){
                mid++;
            } else{
                swap(nums,mid,high);
                high--;
            }
        }
    }
    public static void main(String[] args) {
        int nums[] = {2,0,2,1,1,0};
        sortColors1(nums);
        System.out.println(Arrays.toString(nums));
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));
        sortColors3(nums);
        System.out.println(Arrays.toString(nums));
    }
    
}