package com.mycompany.csc229_bst_example;
/**
 *
 * @author Waleed Shahid
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
        if (root != null) {
            doInOrder(root.getLeft()); // Traverse for the left subtree
            System.out.print(root.getData() + " "); // going to the current node
            doInOrder(root.getRight()); // Traverse for the right subtree
        }
        // ToDo 1: complete InOrder Traversal
    }
        public void preOrderTraversal() {
        doPreOrder(this.root);
            if (root != null) {
                System.out.print(root.getData() + " "); // going to the current node
                doPreOrder(root.getLeft()); // traversing to the left subtree
                doPreOrder(root.getRight()); // or traverse to the right subtree
            }
        // ToDo 2: complete the pre-order travesal . 
    }

    private void doPreOrder(BstNode left) {
    }

    public Integer findHeight() {
        return findHeight(this.root);
        // ToDo 3: Find the height of a tree
    }
    private Integer findHeight(BstNode root) {
        if (root == null) {
            return -1; // this acts as a base case, meaning if the root is null then the tree is == -1
        }
        return 1 + Math.max(findHeight(root.getLeft()), findHeight(root.getRight()));
    } // adding 1 to either left or right side of subtree

    

    public int getDepth(BstNode node) {
        return getDepth(root, node, 0);
        //ToDo 4: complete getDepth of a node 
    }
    private int getDepth(BstNode root, BstNode node, int depth) {
        if (root == null) {
            return -1; // if the node is not found then the value will be -1
        }
        if (root == node) {
            return depth; // if root == node then return the depth
        }
        int left = getDepth(root.getLeft(), node, depth + 1); // searching for the left subtree
        if (left != -1) {
            return left; // if node found in the lest side
        }
        return getDepth(root.getRight(), node, depth + 1); // searching goes on for the right subtree
    }
    
   public void print() {
       System.out.println("\n==== BST Print ===== \n");
        print("", root, false);
        // ToDo 5: complete the print of the BST
    }
    private void print(String prefix, BstNode node, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├ ── " : "└── ") + node.getData()); // printing the current node
            print(prefix + (isLeft ? "│   " : "    "), node.getLeft(), true); // left child (as in recursive)
            print(prefix + (isLeft ? "│   " : "    "), node.getRight(), false); // right child (as in recursive)
        }
    }


}
