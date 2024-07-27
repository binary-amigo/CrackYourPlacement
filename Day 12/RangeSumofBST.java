import javax.swing.tree.TreeNode;

/**
 * RangeSumofBST
 */
public class RangeSumofBST {

    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public static int rangeSumBST(Node root, int low, int high) {
        if(root == null) return 0;

        if(root.data < low){
            return rangeSumBST(root.right, low,high);
        } else if(root.data > high){
            return rangeSumBST(root.left, low,high);
        } else{
            return root.data + rangeSumBST(root.left, low,high) + rangeSumBST(root.right, low,high);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(18);

        System.out.println(rangeSumBST(root, 7, 15));
    }
}