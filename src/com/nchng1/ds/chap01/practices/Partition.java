package com.nchng1.ds.chap01.practices;

public class Partition {

    public static void main(String[] args) {

    }

    Node<Integer> partition(Node<Integer> head, int x) {
        Node<Integer> dummy1 = new Node<>(-1);
        Node<Integer> dummy2 = new Node<>(-1);

        Node<Integer> p1 = dummy1;
        Node<Integer> p2 = dummy2;

        Node<Integer> p = head;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            }
            else {
                p2.next = p;
                p2 = p2.next;
            }

            Node<Integer> temp = p.next;
            p.next = null;
            p = temp;
        }

        p1.next = dummy2.next;
        return dummy1.next;
    }

    // 不保留相对位置
    Node<Integer> partition2(Node<Integer> head, int x) {
        Node<Integer> dummy = new Node<>(-1);
        Node<Integer> p2 = head;
        Node<Integer> p1 = dummy;

        Node<Integer> temp = null;
        while (p2 != null) {
            if (p2.val < x) {
                temp = p2;
                p1.next = temp.next;
                p2 = p2.next;
                temp.next = dummy.next;
                dummy.next = temp;
                continue;
            }
            p1 = p2;
            p2 = p2.next;
        }
        return dummy.next;
    }




    private static class Node<E> {
        E val;
        Node<E> next;
        Node(E val) {
            this.val = val;
        }
    }
}
