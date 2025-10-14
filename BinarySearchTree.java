public class BinarySearchTree {
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    Node root;
    BinarySearchTree(){
        root = null;
    }
    void insert(int value){
        root = insertRec(root, value);
    }
    Node insertRec(Node root, int value){
        if(root == null){
            root = new Node(value);
            System.out.println("Inserted: "+ value);
            return root;
        }
        if(value < root.data){
            root.left = insertRec(root.left, value);
        }
        else if(value > root.data){
            root.right = insertRec(root.right, value);
        }
        else {
            System.out.println("Value: " + value + " already existed!");
        }
        return root;
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
    }
}
