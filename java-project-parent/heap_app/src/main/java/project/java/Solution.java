package project.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Solution {

    static void map(Node node, List<Node> nodes, boolean left) {
        if (left) {
            node.setRight(nodes.get(0));
            nodes.set(0, node);
        } else {
            node.setLeft(nodes.get(1));
            nodes.set(1, node);
        }
    }

    static void calc(Node node) {
        int left = Objects.nonNull(node.getLeft()) ? node.getLeft().getSize() : 0;
        int right = Objects.nonNull(node.getRight()) ? node.getRight().getSize() : 0;
        node.setSize(left + right + 1);
    }

    public static List<Node> split(Node root, int k) {
        List<Node> nodes = new ArrayList<>();
        if (k == 0) {
            nodes.add(root);
            return nodes;
        }
        int left = Objects.nonNull(root.getLeft()) ? root.getLeft().getSize() : 0;
        left += 1;
        if (k >= left) {
            nodes.addAll(split(root.getRight(), k - left));
            if (nodes.size() == 1) {
                nodes.add(0, root);
                root.setRight(null);
                calc(root);
            } else if (nodes.size() == 2) {
                map(root, nodes, true);
                calc(root);
            }
        } else {
            nodes.addAll(split(root.getLeft(), k));
            if (nodes.size() == 1) {
                nodes.add(root);
            } else if (nodes.size() == 2) {
                map(root, nodes, false);
                calc(root);
            }
        }
        return nodes;
    }


    // <template>
    private static class Node {

        private Node left;
        private Node right;
        private int value;
        private int size;

        Node(Node left, Node right, int value, int size) {
            this.left = left;
            this.right = right;
            this.value = value;
            this.size = size;
        }

        public int getValue() {
            return value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }
    // <template>


    public static void test() {
        Node node10 = new Node(null, null, 932, 1);
        Node node9 = new Node(null, node10, 912, 2);
        Node node8 = new Node(null, null, 822, 1);
        Node node7 = new Node(node8, node9, 870, 4);
        Node node6 = new Node(null, null, 701, 1);
        Node node5 = new Node(node6, node7, 702, 6);
        Node node4 = new Node(null, null, 266, 1);
        Node node3 = new Node(null, node4, 191, 2);
        Node node2 = new Node(node3, null, 298, 3);
        Node node1 = new Node(node2, node5, 668, 10);
        List<Node> res = split(node1, 1);

    }
}