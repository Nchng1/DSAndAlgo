package com.nchng1.ds.chap01.practices;

import com.nchng1.ds.chap01.MySingleLinkedList;

public class MergeTwoLists {

    public static void main(String[] args) {

    }

    Node<Integer> mergeTwoLists(Node<Integer> l1, Node<Integer> l2) {
        // 边界条件
        Node<Integer> head = new Node<>(null);
        Node<Integer> emissary = head;
        Node<Integer> p1 = l1;
        Node<Integer> p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                emissary.next = p2;
                p2 = p2.next;
            }
            else {
                emissary.next = p1;
                p1 = p1.next;
            }
            emissary = emissary.next;
        }
        if (p1 == null) {
            emissary.next = p2;
        }
        if (p2 == null) {
            emissary.next = p1;
        }

        return head.next;
    }


    private static class Node<E> {
        E val;
        Node<E> next;
        Node(E val) {
            this.val = val;
        }
    }
}
