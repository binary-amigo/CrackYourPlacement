/**
 * SpiralMatrix
 */
import java.util.*;
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] m) {
        List<Integer> list = new ArrayList<>();
        int n = m.length;
        int ma = m[0].length;
        int top = 0;
        int bottom = n - 1;
        int right = ma - 1;
        int left = 0;

        while(left <= right && top <= bottom){
            for(int i = left;i <= right;i++){
                list.add(m[top][i]);
            }
            top++;

            for(int i = top;i <= bottom;i++){
                list.add(m[i][right]);
            }
            right--;

            if(top <= bottom){
                for(int i = right;i >= left;i--){
                list.add(m[bottom][i]);
                }

            bottom--;
            }
            
            if(left <= right){
                for(int i = bottom;i >= top;i--){
                    list.add(m[i][left]);
                }
            left++;
            }
            
        }

        return list;
    }
    public static void main(String[] args) {
        List<Integer> list = spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        for(int i : list){
            System.out.print(i + " ");
        }
    }
}