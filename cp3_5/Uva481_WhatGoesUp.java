package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Uva481_WhatGoesUp {
	static Stack<Integer> stack;	
	
	static int lis(int[] A, int n)		
	{
		ArrayList<Integer> L = new ArrayList<Integer>(); 
		int[] P = new int[n];			
		int[] L_id = new int[n];
		
		int lis = 0, lis_end = -1;
		for(int i = 0; i < n; ++i) 
		{
			int pos = Collections.binarySearch(L, A[i]);
			if (pos < 0) pos = -(pos + 1);

			if(pos >= L.size()) L.add(A[i]);
			else                 L.set(pos, A[i]);

			if(pos + 1 > lis)
			{
				lis = pos + 1;
				lis_end = i;
			}
			
			//lis_end and the following part for printing the solution
			L_id[pos] = i;
			P[i] = pos > 0 ? L_id[pos-1] : -1;
		}
		
		stack = new Stack<Integer>();
		while(lis_end != -1)
		{
			stack.push(A[lis_end]);
			lis_end = P[lis_end];
		}
		return lis;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int [] arr = new int [((int) 1e6)];
		int n = 0;
		String s = in.nextLine();
		while(s!=null && s.length()!=0)
		{
			arr[n++] = Integer.parseInt(s);
			s = in.nextLine();
		}
		stack = new Stack<>();
		System.out.println(lis(arr, n));
		System.out.println("-");
		while(!stack.isEmpty())
			System.out.println(stack.pop());
		
	}
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
	}
}
