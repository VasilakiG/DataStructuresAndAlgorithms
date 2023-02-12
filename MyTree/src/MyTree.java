import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.Stack;


public class MyTree {

    private TreeNode root;

    private class TreeNode{
        private TreeNode right;
        private TreeNode left;
        private int data;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void CreateBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);

        root = fourth;
        root.left = third;
        root.right = fifth;

        third.left = first;
        third.right = second;

        fifth.left = sixth;
        fifth.right = seventh;
    }

    public void recursivePreOrder(TreeNode root){
        if (root == null){
            return;
        }

        System.out.print(root.data + " ");
        recursivePreOrder(root.left);
        recursivePreOrder(root.right);
    }

    public void iterativePreOrder(){
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");

            if (temp.right != null) {
                stack.push(temp.right);
            }

            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        System.out.println();
    }

    public void recursiveInOrder(TreeNode root){
        if (root == null) {
            return;
        }

        recursiveInOrder(root.left);
        System.out.print(root.data + " ");
        recursiveInOrder(root.right);
    }

    public void iterativeInOrder(){
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp = root;

        while (!stack.isEmpty() || temp != null){
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
              temp = stack.pop();
              System.out.print(temp.data + " ");
              temp = temp.right;
            }
        }
    }

    public void recursivePostOrder(TreeNode root){
        if (root == null) {
            return;
        }

        recursivePostOrder(root.left);
        recursivePostOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void iterativePostOrder(){

    }

    public static void main(String[] args) {

        MyTree bt = new MyTree();

        bt.CreateBinaryTree();

        bt.recursivePreOrder(bt.root);
        System.out.println();

        bt.recursiveInOrder(bt.root);
        System.out.println();

        bt.recursivePostOrder(bt.root);
        System.out.println();
    }
}