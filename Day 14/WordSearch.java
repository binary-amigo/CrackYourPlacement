/**
 * WordSearch
 */
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        
        int index = 0;
        int n = board.length;
        int m = board[0].length;

        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(board[i][j] == word.charAt(index)){
                    if(search(board, word, index, i,j,m,n)){
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public static boolean search(char[][] b, String word, int index, int row, int col, int m,int n){
        if(index == word.length()){
            return true;
        }

        if(row < 0 || col < 0 || row > n-1 || col > m-1 || b[row][col] != word.charAt(index) || b[row][col] == '*'){
            return false;
        }

        char curr = b[row][col];
        b[row][col] = '*';

        //top
        boolean top = search(b,word,index+1,row-1,col,m,n);

        //bottom
        boolean bottom = search(b,word,index+1,row+1,col,m,n);

        //left
        boolean left = search(b,word,index+1,row,col-1,m,n);

        //right
        boolean right = search(b,word,index+1,row,col+1,m,n);

        b[row][col] = curr;

        return top || bottom || left || right;
}

public static void main(String[] args) {
    char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    System.out.println(exist(board, "ABCCED"));
    System.out.println(exist(board, "SEE"));
    System.out.println(exist(board, "ABCB"));    
}
}