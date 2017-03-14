package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C141_Queue {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Person arr [] = new Person[n];
		for(int i=0;i<n;i++)
			arr[i] = new Person(in.next(), in.nextInt());
		boolean flag = true;
		Arrays.sort(arr);
		for(int i=0;i<n;i++)
			if(arr[i].h > i)
				flag = false;
		if(!flag)
		{
			System.out.println(-1);
			return;
		}
		
		

	}
	static class Person implements Comparable<Person>
	{
		String name;
		int h;
		
		Person(String a, int x)
		{
			name = a;
			h = x;
		}
		
		public int compareTo(Person o) {
			if(h != o.h)
				return h - o.h;
			return name.compareTo(o.name);
		}
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
