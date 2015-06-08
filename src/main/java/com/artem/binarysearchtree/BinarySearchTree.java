package com.artem.binarysearchtree;

public class BinarySearchTree {
    private Node root;

    private class Node {
        final int value;
        Node parent;
        Node leftChild;
        Node rightChild;

        Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
            this.leftChild = this.rightChild = null;
        }
    }

    public void add(int value) {
        if (root == null)
            addRoot(value);
        else
            addToTree(root, value);
    }

    private void addRoot(int value) {
        root = new Node(value, null);
    }

    private void addToTree(Node node, int value) {
        if (node.value > value) {
            if (node.leftChild == null)
                node.leftChild = new Node(value, node);
            else
                addToTree(node.leftChild, value);
        }
        if (node.value < value) {
            if (node.rightChild == null)
                node.rightChild = new Node(value, node);
            else
                addToTree(node.rightChild, value);
        }
    }

    public void remove(int value) {
        Node node = findNode(root, value);
        if (node == null)
            return;
        if (node.leftChild != null && node.rightChild != null)
            appendLeftChildToRightChild(node);
        if (node.leftChild == null && node.rightChild != null)
            removeNodeWithRightChild(node);
        if (node.leftChild != null && node.rightChild == null)
            removeNodeWithLeftChild(node);
        if (node.leftChild == null && node.rightChild == null)
            removeNodeWithoutChildren(node);
    }

    private Node findNode(Node node, int value) {
        if (root == null)
            return null;
        if (node.value == value)
            return node;
        if (node.value > value && node.leftChild == null || node.value < value && node.rightChild == null)
            return null;
        if (node.value > value)
            return findNode(node.leftChild, value);
        return findNode(node.rightChild, value);
    }

    private void appendLeftChildToRightChild(Node node) {
        Node leftChildNewParent = getMinNode(node.rightChild);
        node.leftChild.parent = leftChildNewParent;
        leftChildNewParent.leftChild = node.leftChild;
        node.leftChild = null;
    }

    private void removeNodeWithRightChild(Node node) {
        node.rightChild.parent = node.parent;
        if (node == root)
            root = node.rightChild;
        else if (node == node.parent.leftChild)
            node.parent.leftChild = node.rightChild;
        else
            node.parent.rightChild = node.rightChild;
    }

    private void removeNodeWithLeftChild(Node node) {
        node.leftChild.parent = node.parent;
        if (node == root)
            root = node.leftChild;
        else if (node == node.parent.leftChild)
            node.parent.leftChild = node.leftChild;
        else
            node.parent.rightChild = node.leftChild;
    }

    private void removeNodeWithoutChildren(Node node) {
        if (node == root)
            root = null;
        else if (node == node.parent.leftChild)
            node.parent.leftChild = null;
        else
            node.parent.rightChild = null;
    }

    public int getMinValue() {
        return getMinNode(root).value;
    }

    private Node getMinNode(Node node) {
        if (root == null)
            throw new NullPointerException("Tree is empty!");
        if (node.leftChild == null)
            return node;
        else
            return getMinNode(node.leftChild);
    }

    public int getMaxValue() {
        return getMaxNode(root).value;
    }

    private Node getMaxNode(Node node) {
        if (root == null)
            throw new NullPointerException("Tree is empty!");
        if (node.rightChild == null)
            return node;
        else
            return getMaxNode(node.rightChild);
    }

    public boolean contains(int value) {
        return findNode(root, value) != null;
    }

    public String toString() {
        if (root == null)
            return "";
        Node node = getMinNode(root);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(node.value);
        while (getNextNode(node) != null) {
            node = getNextNode(node);
            stringBuilder.append(", ");
            stringBuilder.append(node.value);
        }
        return stringBuilder.toString();
    }

    private Node getNextNode(Node node) {
        if (node.rightChild != null)
            return getMinNode(node.rightChild);
        if (node == root)
            return null;
        if (node == node.parent.leftChild)
            return node.parent;
        while (node.parent != null && node == node.parent.rightChild)
            node = node.parent;
        return node.parent;
    }
}
