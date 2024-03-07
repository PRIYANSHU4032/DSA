package com.shivam;

import java.util.Scanner;

public class LinkdList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public static void addMiddle(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while (temp != null && i < idx - 1) {
            temp = temp.next;
            i++;
        }
        if (temp == null) {
            System.out.println("Index out of bounds");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void main(String args[]) {
        LinkdList ll = new LinkdList();
        ll.addFirst(99);
        ll.addLast(44);
        ll.addFirst(9);
        ll.addLast(11);
        ll.addMiddle(2, 55);
        print();
    }
}
