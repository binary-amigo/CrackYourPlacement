/**
 * SetMatrixZeroes
 */


public class SetMatrixZeroes {

    //Brute Force
    //Time Complexity: O(n^3)
    //Space Complexity: O(1)
    public static void calRow(int [][] matrix, int row){
        for(int j = 0;j < matrix[row].length;j++){
            if(matrix[row][j] != 0){
                matrix[row][j] = -1;
            }
        }
    }

    public static void calCol(int [][] matrix, int col){
        for(int j = 0;j < matrix.length;j++){
            if(matrix[j][col] != 0){
                matrix[j][col] = -1;
            }
        }
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        
        for(int i = 0;i < m;i++){
            for(int j = 0;j < matrix[i].length;j++){
                if(matrix[i][j] == 0){
                    calRow(matrix,i);
                    calCol(matrix,j);
                }
            }
        }

        for(int i = 0;i < m;i++){
            for(int j = 0;j < matrix[i].length;j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }

    }

    //Better
    //Time Complexity: O(n^2)
    //Space Complexity: O(2n)
    public static void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] col = new int[matrix.length];
        int[] row = new int[matrix[0].length];

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == 0){
                    col[i] = 1;
                    row[j] = 1;
                }
            }
        }

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(col[i] == 1 || row[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //Optimal
    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    public static void setZeroes3(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int var = 1;

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j != 0){
                        matrix[0][j] = 0;
                    } else {
                        var = 0;
                    }
                }
            }
        }

        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
                if(j == 0 && var == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int j = 0;j < matrix[0].length;j++){
                matrix[0][j] = 0;
            }
        }

        if(var == 0){
            for(int j = 0;j < matrix.length;j++){
                matrix[j][0] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        setZeroes2(matrix);
        setZeroes3(matrix);
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[i].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }    
}