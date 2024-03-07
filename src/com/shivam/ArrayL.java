package com.shivam;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayL {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many elements do you want to insert?");
        int n = sc.nextInt(); // Read the number of elements from the user
        System.out.println("Insert into list");
        for (int i = 0; i < n; i++) {
            int j = sc.nextInt();
            list.add(j);
        }
        for(int i= list.size()-1;i>=0;i--){
        	System.out.print(list.get(i)+" ");
        }
        
        swapList(list,1,2,n);
}
    
    public static void swapList(ArrayList<Integer> list,int idx1,int idx2,int n) {
    	int temp = list.get(idx1);
    	list.set(idx1, list.get(idx2));
    	list.set(idx2, temp);
    	for(int i=0;i<n;i++) {
    		System.out.print(list.get(i));
    	}
    }
    
}

    