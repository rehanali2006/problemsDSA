public class BST {
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }

    public static Node buildTree(int val,Node root){
        if(root==null){
            root = new Node(val);
        }
        else if(root.data<val){
            root.right=buildTree(val,root.right);
        }
        else{
            root.left = buildTree(val,root.left);
        }
        return root;
    }

    public static void printInRange(Node root,int k1,int k2){
        if(root==null){
            return;
        } 
        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.println(root.data);
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1){
            printInRange(root.right, k1, k2);
        }
        else{
            printInRange(root.left, k1, k2);
        }
    }
    public static boolean ValidBST(Node root){
        if(root == null){
            return true;
        }
        else if(root.left!=null){
            return root.data > root.left.data;
        }
        else if(root.right!=null){
            return root.data < root.right.data;
        }
        boolean leftValid = ValidBST(root.left);
        boolean rightValid = ValidBST(root.right);
        return leftValid && rightValid;
    }
    public static void inorder(Node root){
        if(root==null){
            return ;
        }
        inorder(root.left);
        System.out.println(root.data + " ");
        inorder(root.right);
    }

    public static Node mirror(Node root){
        if(root==null){
            return root;
        }   

        if(root.left != null && root.right != null){
            Node temp = root.right;
            root.right = mirror(root.left);
            root.left = temp;
        }
        else if(root.left==null){
            
            root.right=mirror(root.left);
            root.left=null;
        }
        else{
           
            root.left=mirror(root.right);
            root.right=null;
        }
        return root;
    }

    public static void main(String args[]){
        int values[]={8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0;i<values.length;i++){
            root = buildTree(values[i], root);
        }
        inorder(root);
        System.out.println(ValidBST(root));
    }
}
