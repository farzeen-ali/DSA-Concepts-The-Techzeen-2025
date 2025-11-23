public class AVLTree {
    static class Node{
        int key;
        Node left, right;
        int height;

        Node(int key){
            this.key = key;
            this.height = 1; // 1 + max((lc),(rc))
        }

        private Node root;

        private int height(Node node){
            return (node == null) ? 0 : node.height;
        }

        private int getBalance(Node node){
            return (node == null) ? 0 : height(node.left) - height(node.right);
        }

        private Node rotateRight(Node parent){
            Node leftNode = parent.left;
            Node temp = leftNode.right;

            leftNode.right = parent;
            parent.left = temp;

            parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
            leftNode.height = Math.max(height(leftNode.left), height(leftNode.right)) + 1;

            return leftNode;
        }

        private Node rotateLeft(Node parent){
            Node rightNode = parent.right;
            Node temp = rightNode.left;

            rightNode.left = parent;
            parent.right = temp;

            parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
            rightNode.height = Math.max(height(rightNode.left), height(rightNode.right)) + 1;

            return rightNode;
        }

    }
}
