package Tree;

import java.util.Scanner;

public class main {

    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(in ,15);
        //tree.Display();
        tree.preetyDisplay();
    }

}
