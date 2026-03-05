
package trees;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BSTInorder {
    Node root;

    void printKeys(Node node) {
        if (node == null) return;
        printKeys(node.left);
        System.out.print(node.key + " ");
        printKeys(node.right);
    }

    Node insert(Node node, int key) {
        if (node == null) return new Node(key);
        if (key < node.key) node.left = insert(node.left, key);
        else if (key > node.key) node.right = insert(node.right, key);
        return node;
    }

    public static void main(String[] args) {
        BSTInorder tree = new BSTInorder();
        int[] keys = {50, 30, 20, 40, 70, 60, 80};
        
        System.out.println("Inserting keys: 50, 30, 20, 40, 70, 60, 80");
        for (int key : keys) {
            tree.root = tree.insert(tree.root, key);
        }

        System.out.print("Sorted keys (Inorder): ");
        tree.printKeys(tree.root);
        System.out.println();
    }
}
