package com.nchng1.ds.chap01;

import java.util.NoSuchElementException;

public class MySingleLinkedList<E> {
    private Node<E> head;

    private int size;

    public MySingleLinkedList(){
        this.head = new Node<>(null);
        size = 0;
    }


    /***** 增 *****/

    public void addLast(E e) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> x = new Node<>(e);
        Node<E> p = head.next;
        while(p.next != null) {
            p = p.next;
        }
        p.next = x;

        size++;
    }

    public void addFirst(E e) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> x = new Node<>(e);
        Node<E> temp = head.next;
        x.next = temp;

        size++;
    }

    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == size) {
            addLast(element);
            return;
        }

        // 找到 index 对应的 Node
        Node<E> p = getNode(index);
        Node<E> t = getNode(index - 1);

        // 新要插入的 Node
        Node<E> x = new Node<>(element);

        x.next = p;
        t.next = x;

        size++;
    }

    /***** 删 *****/

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> temp = head.next;
        head.next = temp.next;

        size--;
        return temp.val;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> p = head.next;
        Node<E> t = head;
        while(p.next != null) {
            p = p.next;
            t = t.next;
        }
        t.next = null;
        size--;
        return p.val;
    }

    public E remove(int index) {
        checkElementIndex(index);
        // 找到 index 对应的 Node
        Node<E> x = getNode(index);
        Node<E> t = getNode(index - 1);
        t.next = x.next;

        size--;
        return x.val;
    }


    /***** 查 *****/

    public E get(int index) {
        checkElementIndex(index);
        Node<E> node = getNode(index);
        return node.val;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return head.next.val;
    }

    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> p = head.next;
        while(p.next != null) {
            p = p.next;
        }
        return p.val;
    }

    /***** 改 *****/

    public E set(int index, E val) {
        checkElementIndex(index);
        // 找到 index 对应的 Node
        Node<E> p = getNode(index);

        E oldVal = p.val;
        p.val = val;

        return oldVal;
    }

    /***** 其他工具函数 *****/

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    private Node<E> getNode(int index) {
        checkElementIndex(index);
        Node<E> p = head.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }


    /**
     * 检查 index 索引位置是否可以存在元素
     */
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    /**
     * 检查 index 索引位置是否可以添加元素
     */
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void display() {
        System.out.println("size = " + size);
        for (Node<E> p = head.next; p != null; p = p.next) {
            System.out.print(p.val + " -> ");
        }
        System.out.println("null");
        System.out.println();
    }

    private static class Node<E> {
        E val;
        Node<E> next;
        Node(E val) {
            this.val = val;
        }
    }
}
