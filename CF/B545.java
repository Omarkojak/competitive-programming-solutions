package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B545 {

	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		String s =in.nextLine();
		String t =in.nextLine();
		int diff=0;
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)!=t.charAt(i))
				diff++;
		if(diff%2!=0){
			System.out.println("impossible");
			return;
		}
		boolean f=true;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)!=t.charAt(i)){
				if(f)
					sb.append(s.charAt(i));
				else
					sb.append(t.charAt(i));
				f=!f;
			}else
				sb.append(s.charAt(i));

		}
		System.out.println(sb);
		
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
		
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		
		public boolean ready() throws IOException {return br.ready();}


	}
}
