/**
 * Containerwithmostwater
 */
public class Containerwithmostwater {

    //Brute Force
    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    public static int maxArea1(int[] height) {
        int n = height.length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                int area = Math.min(height[i],height[j]) * (j - i);
                ans = Math.max(area,ans);
            }
        }
        return ans;
    }
    //Optimal
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int maxArea2(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int ans = Integer.MIN_VALUE;
        while(low < high){
            int area = Math.min(height[low],height[high]) * (high - low);
            ans = Math.max(area,ans);
            if(height[low] < height[high])
                low++;
            else
                high--;
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans = maxArea1(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(ans);
    }
}