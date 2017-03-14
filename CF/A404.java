package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A404 {

	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		char[][]m=new char[n][n];
		for(int i=0;i<n;i++){
			String s=in.nextLine();
			for(int j=0;j<n;j++)
				m[i][j]=s.charAt(j);
		}
		
		char c = m[0][0];
		m[0][0] = ' ';
		int k=1;boolean flag=true;
		while(k<n){
			if(m[k][k]!=c)
				flag=false;
			m[k][k]=' ';
			k++;
		}
		int k1=0;int k2=n-1;
		while(k1<n){
			if(m[k1][k2]!=c&&k1!=n/2)
				flag=false;
			m[k1][k2]=' ';
			k1++;k2--;
		}
		if(!flag){
			System.out.println("NO");
			return;
		}
		boolean res=true;
		char ck=m[0][1];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(m[i][j]!=ck && m[i][j]!=' ')
					res=false;
		System.out.println((res&&c!=ck)? "YES":"NO");
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
