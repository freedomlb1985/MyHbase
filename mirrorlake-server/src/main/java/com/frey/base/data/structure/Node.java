package com.frey.base.data.structure;

/**
 * Created by Frey on 2017/11/5.
 */
public class Node<T> {
    private int leftChild = -1;


    private int rightChild = -1;
    private T value;

    public Node(T value) {
        this.value = value;
    }

    public Node(int pre, int pos, T value) {
        this.leftChild = pre;
        this.rightChild = pos;
        this.value = value;
    }

    public int getLeftChild() {
        return leftChild;
    }

    public int getRightChild() {
        return rightChild;
    }

    public T getValue() {
        return value;
    }

    public void setLeftChild(int leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(int rightChild) {
        this.rightChild = rightChild;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

}
