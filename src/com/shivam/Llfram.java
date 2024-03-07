package com.shivam;
import java.util.LinkedList;
import java.util.Scanner;

public class Llfram {
	public static void main(String args[]) {
		LinkedList<Integer> ll = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<=10;i++) {
			System.out.println("Enter the "+i+" number:");
			int num = sc.nextInt();
			ll.addLast(num);
		}
		System.out.println(ll);
	}
}
