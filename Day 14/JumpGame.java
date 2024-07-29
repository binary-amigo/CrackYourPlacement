/**
 * JumpGame
 */
public class JumpGame {

    public static boolean canJump(int[] nums) {
        int m = 0;
        for(int i = 0;i < nums.length;i++){
            if(i > m) return false;
            m = Math.max(m,i+nums[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }   
}