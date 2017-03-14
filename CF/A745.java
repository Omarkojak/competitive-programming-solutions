package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class A745 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		TreeSet<String> ts = new TreeSet<>();
		char s[] = in.nextLine().toCharArray();
		int n = s.length;
		for(int i=0;i<n;i++){
			StringBuilder sb = new StringBuilder();
			for(int j=i;j<n;j++)
				sb.append(s[j]);
			for(int j=0;j<i;j++)
				sb.append(s[j]);
			ts.add(sb.toString());
		}
		System.out.println(ts.size());
		
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
