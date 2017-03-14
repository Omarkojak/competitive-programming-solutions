package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A644 {
	static int []dx={-1,1,0,0};
	static int []dy={0,0,1,-1};
	static int a,b,n;
	
	static boolean valid(int x,int y){
		return x>=0&&x<a&&y>=0&&y<b;
	}
	
	static void print(int [][]m){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<a;i++){
			for(int j=0;j<b;j++){
				sb.append(m[i][j]);
				if(j!=b-1)
					sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	static void valid(int [][]m){
		int e=2;
		int o=1;
		boolean even=false;
		for(int i=0;i<a;i++){
			for(int j=0;j<b;j++){
				if(even){
					if(j%2==0){
						if(e>n)
							m[i][j]=0;
						else
							m[i][j]=e;
						e+=2;
					}else{
						if(o>n)
							m[i][j]=0;
						else
							m[i][j]=o;
						o+=2;
					}
				}else{
					if(j%2!=0){
						if(e>n)
							m[i][j]=0;
						else
							m[i][j]=e;
						e+=2;
					}else{
						if(o>n)
							m[i][j]=0;
						else
							m[i][j]=o;
						o+=2;
					}
					
					
				}
			}
			even=!even;
		}
		print(m);
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		n=in.nextInt();
		a=in.nextInt();
		b=in.nextInt();
		
		int [][]m=new int [a][b];
		for(int i=0;i<a;i++)
			Arrays.fill(m[i], -1);
		//m[0][0]=0;
		if(a*b<n){
			System.out.println(-1);
			return;
		}
		valid(m);
		
		
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
