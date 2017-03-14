package cp4_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva1112_MiceAndMaze {
	static int [][]adjMatrix;
	static int v;
	static final int inf=(int)1e9;
	
	static void floyd(){
		for(int k = 0; k < v; k++)
			for(int i = 0; i < v; i++)
				for(int j = 0; j < v; j++)
					if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]){
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
					}
	}

	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0){
			v=in.nextInt();
			int exit=in.nextInt()-1;
			int time=in.nextInt();
			int m=in.nextInt();
			adjMatrix=new int [v][v];
			for(int i=0;i<v;i++){
				Arrays.fill(adjMatrix[i], inf);
				adjMatrix[i][i]=0;
			}
			while(m-->0){
				int u1=in.nextInt()-1;
				int u2=in.nextInt()-1;
				int ti=in.nextInt();
				adjMatrix[u1][u2]=Math.min(adjMatrix[u1][u2], ti);
			}
			floyd();
			int cnt=0;
			for(int i=0;i<v;i++){
				if(adjMatrix[i][exit]<=time)
					cnt++;
			}
			System.out.println(cnt);
			//for(int i=0;i<v;i++)
				//System.out.println(Arrays.toString(adjMatrix[i]));
			//System.out.println();
			if(t!=0)
				System.out.println();
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
