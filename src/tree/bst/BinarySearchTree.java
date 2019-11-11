package tree.bst;

public class Tree {

    public static void printTree_LeftOrder(Node node) {
        if (node != null) {
            System.out.println( node.data + " " );
        }
        if (node.left != null) {
            printTree_LeftOrder(node.left);
        }

        if (node.right != null) {
            printTree_LeftOrder(node.right);
        }
    }

    public static void printTree_RightOrder(Node node) {
        if (node.left != null) {
            printTree_RightOrder(node.left);
        }

        if (node.right != null) {
            printTree_RightOrder(node.right);
        }
        if (node != null) {
            System.out.println( node.data + " " );
        }
    }

    public static void printTree_InOrder(Node node) {
        if (node.left != null) {
            printTree_InOrder(node.left);
        }

        if (node != null) {
            System.out.println( node.data + " " );
        }

        if (node.right != null) {
            printTree_InOrder(node.right);
        }
    }

    /**
     * Insert values to a Binary Search Tree
     *
     * @param node
     * @param val
     * @return
     */

    public static Node insertNode(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (val < node.data)
            node.left = insertNode(node.left, val);
        if (val > node.data)
            node.right = insertNode(node.right, val);
        return node;
    }


    public static void main(String args[]) {
        String bstInput = "10,5,15,30,25,35";
        Node head = null, node = null;

        for (String n: bstInput.split(",")) {
            Integer valI = Integer.valueOf(n);
            int val = valI.intValue();
            if (head == null) {
                head = new Node( val );
                node = head;
                continue;
            }
            node = insertNode(node, val);
        }

        System.out.println( "Printing Tree -> In Order <-" + head );
        printTree_InOrder(head);
        System.out.println( "Printing Tree -> Left Order <-" + head );
        printTree_LeftOrder(head);
        System.out.println( "Printing Tree -> Right Order <-" + head );
        printTree_RightOrder(head);
    }

}

class Node {
    int data;
    Node left;
    Node right;

    Node(int dt) {
        data = dt;
    }
}