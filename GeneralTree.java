import com.sun.source.tree.Tree;

import java.util.*;

public class GeneralTree {
    public static class TreeNode{
        int data;
        List<TreeNode> children;

        TreeNode(int data){
            this.data = data;
            this.children = new ArrayList<>();
        }
        void addChild(TreeNode child){
            children.add(child);
        }
    }
    TreeNode root;

    public GeneralTree(int rootData){
        root = new TreeNode(rootData);
    }

    public void printTree(TreeNode node, String space){
        if (node == null) return;
        System.out.println(space + node.data);
        for (TreeNode child: node.children){
            printTree(child, space + "--");
        }
    }

    public static void main(String[] args) {
        GeneralTree tree = new GeneralTree(1);

        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(3);
        TreeNode child3 = new TreeNode(4);

        tree.root.addChild(child1);
        tree.root.addChild(child2);
        tree.root.addChild(child3);

        child1.addChild(new TreeNode(5));
        child1.addChild(new TreeNode(6));

        child2.addChild(new TreeNode(7));

        child3.addChild(new TreeNode(8));
        child3.addChild(new TreeNode(9));
        child3.addChild(new TreeNode(10));

        System.out.println("General Tree Structure: ");
        tree.printTree(tree.root, "");

    }
}
