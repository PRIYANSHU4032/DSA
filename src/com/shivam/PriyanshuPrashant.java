package com.shivam;

import com.shivam.LinkedList.Node;

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


	private Node getMid(Node head) {
		Node slow = head;
		Node fast = head.next;
		while(fast!= null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private Node merge(Node head1,Node head2) {
		Node mergeLL = new Node(-1);
		Node temp = mergeLL;
		
		while(head1!=null && head2!=null) {
			if(head1.data<=head2.data) {
				temp.next = head1;
				head1 = head1.next;
				temp = temp.next;
			}else {
				temp.next = head2;
				head2 = head2.next;
				temp = temp.next;
			}
		}
		
		while(head1!=head2) {
			temp.next = head1;
			head1 = head1.next;
			temp = temp.next;
		}
		
		while(head2!=head1) {
			temp.next = head2;
			head2 = head2.next;
			temp = temp.next;
		}
		
		return mergeLL.next;
	}
	
	public Node mergeSort(Node head) {
		if(head==null || head.next == null) {
			return head;
		}
		
		Node mid = getMid(head);
		Node rightHead = mid.next;
		mid.next = null;
		Node newleft = mergeSort(head);
		Node newright = mergeSort(rightHead);
		return merge(newleft,newright);
	}
	
	public static void zigZag() {
		Node slow = head;
		Node fast = head.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		Node mid = slow;
		
		Node curr = mid.next;
		mid.next = null;
		Node prev = null;
		Node next;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		Node left = head;
		Node right = prev;
		Node nextL , nextR;
		
		while(left != null && right != null) {
			nextL = left.next;
			left.next = right;
			nextR = right.next;
			right.next = nextL;
			
			left = nextL;
			right = nextR;
		}
	}
	    
	    
	    
	public static void main(String args[]) {
		PriyanshuPrashant pp = new PriyanshuPrashant();
		pp.addLast(5);
		pp.addLast(4);
		pp.addLast(3);
		pp.addLast(2);
		pp.addLast(1);
		pp.print();
		pp.head = pp.mergeSort(pp.head);
		pp.print();
		pp.zigZag();
		pp.print();
		
	}

}
