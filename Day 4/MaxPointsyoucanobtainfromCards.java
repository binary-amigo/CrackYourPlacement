public class MaxPointsyoucanobtainfromCards {

    //Optimal
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int maxScore(int[] c, int k) {
        int i = k -1;
        int j = c.length;
        int prevSum = 0;
        for(int idx = 0;idx < k;idx++){
            prevSum += c[idx];
        }

        int ans = prevSum;

        while(k > 0){
            prevSum -= c[i];
            i--;
            j--;
            prevSum += c[j];
            ans = Math.max(ans,prevSum);
            k--;
        }

        return ans;
    }
    public static void main(String[] args) {
        int c[] = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(maxScore(c,k));
    }
}