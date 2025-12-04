public class AVLTree {
    static class Node {
        int key;
        Node left, right;
        int height;

        Node(int key) {
            this.key = key;
            this.height = 1; // 1 + max((lc),(rc))
        }
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
//        insertion operation
        public void insert(int key){
            root = insertRec(root, key);
            System.out.println("Inserted: " + key);
        }
//        actual insertion login
        private Node insertRec(Node node, int key){
            if(node == null){
                return new Node(key);
            }
            if(key < node.key){
                node.left = insertRec(node.left, key);
            }
            else if(key > node.key){
                node.right = insertRec(node.right, key);
            }
            else {
                return node;
            }

//            update height
            node.height = 1 + Math.max(height(node.left), height(node.right));

            int balance = getBalance(node);
// -1, 0, 1
//          LL
            if(balance > 1 && key < node.left.key){
                return rotateRight(node);
            }
            // RR
            if (balance < -1 && key > node.right.key){
                return rotateLeft(node);
            }
//            LR
            if(balance > 1 && key > node.right.key){
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
            // RR
            if (balance < -1 && key < node.left.key){
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
            return node;
        }

//        Inorder => Sorted Output
        public void inorder(){
            inorderRec(root);
            System.out.println();
        }

        private void inorderRec(Node node){
            if(node != null){
                inorderRec(node.left);
                System.out.println(node.key + " ");
                inorderRec(node.right);
            }
        }

//        public search
    public boolean search(int key){
            return searchRec(root, key);
    }

    private boolean searchRec(Node node, int key){
            if(node == null){
                return false;
            }
            if(key == node.key){
                return true;
            }
            return (key < node.key)
                    ?
                    searchRec(node.left, key)
                    : searchRec(node.right, key);

    }

    public static void main(String[] args) {
        AVLTree avl = new AVLTree();

        avl.insert(30);
        avl.insert(20);
        avl.insert(40);
        avl.insert(10);
        avl.insert(25);
        avl.insert(50);

        System.out.println("\nInorder Traversal: ");
        avl.inorder();

        System.out.println("Search 25: " + avl.search(25));
        System.out.println("Search 100: " + avl.search(100));
    }
}
