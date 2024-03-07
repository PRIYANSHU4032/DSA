package com.shivam;

public class PriyanshuPrashant {
	public static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		
		
	}
	public static Node head;
	public static Node tail;
	
	public static boolean isCycle() {
			Node slow = head;
			Node fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	public static void removeCycle() {
	    Node slow = head;
	    Node fast = head;
	    boolean exist = false;

	    // Detect if there's a cycle
	    while (fast != null && fast.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	        if (fast == slow) {
	            exist = true;
	            break;
	        }
	    }

	    // If no cycle exists, return
	    if (!exist) {
	        return;
	    }

	    // Reset slow to head and find the node where the cycle starts
	    slow = head;
	    while (slow != fast) {
	        slow = slow.next;
	        fast = fast.next;
	    }

	    // Find the node previous to the start of the cycle
	    Node prev = null;
	    while (fast.next != slow) {
	        fast = fast.next;
	    }
	    prev = fast;

	    // Remove the cycle by setting the next of the previous node to null
	    prev.next = null;
	}


	
	public static void main(String args[]) {
		PriyanshuPrashant pp = new PriyanshuPrashant();
		pp.head = new Node(1);
		Node temp = new Node(2);
		pp.head.next = temp;;
		pp.head.next.next = new Node(3);
		pp.head.next.next.next = temp;
		System.out.println(pp.isCycle());
		pp.removeCycle();
		System.out.println(pp.isCycle());
		
	}

}
