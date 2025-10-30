package Tree;

public class SegmentTree {
    public class  Node {
        Node left;
        Node right;
        int startIndex;
        int endIndex;
        int data;

        public Node(int Stindex, int edIndex) {
            this.startIndex = Stindex;
            this.endIndex = edIndex;
        }
    }
        Node root;
        public  SegmentTree(int[]arr){
            this.root = ConstructTree(arr, 0 ,arr.length-1);



        }

        private Node ConstructTree(int[] arr, int start, int end) {
            if (start == end){
                Node leaf = new Node(start, end);
                leaf.data = arr[start];
                return leaf;
            }
            int mid = start+(end-start)/2;
            Node node = new Node(start, end);
            node.left = ConstructTree(arr, start, mid);
            node.right = ConstructTree(arr, mid+1, end);
            return node;
        }
        public void Display(){
             Display(root);
        }
        public void Display(Node node){
            String str = " ";
            if (node.left!=null){
                str = str+ "[ " + node.left.startIndex + node.left.endIndex  + " ] " + "data -> " + node.left.data;


            }else{
                str = str+ " no left child";
            }
            str = str+ "[ " + node.startIndex + node.startIndex  + " ] " + "data -> " + node.data;
            if (node.right != null){
                str = str+ "[ " + node.right.startIndex + node.right.endIndex + " ] " + "data -> " + node.right.data;


            }else{
                str = str +" No right child ; ";
            }
            System.out.println(str + '\n');

            if (node.left!=null) {


                Display(node.left);
            }
            if (node.right != null) {


                Display(node.right);
            }

        }
        public int query(int sin , int eind){
            return this.query(this.root , sin , eind);
        }
        public int query(Node node , int sin , int ein){
            if (node.startIndex < ein || node.endIndex > sin) {
                return node.data;
            }else if (node.startIndex > ein || node.endIndex < sin) {

                return 0;
            }else{
                return this.query(node.left, sin, ein) + this.query(node.right, sin, ein);

            }


            }
            public int  update( int index , int value){
            return update(this.root , index , value);


            }
            public int update(Node node , int index , int value){
            if (index>= node.startIndex && index <= node.endIndex){
                if (index == node.startIndex && index == node.endIndex){
                    node.data = value;
                    return node.data;
                }else{
                    int leftAns = update(node.left,index,value);
                    int rightAns = update(node.right,index,value);
                    node.data = leftAns+rightAns;
                    return node.data;
                }
            }
            return node.data;
            }




}
