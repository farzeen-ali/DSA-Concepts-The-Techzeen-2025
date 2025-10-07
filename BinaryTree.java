public class BinaryTree {
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    Node root;

    BinaryTree(int rootData) {
        root = new Node(rootData);
    }

//    Inorder (left, Root, Right)
    void inorder(Node node){
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
    //    Preorder (root, left, Right)
    void preorder(Node node){
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }
    //    Postorder (left, Right, root)
    void postorder(Node node){
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Inorder Traversal");
        tree.inorder(tree.root);
        System.out.println();
        System.out.println("Preorder Traversal");
        tree.preorder(tree.root);
        System.out.println();
        System.out.println("Postorder Traversal");
        tree.postorder(tree.root);
        System.out.println();


    }
}
