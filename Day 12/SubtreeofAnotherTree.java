import javax.swing.tree.TreeNode;

public class SubtreeofAnotherTree {

    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if(root == null && subRoot == null){
            return true;
        } else if(root == null){
            return false;
        }

        if(root.data == subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }

        boolean left = isSubtree(root.left,subRoot);
        boolean right = isSubtree(root.right,subRoot);

        return left || right;
    }

    public static boolean isIdentical(Node root, Node subRoot){
        if(root == null && subRoot == null) return true;
        else if(root == null || subRoot == null || root.data != subRoot.data) return false;

        boolean left = isIdentical(root.left, subRoot.left);
        boolean right = isIdentical(root.right, subRoot.right);

        return left && right;           
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(2);
        root.left.right.left = new Node(0);
        root.right.right = new Node(6);

        Node subRoot = new Node(4);
        subRoot.left = new Node(1);
        subRoot.right = new Node(2);

        System.out.println(isSubtree(root, subRoot));        
    }
}
