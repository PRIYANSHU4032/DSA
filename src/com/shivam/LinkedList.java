package com.shivam;

import java.util.Scanner;

public class LinkedList {
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
    public static int size;

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
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public static void addLast(int data) {
        Node newNode = new Node(data);
        size++;
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
        size++;
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
    
    
    public static int removeFirst() {
    	if(size==0) {
    		System.out.println("list is empty");
    		return -1;
    		}else if(size==1) {
    			int val = head.data;
    			head = tail = null;
    			size--;
    		}
    	int val = head.data;
    	head = head.next;
    	size--;
    	return val;
    }
    
    public static int removeLast() {
    	if(size==0) {
    		System.out.println("list is empty");
    		return -1;
    		}else if(size==1) {
    			int val = head.data;
    			head = tail = null;
    		}
    	Node prev = head;
    	for(int i=0;i<size-2;i++) {
    		prev = prev.next;
    	}
    	int val = tail.data;
    	prev.next = null;
    	tail = prev;
    	size--;
    	return val;
    	
    }
    
    public static int searchItreative(int key) {
    	Node temp = head;
    	int i =0;
    	while(temp != null) {
    		if(temp.data == key) {
    			return i;
    		}
    		temp = temp.next;
    		i++;
    		}
    	return -1;
    }
    
    
    public static int helper( Node head,int key) {
    	if(head == null) {
    		return -1;
    	}
    	int id = helper(head.next,key);
    	if(id == -1) {
    		return -1;
    	}
    	return id+1;
    }
    
    
    public static int recSearch(int key) {
    	return helper(head,key);
    }
    
    public static void reverse() {
    	Node prev = null;
    	Node curr = tail = head;
    	Node next;
    	
    	while(curr != null) {
    		next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	head = prev;
    }
    
    
    public static void searchNthnodeFromend(int n) {
        int size = 0;
        Node temp = head;
        
        // Calculate the size of the linked list
        while(temp != null) {
            temp = temp.next;
            size++;
        }
        
        // If the node to remove is the head, remove it and return
        if(n == size) {
            head = head.next;
            return;
        }
        
        int idtofind = size - n; // Calculate the index of the node to remove
        int i = 0;
        Node prev = head;
        
        // Move to the node just before the one to be removed
        while(i < idtofind - 1) {
            prev = prev.next;
            i++;
        }
        
        // Remove the node
        prev.next = prev.next.next;
    }
    
    
    public Node findMid(Node head) {
    	Node slow = head;
    	Node fast = head;
    	while(fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow;
    }
    
    
    public boolean isPalindrome() {
    	if(head == null || head.next == null) {
    		return true;
    	}
    	
    	Node midnode = findMid(head);
    	Node prev = null;
    	Node curr = midnode;
    	Node next;
    	
    	while(curr != null) {
    		next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	Node right = prev;
    	Node left = head;
    	
    	while(right != null) {
    		if(left.data != right.data) {
    			return false;
    		}
    		left = left.next;
    		right = right.next;
    	}
    	return true;
    }
                                                

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        //ll.addFirst(99);
        //ll.addLast(44);
       // ll.addFirst(9);
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(4);
        //ll.addMiddle(2, 55);
       // print();
      //  reverse();
      //  print();
        //System.out.println(ll.searchItreative(55));
       // print();
       // System.out.println(removeFirst());
        //System.out.println(removeLast());
        
       // System.out.println(ll.recSearch(44));
        
       //searchNthnodeFromend(3);
      ll.print();
      System.out.println(ll.isPalindrome());
        
    }
}
