import java.util.Scanner;

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
    void inorder(Node root){
        if(root == null) return;

        inorder(root.left);
        System.out.println(root.data + " ");
        inorder(root.right);
    }

    boolean search(Node root, int key){
//        base condition
        if(root == null){
            return false;
        }
//        found the key
        if(root.data == key){
            return true;
        }
//        recursive search
        if(key < root.data){
            return search(root.left, key);
        }
        else {
            return search(root.right, key);
        }
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

        bst.inorder(bst.root);

        int keyValue;
        System.out.print("Enter a number you want to search: ");
        Scanner sc = new Scanner(System.in);
        keyValue = sc.nextInt();
        System.out.println("\nSearching for " + keyValue + "......");
        if(bst.search(bst.root, keyValue)){
            System.out.println("Node " + keyValue + " found in the BST");
        }
        else {
            System.out.println("Node " + keyValue + " not found in the BST");
        }
    }

}

