/**
 * MergeSortedArrays
 */
public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int eidx = nums1.length-1;

        while(m > 0 && n > 0){
            if(nums2[n-1] > nums1[m-1]){
                nums1[eidx] = nums2[n-1];
                n--;
            } else{
                nums1[eidx] = nums1[m-1];
                m--;
            }
            eidx--;
        }

        while(n > 0){
            nums1[eidx] = nums2[n-1];
            eidx--;
            n--;
        }
    }
    public static void main(String[] args) {
        int [] nums1 = new int[]{1,2,3,0,0,0};
        int [] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
        for(int i : nums1){
            System.out.print(i + " ");
        }
    }
}