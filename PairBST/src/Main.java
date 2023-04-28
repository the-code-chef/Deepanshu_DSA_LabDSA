import java.util.*;

public class Main {

    // node class structure
    static class Node {
        int data;
        Node left, right;
    }

    // utility function that returns the new node
    static Node NewNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    // inserting node at correct position in BST
    static Node insert(Node root, int key){
        if (root == null) return NewNode(key);
        if (key < root.data) root.left = insert(root.left, key);
        else root.right = insert(root.right, key);
        return root;
    }

    static boolean findpairUtil(Node root, int sum, HashSet<Integer> set){
        // base case
        if (root == null) return false;

        if (findpairUtil(root.left, sum, set)) return true;

        if (set.contains(sum - root.data)){
            System.out.println("Pair is (" + (sum - root.data) + ", " + root.data + ")");
            return true;
        }
        else set.add(root.data);

        return findpairUtil(root.right, sum, set);
    }

    static void findPair(Node root, int sum){
        HashSet<Integer> set = new HashSet<>();
        if (!findpairUtil(root, sum, set))
            System.out.print("nodes are not found. \n");
    }
    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 70);
        root = insert(root, 60);
        root = insert(root, 30);

        int sum = 130;
        findPair(root, sum);
    }
}