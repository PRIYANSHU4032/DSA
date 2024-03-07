package com.shivam;

import java.util.ArrayList;
import java.util.Scanner;

public class Array2L {
	public static void insertList(ArrayList<Integer>list,int n) {
		Scanner sc = new Scanner(System.in);
        System.out.println("Insert into list");
        for (int i = 0; i < n; i++) {
            int j = sc.nextInt();
            list.add(j);
        }
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many elements do you want to insert?");
        int n = sc.nextInt(); // Read the number of elements from the user
		ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> list3 = new ArrayList<>();
		ArrayList<Integer> list4 = new ArrayList<>();
		
		insertList(list1,n);
		insertList(list2,n);
		insertList(list3,n);
		insertList(list4,n);
		
		mainlist.add(list1);
		mainlist.add(list2);
		mainlist.add(list3);
		mainlist.add(list4);
		
		for(int i=0;i<mainlist.size();i++){
			ArrayList<Integer> currlist = mainlist.get(i);
			for(int j=0;j<currlist.size();j++) {
				System.out.print(currlist.get(j)+" ");
			}
			System.out.println();
		}
		
	}
}
