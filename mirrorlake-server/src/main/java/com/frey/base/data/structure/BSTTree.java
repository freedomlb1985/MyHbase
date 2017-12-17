package com.frey.base.data.structure;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Frey on 2017/11/5.
 */
public class BSTTree<T> {
    public Node root;
    private Node[] tree = new Node[64];
    private int capacity =64;
    private int position = 0;

    public BSTTree(T value) {
        this.root = new Node(value);
        tree[position] = root;
    }

    public void preLookup() {
        leftLookup(root);
        System.out.println(root.getValue());
        rightLookup(root);
    }
    public void leftLookup(Node node) {
        if(node.getLeftChild() != -1) {
            leftLookup(tree[node.getLeftChild()]);
        }
        System.out.println(node.getValue());
        if(node.getRightChild() != -1) {
            rightLookup(tree[node.getRightChild()]);
        }
    }

    public void rightLookup(Node node) {
        if(node.getLeftChild() != -1) {
            leftLookup(tree[node.getLeftChild()]);
        }
        System.out.println(node.getValue());
        if(node.getRightChild() != -1) {
            rightLookup(tree[node.getRightChild()]);
        }
    }

    public void insert(T value) {
        Node n = findParent(value ,root);
        if(position >= capacity -1){
            capacity = capacity * 2;
            Node[] _tree = new Node[capacity];
            System.arraycopy(tree, 0, _tree, 0, tree.length);
            tree = _tree;
        }
        tree[++position] = new Node(value);

        if(n.getValue().hashCode() >= value.hashCode()) {
            n.setLeftChild(position);
        } else {
            n.setRightChild(position);
        }
    }
    
    public Node find(T value) {
        return lookUp(value, root);
    }

    private Node lookUp(T value, Node node) {
        Node n = null;
        if(node.hashCode() == value.hashCode()) {
            return node;
        }
        if(node.hashCode() > value.hashCode() && node.getLeftChild() != -1) {
            n = tree[node.getLeftChild()];
        } else if(node.hashCode() < value.hashCode() && node.getRightChild() != -1){
            n = tree[node.getRightChild()];
        }
        if(n == null) {
            return n;
        } else {
            return lookUp(value, n);
        }
    }

    private Node findParent(T value, Node node) {
        Node n = null;
        if(node.hashCode() >= value.hashCode() && node.getLeftChild() != -1) {
            n = tree[node.getLeftChild()];
        } else if(node.hashCode() < value.hashCode() && node.getRightChild() != -1){
            n = tree[node.getRightChild()];
        }
        if(n == null) {
            return node;
        } else {
            return findParent(value, n); 
        }
    }

    public static void main(String[] args) {
        Random ran = new Random(System.currentTimeMillis());
        BSTTree tree = new BSTTree(ran.nextInt(1000));

        for(int i = 0; i < 100; i++) {
            tree.insert(ran.nextInt(1000));
        }
        System.out.println("Root:" + tree.root.getValue());
        tree.preLookup();
    }

}
