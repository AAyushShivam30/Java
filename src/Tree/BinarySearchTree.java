package Tree;

import java.util.Scanner;

public class BinarySearchTree {
    public class Node {
        Node right;
        Node left;
        public int height;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    public BinarySearchTree(){

    }
    private Node root;
    public int height(Node node){
        if (node == null){
            return -1;
        }
        return node.height;


    }
    public boolean isEmpty(){
        return root == null;
    }
    public void insert(int value){
        root = insert (value,root);
    }
    public Node insert(int value , Node node) {
        if (node == null) {
            node = new Node(value);

            return node;
        }
        if (value<node.value){
            node.left = insert(value, node.left);

        }
        if (value>node.value){
            node.right = insert(value, node.right);

        }
        node.height = Math.max(height(node.left) , height(node.right) )+1;
        return node;
    }
    public void Populate(int[]nums) {
        for (int i = 0; i < nums.length; i++) {


            this.insert(nums[i]);
        }
    }
    public boolean balanced(){
        return  balanced(root);
    }
    public boolean balanced(Node node){
        if (node == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right) +1)  <= 1 && balanced(node.left) && balanced(node.right)   ;   }
    public void Display(){
        Display(this.root , " Root Node : ");
    }
    private void Display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        Display(node.left, "Left child of " + node.value + " : ");
        Display(node.right, "Right child of " + node.value + " : ");
    }





}

