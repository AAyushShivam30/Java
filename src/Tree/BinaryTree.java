package Tree;

import java.util.Scanner;

public class BinaryTree {
    public BinaryTree() {

    }
        public static class Node{
        Node left;
        Node right;
        int value;
        public Node(int value){
            this.value = value;

        }
        }
        public Node root;

    public void populate( Scanner in , int value ){
        System.out.println("Enter the value of the root node ");
       // int value = in.nextInt();
        root = new Node(value);
        populate( in, value , root);




    }
    public void populate(Scanner in , int value ,  Node node){
        System.out.println("Do you want to enter the value in the left of the  : " + node.value);
        boolean left = in.nextBoolean();
        if (left){
            System.out.println("Enter the value in the left of the " + node.value);
             value = in.nextInt();
            node.left = new Node(value);
            populate(in , value,  node.left);
        }
        System.out.println("Do you enter the value in the right of the " + node.value);
        boolean right = in.nextBoolean();
        if (right){
            System.out.println("Enter the value in the right of the " + node.value);
             value = in.nextInt();
            node.right = new Node(value);
            populate(in, value, node.right);
        }
    }
    public void Display(){
        Display(this.root , " ");
    }
    private void Display(Node node , String indent){
        if (node == null){
            return ;
        }
        System.out.println(indent + node.value);
        Display(node.left, indent + "\t ");
        Display(node.right , indent + "\t");
    }
    public  void preetyDisplay(){
        preetyDisplay(root , 0);

    }
    public void preetyDisplay(Node node , int level){
        if (node == null){
            return;
        }
        preetyDisplay( node.right , level+1);
        if (level != 0){
            for (int i = 0; i<level-1; i++){
                System.out.print( "|\t + \t");
            }
            System.out.println(" |-----------> " + node.value);
        }else{
            System.out.println(node.value);
        }
        preetyDisplay(node.left , level+1);
    }


}
